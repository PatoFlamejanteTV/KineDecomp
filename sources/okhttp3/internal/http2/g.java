package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class g extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29069b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f29070c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ k f29071d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(k kVar, String str, Object[] objArr, int i, List list) {
        super(str, objArr);
        this.f29071d = kVar;
        this.f29069b = i;
        this.f29070c = list;
    }

    @Override // okhttp3.a.b
    public void c() {
        if (this.f29071d.k.a(this.f29069b, this.f29070c)) {
            try {
                this.f29071d.s.a(this.f29069b, ErrorCode.CANCEL);
                synchronized (this.f29071d) {
                    this.f29071d.u.remove(Integer.valueOf(this.f29069b));
                }
            } catch (IOException unused) {
            }
        }
    }
}
