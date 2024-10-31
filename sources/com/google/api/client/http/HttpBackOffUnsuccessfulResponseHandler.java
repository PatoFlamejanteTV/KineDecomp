package com.google.api.client.http;

import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class HttpBackOffUnsuccessfulResponseHandler implements HttpUnsuccessfulResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    private final BackOff f2458a;
    private BackOffRequired b;
    private Sleeper c;

    @Beta
    /* loaded from: classes.dex */
    public interface BackOffRequired {

        /* renamed from: a, reason: collision with root package name */
        public static final BackOffRequired f2459a = new b();
        public static final BackOffRequired b = new c();

        boolean a(HttpResponse httpResponse);
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public final boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) throws IOException {
        if (!z || !this.b.a(httpResponse)) {
            return false;
        }
        try {
            return BackOffUtils.a(this.c, this.f2458a);
        } catch (InterruptedException e) {
            return false;
        }
    }
}
