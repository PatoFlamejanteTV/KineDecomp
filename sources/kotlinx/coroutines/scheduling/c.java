package kotlinx.coroutines.scheduling;

import java.util.concurrent.RejectedExecutionException;
import kotlinx.coroutines.AbstractC2546o;
import kotlinx.coroutines.J;
import kotlinx.coroutines.RunnableC2554x;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
public class c extends J {

    /* renamed from: b, reason: collision with root package name */
    private CoroutineScheduler f28697b;

    /* renamed from: c, reason: collision with root package name */
    private final int f28698c;

    /* renamed from: d, reason: collision with root package name */
    private final int f28699d;

    /* renamed from: e, reason: collision with root package name */
    private final long f28700e;

    /* renamed from: f, reason: collision with root package name */
    private final String f28701f;

    public c(int i, int i2, long j, String str) {
        kotlin.jvm.internal.h.b(str, "schedulerName");
        this.f28698c = i;
        this.f28699d = i2;
        this.f28700e = j;
        this.f28701f = str;
        this.f28697b = u();
    }

    private final CoroutineScheduler u() {
        return new CoroutineScheduler(this.f28698c, this.f28699d, this.f28700e, this.f28701f);
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(runnable, "block");
        try {
            CoroutineScheduler.a(this.f28697b, runnable, null, false, 6, null);
        } catch (RejectedExecutionException unused) {
            RunnableC2554x.f28729h.a(eVar, runnable);
        }
    }

    public /* synthetic */ c(int i, int i2, String str, int i3, kotlin.jvm.internal.f fVar) {
        this((i3 & 1) != 0 ? k.f28716d : i, (i3 & 2) != 0 ? k.f28717e : i2, (i3 & 4) != 0 ? "DefaultDispatcher" : str);
    }

    public final AbstractC2546o a(int i) {
        if (i > 0) {
            return new e(this, i, TaskMode.PROBABLY_BLOCKING);
        }
        throw new IllegalArgumentException(("Expected positive parallelism level, but have " + i).toString());
    }

    public final void a(Runnable runnable, i iVar, boolean z) {
        kotlin.jvm.internal.h.b(runnable, "block");
        kotlin.jvm.internal.h.b(iVar, com.umeng.analytics.pro.b.Q);
        try {
            this.f28697b.a(runnable, iVar, z);
        } catch (RejectedExecutionException unused) {
            RunnableC2554x.f28729h.a(this.f28697b.a(runnable, iVar));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public c(int i, int i2, String str) {
        this(i, i2, k.f28718f, str);
        kotlin.jvm.internal.h.b(str, "schedulerName");
    }
}
