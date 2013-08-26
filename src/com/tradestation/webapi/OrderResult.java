package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class OrderResult {
    private String Message;
    private String OrderID;
    private String OrderStatus;
    private int StatusCode;

    public String getMessage() {
        return Message;
    }

    @JsonProperty("Message")
    public void setMessage(String message) {
        Message = message;
    }

    public String getOrderID() {
        return OrderID;
    }

    @JsonProperty("OrderID")
    public void setOrderID(String orderID) {
        OrderID = orderID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    @JsonProperty("OrderStatus")
    public void setOrderStatus(String orderStatus) {
        OrderStatus = orderStatus;
    }

    public int getStatusCode() {
        return StatusCode;
    }

    @JsonProperty("StatusCode")
    public void setStatusCode(int statusCode) {
        StatusCode = statusCode;
    }
}
