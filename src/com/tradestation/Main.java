package com.tradestation;

public class Main {

    public static void main(String[] args) {
        System.out.println("Starting local web server");
        String localServer = StartEmbeddedWebServer();
        TradeStationWebApi api = new TradeStationWebApi(localServer);
        System.out.println("Opening browser to go here: " + api.getAuthorizationUrl());
        System.out.print("Waiting for authorization code:");
        String code = "";
        System.out.println("...DONE");
        System.out.println("Generating Access Token");
        api.setAccessToken(code);
        Token token = api.getAccessToken();
        System.out.println("Token looks like this: abcd");
        System.out.println("Getting a quote");
        System.out.println(api.GetQuotes("MSFT").getSymbol());
    }

    private static String StartEmbeddedWebServer() {
        return "http://localhost:1234";
    }

    private static class TradeStationWebApi {
        private final String APIKEY;
        private final String CALLBACK;
        private final String APISECRET;
        private final String BASEURL;
        private Token TOKEN;

        public TradeStationWebApi(String redirectUri) {
            APIKEY = "your api key";
            APISECRET = "your api secret";
            BASEURL = "https://sim.api.tradestation.com/v2";
            CALLBACK = redirectUri;
        }

        public String getAuthorizationUrl() {
            return BASEURL + String.format("authorize?client_id=%s&response_type=code&redirect_uri=%s", APIKEY,
                    CALLBACK);
        }

        public Quote GetQuotes(String symbols) {
            return new Quote();
        }

        private Token getAccessToken() {
            return TOKEN;
        }

        private void setAccessToken(String authorizationCode) {
            this.TOKEN = new Token();
        }
    }
}
