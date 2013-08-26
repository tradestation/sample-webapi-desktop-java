package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class OrderDetail {
    private String AccountID;
    private String AdvancedOptions;
    private String Alias;
    private String AssetType;
    private double CommissionFee;
    private String ContractExpireDate;
    private double ConversionRate;
    private String Country;
    private String Denomination;
    private String DisplayName;
    private String Duration;
    private int ExecuteQuantity;
    private String FilledCanceled;
    private String FilledPriceText;
    private String GroupName;
    private Leg[] Legs;
    private String LimitPriceText;
    private int OrderID;
    private int Originator;
    private int Quantity;
    private int QuantityLeft;
    private String RejectReason;
    private String Routing;
    private String Spread;
    private String Status;
    private String StatusDescription;
    private String StopPriceText;
    private String Symbol;
    private String TimeStamp;
    private String TriggeredBy;
    private String Type;

    public String getAccountID() {
        return AccountID;
    }

    @JsonProperty("AccountID")
    public void setAccountID(String accountID) {
        AccountID = accountID;
    }

    public String getAdvancedOptions() {
        return AdvancedOptions;
    }

    @JsonProperty("AdvancedOptions")
    public void setAdvancedOptions(String advancedOptions) {
        AdvancedOptions = advancedOptions;
    }

    public String getAlias() {
        return Alias;
    }

    @JsonProperty("Alias")
    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getAssetType() {
        return AssetType;
    }

    @JsonProperty("AssetType")
    public void setAssetType(String assetType) {
        AssetType = assetType;
    }

    public double getCommissionFee() {
        return CommissionFee;
    }

    @JsonProperty("CommissionFee")
    public void setCommissionFee(double commissionFee) {
        CommissionFee = commissionFee;
    }

    public String getContractExpireDate() {
        return ContractExpireDate;
    }

    @JsonProperty("ContractExpireDate")
    public void setContractExpireDate(String contractExpireDate) {
        ContractExpireDate = contractExpireDate;
    }

    public double getConversionRate() {
        return ConversionRate;
    }

    @JsonProperty("ConversionRate")
    public void setConversionRate(double conversionRate) {
        ConversionRate = conversionRate;
    }

    public String getCountry() {
        return Country;
    }

    @JsonProperty("Country")
    public void setCountry(String country) {
        Country = country;
    }

    public String getDenomination() {
        return Denomination;
    }

    @JsonProperty("Denomination")
    public void setDenomination(String denomination) {
        Denomination = denomination;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getDuration() {
        return Duration;
    }

    @JsonProperty("Duration")
    public void setDuration(String duration) {
        Duration = duration;
    }

    public int getExecuteQuantity() {
        return ExecuteQuantity;
    }

    @JsonProperty("ExecuteQuantity")
    public void setExecuteQuantity(int executeQuantity) {
        ExecuteQuantity = executeQuantity;
    }

    public String getFilledCanceled() {
        return FilledCanceled;
    }

    @JsonProperty("FilledCanceled")
    public void setFilledCanceled(String filledCanceled) {
        FilledCanceled = filledCanceled;
    }

    public String getFilledPriceText() {
        return FilledPriceText;
    }

    @JsonProperty("FilledPriceText")
    public void setFilledPriceText(String filledPriceText) {
        FilledPriceText = filledPriceText;
    }

    public String getGroupName() {
        return GroupName;
    }

    @JsonProperty("GroupName")
    public void setGroupName(String groupName) {
        GroupName = groupName;
    }

    public Leg[] getLegs() {
        return Legs;
    }

    @JsonProperty("Legs")
    public void setLegs(Leg[] legs) {
        Legs = legs;
    }

    public String getLimitPriceText() {
        return LimitPriceText;
    }

    @JsonProperty("LimitPriceText")
    public void setLimitPriceText(String limitPriceText) {
        LimitPriceText = limitPriceText;
    }

    public int getOrderID() {
        return OrderID;
    }

    @JsonProperty("OrderID")
    public void setOrderID(int orderID) {
        OrderID = orderID;
    }

    public int getOriginator() {
        return Originator;
    }

    @JsonProperty("Originator")
    public void setOriginator(int originator) {
        Originator = originator;
    }

    public int getQuantity() {
        return Quantity;
    }

    @JsonProperty("Quantity")
    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public int getQuantityLeft() {
        return QuantityLeft;
    }

    @JsonProperty("QuantityLeft")
    public void setQuantityLeft(int quantityLeft) {
        QuantityLeft = quantityLeft;
    }

    public String getRejectReason() {
        return RejectReason;
    }

    @JsonProperty("RejectReason")
    public void setRejectReason(String rejectReason) {
        RejectReason = rejectReason;
    }

    public String getRouting() {
        return Routing;
    }

    @JsonProperty("Routing")
    public void setRouting(String routing) {
        Routing = routing;
    }

    public String getSpread() {
        return Spread;
    }

    @JsonProperty("Spread")
    public void setSpread(String spread) {
        Spread = spread;
    }

    public String getStatus() {
        return Status;
    }

    @JsonProperty("Status")
    public void setStatus(String status) {
        Status = status;
    }

    public String getStatusDescription() {
        return StatusDescription;
    }

    @JsonProperty("StatusDescription")
    public void setStatusDescription(String statusDescription) {
        StatusDescription = statusDescription;
    }

    public String getStopPriceText() {
        return StopPriceText;
    }

    @JsonProperty("StopPriceText")
    public void setStopPriceText(String stopPriceText) {
        StopPriceText = stopPriceText;
    }

    public String getSymbol() {
        return Symbol;
    }

    @JsonProperty("Symbol")
    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getTimeStamp() {
        return TimeStamp;
    }

    @JsonProperty("TimeStamp")
    public void setTimeStamp(String timeStamp) {
        TimeStamp = timeStamp;
    }

    public String getTriggeredBy() {
        return TriggeredBy;
    }

    @JsonProperty("TriggeredBy")
    public void setTriggeredBy(String triggeredBy) {
        TriggeredBy = triggeredBy;
    }

    public String getType() {
        return Type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        Type = type;
    }

}
