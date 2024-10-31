package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.k;

/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
class m extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ q f29107b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ k.d f29108c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(k.d dVar, String str, Object[] objArr, q qVar) {
        super(str, objArr);
        this.f29108c = dVar;
        this.f29107b = qVar;
    }

    @Override // okhttp3.a.b
    public void c() {
        try {
            k.this.f29086c.a(this.f29107b);
        } catch (IOException e2) {
            okhttp3.a.d.f.a().a(4, "Http2Connection.Listener failure for " + k.this.f29088e, e2);
            try {
                this.f29107b.a(ErrorCode.PROTOCOL_ERROR);
            } catch (IOException unused) {
            }
        }
    }
}
