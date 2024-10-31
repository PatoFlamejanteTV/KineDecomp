package com.google.api.services.oauth2.model;

import com.facebook.AccessToken;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public final class Tokeninfo extends GenericJson {

    @Key(a = "access_type")
    private String accessType;

    @Key
    private String audience;

    @Key
    private String email;

    @Key(a = AccessToken.EXPIRES_IN_KEY)
    private Integer expiresIn;

    @Key(a = "issued_to")
    private String issuedTo;

    @Key
    private String scope;

    @Key(a = "token_handle")
    private String tokenHandle;

    @Key(a = AccessToken.USER_ID_KEY)
    private String userId;

    @Key(a = "verified_email")
    private Boolean verifiedEmail;

    public String getAccessType() {
        return this.accessType;
    }

    public Tokeninfo setAccessType(String str) {
        this.accessType = str;
        return this;
    }

    public String getAudience() {
        return this.audience;
    }

    public Tokeninfo setAudience(String str) {
        this.audience = str;
        return this;
    }

    public String getEmail() {
        return this.email;
    }

    public Tokeninfo setEmail(String str) {
        this.email = str;
        return this;
    }

    public Integer getExpiresIn() {
        return this.expiresIn;
    }

    public Tokeninfo setExpiresIn(Integer num) {
        this.expiresIn = num;
        return this;
    }

    public String getIssuedTo() {
        return this.issuedTo;
    }

    public Tokeninfo setIssuedTo(String str) {
        this.issuedTo = str;
        return this;
    }

    public String getScope() {
        return this.scope;
    }

    public Tokeninfo setScope(String str) {
        this.scope = str;
        return this;
    }

    public String getTokenHandle() {
        return this.tokenHandle;
    }

    public Tokeninfo setTokenHandle(String str) {
        this.tokenHandle = str;
        return this;
    }

    public String getUserId() {
        return this.userId;
    }

    public Tokeninfo setUserId(String str) {
        this.userId = str;
        return this;
    }

    public Boolean getVerifiedEmail() {
        return this.verifiedEmail;
    }

    public Tokeninfo setVerifiedEmail(Boolean bool) {
        this.verifiedEmail = bool;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public Tokeninfo set(String str, Object obj) {
        return (Tokeninfo) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public Tokeninfo clone() {
        return (Tokeninfo) super.clone();
    }
}
