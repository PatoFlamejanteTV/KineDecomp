package okhttp3;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.M;
import okhttp3.z;

/* compiled from: OkHttpClient.java */
/* loaded from: classes3.dex */
class E extends okhttp3.a.a {
    @Override // okhttp3.a.a
    public void a(z.a aVar, String str) {
        aVar.a(str);
    }

    @Override // okhttp3.a.a
    public void b(C2569m c2569m, okhttp3.internal.connection.c cVar) {
        c2569m.b(cVar);
    }

    @Override // okhttp3.a.a
    public void a(z.a aVar, String str, String str2) {
        aVar.b(str, str2);
    }

    @Override // okhttp3.a.a
    public boolean a(C2569m c2569m, okhttp3.internal.connection.c cVar) {
        return c2569m.a(cVar);
    }

    @Override // okhttp3.a.a
    public okhttp3.internal.connection.c a(C2569m c2569m, C2557a c2557a, okhttp3.internal.connection.f fVar, P p) {
        return c2569m.a(c2557a, fVar, p);
    }

    @Override // okhttp3.a.a
    public boolean a(C2557a c2557a, C2557a c2557a2) {
        return c2557a.a(c2557a2);
    }

    @Override // okhttp3.a.a
    public Socket a(C2569m c2569m, C2557a c2557a, okhttp3.internal.connection.f fVar) {
        return c2569m.a(c2557a, fVar);
    }

    @Override // okhttp3.a.a
    public okhttp3.internal.connection.d a(C2569m c2569m) {
        return c2569m.f29180f;
    }

    @Override // okhttp3.a.a
    public int a(M.a aVar) {
        return aVar.f28829c;
    }

    @Override // okhttp3.a.a
    public void a(C2570n c2570n, SSLSocket sSLSocket, boolean z) {
        c2570n.a(sSLSocket, z);
    }

    @Override // okhttp3.a.a
    @Nullable
    public IOException a(InterfaceC2562f interfaceC2562f, @Nullable IOException iOException) {
        return ((H) interfaceC2562f).a(iOException);
    }
}
