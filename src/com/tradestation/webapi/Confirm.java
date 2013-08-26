package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class Confirm {
    private String __type;
    private String Account;
    private String DisplayName;
    private String RelationIdentifier;
    private String Route;
    private String SummaryMessage;
    private double EstimatedCommission;
    private String EstimatedCommissionDisplay;
    private double EstimatedCost;
    private String EstimatedCostDisplay;
    private double EstimatedPrice;
    private String EstimatedPriceDisplay;
    private String Duration;
    private String Message;
    private String StatusCode;

    public String get__type() {
        return __type;
    }

    @JsonProperty("__type")
    public void set__type(String __type) {
        this.__type = __type;
    }

    public String getAccount() {
        return Account;
    }

    @JsonProperty("Account")
    public void setAccount(String account) {
        Account = account;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public String getRelationIdentifier() {
        return RelationIdentifier;
    }

    @JsonProperty("RelationIdentifier")
    public void setRelationIdentifier(String relationIdentifier) {
        RelationIdentifier = relationIdentifier;
    }

    public String getRoute() {
        return Route;
    }

    @JsonProperty("Route")
    public void setRoute(String route) {
        Route = route;
    }

    public String getSummaryMessage() {
        return SummaryMessage;
    }

    @JsonProperty("SummaryMessage")
    public void setSummaryMessage(String summaryMessage) {
        SummaryMessage = summaryMessage;
    }

    public double getEstimatedCommission() {
        return EstimatedCommission;
    }

    @JsonProperty("EstimatedCommission")
    public void setEstimatedCommission(double estimatedCommission) {
        EstimatedCommission = estimatedCommission;
    }

    public String getEstimatedCommissionDisplay() {
        return EstimatedCommissionDisplay;
    }

    @JsonProperty("EstimatedCommissionDisplay")
    public void setEstimatedCommissionDisplay(String estimatedCommissionDisplay) {
        EstimatedCommissionDisplay = estimatedCommissionDisplay;
    }

    public double getEstimatedCost() {
        return EstimatedCost;
    }

    @JsonProperty("EstimatedCost")
    public void setEstimatedCost(double estimatedCost) {
        EstimatedCost = estimatedCost;
    }

    public String getEstimatedCostDisplay() {
        return EstimatedCostDisplay;
    }

    @JsonProperty("EstimatedCostDisplay")
    public void setEstimatedCostDisplay(String estimatedCostDisplay) {
        EstimatedCostDisplay = estimatedCostDisplay;
    }

    public double getEstimatedPrice() {
        return EstimatedPrice;
    }

    @JsonProperty("EstimatedPrice")
    public void setEstimatedPrice(double estimatedPrice) {
        EstimatedPrice = estimatedPrice;
    }

    public String getEstimatedPriceDisplay() {
        return EstimatedPriceDisplay;
    }

    @JsonProperty("EstimatedPriceDisplay")
    public void setEstimatedPriceDisplay(String estimatedPriceDisplay) {
        EstimatedPriceDisplay = estimatedPriceDisplay;
    }

    public String getDuration() {
        return Duration;
    }

    @JsonProperty("Duration")
    public void setDuration(String duration) {
        Duration = duration;
    }

    public String getMessage() {
        return Message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        Message = message;
    }

    public String getStatusCode() {
        return StatusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(String statusCode) {
        StatusCode = statusCode;
    }
}
