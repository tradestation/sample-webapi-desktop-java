package com.tradestation;

/**
 * @author jjelinek@tradestation.com
 */
class Token {
    private String _accessToken, _refreshToken, _tokenType, _userid;
    private int _expiresIn;

    public String getAccess_token() {
        return _accessToken;
    }

    public void setAccess_token(String _access_token) {
        this._accessToken = _access_token;
    }

    public int getExpires_in() {
        return _expiresIn;
    }

    public void setExpires_in(int _expires_in) {
        this._expiresIn = _expires_in;
    }

    public String getRefresh_token() {
        return _refreshToken;
    }

    public void setRefresh_token(String _refresh_token) {
        this._refreshToken = _refresh_token;
    }

    public String getToken_type() {
        return _tokenType;
    }

    public void setToken_type(String _token_type) {
        this._tokenType = _token_type;
    }

    public String getUserid() {
        return _userid;
    }

    public void setUserid(String _userid) {
        this._userid = _userid;
    }
}
