package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

/* loaded from: classes.dex */
public class RefreshTokenRequest extends TokenRequest {

    @Key(a = "refresh_token")
    private String c;

    public RefreshTokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        super(httpTransport, jsonFactory, genericUrl, "refresh_token");
        c(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a */
    public RefreshTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (RefreshTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a */
    public RefreshTokenRequest b(GenericUrl genericUrl) {
        return (RefreshTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a */
    public RefreshTokenRequest b(String str) {
        return (RefreshTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a */
    public RefreshTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (RefreshTokenRequest) super.b(httpExecuteInterceptor);
    }

    public RefreshTokenRequest c(String str) {
        this.c = (String) Preconditions.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: a */
    public RefreshTokenRequest set(String str, Object obj) {
        return (RefreshTokenRequest) super.set(str, obj);
    }
}
