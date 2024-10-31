package kotlinx.coroutines.scheduling;

import kotlinx.coroutines.AbstractC2546o;
import kotlinx.coroutines.internal.r;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public final class b extends c {

    /* renamed from: g, reason: collision with root package name */
    private static final AbstractC2546o f28695g;

    /* renamed from: h, reason: collision with root package name */
    public static final b f28696h;

    static {
        int a2;
        b bVar = new b();
        f28696h = bVar;
        a2 = kotlin.c.h.a(64, r.a());
        f28695g = bVar.a(r.a("kotlinx.coroutines.io.parallelism", a2, 0, 0, 12, (Object) null));
    }

    private b() {
        super(0, 0, null, 7, null);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new UnsupportedOperationException("DefaultDispatcher cannot be closed");
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public String toString() {
        return "DefaultDispatcher";
    }

    public final AbstractC2546o u() {
        return f28695g;
    }
}
