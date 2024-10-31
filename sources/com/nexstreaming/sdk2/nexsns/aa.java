package com.nexstreaming.sdk2.nexsns;

import android.accounts.Account;
import android.content.Context;
import com.google.android.gms.auth.GoogleAuthException;
import com.google.android.gms.auth.GoogleAuthUtil;
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

/* compiled from: NexGoogleAccountCredential.java */
/* loaded from: classes.dex */
public class aa implements HttpRequestInitializer {

    /* renamed from: a, reason: collision with root package name */
    final Context f4412a;
    final String b;
    private final GoogleAccountManager c;
    private String d;
    private Account e;
    private Sleeper f = Sleeper.f2547a;
    private BackOff g;

    public aa(Context context, String str) {
        this.c = new GoogleAccountManager(context);
        this.f4412a = context;
        this.b = str;
    }

    public static aa a(Context context, Collection<String> collection) {
        Preconditions.a(collection != null && collection.iterator().hasNext());
        return new aa(context, "oauth2: " + Joiner.a(' ').a(collection));
    }

    public final aa a(Account account) {
        this.e = account;
        this.d = account.name;
        return this;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) {
        a aVar = new a();
        httpRequest.a((HttpExecuteInterceptor) aVar);
        httpRequest.a((HttpUnsuccessfulResponseHandler) aVar);
    }

    public aa a(BackOff backOff) {
        this.g = backOff;
        return this;
    }

    public String a() throws IOException, GoogleAuthException {
        if (this.g != null) {
            this.g.a();
        }
        while (true) {
            try {
                return GoogleAuthUtil.a(this.f4412a, this.d, this.b);
            } catch (IOException e) {
                if (this.g == null || !BackOffUtils.a(this.f, this.g)) {
                    throw e;
                    break;
                }
                continue;
            }
        }
    }

    /* compiled from: NexGoogleAccountCredential.java */
    @Beta
    /* loaded from: classes.dex */
    class a implements HttpExecuteInterceptor, HttpUnsuccessfulResponseHandler {

        /* renamed from: a, reason: collision with root package name */
        boolean f4413a;
        String b;

        a() {
        }

        @Override // com.google.api.client.http.HttpExecuteInterceptor
        public void b(HttpRequest httpRequest) throws IOException {
            try {
                this.b = aa.this.a();
                httpRequest.g().b("Bearer " + this.b);
            } catch (GoogleAuthException e) {
                throw new IOException(e);
            }
        }

        @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
        public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
            if (httpResponse.d() != 401 || this.f4413a) {
                return false;
            }
            this.f4413a = true;
            GoogleAuthUtil.a(aa.this.f4412a, this.b);
            return true;
        }
    }
}
