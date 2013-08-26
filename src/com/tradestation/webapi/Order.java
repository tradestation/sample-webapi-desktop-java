package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * @author jjelinek@tradestation.com
 */
public class Order {
    private String Description;
    private String OrderID;
    private String AssetType;
    private String Symbol;
    private String Quantity;
    private String LimitPrice;
    private String StopPrice;
    private String OrderType;
    private String Route;
    private String Duration;
    private int AccountKey;
    private String GTDDate;
    private String TradeAction;
    private boolean IsDelayed;
    private AdvancedOptions AdvancedOptions;
    private ArrayList<GroupOrder> OSOs;

    public Order(String description, String orderID, String assetType, String symbol, String quantity, String limitPrice, String stopPrice,
                 String orderType, String route, String duration, int accountKey, String gtdDate, String tradeAction,
                 boolean isDelayed, AdvancedOptions advancedOptions, ArrayList<GroupOrder> osos) {
        Description = description;
        OrderID = orderID;
        AssetType = assetType;
        Symbol = symbol;
        Quantity = quantity;
        LimitPrice = limitPrice;
        StopPrice = stopPrice;
        OrderType = orderType;
        Route = route;
        Duration = duration;
        AccountKey = accountKey;
        GTDDate = gtdDate;
        IsDelayed = isDelayed;
        TradeAction = tradeAction;
        AdvancedOptions = advancedOptions;
        OSOs = osos;
    }

    public String getDescription() {
        return Description;
    }

    @JsonProperty("Description")
    public void setDescription(String description) {
        Description = description;
    }

    public String getOrderID() {
        return OrderID;
    }

    @JsonProperty("OrderID")
    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getAssetType() {
        return AssetType;
    }

    @JsonProperty("AssetType")
    public void setAssetType(String assetType) {
        AssetType = assetType;
    }

    public String getSymbol() {
        return Symbol;
    }

    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getQuantity() {
        return Quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(String quantity) {
        Quantity = quantity;
    }

    public String getLimitPrice() {
        return LimitPrice;
    }

    @JsonProperty("LimitPrice")
    public void setLimitPrice(String limitPrice) {
        LimitPrice = limitPrice;
    }

    public String getStopPrice() {
        return StopPrice;
    }

    @JsonProperty("StopPrice")
    public void setStopPrice(String stopPrice) {
        StopPrice = stopPrice;
    }

    public String getOrderType() {
        return OrderType;
    }

    @JsonProperty("OrderType")
    public void setOrderType(String orderType) {
        OrderType = orderType;
    }

    public String getRoute() {
        return Route;
    }

    @JsonProperty("Route")
    public void setRoute(String route) {
        Route = route;
    }

    public String getDuration() {
        return Duration;
    }

    @JsonProperty("Duration")
    public void setDuration(String duration) {
        Duration = duration;
    }

    public int getAccountKey() {
        return AccountKey;
    }

    @JsonProperty("AccountKey")
    public void setAccountKey(int accountKey) {
        AccountKey = accountKey;
    }

    public String getGTDDate() {
        return GTDDate;
    }

    @JsonProperty("GTDDate")
    public void setGTDDate(String GTDDate) {
        this.GTDDate = GTDDate;
    }

    public String getTradeAction() {
        return TradeAction;
    }

    @JsonProperty("TradeAction")
    public void setTradeAction(String tradeAction) {
        TradeAction = tradeAction;
    }

    public boolean getIsDelayed() {
        return IsDelayed;
    }

    @JsonProperty("IsDelayed")
    public void setIsDelayed(boolean isDelayed) {
        IsDelayed = isDelayed;
    }

    public AdvancedOptions getAdvancedOptions() {
        return AdvancedOptions;
    }

    @JsonProperty("AdvancedOptions")
    public void setAdvancedOptions(AdvancedOptions advancedOptions) {
        AdvancedOptions = advancedOptions;
    }

    public ArrayList<GroupOrder> getOSOs() {
        return OSOs;
    }

    @JsonProperty("OSOs")
    public void setOSOs(ArrayList<GroupOrder> OSOs) {
        this.OSOs = OSOs;
    }
}
