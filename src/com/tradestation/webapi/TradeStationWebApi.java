package com.tradestation.webapi;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * @author jjelinek@tradestation.com
 */
public class TradeStationWebApi {
    private final String APIKEY;
    private final String CALLBACK;
    private final String APISECRET;
    private final String BASEURL;
    private final AsyncHttpClient client = new AsyncHttpClient();
    private final ObjectMapper mapper = new ObjectMapper();
    private Token token;

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

    public ArrayList<Quote> getQuotes(String[] symbols) {
        com.ning.http.client.Request request = new RequestBuilder("GET")
                .setUrl(BASEURL + String.format("data/quote/%s", StringUtils.join(symbols, ",")))
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Bearer " + this.token.getAccess_token())
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

        ArrayList<Quote> quotes = new ArrayList<Quote>();

        if (response != null) {
            try {
                String json = response.get().getResponseBody();
                quotes = this.mapper.readValue(json, new TypeReference<ArrayList<Quote>>() {
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return quotes;
    }

    public Token getAccessToken() {
        return this.token;
    }

    public void setAccessToken(String authorizationCode) {
        if (authorizationCode.isEmpty()) return;
        Request request = new RequestBuilder("POST")
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

    public void getBarchartStream(String symbol, int interval, String intervalType, String startDate) {
        com.ning.http.client.Request request = new RequestBuilder("GET")
                .setUrl(BASEURL + String.format("stream/barchart/%s/%s/%s/%s",
                        symbol, interval, intervalType, startDate))
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .addHeader("Authorization", "Bearer " + this.token.getAccess_token())
                .build();

        try {
            this.client.executeRequest(request, new AsyncHandler<Response>() {
                private String remainingPartialJsonData = "";

                @Override
                public void onThrowable(Throwable throwable) {
                    throwable.printStackTrace();
                }

                @Override
                public STATE onBodyPartReceived(HttpResponseBodyPart httpResponseBodyPart) throws Exception {
                    ByteArrayOutputStream responseBytes = new ByteArrayOutputStream();
                    responseBytes.write(httpResponseBodyPart.getBodyPartBytes());

                    remainingPartialJsonData += responseBytes.toString("UTF-8");
                    String partialJsonData = remainingPartialJsonData;

                    if (partialJsonData.contains("ERROR")) {
                        return STATE.ABORT;
                    }

                    IntradayBar bar = processJson(partialJsonData, IntradayBar.class);
                    if (bar != null) {
                        System.out.println(bar.getTimeStamp());
                    }

                    return STATE.CONTINUE;
                }

                @Override
                public STATE onStatusReceived(HttpResponseStatus httpResponseStatus) throws Exception {
                    return STATE.CONTINUE;
                }

                @Override
                public STATE onHeadersReceived(HttpResponseHeaders httpResponseHeaders) throws Exception {
                    return STATE.CONTINUE;
                }

                @Override
                public Response onCompleted() throws Exception {
                    return null;
                }

                private <T> T processJson(String partialJsonData, Class<T> type) throws IOException {
                    String json = "";
                    for (char c : partialJsonData.toCharArray()) {
                        json += c;
                        if (json.contains("{") && isValidJSON(json)) {
                            remainingPartialJsonData = remainingPartialJsonData.replace(json, "");
                            json = json.replace("\\/Date(", "").replace(")\\/", "");
                            return mapper.readValue(json, type);
                        }
                    }
                    return null;
                }
            }).get();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    private boolean isValidJSON(String json) {
        boolean valid = false;
        try {
            final com.fasterxml.jackson.core.JsonParser parser;
            parser = mapper.getFactory().createParser(json);
            while (parser.nextToken() != null) {
            }
            valid = true;
        } catch (JsonParseException e) {
            // not valid json, so swallow
        } catch (IOException e) {
            e.printStackTrace();
        }

        return valid;
    }
}
