package com.google.api.client.googleapis.auth.clientlogin;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;

@Beta
/* loaded from: classes.dex */
public final class ClientLogin {

    /* renamed from: a, reason: collision with root package name */
    public GenericUrl f2426a = new GenericUrl("https://www.google.com");

    /* loaded from: classes.dex */
    public static final class ErrorInfo {
    }

    /* loaded from: classes.dex */
    public static final class Response implements HttpExecuteInterceptor, HttpRequestInitializer {

        /* renamed from: a, reason: collision with root package name */
        @Key(a = "Auth")
        public String f2427a;

        public String a() {
            return ClientLogin.a(this.f2427a);
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void a(HttpRequest httpRequest) {
            httpRequest.a(this);
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void b(HttpRequest httpRequest) {
            httpRequest.g().b(a());
        }
    }

    public static String a(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? "GoogleLogin auth=".concat(valueOf) : new String("GoogleLogin auth=");
    }
}
