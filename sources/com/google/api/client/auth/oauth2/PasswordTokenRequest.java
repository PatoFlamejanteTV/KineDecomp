package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public class PasswordTokenRequest extends TokenRequest {

    @Key
    private String password;

    @Key
    private String username;

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest a(Class cls) {
        return a((Class<? extends TokenResponse>) cls);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public PasswordTokenRequest set(String str, Object obj) {
        return (PasswordTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest a(GenericUrl genericUrl) {
        super.a(genericUrl);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public PasswordTokenRequest a(Class<? extends TokenResponse> cls) {
        super.a(cls);
        return this;
    }
}
