package com.google.api.client.googleapis.auth.clientlogin;

import android.support.v4.app.NotificationCompat;
import com.facebook.share.internal.ShareConstants;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Key;

@Beta
/* loaded from: classes2.dex */
public final class ClientLogin {

    /* renamed from: a */
    public GenericUrl f14647a = new GenericUrl("https://www.google.com");

    @Key
    public String accountType;

    @Key(ShareConstants.FEED_SOURCE_PARAM)
    public String applicationName;

    @Key(NotificationCompat.CATEGORY_SERVICE)
    public String authTokenType;

    @Key("logincaptcha")
    public String captchaAnswer;

    @Key("logintoken")
    public String captchaToken;

    @Key("Passwd")
    public String password;

    @Key("Email")
    public String username;

    /* loaded from: classes2.dex */
    public static final class ErrorInfo {

        @Key("CaptchaToken")
        public String captchaToken;

        @Key("CaptchaUrl")
        public String captchaUrl;

        @Key("Error")
        public String error;

        @Key("Url")
        public String url;
    }

    /* loaded from: classes2.dex */
    public static final class Response implements HttpExecuteInterceptor, HttpRequestInitializer {

        @Key("Auth")
        public String auth;

        public String a() {
            return ClientLogin.a(this.auth);
        }

        @Override // com.google.api.client.http.HttpRequestInitializer
        public void b(HttpRequest httpRequest) {
            httpRequest.a(this);
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void a(HttpRequest httpRequest) {
            httpRequest.e().b(a());
        }
    }

    public static String a(String str) {
        return "GoogleLogin auth=" + str;
    }
}
