package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.content.Context;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Sleeper;
import java.io.IOException;

@Beta
/* loaded from: classes.dex */
public class GoogleAccountCredential implements HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    final Context f2434a;
    final String b;
    private String c;
    private Sleeper d;
    private BackOff e;

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) {
        a aVar = new a();
        httpRequest.a((HttpExecuteInterceptor) aVar);
        httpRequest.a((HttpUnsuccessfulResponseHandler) aVar);
    }

    public String a() throws IOException, GoogleAuthException {
        if (this.e != null) {
            this.e.a();
        }
        while (true) {
            try {
                return GoogleAuthUtil.a(this.f2434a, this.c, this.b);
            } catch (IOException e) {
                if (this.e == null || !BackOffUtils.a(this.d, this.e)) {
                    throw e;
                    break;
                }
                continue;
            }
        }
    }

    @Beta
    /* loaded from: classes.dex */
    class a implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {

        /* renamed from: a, reason: collision with root package name */
        boolean f2435a;
        String b;

        a() {
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void b(HttpRequest httpRequest) throws IOException {
            try {
                this.b = GoogleAccountCredential.this.a();
                HttpHeaders g = httpRequest.g();
                String valueOf = String.valueOf(this.b);
                g.b(valueOf.length() != 0 ? "Bearer ".concat(valueOf) : new String("Bearer "));
            } catch (GooglePlayServicesAvailabilityException e) {
                throw new GooglePlayServicesAvailabilityIOException(e);
            } catch (UserRecoverableAuthException e2) {
                throw new UserRecoverableAuthIOException(e2);
            } catch (GoogleAuthException e3) {
                throw new GoogleAuthIOException(e3);
            }
        }

        @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
        public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
            if (httpResponse.d() != 401 || this.f2435a) {
                return false;
            }
            this.f2435a = true;
            GoogleAuthUtil.a(GoogleAccountCredential.this.f2434a, this.b);
            return true;
        }
    }
}
