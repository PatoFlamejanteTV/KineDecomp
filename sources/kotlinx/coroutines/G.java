package kotlinx.coroutines;

/* compiled from: EventLoop.common.kt */
/* loaded from: classes3.dex */
public abstract class G extends AbstractC2546o {

    /* renamed from: b */
    private long f28585b;

    /* renamed from: c */
    private boolean f28586c;

    /* renamed from: d */
    private kotlinx.coroutines.internal.b<C<?>> f28587d;

    private final long c(boolean z) {
        return z ? 4294967296L : 1L;
    }

    public final void a(C<?> c2) {
        kotlin.jvm.internal.h.b(c2, "task");
        kotlinx.coroutines.internal.b<C<?>> bVar = this.f28587d;
        if (bVar == null) {
            bVar = new kotlinx.coroutines.internal.b<>();
            this.f28587d = bVar;
        }
        bVar.a(c2);
    }

    public final void b(boolean z) {
        this.f28585b += c(z);
        if (z) {
            return;
        }
        this.f28586c = true;
    }

    protected void shutdown() {
    }

    public long u() {
        kotlinx.coroutines.internal.b<C<?>> bVar = this.f28587d;
        return (bVar == null || bVar.a()) ? Long.MAX_VALUE : 0L;
    }

    public final boolean v() {
        return this.f28585b >= c(true);
    }

    public final boolean w() {
        kotlinx.coroutines.internal.b<C<?>> bVar = this.f28587d;
        if (bVar != null) {
            return bVar.a();
        }
        return true;
    }

    public final boolean x() {
        C<?> b2;
        kotlinx.coroutines.internal.b<C<?>> bVar = this.f28587d;
        if (bVar == null || (b2 = bVar.b()) == null) {
            return false;
        }
        b2.run();
        return true;
    }

    public static /* synthetic */ void a(G g2, boolean z, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                z = false;
            }
            g2.b(z);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incrementUseCount");
    }

    public final void a(boolean z) {
        this.f28585b -= c(z);
        long j = this.f28585b;
        if (j > 0) {
            return;
        }
        if (j == 0) {
            if (this.f28586c) {
                shutdown();
                return;
            }
            return;
        }
        throw new IllegalStateException("Extra decrementUseCount");
    }
}
