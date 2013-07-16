package com.tradestation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.*;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class Main {

    public static void main(String[] args) {
        // An embedded http server is required to automate capture of authorization code from login page
        String sync = "";
        EmbeddedHttpServer embeddedServer = new EmbeddedHttpServer(sync);
        (new Thread(embeddedServer)).start();
        System.out.println("Starting local web server");

        // wait for embedded http server to start
        while (embeddedServer.notStarted()) { }
        TradeStationWebApi api = new TradeStationWebApi("http://localhost:" + embeddedServer.getPort());
        try {
            System.out.println("Opening browser to go here: " + api.getAuthorizationUrl());
            browseTo(api.getAuthorizationUrl());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.print("Waiting for authorization code...");

        // wait until the authorization code is received
        try {
            synchronized (sync) {
                sync.wait();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        String code = embeddedServer.getAuthorizationCode();
        System.out.println("DONE");

        System.out.println("Generating Access Token");
        api.setAccessToken(code);
        Token token = api.getAccessToken();
        System.out.println("Token looks like this: " + token.getAccess_token());
        System.out.println("Getting a quote");
        System.out.println(api.GetQuotes(new String[]{"MSFT"}).getSymbol());
        System.exit(0);
    }

    private static void browseTo(String url) {

    }

    private static class TradeStationWebApi {
        private final String APIKEY;
        private final String CALLBACK;
        private final String APISECRET;
        private final String BASEURL;
        private Token token;
        private AsyncHttpClient client = new AsyncHttpClient();
        private final ObjectMapper mapper = new ObjectMapper();

        public TradeStationWebApi(String redirectUri) {
            APIKEY = "your api key";
            APISECRET = "your api secret";
            BASEURL = "https://sim.api.tradestation.com/v2/";
            CALLBACK = redirectUri;
        }

        public String getAuthorizationUrl() throws UnsupportedEncodingException {
            return BASEURL + String.format("authorize?client_id=%s&response_type=code&redirect_uri=%s", APIKEY,
                    URLEncoder.encode(CALLBACK, "UTF-8"));
        }

        public Quote GetQuotes(String[] symbols) {
            return new Quote();
        }

        private Token getAccessToken() {
            return this.token;
        }

        private void setAccessToken(String authorizationCode) {
            if (authorizationCode.isEmpty()) return;
            com.ning.http.client.Request request = new RequestBuilder("POST")
                    .setUrl(BASEURL + "security/authorize")
                    .addHeader("Content-Type", "application/x-www-form-urlencoded")
                    .setBody("grant_type=authorization_code&code=" + authorizationCode + "&client_id=" + APIKEY
                            + "&redirect_uri=" + CALLBACK + "&client_secret=" + APISECRET)
                    .build();

            ListenableFuture<Response> response = null;
            try {
                response = this.client.executeRequest(request, new AsyncCompletionHandler<Response>() {
                    @Override
                    public Response onCompleted(Response response) throws Exception {
                        return response;
                    }
                });
            } catch (IOException e) {
                e.printStackTrace();
            }

            Token token = null;
            if (response != null) {
                try {
                    String json = response.get().getResponseBody();
                    token = this.mapper.readValue(json, Token.class);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            this.token = token;
        }
    }

    private static class EmbeddedHttpServer implements Runnable {
        private final Server server;
        private String authorizationCode;

        public EmbeddedHttpServer(final Object sync) {
            this.server = new Server(0);
            this.server.setHandler(new AbstractHandler() {
                @Override
                public void handle(String target, Request baseRequest, HttpServletRequest request,
                                   HttpServletResponse response) throws IOException, ServletException {
                    response.setContentType("text/html;charset=utf-8");
                    response.setStatus(HttpServletResponse.SC_OK);
                    baseRequest.setHandled(true);
                    if (request.getParameter("code") != null && !request.getParameter("code").isEmpty()) {
                        response.getWriter().println("<html><body><h1>Authorization Code Received</h1>"
                                + "<p>You can now close this window.</p></body></html>");
                        authorizationCode = request.getParameter("code");
                        synchronized (sync) {
                            sync.notifyAll();
                        }
                    } else {
                        response.getWriter().println(
                                "<html><body><h1 style=\"color: red\">Authorization Code Not Received</h1>"
                                + "<p>Check the URL for the \"?code=\" querystring parameter.</p></body></html>");
                    }
                }
            });
        }

        @Override
        public void run() {
            try {
                this.server.start();
                this.server.join();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public int getPort() {
            return this.server.getConnectors()[0].getLocalPort();
        }

        public boolean notStarted() {
            return !this.server.isStarted();
        }

        public String getAuthorizationCode() {
            return authorizationCode;
        }
    }
}
