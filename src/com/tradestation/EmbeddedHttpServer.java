package com.tradestation;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author jjelinek@tradestation.com
 */
class EmbeddedHttpServer implements Runnable {
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
                                    + "<p>Check the URL for the \"?code=\" query string parameter.</p></body></html>");
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
