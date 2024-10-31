package com.google.api.services.oauth2;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public abstract class Oauth2Request<T> extends AbstractGoogleJsonClientRequest<T> {

    @Key
    private String alt;

    @Key
    private String fields;

    @Key
    private String key;

    @Key(a = "oauth_token")
    private String oauthToken;

    @Key
    private Boolean prettyPrint;

    @Key
    private String quotaUser;

    @Key
    private String userIp;

    public Oauth2Request(Oauth2 oauth2, String str, String str2, Object obj, Class<T> cls) {
        super(oauth2, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    /* renamed from: setAlt */
    public Oauth2Request<T> setAlt2(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    /* renamed from: setFields */
    public Oauth2Request<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    /* renamed from: setKey */
    public Oauth2Request<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    /* renamed from: setOauthToken */
    public Oauth2Request<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* renamed from: setPrettyPrint */
    public Oauth2Request<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    /* renamed from: setQuotaUser */
    public Oauth2Request<T> setQuotaUser2(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    /* renamed from: setUserIp */
    public Oauth2Request<T> setUserIp2(String str) {
        this.userIp = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Oauth2 getAbstractGoogleClient() {
        return (Oauth2) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public Oauth2Request<T> setDisableGZipContent(boolean z) {
        return (Oauth2Request) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public Oauth2Request<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (Oauth2Request) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public Oauth2Request<T> set(String str, Object obj) {
        return (Oauth2Request) super.set(str, obj);
    }
}
