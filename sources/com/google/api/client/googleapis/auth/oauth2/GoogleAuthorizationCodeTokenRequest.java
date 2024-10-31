package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Preconditions;
import java.io.IOException;

/* loaded from: classes.dex */
public class GoogleAuthorizationCodeTokenRequest extends AuthorizationCodeTokenRequest {
    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleAuthorizationCodeTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (GoogleAuthorizationCodeTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleAuthorizationCodeTokenRequest b(GenericUrl genericUrl) {
        return (GoogleAuthorizationCodeTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleAuthorizationCodeTokenRequest b(String str) {
        return (GoogleAuthorizationCodeTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleAuthorizationCodeTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        Preconditions.a(httpExecuteInterceptor);
        return (GoogleAuthorizationCodeTokenRequest) super.b(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleTokenResponse b() throws IOException {
        return (GoogleTokenResponse) a().a(GoogleTokenResponse.class);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public GoogleAuthorizationCodeTokenRequest set(String str, Object obj) {
        return (GoogleAuthorizationCodeTokenRequest) super.set(str, obj);
    }
}
