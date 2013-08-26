package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

/**
 * @author jjelinek@tradestation.com
 */
public class GroupOrder {
    private String Type;
    private ArrayList<Order> Orders;

    private String getType() {
        return Type;
    }

    @JsonProperty("Type")
    private void setType(String type) {
        Type = type;
    }

    private ArrayList<Order> getOrders() {
        return Orders;
    }

    @JsonProperty("Orders")
    private void setOrders(ArrayList<Order> orders) {
        Orders = orders;
    }
}
