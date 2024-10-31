package io.fabric.sdk.android.services.network;

import io.fabric.sdk.android.o;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

/* compiled from: DefaultHttpRequestFactory.java */
/* loaded from: classes3.dex */
public class c implements f {

    /* renamed from: a */
    private final o f26976a;

    /* renamed from: b */
    private h f26977b;

    /* renamed from: c */
    private SSLSocketFactory f26978c;

    /* renamed from: d */
    private boolean f26979d;

    public c() {
        this(new io.fabric.sdk.android.c());
    }

    private synchronized SSLSocketFactory b() {
        SSLSocketFactory a2;
        this.f26979d = true;
        try {
            a2 = g.a(this.f26977b);
            this.f26976a.d("Fabric", "Custom SSL pinning enabled");
        } catch (Exception e2) {
            this.f26976a.c("Fabric", "Exception while validating pinned certs", e2);
            return null;
        }
        return a2;
    }

    private synchronized void c() {
        this.f26979d = false;
        this.f26978c = null;
    }

    @Override // io.fabric.sdk.android.services.network.f
    public void a(h hVar) {
        if (this.f26977b != hVar) {
            this.f26977b = hVar;
            c();
        }
    }

    public c(o oVar) {
        this.f26976a = oVar;
    }

    @Override // io.fabric.sdk.android.services.network.f
    public HttpRequest a(HttpMethod httpMethod, String str) {
        return a(httpMethod, str, Collections.emptyMap());
    }

    @Override // io.fabric.sdk.android.services.network.f
    public HttpRequest a(HttpMethod httpMethod, String str, Map<String, String> map) {
        HttpRequest a2;
        SSLSocketFactory a3;
        int i = b.f26975a[httpMethod.ordinal()];
        if (i == 1) {
            a2 = HttpRequest.a((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 2) {
            a2 = HttpRequest.b((CharSequence) str, (Map<?, ?>) map, true);
        } else if (i == 3) {
            a2 = HttpRequest.e((CharSequence) str);
        } else if (i == 4) {
            a2 = HttpRequest.a((CharSequence) str);
        } else {
            throw new IllegalArgumentException("Unsupported HTTP method!");
        }
        if (a(str) && this.f26977b != null && (a3 = a()) != null) {
            ((HttpsURLConnection) a2.j()).setSSLSocketFactory(a3);
        }
        return a2;
    }

    private boolean a(String str) {
        return str != null && str.toLowerCase(Locale.US).startsWith("https");
    }

    private synchronized SSLSocketFactory a() {
        if (this.f26978c == null && !this.f26979d) {
            this.f26978c = b();
        }
        return this.f26978c;
    }
}
