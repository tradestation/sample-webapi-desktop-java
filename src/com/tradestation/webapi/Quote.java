package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class Quote {
    private String Symbol;
    private String SymbolRoot;
    private String Description;
    private String AssetType;
    private String Exchange;
    private boolean FractionalDisplay;
    private int DisplayType;
    private double Open;
    private String OpenPriceDisplay;
    private double High;
    private String HighPriceDisplay;
    private double Low;
    private String LowPriceDisplay;
    private double PreviousClose;
    private String PreviousClosePriceDisplay;
    private double Last;
    private String LastPriceDisplay;
    private double Ask;
    private String AskPriceDisplay;
    private int AskSize;
    private double Bid;
    private String BidPriceDisplay;
    private int BidSize;
    private double NetChange;
    private double NetChangePct;
    private double High52Week;
    private String High52WeekPriceDisplay;
    private double Low52Week;
    private String Low52WeekPriceDisplay;
    private int Volume;
    private int PreviousVolume;
    private String Currency;
    private String CountryCode;
    private double StrikePrice;
    private String StrikePriceDisplay;
    private String NameExt;
    private int MinMove;
    private double PointValue;
    private double Close;
    private String ClosePriceDisplay;
    private String Error;
    private int DailyOpenInterest;
    private boolean IsDelayed;

    public String getSymbol() {
        return Symbol;
    }

    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getSymbolRoot() {
        return SymbolRoot;
    }

    @JsonProperty("SymbolRoot")
    public void setSymbolRoot(String symbolRoot) {
        SymbolRoot = symbolRoot;
    }

    public String getDescription() {
        return Description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        Description = description;
    }

    public String getAssetType() {
        return AssetType;
    }

    @JsonProperty("AssetType")
    public void setAssetType(String assetType) {
        AssetType = assetType;
    }

    public String getExchange() {
        return Exchange;
    }

    @JsonProperty("Exchange")
    public void setExchange(String exchange) {
        Exchange = exchange;
    }

    public boolean isFractionalDisplay() {
        return FractionalDisplay;
    }

    @JsonProperty("FractionalDisplay")
    public void setFractionalDisplay(boolean fractionalDisplay) {
        FractionalDisplay = fractionalDisplay;
    }

    public int getDisplayType() {
        return DisplayType;
    }

    @JsonProperty("DisplayType")
    public void setDisplayType(int displayType) {
        DisplayType = displayType;
    }

    public double getOpen() {
        return Open;
    }

    @JsonProperty("Open")
    public void setOpen(double open) {
        Open = open;
    }

    public String getOpenPriceDisplay() {
        return OpenPriceDisplay;
    }

    @JsonProperty("OpenPriceDisplay")
    public void setOpenPriceDisplay(String openPriceDisplay) {
        OpenPriceDisplay = openPriceDisplay;
    }

    public double getHigh() {
        return High;
    }

    @JsonProperty("High")
    public void setHigh(double high) {
        High = high;
    }

    public String getHighPriceDisplay() {
        return HighPriceDisplay;
    }

    @JsonProperty("HighPriceDisplay")
    public void setHighPriceDisplay(String highPriceDisplay) {
        HighPriceDisplay = highPriceDisplay;
    }

    public double getLow() {
        return Low;
    }

    @JsonProperty("Low")
    public void setLow(double low) {
        Low = low;
    }

    public String getLowPriceDisplay() {
        return LowPriceDisplay;
    }

    @JsonProperty("LowPriceDisplay")
    public void setLowPriceDisplay(String lowPriceDisplay) {
        LowPriceDisplay = lowPriceDisplay;
    }

    public double getPreviousClose() {
        return PreviousClose;
    }

    @JsonProperty("PreviousClose")
    public void setPreviousClose(double previousClose) {
        PreviousClose = previousClose;
    }

    public String getPreviousClosePriceDisplay() {
        return PreviousClosePriceDisplay;
    }

    @JsonProperty("PreviousClosePriceDisplay")
    public void setPreviousClosePriceDisplay(String previousClosePriceDisplay) {
        PreviousClosePriceDisplay = previousClosePriceDisplay;
    }

    public double getLast() {
        return Last;
    }

    @JsonProperty("Last")
    public void setLast(double last) {
        Last = last;
    }

    public String getLastPriceDisplay() {
        return LastPriceDisplay;
    }

    @JsonProperty("LastPriceDisplay")
    public void setLastPriceDisplay(String lastPriceDisplay) {
        LastPriceDisplay = lastPriceDisplay;
    }

    public double getAsk() {
        return Ask;
    }

    @JsonProperty("Ask")
    public void setAsk(double ask) {
        Ask = ask;
    }

    public String getAskPriceDisplay() {
        return AskPriceDisplay;
    }

    @JsonProperty("AskPriceDisplay")
    public void setAskPriceDisplay(String askPriceDisplay) {
        AskPriceDisplay = askPriceDisplay;
    }

    public int getAskSize() {
        return AskSize;
    }

    @JsonProperty("AskSize")
    public void setAskSize(int askSize) {
        AskSize = askSize;
    }

    public double getBid() {
        return Bid;
    }

    @JsonProperty("Bid")
    public void setBid(double bid) {
        Bid = bid;
    }

    public String getBidPriceDisplay() {
        return BidPriceDisplay;
    }

    @JsonProperty("BidPriceDisplay")
    public void setBidPriceDisplay(String bidPriceDisplay) {
        BidPriceDisplay = bidPriceDisplay;
    }

    public int getBidSize() {
        return BidSize;
    }

    @JsonProperty("BidSize")
    public void setBidSize(int bidSize) {
        BidSize = bidSize;
    }

    public double getNetChange() {
        return NetChange;
    }

    @JsonProperty("NetChange")
    public void setNetChange(double netChange) {
        NetChange = netChange;
    }

    public double getNetChangePct() {
        return NetChangePct;
    }

    @JsonProperty("NetChangePct")
    public void setNetChangePct(double netChangePct) {
        NetChangePct = netChangePct;
    }

    public double getHigh52Week() {
        return High52Week;
    }

    @JsonProperty("High52Week")
    public void setHigh52Week(double high52Week) {
        High52Week = high52Week;
    }

    public String getHigh52WeekPriceDisplay() {
        return High52WeekPriceDisplay;
    }

    @JsonProperty("High52WeekPriceDisplay")
    public void setHigh52WeekPriceDisplay(String high52WeekPriceDisplay) {
        High52WeekPriceDisplay = high52WeekPriceDisplay;
    }

    public double getLow52Week() {
        return Low52Week;
    }

    @JsonProperty("Low52Week")
    public void setLow52Week(double low52Week) {
        Low52Week = low52Week;
    }

    public String getLow52WeekPriceDisplay() {
        return Low52WeekPriceDisplay;
    }

    @JsonProperty("Low52WeekPriceDisplay")
    public void setLow52WeekPriceDisplay(String low52WeekPriceDisplay) {
        Low52WeekPriceDisplay = low52WeekPriceDisplay;
    }

    public int getVolume() {
        return Volume;
    }

    @JsonProperty("Volume")
    public void setVolume(int volume) {
        Volume = volume;
    }

    public int getPreviousVolume() {
        return PreviousVolume;
    }

    @JsonProperty("PreviousVolume")
    public void setPreviousVolume(int previousVolume) {
        PreviousVolume = previousVolume;
    }

    public String getCurrency() {
        return Currency;
    }

    @JsonProperty("Currency")
    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getCountryCode() {
        return CountryCode;
    }

    @JsonProperty("CountryCode")
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }

    public double getStrikePrice() {
        return StrikePrice;
    }

    @JsonProperty("StrikePrice")
    public void setStrikePrice(double strikePrice) {
        StrikePrice = strikePrice;
    }

    public String getStrikePriceDisplay() {
        return StrikePriceDisplay;
    }

    @JsonProperty("StrikePriceDisplay")
    public void setStrikePriceDisplay(String strikePriceDisplay) {
        StrikePriceDisplay = strikePriceDisplay;
    }

    public String getNameExt() {
        return NameExt;
    }

    @JsonProperty("NameExt")
    public void setNameExt(String nameExt) {
        NameExt = nameExt;
    }

    public int getMinMove() {
        return MinMove;
    }

    @JsonProperty("MinMove")
    public void setMinMove(int minMove) {
        MinMove = minMove;
    }

    public double getPointValue() {
        return PointValue;
    }

    @JsonProperty("PointValue")
    public void setPointValue(double pointValue) {
        PointValue = pointValue;
    }

    public double getClose() {
        return Close;
    }

    @JsonProperty("Close")
    public void setClose(double close) {
        Close = close;
    }

    public String getClosePriceDisplay() {
        return ClosePriceDisplay;
    }

    @JsonProperty("ClosePriceDisplay")
    public void setClosePriceDisplay(String closePriceDisplay) {
        ClosePriceDisplay = closePriceDisplay;
    }

    public String getError() {
        return Error;
    }

    @JsonProperty("Error")
    public void setError(String error) {
        Error = error;
    }

    public int getDailyOpenInterest() {
        return DailyOpenInterest;
    }

    @JsonProperty("DailyOpenInterest")
    public void setDailyOpenInterest(int dailyOpenInterest) {
        DailyOpenInterest = dailyOpenInterest;
    }

    public boolean isIsDelayed() {
        return IsDelayed;
    }

    @JsonProperty("IsDelayed")
    public void setIsDelayed(boolean isDelayed) {
        IsDelayed = isDelayed;
    }
}
