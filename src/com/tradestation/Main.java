package com.tradestation;

import com.tradestation.webapi.*;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

        // Get Refresh Token:
        // The Access Token will expire after the time reference in token.getExpires_in()
        // if you do not want to log back in with user credentials, you need to refresh the token, here's how:
        System.out.println("Generating Refresh Token");
        api.setAccessToken(token);
        token = api.getAccessToken();
        System.out.println("Token looks like this: " + token.getAccess_token());

        // Refresh again
        System.out.println("Generating Another Refresh Token");
        api.setAccessToken(token);
        token = api.getAccessToken();
        System.out.println("Token looks like this: " + token.getAccess_token());

        Scanner input = new Scanner(System.in);

        // Get Accounts
        System.out.println(String.format("Accounts for: %s", token.getUserid()));
        ArrayList<AccountInfo> accounts = api.getUserAccounts();
        for (AccountInfo account : accounts) {
            System.out.println(String.format("Key: %s\t\tName: %s\t\tType: %s\t\tTypeDescription: %s",
                    account.getKey(), account.getName(), account.getType(), account.getTypeDescription()));
        }

        // Get Orders
        String[] accountKeys = new String[accounts.size()];
        Iterator<AccountInfo> iterator = accounts.iterator();
        for (int i = 0; i < accountKeys.length; i++) {
            accountKeys[i] = Integer.toString(iterator.next().getKey());
        }
        ArrayList<OrderDetail> orders = api.getOrders(accountKeys);
        if (orders.size() == 0) {
            System.out.println("No Orders to Display");
        } else {
            System.out.println("Order Requests:");
            for (OrderDetail orderDetail : orders) {
                System.out.println(
                        String.format("Account ID: %s\t\tOrder ID: %s\t\tSymbol: %s\t\tQuantity: %s\t\tStatus: %s",
                                orderDetail.getAccountID(), orderDetail.getOrderID(), orderDetail.getSymbol(),
                                orderDetail.getQuantity(), orderDetail.getStatusDescription()));
            }
        }

        // Get Quotes
        System.out.print("Provide a list of symbols to retrieve quotes (example: MSFT,GOOG):");
        String[] symbols = input.nextLine().split(",");
        ArrayList<Quote> quotes = api.getQuotes(symbols);
        for (Quote quote : quotes) {
            System.out.println(String.format("Symbol: %s\t\tLast: %.2f\t\tLastPriceDisplay: %s\t\t"
                    + "CountryCode: %s\t\tCurrency: %s\t\tAsset Type: %s", quote.getSymbol(), quote.getLast(),
                    quote.getLastPriceDisplay(), quote.getCountryCode(), quote.getCurrency(), quote.getAssetType()));
        }

        // New up an order
        Order order = new Order(quotes.get(0).getDescription(), null,
                QuoteAssetTypeToOrderAssetType(quotes.get(0).getAssetType()), quotes.get(0).getSymbol(), "1",
                quotes.get(0).getLastPriceDisplay(), null, "Limit", "Intelligent", "DAY",
                Integer.parseInt(accountKeys[0]), "", "buy", true, null, new ArrayList<GroupOrder>());
        System.out.println(String.format("Trying to place an order of %s share of %s at %s",
                order.getQuantity(), order.getSymbol(), order.getLimitPrice()));

        // Get an Order Estimate
        Confirm confirmation = api.confirmOrder(order).get(0);
        if (confirmation.getStatusCode() != null && confirmation.getStatusCode().equals("400")) {
            System.out.println(String.format("Message: %s\t\tStatus Code: %s",
                    confirmation.getMessage(), confirmation.getStatusCode()));
        } else {
            System.out.println(String.format("SummaryMessage: %s", confirmation.getSummaryMessage()));
        }

        // Place an Order
        ArrayList<OrderResult> orderResults = api.placeOrder(order);
        System.out.println(String.format("Message: %s\t\tStatus Code: %s",
                orderResults.get(0).getMessage(),
                orderResults.get(0).getStatusCode()));

        // Check Order Status
        orders = api.getOrders(accountKeys);
        if (orders.size() == 0) {
            System.out.println("No Orders to Display");
        } else {
            System.out.println("Order Requests:");
            for (OrderDetail orderDetail : orders) {
                System.out.println(
                        String.format("Account ID: %s\t\tOrder ID: %s\t\tSymbol: %s\t\tQuantity: %s\t\tStatus: %s",
                                orderDetail.getAccountID(), orderDetail.getOrderID(), orderDetail.getSymbol(),
                                orderDetail.getQuantity(), orderDetail.getStatusDescription()));
            }
        }

        // Get Streaming Barchart
        System.out.print("Provide a list of symbols to retrieve barchart stream (example: EURUSD,SPY):");
        symbols = input.nextLine().split(",");
        ArrayList<Thread> streams = new ArrayList<Thread>();

        // Loop through the provided symbols and start streams and stream observers
        for (String symbol : symbols) {
            // create an observer
            Thread stream = api.getBarchartStream(new BarchartStreamObserver(symbol), symbol, 5, "Minute",
                    new SimpleDateFormat("M-dd-yyyy").format(new Date()));
            stream.start();
            streams.add(stream);
        }

        // Join on streams to get streaming data (should stream forever)
        for (Thread stream : streams) {
            try {
                stream.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
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

    private static String QuoteAssetTypeToOrderAssetType(String quoteAssetType) {
        if (quoteAssetType.equals("STOCK") || quoteAssetType.equals("EQUITY")) {
            return "EQ";
        } else if (quoteAssetType.equals("FUTURE")) {
            return "FU";
        } else if (quoteAssetType.equals("FOREX")) {
            return "FX";
        } else if (quoteAssetType.equals("OPTION")) {
            return "OP";
        } else {
            return quoteAssetType;
        }
    }
}
