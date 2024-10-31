package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;

/* loaded from: classes2.dex */
public class ClientCredentialsTokenRequest extends TokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest a(Class cls) {
        return a((Class<? extends TokenResponse>) cls);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public ClientCredentialsTokenRequest set(String str, Object obj) {
        return (ClientCredentialsTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest a(GenericUrl genericUrl) {
        super.a(genericUrl);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public ClientCredentialsTokenRequest a(Class<? extends TokenResponse> cls) {
        super.a(cls);
        return this;
    }
}
