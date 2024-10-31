package com.google.api.client.auth.oauth2;

import com.facebook.internal.ServerProtocol;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public class AuthorizationCodeTokenRequest extends TokenRequest {

    @Key
    private String code;

    @Key(ServerProtocol.DIALOG_PARAM_REDIRECT_URI)
    private String redirectUri;

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public /* bridge */ /* synthetic */ TokenRequest a(Class cls) {
        return a((Class<? extends TokenResponse>) cls);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public AuthorizationCodeTokenRequest set(String str, Object obj) {
        return (AuthorizationCodeTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public AuthorizationCodeTokenRequest a(GenericUrl genericUrl) {
        super.a(genericUrl);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public AuthorizationCodeTokenRequest a(String str) {
        super.a(str);
        return this;
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public AuthorizationCodeTokenRequest a(Class<? extends TokenResponse> cls) {
        super.a(cls);
        return this;
    }
}
