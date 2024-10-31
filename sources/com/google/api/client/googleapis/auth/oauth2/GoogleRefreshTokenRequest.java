package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.RefreshTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import java.io.IOException;

/* loaded from: classes.dex */
public class GoogleRefreshTokenRequest extends RefreshTokenRequest {
    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (GoogleRefreshTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest b(GenericUrl genericUrl) {
        return (GoogleRefreshTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest b(String str) {
        return (GoogleRefreshTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (GoogleRefreshTokenRequest) super.b(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest
    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest c(String str) {
        return (GoogleRefreshTokenRequest) super.c(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleTokenResponse b() throws IOException {
        return (GoogleTokenResponse) a().a(GoogleTokenResponse.class);
    }

    @Override // com.google.api.client.auth.oauth2.RefreshTokenRequest, com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleRefreshTokenRequest set(String str, Object obj) {
        return (GoogleRefreshTokenRequest) super.set(str, obj);
    }
}
