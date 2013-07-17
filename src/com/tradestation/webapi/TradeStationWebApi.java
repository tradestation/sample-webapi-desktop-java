package com.tradestation.webapi;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ning.http.client.*;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

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
}
