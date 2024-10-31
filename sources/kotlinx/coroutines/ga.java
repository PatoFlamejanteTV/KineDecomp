package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public final class ga {

    /* renamed from: b */
    public static final ga f28622b = new ga();

    /* renamed from: a */
    private static final ThreadLocal<G> f28621a = new ThreadLocal<>();

    private ga() {
    }

    public final G a() {
        G g2 = f28621a.get();
        if (g2 != null) {
            return g2;
        }
        G c2 = I.c();
        f28621a.set(c2);
        return c2;
    }

    public final void b() {
        f28621a.set(null);
    }

    public final void a(G g2) {
        kotlin.jvm.internal.h.b(g2, "eventLoop");
        f28621a.set(g2);
    }
}
