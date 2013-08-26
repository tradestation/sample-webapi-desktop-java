package com.tradestation.webapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author jjelinek@tradestation.com
 */
public class AccountInfo {
    private String Alias;
    private String AltId;
    private String DisplayName;
    private int Key;
    private String Name;
    private char Type;
    private String TypeDescription;

    public String getAlias() {
        return Alias;
    }

    @JsonProperty("Alias")
    public void setAlias(String alias) {
        Alias = alias;
    }

    public String getAltId() {
        return AltId;
    }

    @JsonProperty("AltId")
    public void setAltId(String altId) {
        AltId = altId;
    }

    public String getDisplayName() {
        return DisplayName;
    }

    @JsonProperty("DisplayName")
    public void setDisplayName(String displayName) {
        DisplayName = displayName;
    }

    public int getKey() {
        return Key;
    }

    @JsonProperty("Key")
    public void setKey(int key) {
        Key = key;
    }

    public String getName() {
        return Name;
    }

    @JsonProperty("Name")
    public void setName(String name) {
        Name = name;
    }

    public char getType() {
        return Type;
    }

    @JsonProperty("Type")
    public void setType(char type) {
        Type = type;
    }

    public String getTypeDescription() {
        return TypeDescription;
    }

    @JsonProperty("TypeDescription")
    public void setTypeDescription(String typeDescription) {
        TypeDescription = typeDescription;
    }
}
