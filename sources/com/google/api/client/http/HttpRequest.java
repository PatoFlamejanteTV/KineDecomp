package com.google.api.client.http;

import com.google.api.client.util.Beta;
import com.google.api.client.util.ObjectParser;
import com.google.api.client.util.Preconditions;
import com.google.api.client.util.Sleeper;

/* loaded from: classes2.dex */
public final class HttpRequest {

    /* renamed from: a, reason: collision with root package name */
    private HttpExecuteInterceptor f14764a;

    /* renamed from: h, reason: collision with root package name */
    private HttpContent f14771h;
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

    /* renamed from: b, reason: collision with root package name */
    private HttpHeaders f14765b = new HttpHeaders();

    /* renamed from: c, reason: collision with root package name */
    private HttpHeaders f14766c = new HttpHeaders();

    /* renamed from: d, reason: collision with root package name */
    private int f14767d = 10;

    /* renamed from: e, reason: collision with root package name */
    private int f14768e = 16384;

    /* renamed from: f, reason: collision with root package name */
    private boolean f14769f = true;

    /* renamed from: g, reason: collision with root package name */
    private boolean f14770g = true;
    private int l = 20000;
    private int m = 20000;
    private boolean t = true;
    private boolean u = true;

    @Beta
    @Deprecated
    private boolean v = false;
    private Sleeper x = Sleeper.f14980a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public HttpRequest(HttpTransport httpTransport, String str) {
        this.i = httpTransport;
        a(str);
    }

    public HttpRequest a(String str) {
        Preconditions.a(str == null || HttpMediaType.b(str));
        this.j = str;
        return this;
    }

    public HttpContent b() {
        return this.f14771h;
    }

    public int c() {
        return this.f14768e;
    }

    public boolean d() {
        return this.t;
    }

    public HttpHeaders e() {
        return this.f14765b;
    }

    @Beta
    public HttpIOExceptionHandler f() {
        return this.o;
    }

    public HttpExecuteInterceptor g() {
        return this.f14764a;
    }

    public final ObjectParser h() {
        return this.q;
    }

    public String i() {
        return this.j;
    }

    public HttpHeaders j() {
        return this.f14766c;
    }

    public HttpResponseInterceptor k() {
        return this.p;
    }

    public boolean l() {
        return this.u;
    }

    public HttpTransport m() {
        return this.i;
    }

    public HttpUnsuccessfulResponseHandler n() {
        return this.n;
    }

    public GenericUrl o() {
        return this.k;
    }

    public boolean p() {
        return this.f14769f;
    }

    public HttpRequest a(GenericUrl genericUrl) {
        Preconditions.a(genericUrl);
        this.k = genericUrl;
        return this;
    }

    public HttpRequest a(HttpContent httpContent) {
        this.f14771h = httpContent;
        return this;
    }

    public HttpRequest a(HttpEncoding httpEncoding) {
        this.r = httpEncoding;
        return this;
    }

    public HttpRequest a(HttpExecuteInterceptor httpExecuteInterceptor) {
        this.f14764a = httpExecuteInterceptor;
        return this;
    }

    public HttpRequest a(HttpUnsuccessfulResponseHandler httpUnsuccessfulResponseHandler) {
        this.n = httpUnsuccessfulResponseHandler;
        return this;
    }

    @Beta
    public HttpRequest a(HttpIOExceptionHandler httpIOExceptionHandler) {
        this.o = httpIOExceptionHandler;
        return this;
    }

    public HttpRequest a(HttpResponseInterceptor httpResponseInterceptor) {
        this.p = httpResponseInterceptor;
        return this;
    }

    public HttpRequest a(ObjectParser objectParser) {
        this.q = objectParser;
        return this;
    }

    public HttpRequest a(boolean z) {
        this.u = z;
        return this;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(30:(1:9)|10|(1:12)|13|(1:170)(1:17)|(2:19|(23:21|(1:23)|24|(2:26|(1:28)(1:29))|30|(1:32)|33|(1:167)(1:37)|38|(7:40|(1:42)(1:165)|43|(1:45)(2:161|(1:163)(1:164))|(5:47|(2:49|(1:51))(1:159)|(2:53|(1:55))|56|(1:58))(1:160)|(1:60)|61)(1:166)|(2:63|(3:65|(1:67)|68))|(1:158)(1:71)|72|73|74|75|76|77|(3:105|106|(7:108|(1:110)(1:130)|(3:112|(1:(3:120|121|(2:123|124)))|114)|127|(1:129)|82|(2:85|(4:87|(1:89)|90|(1:102)(3:94|95|96))(1:103))(1:84)))|(1:80)(1:104)|81|82|(0)(0)))(1:169)|168|24|(0)|30|(0)|33|(1:35)|167|38|(0)(0)|(0)|(0)|158|72|73|74|75|76|77|(0)|(0)(0)|81|82|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x020a, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x020b, code lost:            r4 = r0;     */
    /* JADX WARN: Code restructure failed: missing block: B:146:0x020e, code lost:            if (r1.v == false) goto L100;     */
    /* JADX WARN: Code restructure failed: missing block: B:147:0x0210, code lost:            r0 = r1.o;     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0212, code lost:            if (r0 != null) goto L102;     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0218, code lost:            if (r0.a(r1, r2) == false) goto L174;     */
    /* JADX WARN: Code restructure failed: missing block: B:152:?, code lost:            throw r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x021b, code lost:            throw r4;     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x021c, code lost:            if (r8 != false) goto L107;     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x021e, code lost:            r7.log(java.util.logging.Level.WARNING, "exception thrown while executing request", (java.lang.Throwable) r4);     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0225, code lost:            r3 = null;     */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0228 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x02a9 A[LOOP:0: B:8:0x0021->B:84:0x02a9, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0288 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.api.client.http.HttpResponse a() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 684
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.api.client.http.HttpRequest.a():com.google.api.client.http.HttpResponse");
    }

    public boolean a(int i, HttpHeaders httpHeaders) {
        String location = httpHeaders.getLocation();
        if (!d() || !HttpStatusCodes.a(i) || location == null) {
            return false;
        }
        a(new GenericUrl(this.k.e(location)));
        if (i == 303) {
            a("GET");
            a((HttpContent) null);
        }
        this.f14765b.b((String) null);
        this.f14765b.e(null);
        this.f14765b.g(null);
        this.f14765b.f(null);
        this.f14765b.i(null);
        this.f14765b.h(null);
        return true;
    }
}
