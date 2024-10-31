package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

/* loaded from: classes2.dex */
public class RefreshTokenRequest extends TokenRequest {

    @Key("refresh_token")
    private String refreshToken;

    public RefreshTokenRequest(HttpTransport httpTransport, JsonFactory jsonFactory, GenericUrl genericUrl, String str) {
        super(httpTransport, jsonFactory, genericUrl, "refresh_token");
        setRefreshToken(str);
    }

    public RefreshTokenRequest setRefreshToken(String str) {
        Preconditions.a(str);
        this.refreshToken = str;
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest a(Class cls) {
        return a((Class<? extends TokenResponse>) cls);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public RefreshTokenRequest set(String str, Object obj) {
        return (RefreshTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public RefreshTokenRequest a(HttpRequestInitializer httpRequestInitializer) {
        super.a(httpRequestInitializer);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public RefreshTokenRequest a(GenericUrl genericUrl) {
        super.a(genericUrl);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public RefreshTokenRequest a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public RefreshTokenRequest a(HttpExecuteInterceptor httpExecuteInterceptor) {
        super.a(httpExecuteInterceptor);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public RefreshTokenRequest a(Class<? extends TokenResponse> cls) {
        super.a(cls);
        return this;
    }
}
