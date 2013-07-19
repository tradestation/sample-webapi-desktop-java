package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author jjelinek@tradestation.com
 *         <p/>
 *         Intraday Bar data
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

    public int getStatus() {
        return Status;
    }

    @JsonProperty("Status")
    public void setStatus(int status) {
        Status = status;
    }

    public double getClose() {
        return Close;
    }

    @JsonProperty("Close")
    public void setClose(double close) {
        Close = close;
    }

    public int getDownTicks() {
        return DownTicks;
    }

    @JsonProperty("DownTicks")
    public void setDownTicks(int downTicks) {
        DownTicks = downTicks;
    }

    public long getDownVolume() {
        return DownVolume;
    }

    @JsonProperty("DownVolume")
    public void setDownVolume(long downVolume) {
        DownVolume = downVolume;
    }

    public double getHigh() {
        return High;
    }

    @JsonProperty("High")
    public void setHigh(double high) {
        High = high;
    }

    public double getLow() {
        return Low;
    }

    @JsonProperty("Low")
    public void setLow(double low) {
        Low = low;
    }

    public double getOpen() {
        return Open;
    }

    @JsonProperty("Open")
    public void setOpen(double open) {
        Open = open;
    }

    public int getOpenInterest() {
        return OpenInterest;
    }

    @JsonProperty("OpenInterest")
    public void setOpenInterest(int openInterest) {
        OpenInterest = openInterest;
    }

    public Date getTimeStamp() {
        return TimeStamp;
    }

    @JsonProperty("TimeStamp")
    public void setTimeStamp(Date timeStamp) {
        TimeStamp = timeStamp;
    }

    public int getTotalTicks() {
        return TotalTicks;
    }

    @JsonProperty("TotalTicks")
    public void setTotalTicks(int totalTicks) {
        TotalTicks = totalTicks;
    }

    public long getTotalVolume() {
        return TotalVolume;
    }

    @JsonProperty("TotalVolume")
    public void setTotalVolume(long totalVolume) {
        TotalVolume = totalVolume;
    }

    public int getUnchangedTicks() {
        return UnchangedTicks;
    }

    @JsonProperty("UnchangedTicks")
    public void setUnchangedTicks(int unchangedTicks) {
        UnchangedTicks = unchangedTicks;
    }

    public long getUnchangedVolume() {
        return UnchangedVolume;
    }

    @JsonProperty("UnchangedVolume")
    public void setUnchangedVolume(long unchangedVolume) {
        UnchangedVolume = unchangedVolume;
    }

    public int getUpTicks() {
        return UpTicks;
    }

    @JsonProperty("UpTicks")
    public void setUpTicks(int upTicks) {
        UpTicks = upTicks;
    }

    public long getUpVolume() {
        return UpVolume;
    }

    @JsonProperty("UpVolume")
    public void setUpVolume(long upVolume) {
        UpVolume = upVolume;
    }
}
