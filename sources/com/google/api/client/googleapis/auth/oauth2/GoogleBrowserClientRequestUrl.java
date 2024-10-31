package com.google.api.client.googleapis.auth.oauth2;

import com.google.api.client.auth.oauth2.BrowserClientRequestUrl;
import com.google.api.client.util.Key;

/* loaded from: classes2.dex */
public class GoogleBrowserClientRequestUrl extends BrowserClientRequestUrl {

    @Key("approval_prompt")
    private String approvalPrompt;

    @Override // com.google.api.client.auth.oauth2.BrowserClientRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData
    public GoogleBrowserClientRequestUrl set(String str, Object obj) {
        return (GoogleBrowserClientRequestUrl) super.set(str, obj);
    }

    @Override // com.google.api.client.auth.oauth2.BrowserClientRequestUrl, com.google.api.client.auth.oauth2.AuthorizationRequestUrl, com.google.api.client.http.GenericUrl, com.google.api.client.util.GenericData, java.util.AbstractMap
    public GoogleBrowserClientRequestUrl clone() {
        return (GoogleBrowserClientRequestUrl) super.clone();
    }
}
