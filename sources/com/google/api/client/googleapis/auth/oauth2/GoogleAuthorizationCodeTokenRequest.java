package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest;
import com.google.api.client.http.GenericUrl;
import java.io.IOException;

/* loaded from: classes2.dex */
public class GoogleAuthorizationCodeTokenRequest extends AuthorizationCodeTokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    public GoogleTokenResponse execute() throws IOException {
        return (GoogleTokenResponse) executeUnparsed().a(GoogleTokenResponse.class);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    public GoogleAuthorizationCodeTokenRequest set(String str, Object obj) {
        return (GoogleAuthorizationCodeTokenRequest) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleAuthorizationCodeTokenRequest a(GenericUrl genericUrl) {
        return (GoogleAuthorizationCodeTokenRequest) super.a(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeTokenRequest, com.google.api.client.auth.oauth2.TokenRequest
    public GoogleAuthorizationCodeTokenRequest a(String str) {
        return (GoogleAuthorizationCodeTokenRequest) super.a(str);
    }
}
