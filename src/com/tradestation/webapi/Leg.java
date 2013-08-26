package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class Leg {
    private int OrderID;
    private String Symbol;
    private String BaseSymbol;
    private String Side;
    private String OpenOrClose;
    private int LegNumber;
    private String TimeExecuted;
    private int ExecQuantity;
    private int Leaves;
    private double ExecPrice;
    private int Quantity;
    private int Month;
    private int Year;
    private double LimitPrice;
    private String LimitPriceDisplay;
    private double StopPrice;
    private String StopPriceDisplay;
    private double PointValue;
    private char PutOrCall;
    private double StrikePrice;
    private double Bid;
    private double Ask;
    private double PriceUsedForBuyingPower;
    private String OrderType;
    private String ExpireDate;

    private int getOrderID() {
        return OrderID;
    }

    @JsonProperty("OrderID")
    private void setOrderID(int orderID) {
        OrderID = orderID;
    }

    private String getSymbol() {
        return Symbol;
    }

    @JsonProperty("Symbol")
    private void setSymbol(String symbol) {
        Symbol = symbol;
    }

    private String getBaseSymbol() {
        return BaseSymbol;
    }

    @JsonProperty("BaseSymbol")
    private void setBaseSymbol(String baseSymbol) {
        BaseSymbol = baseSymbol;
    }

    private String getSide() {
        return Side;
    }

    @JsonProperty("Side")
    private void setSide(String side) {
        Side = side;
    }

    private String getOpenOrClose() {
        return OpenOrClose;
    }

    @JsonProperty("OpenOrClose")
    private void setOpenOrClose(String openOrClose) {
        OpenOrClose = openOrClose;
    }

    private int getLegNumber() {
        return LegNumber;
    }

    @JsonProperty("LegNumber")
    private void setLegNumber(int legNumber) {
        LegNumber = legNumber;
    }

    private String getTimeExecuted() {
        return TimeExecuted;
    }

    @JsonProperty("TimeExecuted")
    private void setTimeExecuted(String timeExecuted) {
        TimeExecuted = timeExecuted;
    }

    private int getExecQuantity() {
        return ExecQuantity;
    }

    @JsonProperty("ExecQuantity")
    private void setExecQuantity(int execQuantity) {
        ExecQuantity = execQuantity;
    }

    private int getLeaves() {
        return Leaves;
    }

    @JsonProperty("Leaves")
    private void setLeaves(int leaves) {
        Leaves = leaves;
    }

    private double getExecPrice() {
        return ExecPrice;
    }

    @JsonProperty("ExecPrice")
    private void setExecPrice(double execPrice) {
        ExecPrice = execPrice;
    }

    private int getQuantity() {
        return Quantity;
    }

    @JsonProperty("Quantity")
    private void setQuantity(int quantity) {
        Quantity = quantity;
    }

    private int getMonth() {
        return Month;
    }

    @JsonProperty("Month")
    private void setMonth(int month) {
        Month = month;
    }

    private int getYear() {
        return Year;
    }

    @JsonProperty("Year")
    private void setYear(int year) {
        Year = year;
    }

    private double getLimitPrice() {
        return LimitPrice;
    }

    @JsonProperty("LimitPrice")
    private void setLimitPrice(double limitPrice) {
        LimitPrice = limitPrice;
    }

    private String getLimitPriceDisplay() {
        return LimitPriceDisplay;
    }

    @JsonProperty("LimitPriceDisplay")
    private void setLimitPriceDisplay(String limitPriceDisplay) {
        LimitPriceDisplay = limitPriceDisplay;
    }

    private double getStopPrice() {
        return StopPrice;
    }

    @JsonProperty("StopPrice")
    private void setStopPrice(double stopPrice) {
        StopPrice = stopPrice;
    }

    private String getStopPriceDisplay() {
        return StopPriceDisplay;
    }

    @JsonProperty("StopPriceDisplay")
    private void setStopPriceDisplay(String stopPriceDisplay) {
        StopPriceDisplay = stopPriceDisplay;
    }

    private double getPointValue() {
        return PointValue;
    }

    @JsonProperty("PointValue")
    private void setPointValue(double pointValue) {
        PointValue = pointValue;
    }

    private char getPutOrCall() {
        return PutOrCall;
    }

    @JsonProperty("PutOrCall")
    private void setPutOrCall(char putOrCall) {
        PutOrCall = putOrCall;
    }

    private double getStrikePrice() {
        return StrikePrice;
    }

    @JsonProperty("StrikePrice")
    private void setStrikePrice(double strikePrice) {
        StrikePrice = strikePrice;
    }

    private double getBid() {
        return Bid;
    }

    @JsonProperty("Bid")
    private void setBid(double bid) {
        Bid = bid;
    }

    private double getAsk() {
        return Ask;
    }

    @JsonProperty("Ask")
    private void setAsk(double ask) {
        Ask = ask;
    }

    private double getPriceUsedForBuyingPower() {
        return PriceUsedForBuyingPower;
    }

    @JsonProperty("PriceUsedForBuyingPower")
    private void setPriceUsedForBuyingPower(double priceUsedForBuyingPower) {
        PriceUsedForBuyingPower = priceUsedForBuyingPower;
    }

    private String getOrderType() {
        return OrderType;
    }

    @JsonProperty("OrderType")
    private void setOrderType(String orderType) {
        OrderType = orderType;
    }

    private String getExpireDate() {
        return ExpireDate;
    }

    @JsonProperty("ExpireDate")
    private void setExpireDate(String expireDate) {
        ExpireDate = expireDate;
    }
}
