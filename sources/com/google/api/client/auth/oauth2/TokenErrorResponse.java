package com.google.api.client.auth.oauth2;

import com.facebook.internal.NativeProtocol;
import com.google.api.client.json.GenericJson;
import com.google.api.client.util.Key;
import com.google.api.client.util.Preconditions;

/* loaded from: classes.dex */
public class TokenErrorResponse extends GenericJson {

    @Key
    private String error;

    @Key(a = NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION)
    private String errorDescription;

    @Key(a = "error_uri")
    private String errorUri;

    public final String getError() {
        return this.error;
    }

    public TokenErrorResponse setError(String str) {
        this.error = (String) Preconditions.a(str);
        return this;
    }

    public final String getErrorDescription() {
        return this.errorDescription;
    }

    public TokenErrorResponse setErrorDescription(String str) {
        this.errorDescription = str;
        return this;
    }

    public final String getErrorUri() {
        return this.errorUri;
    }

    public TokenErrorResponse setErrorUri(String str) {
        this.errorUri = str;
        return this;
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData
    public TokenErrorResponse set(String str, Object obj) {
        return (TokenErrorResponse) super.set(str, obj);
    }

    @Override // com.google.api.client.json.GenericJson, com.google.api.client.util.GenericData, java.util.AbstractMap
    public TokenErrorResponse clone() {
        return (TokenErrorResponse) super.clone();
    }
}
