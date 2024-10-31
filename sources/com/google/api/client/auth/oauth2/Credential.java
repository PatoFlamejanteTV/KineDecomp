package com.google.api.client.auth.oauth2;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpExecuteInterceptor;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.HttpUnsuccessfulResponseHandler;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Lists;
import com.google.api.client.util.Objects;
import com.google.api.client.util.Preconditions;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f2410a = Logger.getLogger(Credential.class.getName());
    private final Lock b = new ReentrantLock();
    private final AccessMethod c;
    private final Clock d;
    private String e;
    private Long f;
    private String g;
    private final HttpTransport h;
    private final HttpExecuteInterceptor i;
    private final JsonFactory j;
    private final String k;
    private final Collection<CredentialRefreshListener> l;
    private final HttpRequestInitializer m;

    /* loaded from: classes.dex */
    public interface AccessMethod {
        String a(HttpRequest httpRequest);

        void a(HttpRequest httpRequest, String str) throws IOException;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Credential(Builder builder) {
        this.c = (AccessMethod) Preconditions.a(builder.f2411a);
        this.h = builder.b;
        this.j = builder.c;
        this.k = builder.d == null ? null : builder.d.j();
        this.i = builder.f;
        this.m = builder.g;
        this.l = Collections.unmodifiableCollection(builder.h);
        this.d = (Clock) Preconditions.a(builder.e);
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void b(HttpRequest httpRequest) throws IOException {
        this.b.lock();
        try {
            Long h = h();
            if (this.e == null || (h != null && h.longValue() <= 60)) {
                j();
                if (this.e == null) {
                    return;
                }
            }
            this.c.a(httpRequest, this.e);
        } finally {
            this.b.unlock();
        }
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        List<String> i = httpResponse.b().i();
        if (i != null) {
            for (String str : i) {
                if (str.startsWith("Bearer ")) {
                    z3 = BearerToken.f2408a.matcher(str).find();
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        z3 = false;
        if (!z2) {
            z3 = httpResponse.d() == 401;
        }
        if (z3) {
            try {
                this.b.lock();
                try {
                    if (Objects.a(this.e, this.c.a(httpRequest))) {
                        if (!j()) {
                            z4 = false;
                        }
                    }
                    return z4;
                } finally {
                    this.b.unlock();
                }
            } catch (IOException e) {
                f2410a.log(Level.SEVERE, "unable to refresh token", (Throwable) e);
            }
        }
        return false;
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void a(HttpRequest httpRequest) throws IOException {
        httpRequest.a((HttpExecuteInterceptor) this);
        httpRequest.a((HttpUnsuccessfulResponseHandler) this);
    }

    public final String a() {
        this.b.lock();
        try {
            return this.e;
        } finally {
            this.b.unlock();
        }
    }

    public Credential a(String str) {
        this.b.lock();
        try {
            this.e = str;
            return this;
        } finally {
            this.b.unlock();
        }
    }

    public final Clock b() {
        return this.d;
    }

    public final HttpTransport c() {
        return this.h;
    }

    public final JsonFactory d() {
        return this.j;
    }

    public final String e() {
        return this.k;
    }

    public final String f() {
        this.b.lock();
        try {
            return this.g;
        } finally {
            this.b.unlock();
        }
    }

    public Credential b(String str) {
        this.b.lock();
        if (str != null) {
            try {
                Preconditions.a((this.j == null || this.h == null || this.i == null || this.k == null) ? false : true, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
            } finally {
                this.b.unlock();
            }
        }
        this.g = str;
        return this;
    }

    public final Long g() {
        this.b.lock();
        try {
            return this.f;
        } finally {
            this.b.unlock();
        }
    }

    public Credential a(Long l) {
        this.b.lock();
        try {
            this.f = l;
            return this;
        } finally {
            this.b.unlock();
        }
    }

    public final Long h() {
        this.b.lock();
        try {
            if (this.f != null) {
                return Long.valueOf((this.f.longValue() - this.d.a()) / 1000);
            }
            return null;
        } finally {
            this.b.unlock();
        }
    }

    public Credential b(Long l) {
        return a(l == null ? null : Long.valueOf(this.d.a() + (l.longValue() * 1000)));
    }

    public final HttpExecuteInterceptor i() {
        return this.i;
    }

    public final boolean j() throws IOException {
        this.b.lock();
        try {
            try {
                TokenResponse k = k();
                if (k != null) {
                    a(k);
                    Iterator<CredentialRefreshListener> it = this.l.iterator();
                    while (it.hasNext()) {
                        it.next().a(this, k);
                    }
                    return true;
                }
            } catch (TokenResponseException e) {
                boolean z = 400 <= e.getStatusCode() && e.getStatusCode() < 500;
                if (e.getDetails() != null && z) {
                    a((String) null);
                    b((Long) null);
                }
                Iterator<CredentialRefreshListener> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, e.getDetails());
                }
                if (z) {
                    throw e;
                }
            }
            return false;
        } finally {
            this.b.unlock();
        }
    }

    public Credential a(TokenResponse tokenResponse) {
        a(tokenResponse.getAccessToken());
        if (tokenResponse.getRefreshToken() != null) {
            b(tokenResponse.getRefreshToken());
        }
        b(tokenResponse.getExpiresInSeconds());
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public TokenResponse k() throws IOException {
        if (this.g == null) {
            return null;
        }
        return new RefreshTokenRequest(this.h, this.j, new GenericUrl(this.k), this.g).b(this.i).b(this.m).b();
    }

    /* loaded from: classes.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        final AccessMethod f2411a;
        HttpTransport b;
        JsonFactory c;
        GenericUrl d;
        HttpExecuteInterceptor f;
        HttpRequestInitializer g;
        Clock e = Clock.f2532a;
        Collection<CredentialRefreshListener> h = Lists.a();

        public Builder(AccessMethod accessMethod) {
            this.f2411a = (AccessMethod) Preconditions.a(accessMethod);
        }

        public Builder a(String str) {
            this.d = str == null ? null : new GenericUrl(str);
            return this;
        }
    }
}
