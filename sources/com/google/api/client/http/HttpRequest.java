package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;

/* loaded from: classes.dex */
public final class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private HttpExecuteInterceptor f2465a;
    private HttpContent h;
    private final HttpTransport i;
    private String j;
    private GenericUrl k;
    private HttpUnsuccessfulResponseHandler n;

    @Beta
    private HttpIOExceptionHandler o;
    private HttpResponseInterceptor p;
    private ObjectParser q;
    private HttpEncoding r;

    @Beta
    @Deprecated
    private BackOffPolicy s;
    private boolean w;
    private HttpHeaders b = new HttpHeaders();
    private HttpHeaders c = new HttpHeaders();
    private int d = 10;
    private int e = 16384;
    private boolean f = true;
    private boolean g = true;
    private int l = 20000;
    private int m = 20000;
    private boolean t = true;
    private boolean u = true;

    @Beta
    @Deprecated
    private boolean v = false;
    private Sleeper x = Sleeper.f2547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequest(HttpTransport httpTransport, String str) {
        this.i = httpTransport;
        a(str);
    }

    public HttpTransport a() {
        return this.i;
    }

    public String b() {
        return this.j;
    }

    public HttpRequest a(String str) {
        Preconditions.a(str == null || HttpMediaType.e(str));
        this.j = str;
        return this;
    }

    public GenericUrl c() {
        return this.k;
    }

    public HttpRequest a(GenericUrl genericUrl) {
        this.k = (GenericUrl) Preconditions.a(genericUrl);
        return this;
    }

    public HttpContent d() {
        return this.h;
    }

    public HttpRequest a(HttpContent httpContent) {
        this.h = httpContent;
        return this;
    }

    public HttpRequest a(HttpEncoding httpEncoding) {
        this.r = httpEncoding;
        return this;
    }

    public int e() {
        return this.e;
    }

    public boolean f() {
        return this.f;
    }

    public HttpHeaders g() {
        return this.b;
    }

    public HttpHeaders h() {
        return this.c;
    }

    public HttpExecuteInterceptor i() {
        return this.f2465a;
    }

    public HttpRequest a(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f2465a = httpExecuteInterceptor;
        return this;
    }

    public HttpUnsuccessfulResponseHandler j() {
        return this.n;
    }

    public HttpRequest a(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.n = httpUnsuccessfulResponseHandler;
        return this;
    }

    @Beta
    public HttpIOExceptionHandler k() {
        return this.o;
    }

    @Beta
    public HttpRequest a(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.o = httpIOExceptionHandler;
        return this;
    }

    public HttpResponseInterceptor l() {
        return this.p;
    }

    public HttpRequest a(HttpResponseInterceptor httpResponseInterceptor) {
        this.p = httpResponseInterceptor;
        return this;
    }

    public HttpRequest a(ObjectParser objectParser) {
        this.q = objectParser;
        return this;
    }

    public final ObjectParser m() {
        return this.q;
    }

    public boolean n() {
        return this.t;
    }

    public boolean o() {
        return this.u;
    }

    public HttpRequest a(boolean z) {
        this.u = z;
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:97:0x039e A[LOOP:0: B:8:0x002b->B:97:0x039e, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0287 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.api.client.http.HttpResponse p() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 932
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.p():com.google.api.client.http.HttpResponse");
    }

    public boolean a(int i, HttpHeaders httpHeaders) {
        String f = httpHeaders.f();
        if (!n() || !HttpStatusCodes.b(i) || f == null) {
            return false;
        }
        a(new GenericUrl(this.k.c(f)));
        if (i == 303) {
            a("GET");
            a((HttpContent) null);
        }
        this.b.b((String) null);
        this.b.g((String) null);
        this.b.h((String) null);
        this.b.f((String) null);
        this.b.i((String) null);
        this.b.j((String) null);
        return true;
    }
}
