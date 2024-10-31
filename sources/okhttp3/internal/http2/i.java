package okhttp3.internal.http2;

import java.io.IOException;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class i extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29076b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ okio.g f29077c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ int f29078d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ boolean f29079e;

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ k f29080f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(k kVar, String str, Object[] objArr, int i, okio.g gVar, int i2, boolean z) {
        super(str, objArr);
        this.f29080f = kVar;
        this.f29076b = i;
        this.f29077c = gVar;
        this.f29078d = i2;
        this.f29079e = z;
    }

    @Override // okhttp3.a.b
    public void c() {
        try {
            boolean a2 = this.f29080f.k.a(this.f29076b, this.f29077c, this.f29078d, this.f29079e);
            if (a2) {
                this.f29080f.s.a(this.f29076b, ErrorCode.CANCEL);
            }
            if (a2 || this.f29079e) {
                synchronized (this.f29080f) {
                    this.f29080f.u.remove(Integer.valueOf(this.f29076b));
                }
            }
        } catch (IOException unused) {
        }
    }
}
