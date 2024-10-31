package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;

/* loaded from: classes.dex */
public class ClientCredentialsTokenRequest extends TokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClientCredentialsTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (ClientCredentialsTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClientCredentialsTokenRequest b(GenericUrl genericUrl) {
        return (ClientCredentialsTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClientCredentialsTokenRequest b(String str) {
        return (ClientCredentialsTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClientCredentialsTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (ClientCredentialsTokenRequest) super.b(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ClientCredentialsTokenRequest set(String str, Object obj) {
        return (ClientCredentialsTokenRequest) super.set(str, obj);
    }
}
