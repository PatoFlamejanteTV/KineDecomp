package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;

/* loaded from: classes.dex */
public class AuthorizationCodeTokenRequest extends TokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthorizationCodeTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (AuthorizationCodeTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthorizationCodeTokenRequest b(GenericUrl genericUrl) {
        return (AuthorizationCodeTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthorizationCodeTokenRequest b(String str) {
        return (AuthorizationCodeTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthorizationCodeTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (AuthorizationCodeTokenRequest) super.b(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AuthorizationCodeTokenRequest set(String str, Object obj) {
        return (AuthorizationCodeTokenRequest) super.set(str, obj);
    }
}
