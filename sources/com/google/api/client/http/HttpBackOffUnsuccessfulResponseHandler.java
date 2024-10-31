package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes2.dex */
public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    /* renamed from: a */
    private final BackOff f14743a;

    /* renamed from: b */
    private BackOffRequired f14744b;

    /* renamed from: c */
    private Sleeper f14745c;

    @Beta
    /* loaded from: classes2.dex */
    public interface BackOffRequired {

        /* renamed from: a */
        public static final BackOffRequired f14746a = new b();

        /* renamed from: b */
        public static final BackOffRequired f14747b = new c();

        boolean a(HttpResponse httpResponse);
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public final boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        if (!z || !this.f14744b.a(httpResponse)) {
            return false;
        }
        try {
            return BackOffUtils.a(this.f14745c, this.f14743a);
        } catch (InterruptedException unused) {
            return false;
        }
    }
}
