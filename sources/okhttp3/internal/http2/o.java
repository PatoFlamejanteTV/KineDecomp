package okhttp3.internal.http2;

import java.io.IOException;
import okhttp3.internal.http2.k;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Http2Connection.java */
/* loaded from: classes3.dex */
public class o extends okhttp3.a.b {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f29110b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ k.d f29111c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o(k.d dVar, String str, Object[] objArr, v vVar) {
        super(str, objArr);
        this.f29111c = dVar;
        this.f29110b = vVar;
    }

    @Override // okhttp3.a.b
    public void c() {
        try {
            k.this.s.a(this.f29110b);
        } catch (IOException unused) {
            k.this.s();
        }
    }
}
