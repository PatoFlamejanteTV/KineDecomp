package okhttp3.internal.http2;

import java.io.IOException;
import java.util.List;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class h extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ int f29072b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f29073c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ boolean f29074d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ k f29075e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(k kVar, String str, Object[] objArr, int i, List list, boolean z) {
        super(str, objArr);
        this.f29075e = kVar;
        this.f29072b = i;
        this.f29073c = list;
        this.f29074d = z;
    }

    @Override // okhttp3.a.b
    public void c() {
        boolean a2 = this.f29075e.k.a(this.f29072b, this.f29073c, this.f29074d);
        if (a2) {
            try {
                this.f29075e.s.a(this.f29072b, ErrorCode.CANCEL);
            } catch (IOException unused) {
                return;
            }
        }
        if (a2 || this.f29074d) {
            synchronized (this.f29075e) {
                this.f29075e.u.remove(Integer.valueOf(this.f29072b));
            }
        }
    }
}
