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

/* loaded from: classes2.dex */
public class Credential implements HttpExecuteInterceptor, HttpRequestInitializer, HttpUnsuccessfulResponseHandler {

    /* renamed from: a, reason: collision with root package name */
    static final Logger f14595a = Logger.getLogger(Credential.class.getName());

    /* renamed from: b, reason: collision with root package name */
    private final Lock f14596b = new ReentrantLock();

    /* renamed from: c, reason: collision with root package name */
    private final AccessMethod f14597c;

    /* renamed from: d, reason: collision with root package name */
    private final Clock f14598d;

    /* renamed from: e, reason: collision with root package name */
    private String f14599e;

    /* renamed from: f, reason: collision with root package name */
    private Long f14600f;

    /* renamed from: g, reason: collision with root package name */
    private String f14601g;

    /* renamed from: h, reason: collision with root package name */
    private final HttpTransport f14602h;
    private final HttpExecuteInterceptor i;
    private final JsonFactory j;
    private final String k;
    private final Collection<CredentialRefreshListener> l;
    private final HttpRequestInitializer m;

    /* loaded from: classes2.dex */
    public interface AccessMethod {
        String a(HttpRequest httpRequest);

        void a(HttpRequest httpRequest, String str) throws IOException;
    }

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a, reason: collision with root package name */
        final AccessMethod f14603a;

        /* renamed from: b, reason: collision with root package name */
        HttpTransport f14604b;

        /* renamed from: c, reason: collision with root package name */
        JsonFactory f14605c;

        /* renamed from: d, reason: collision with root package name */
        GenericUrl f14606d;

        /* renamed from: f, reason: collision with root package name */
        HttpExecuteInterceptor f14608f;

        /* renamed from: g, reason: collision with root package name */
        HttpRequestInitializer f14609g;

        /* renamed from: e, reason: collision with root package name */
        Clock f14607e = Clock.f14923a;

        /* renamed from: h, reason: collision with root package name */
        Collection<CredentialRefreshListener> f14610h = Lists.a();

        public Builder(AccessMethod accessMethod) {
            Preconditions.a(accessMethod);
            this.f14603a = accessMethod;
        }

        public Builder a(String str) {
            this.f14606d = str == null ? null : new GenericUrl(str);
            return this;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Credential(Builder builder) {
        AccessMethod accessMethod = builder.f14603a;
        Preconditions.a(accessMethod);
        this.f14597c = accessMethod;
        this.f14602h = builder.f14604b;
        this.j = builder.f14605c;
        GenericUrl genericUrl = builder.f14606d;
        this.k = genericUrl == null ? null : genericUrl.build();
        this.i = builder.f14608f;
        this.m = builder.f14609g;
        this.l = Collections.unmodifiableCollection(builder.f14610h);
        Clock clock = builder.f14607e;
        Preconditions.a(clock);
        this.f14598d = clock;
    }

    @Override // com.google.api.client.http.HttpExecuteInterceptor
    public void a(HttpRequest httpRequest) throws IOException {
        this.f14596b.lock();
        try {
            Long f2 = f();
            if (this.f14599e == null || (f2 != null && f2.longValue() <= 60)) {
                k();
                if (this.f14599e == null) {
                    return;
                }
            }
            this.f14597c.a(httpRequest, this.f14599e);
        } finally {
            this.f14596b.unlock();
        }
    }

    @Override // com.google.api.client.http.HttpRequestInitializer
    public void b(HttpRequest httpRequest) throws IOException {
        httpRequest.a((HttpExecuteInterceptor) this);
        httpRequest.a((HttpUnsuccessfulResponseHandler) this);
    }

    public final HttpExecuteInterceptor c() {
        return this.i;
    }

    public final Clock d() {
        return this.f14598d;
    }

    public final Long e() {
        this.f14596b.lock();
        try {
            return this.f14600f;
        } finally {
            this.f14596b.unlock();
        }
    }

    public final Long f() {
        this.f14596b.lock();
        try {
            return this.f14600f == null ? null : Long.valueOf((this.f14600f.longValue() - this.f14598d.a()) / 1000);
        } finally {
            this.f14596b.unlock();
        }
    }

    public final JsonFactory g() {
        return this.j;
    }

    public final String h() {
        this.f14596b.lock();
        try {
            return this.f14601g;
        } finally {
            this.f14596b.unlock();
        }
    }

    public final String i() {
        return this.k;
    }

    public final HttpTransport j() {
        return this.f14602h;
    }

    public final boolean k() throws IOException {
        this.f14596b.lock();
        boolean z = true;
        try {
            try {
                TokenResponse a2 = a();
                if (a2 != null) {
                    a(a2);
                    Iterator<CredentialRefreshListener> it = this.l.iterator();
                    while (it.hasNext()) {
                        it.next().a(this, a2);
                    }
                    return true;
                }
            } catch (TokenResponseException e2) {
                if (400 > e2.getStatusCode() || e2.getStatusCode() >= 500) {
                    z = false;
                }
                if (e2.getDetails() != null && z) {
                    a((String) null);
                    b((Long) null);
                }
                Iterator<CredentialRefreshListener> it2 = this.l.iterator();
                while (it2.hasNext()) {
                    it2.next().a(this, e2.getDetails());
                }
                if (z) {
                    throw e2;
                }
            }
            return false;
        } finally {
            this.f14596b.unlock();
        }
    }

    public final String b() {
        this.f14596b.lock();
        try {
            return this.f14599e;
        } finally {
            this.f14596b.unlock();
        }
    }

    public Credential b(String str) {
        this.f14596b.lock();
        if (str != null) {
            try {
                Preconditions.a((this.j == null || this.f14602h == null || this.i == null || this.k == null) ? false : true, "Please use the Builder and call setJsonFactory, setTransport, setClientAuthentication and setTokenServerUrl/setTokenServerEncodedUrl");
            } finally {
                this.f14596b.unlock();
            }
        }
        this.f14601g = str;
        return this;
    }

    @Override // com.google.api.client.http.HttpUnsuccessfulResponseHandler
    public boolean a(HttpRequest httpRequest, HttpResponse httpResponse, boolean z) {
        boolean z2;
        boolean z3;
        List<String> a2 = httpResponse.e().a();
        boolean z4 = true;
        if (a2 != null) {
            for (String str : a2) {
                if (str.startsWith("Bearer ")) {
                    z3 = BearerToken.f14592a.matcher(str).find();
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        z3 = false;
        if (!z2) {
            z3 = httpResponse.g() == 401;
        }
        if (z3) {
            try {
                this.f14596b.lock();
                try {
                    if (Objects.a(this.f14599e, this.f14597c.a(httpRequest))) {
                        if (!k()) {
                            z4 = false;
                        }
                    }
                    return z4;
                } finally {
                    this.f14596b.unlock();
                }
            } catch (IOException e2) {
                f14595a.log(Level.SEVERE, "unable to refresh token", (Throwable) e2);
            }
        }
        return false;
    }

    public Credential b(Long l) {
        return a(l == null ? null : Long.valueOf(this.f14598d.a() + (l.longValue() * 1000)));
    }

    public Credential a(String str) {
        this.f14596b.lock();
        try {
            this.f14599e = str;
            return this;
        } finally {
            this.f14596b.unlock();
        }
    }

    public Credential a(Long l) {
        this.f14596b.lock();
        try {
            this.f14600f = l;
            return this;
        } finally {
            this.f14596b.unlock();
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
    public TokenResponse a() throws IOException {
        if (this.f14601g == null) {
            return null;
        }
        return new RefreshTokenRequest(this.f14602h, this.j, new GenericUrl(this.k), this.f14601g).a(this.i).a(this.m).execute();
    }
}
