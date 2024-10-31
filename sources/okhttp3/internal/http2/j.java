package okhttp3.internal.http2;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class j extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29081b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ ErrorCode f29082c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f29083d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(k kVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        super(str, objArr);
        this.f29083d = kVar;
        this.f29081b = i;
        this.f29082c = errorCode;
    }

    @Override // okhttp3.a.b
    public void c() {
        this.f29083d.k.a(this.f29081b, this.f29082c);
        synchronized (this.f29083d) {
            this.f29083d.u.remove(Integer.valueOf(this.f29081b));
        }
    }
}
