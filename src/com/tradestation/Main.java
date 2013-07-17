package com.tradestation;

import com.tradestation.webapi.Quote;
import com.tradestation.webapi.Token;
import com.tradestation.webapi.TradeStationWebApi;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // An embedded http server is required to automate capture of authorization code from login page
        String codeSync = "";
        EmbeddedHttpServer embeddedServer = new EmbeddedHttpServer(codeSync);
        (new Thread(embeddedServer)).start();
        System.out.println("Starting local web server");

        // wait for embedded http server to start
        while (embeddedServer.notStarted()) {
        }
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
            synchronized (codeSync) {
                codeSync.wait();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        String code = embeddedServer.getAuthorizationCode();
        System.out.println("DONE");

        // Get Access Token
        System.out.println("Generating Access Token");
        api.setAccessToken(code);
        Token token = api.getAccessToken();
        System.out.println("Token looks like this: " + token.getAccess_token());

        // Get Quotes
        System.out.print("Provide a list of quote symbols to retrieve (example: MSFT,GOOG):");
        String input = new Scanner(System.in).nextLine();
        String[] symbols = input.split(",");
        for (Quote quote : api.getQuotes(symbols)) {
            System.out.println(String.format("Symbol: %s\t\t52-Wk High: %.2f\t\t52-Wk Low: %.2f",
                    quote.getSymbol(), quote.getHigh52Week(), quote.getLow52Week()));
        }
        System.exit(0);
    }

    private static void browseTo(String url) {
        if (url.isEmpty()) return;
        url = url.trim();
        try {
            if (OSValidator.isMac()) {
                (new ProcessBuilder("open", url)).start();
            }
            if (OSValidator.isWindows()) {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
            }
            if (OSValidator.isUnix()) {
                (new ProcessBuilder("sensible-browser", url)).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
