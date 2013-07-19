package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author jjelinek@tradestation.com
 *
 * Intraday Bar data
 */
public class IntradayBar {
    private double Close;
    private int DownTicks;
    private long DownVolume;
    private double High;
    private double Low;
    private double Open;
    private int OpenInterest;
    private Date TimeStamp;
    private int TotalTicks;
    private long TotalVolume;
    private int UnchangedTicks;
    private long UnchangedVolume;
    private int UpTicks;
    private long UpVolume;
    private int Status;

    int getStatus() {
        return Status;
    }

    @JsonProperty("Status")
    void setStatus(int status) {
        Status = status;
    }

    double getClose() {
        return Close;
    }

    @JsonProperty("Close")
    void setClose(double close) {
        Close = close;
    }

    int getDownTicks() {
        return DownTicks;
    }

    @JsonProperty("DownTicks")
    void setDownTicks(int downTicks) {
        DownTicks = downTicks;
    }

    long getDownVolume() {
        return DownVolume;
    }

    @JsonProperty("DownVolume")
    void setDownVolume(long downVolume) {
        DownVolume = downVolume;
    }

    double getHigh() {
        return High;
    }

    @JsonProperty("High")
    void setHigh(double high) {
        High = high;
    }

    double getLow() {
        return Low;
    }

    @JsonProperty("Low")
    void setLow(double low) {
        Low = low;
    }

    double getOpen() {
        return Open;
    }

    @JsonProperty("Open")
    void setOpen(double open) {
        Open = open;
    }

    int getOpenInterest() {
        return OpenInterest;
    }

    @JsonProperty("OpenInterest")
    void setOpenInterest(int openInterest) {
        OpenInterest = openInterest;
    }

    Date getTimeStamp() {
        return TimeStamp;
    }

    @JsonProperty("TimeStamp")
    void setTimeStamp(Date timeStamp) {
        TimeStamp = timeStamp;
    }

    int getTotalTicks() {
        return TotalTicks;
    }

    @JsonProperty("TotalTicks")
    void setTotalTicks(int totalTicks) {
        TotalTicks = totalTicks;
    }

    long getTotalVolume() {
        return TotalVolume;
    }

    @JsonProperty("TotalVolume")
    void setTotalVolume(long totalVolume) {
        TotalVolume = totalVolume;
    }

    int getUnchangedTicks() {
        return UnchangedTicks;
    }

    @JsonProperty("UnchangedTicks")
    void setUnchangedTicks(int unchangedTicks) {
        UnchangedTicks = unchangedTicks;
    }

    long getUnchangedVolume() {
        return UnchangedVolume;
    }

    @JsonProperty("UnchangedVolume")
    void setUnchangedVolume(long unchangedVolume) {
        UnchangedVolume = unchangedVolume;
    }

    int getUpTicks() {
        return UpTicks;
    }

    @JsonProperty("UpTicks")
    void setUpTicks(int upTicks) {
        UpTicks = upTicks;
    }

    long getUpVolume() {
        return UpVolume;
    }

    @JsonProperty("UpVolume")
    void setUpVolume(long upVolume) {
        UpVolume = upVolume;
    }
}
