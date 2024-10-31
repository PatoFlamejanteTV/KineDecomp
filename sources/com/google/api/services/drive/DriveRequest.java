package com.google.api.services.drive;

import com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.util.Key;

/* loaded from: classes.dex */
public abstract class DriveRequest<T> extends AbstractGoogleJsonClientRequest<T> {

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

    public DriveRequest(Drive drive, String str, String str2, Object obj, Class<T> cls) {
        super(drive, str, str2, obj, cls);
    }

    public String getAlt() {
        return this.alt;
    }

    /* renamed from: setAlt */
    public DriveRequest<T> setAlt2(String str) {
        this.alt = str;
        return this;
    }

    public String getFields() {
        return this.fields;
    }

    /* renamed from: setFields */
    public DriveRequest<T> setFields2(String str) {
        this.fields = str;
        return this;
    }

    public String getKey() {
        return this.key;
    }

    /* renamed from: setKey */
    public DriveRequest<T> setKey2(String str) {
        this.key = str;
        return this;
    }

    public String getOauthToken() {
        return this.oauthToken;
    }

    /* renamed from: setOauthToken */
    public DriveRequest<T> setOauthToken2(String str) {
        this.oauthToken = str;
        return this;
    }

    public Boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    /* renamed from: setPrettyPrint */
    public DriveRequest<T> setPrettyPrint2(Boolean bool) {
        this.prettyPrint = bool;
        return this;
    }

    public String getQuotaUser() {
        return this.quotaUser;
    }

    /* renamed from: setQuotaUser */
    public DriveRequest<T> setQuotaUser2(String str) {
        this.quotaUser = str;
        return this;
    }

    public String getUserIp() {
        return this.userIp;
    }

    /* renamed from: setUserIp */
    public DriveRequest<T> setUserIp2(String str) {
        this.userIp = str;
        return this;
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public final Drive getAbstractGoogleClient() {
        return (Drive) super.getAbstractGoogleClient();
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public DriveRequest<T> setDisableGZipContent(boolean z) {
        return (DriveRequest) super.setDisableGZipContent(z);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest
    public DriveRequest<T> setRequestHeaders(HttpHeaders httpHeaders) {
        return (DriveRequest) super.setRequestHeaders(httpHeaders);
    }

    @Override // com.google.api.client.googleapis.services.json.AbstractGoogleJsonClientRequest, com.google.api.client.googleapis.services.AbstractGoogleClientRequest, com.google.api.client.util.GenericData
    public DriveRequest<T> set(String str, Object obj) {
        return (DriveRequest) super.set(str, obj);
    }
}
