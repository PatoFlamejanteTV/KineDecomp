package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.B;
import okhttp3.F;
import okhttp3.I;
import okhttp3.M;
import okhttp3.a.b.h;

/* compiled from: ConnectInterceptor.java */
/* loaded from: classes3.dex */
public final class a implements B {

    /* renamed from: a, reason: collision with root package name */
    public final F f28991a;

    public a(F f2) {
        this.f28991a = f2;
    }

    @Override // okhttp3.B
    public M a(B.a aVar) throws IOException {
        h hVar = (h) aVar;
        I a2 = hVar.a();
        f i = hVar.i();
        return hVar.a(a2, i, i.a(this.f28991a, aVar, !a2.e().equals("GET")), i.c());
    }
}
