package com.google.api.client.googleapis.extensions.android.gms.auth;

import android.accounts.Account;
import android.content.Context;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
import com.google.android.gms.auth.GooglePlayServicesAvailabilityException;
import com.google.android.gms.auth.UserRecoverableAuthException;
import com.google.api.client.googleapis.extensions.android.accounts.GoogleAccountManager;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.util.BackOff;
import com.google.api.client.util.BackOffUtils;
import com.google.api.client.util.Beta;
import com.google.api.client.util.Joiner;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;
import java.io.IOException;
import java.util.Collection;

@Beta
/* loaded from: classes2.dex */
public class GoogleAccountCredential implements HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    final Context f14664a;

    /* renamed from: b, reason: collision with root package name */
    final String f14665b;

    /* renamed from: c, reason: collision with root package name */
    private final GoogleAccountManager f14666c;

    /* renamed from: d, reason: collision with root package name */
    private String f14667d;

    /* renamed from: e, reason: collision with root package name */
    private Account f14668e;

    /* renamed from: f, reason: collision with root package name */
    private Sleeper f14669f = Sleeper.f14980a;

    /* renamed from: g, reason: collision with root package name */
    private BackOff f14670g;

    public GoogleAccountCredential(Context context, String str) {
        this.f14666c = new GoogleAccountManager(context);
        this.f14664a = context;
        this.f14665b = str;
    }

    public static GoogleAccountCredential a(Context context, Collection<String> collection) {
        Preconditions.a(collection != null && collection.iterator().hasNext());
        return new GoogleAccountCredential(context, "oauth2: " + Joiner.a(' ').a(collection));
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) {
        a aVar = new a();
        httpRequest.a((HttpExecuteInterceptor) aVar);
        httpRequest.a((HttpUnsuccessfulResponseHandler) aVar);
    }

    public final GoogleAccountCredential a(Account account) {
        this.f14668e = account;
        this.f14667d = account == null ? null : account.name;
        return this;
    }

    @Beta
    /* loaded from: classes2.dex */
    class a implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {

        /* renamed from: a, reason: collision with root package name */
        boolean f14671a;

        /* renamed from: b, reason: collision with root package name */
        String f14672b;

        a() {
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void a(HttpRequest httpRequest) throws IOException {
            try {
                this.f14672b = GoogleAccountCredential.this.a();
                httpRequest.e().b("Bearer " + this.f14672b);
            } catch (GooglePlayServicesAvailabilityException e2) {
                throw new GooglePlayServicesAvailabilityIOException(e2);
            } catch (UserRecoverableAuthException e3) {
                throw new UserRecoverableAuthIOException(e3);
            } catch (GoogleAuthException e4) {
                throw new GoogleAuthIOException(e4);
            }
        }

        @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
        public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
            if (httpResponse.g() != 401 || this.f14671a) {
                return false;
            }
            this.f14671a = true;
            GoogleAuthUtil.a(GoogleAccountCredential.this.f14664a, this.f14672b);
            return true;
        }
    }

    public String a() throws IOException, GoogleAuthException {
        BackOff backOff = this.f14670g;
        if (backOff != null) {
            backOff.reset();
        }
        while (true) {
            try {
                return GoogleAuthUtil.a(this.f14664a, this.f14667d, this.f14665b);
            } catch (IOException e2) {
                if (this.f14670g == null || !BackOffUtils.a(this.f14669f, this.f14670g)) {
                    throw e2;
                }
            }
        }
        throw e2;
    }
}
