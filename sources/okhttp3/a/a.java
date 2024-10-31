package okhttp3.a;

import java.io.IOException;
import java.net.Socket;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.C2557a;
import okhttp3.C2569m;
import okhttp3.C2570n;
import okhttp3.InterfaceC2562f;
import okhttp3.M;
import okhttp3.P;
import okhttp3.z;

/* compiled from: Internal.java */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a */
    public static a f28854a;

    public abstract int a(M.a aVar);

    @Nullable
    public abstract IOException a(InterfaceC2562f interfaceC2562f, @Nullable IOException iOException);

    public abstract Socket a(C2569m c2569m, C2557a c2557a, okhttp3.internal.connection.f fVar);

    public abstract okhttp3.internal.connection.c a(C2569m c2569m, C2557a c2557a, okhttp3.internal.connection.f fVar, P p);

    public abstract okhttp3.internal.connection.d a(C2569m c2569m);

    public abstract void a(C2570n c2570n, SSLSocket sSLSocket, boolean z);

    public abstract void a(z.a aVar, String str);

    public abstract void a(z.a aVar, String str, String str2);

    public abstract boolean a(C2557a c2557a, C2557a c2557a2);

    public abstract boolean a(C2569m c2569m, okhttp3.internal.connection.c cVar);

    public abstract void b(C2569m c2569m, okhttp3.internal.connection.c cVar);
}
