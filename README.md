# sample-webapi-desktop-java

This is a Java 6 sample console application that follows the Authorization Code grant type. Here are some key features:

* Automatically open TradeStation login screen in the default browser
* Listen on redirect to generate access token
* Make a simple request to the WebAPI
* Deserialize data from JSON into a Plain Old Java Object

## Configuration

Modify your Key/Secret/BaseUrl:

    public TradeStationWebApi(String redirectUri) {
        APIKEY = "your api key";
        APISECRET = "your api secret";
        BASEURL = "https://sim.api.tradestation.com/v2/";
        CALLBACK = redirectUri;
    }

Supported BASEURL environments include:

* SIMULATED TRADING - https://sim.api.tradestation.com/v2/
* LIVE TRADING - https://api.tradestation.com/v2/

## Build Instructions

From the project's root directory:

    mkdir classes
    javac -d classes -classpath "lib/*" src/com/tradestation/*.java src/com/tradestation/webapi/*.java

## How To Run

From the project's root directory:

Windows

    java -classpath classes/;lib/* com.tradestation.Main

Mac OSX

    java -classpath classes/:lib/* com.tradestation.Main
    
## Contributing & Troubleshooting

If you can make this sample code easier to understand, please fork the repository and send a pull request. We will review the changes and merge as appropriate.

If there are any problems, open an issue and we'll take a look! You can also give us feedback by e-mailing webapi@tradestation.com
