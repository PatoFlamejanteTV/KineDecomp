package com.google.api.client.auth.oauth2;

import com.facebook.internal.ServerProtocol;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public class AuthorizationRequestUrl extends GenericUrl {

    @Key("client_id")
    private String clientId;

    @Key(ServerProtocol.DIALOG_PARAM_REDIRECT_URI)
    private String redirectUri;

    @Key(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE)
    private String responseTypes;

    @Key("scope")
    private String scopes;

    @Key
    private String state;

    @Override // com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public AuthorizationRequestUrl set(String str, Object obj) {
        return (AuthorizationRequestUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public AuthorizationRequestUrl clone() {
        return (AuthorizationRequestUrl) super.clone();
    }
}
