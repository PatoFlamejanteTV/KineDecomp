package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public class GoogleAuthorizationCodeRequestUrl extends AuthorizationCodeRequestUrl {

    @Key("access_type")
    private String accessType;

    @Key("approval_prompt")
    private String approvalPrompt;

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public GoogleAuthorizationCodeRequestUrl set(String str, Object obj) {
        return (GoogleAuthorizationCodeRequestUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.AuthorizationCodeRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GoogleAuthorizationCodeRequestUrl clone() {
        return (GoogleAuthorizationCodeRequestUrl) super.clone();
    }
}
