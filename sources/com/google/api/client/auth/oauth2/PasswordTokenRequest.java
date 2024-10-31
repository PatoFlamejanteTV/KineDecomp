package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequestInitializer;

/* loaded from: classes.dex */
public class PasswordTokenRequest extends TokenRequest {
    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PasswordTokenRequest b(HttpRequestInitializer httpRequestInitializer) {
        return (PasswordTokenRequest) super.b(httpRequestInitializer);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PasswordTokenRequest b(GenericUrl genericUrl) {
        return (PasswordTokenRequest) super.b(genericUrl);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PasswordTokenRequest b(String str) {
        return (PasswordTokenRequest) super.b(str);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PasswordTokenRequest b(HttpExecuteInterceptor httpExecuteInterceptor) {
        return (PasswordTokenRequest) super.b(httpExecuteInterceptor);
    }

    @Override // com.google.api.client.auth.oauth2.TokenRequest, com.google.api.client.util.GenericData
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PasswordTokenRequest set(String str, Object obj) {
        return (PasswordTokenRequest) super.set(str, obj);
    }
}
