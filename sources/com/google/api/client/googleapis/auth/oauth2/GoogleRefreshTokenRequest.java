package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GoogleRefreshTokenRequest extends RefreshTokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public GoogleTokenResponse execute() throws IOException {
        return (GoogleTokenResponse) executeUnparsed().a(GoogleTokenResponse.class);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest
    public GoogleRefreshTokenRequest setRefreshToken(String str) {
        super.setRefreshToken(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public GoogleRefreshTokenRequest set(String str, Object obj) {
        return (GoogleRefreshTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest a(HttpRequestInitializer httpRequestInitializer) {
        return (GoogleRefreshTokenRequest) super.a(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest a(GenericUrl genericUrl) {
        return (GoogleRefreshTokenRequest) super.a(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest a(String str) {
        return (GoogleRefreshTokenRequest) super.a(str);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleRefreshTokenRequest a(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (GoogleRefreshTokenRequest) super.a(httpExecuteInterceptor);
    }
}
