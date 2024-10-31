package com.google.api.services.plus;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public abstract class PlusRequest<T> extends AbstractGoogleJsonClientRequest<T> {

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

    public PlusRequest(Plus plus, String str, String str2, Object obj, Class<T> cls) {
        super(plus, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    /* renamed from: setAlt */
    public PlusRequest<T> setAlt2(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    /* renamed from: setFields */
    public PlusRequest<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    /* renamed from: setKey */
    public PlusRequest<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    /* renamed from: setOauthToken */
    public PlusRequest<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* renamed from: setPrettyPrint */
    public PlusRequest<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    /* renamed from: setQuotaUser */
    public PlusRequest<T> setQuotaUser2(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    /* renamed from: setUserIp */
    public PlusRequest<T> setUserIp2(String str) {
        this.userIp = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Plus getAbstractGoogleClient() {
        return (Plus) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public PlusRequest<T> setDisableGZipContent(boolean z) {
        return (PlusRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public PlusRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (PlusRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public PlusRequest<T> set(String str, Object obj) {
        return (PlusRequest) super.set(str, obj);
    }
}
