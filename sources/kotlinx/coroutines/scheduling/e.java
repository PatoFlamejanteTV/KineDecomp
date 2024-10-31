package kotlinx.coroutines.scheduling;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import kotlinx.coroutines.J;

/* compiled from: Dispatcher.kt */
/* loaded from: classes3.dex */
final class e extends J implements i, Executor {

    /* renamed from: b, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f28702b = AtomicIntegerFieldUpdater.newUpdater(e.class, "inFlightTasks");

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentLinkedQueue<Runnable> f28703c;

    /* renamed from: d, reason: collision with root package name */
    private final c f28704d;

    /* renamed from: e, reason: collision with root package name */
    private final int f28705e;

    /* renamed from: f, reason: collision with root package name */
    private final TaskMode f28706f;
    private volatile int inFlightTasks;

    public e(c cVar, int i, TaskMode taskMode) {
        kotlin.jvm.internal.h.b(cVar, "dispatcher");
        kotlin.jvm.internal.h.b(taskMode, "taskMode");
        this.f28704d = cVar;
        this.f28705e = i;
        this.f28706f = taskMode;
        this.f28703c = new ConcurrentLinkedQueue<>();
        this.inFlightTasks = 0;
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(runnable, "block");
        a(runnable, false);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        throw new IllegalStateException("Close cannot be invoked on LimitingBlockingDispatcher");
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        kotlin.jvm.internal.h.b(runnable, "command");
        a(runnable, false);
    }

    @Override // kotlinx.coroutines.scheduling.i
    public void r() {
        Runnable poll = this.f28703c.poll();
        if (poll != null) {
            this.f28704d.a(poll, this, true);
            return;
        }
        f28702b.decrementAndGet(this);
        Runnable poll2 = this.f28703c.poll();
        if (poll2 != null) {
            a(poll2, true);
        }
    }

    @Override // kotlinx.coroutines.scheduling.i
    public TaskMode s() {
        return this.f28706f;
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public String toString() {
        return super.toString() + "[dispatcher = " + this.f28704d + ']';
    }

    private final void a(Runnable runnable, boolean z) {
        while (f28702b.incrementAndGet(this) > this.f28705e) {
            this.f28703c.add(runnable);
            if (f28702b.decrementAndGet(this) >= this.f28705e || (runnable = this.f28703c.poll()) == null) {
                return;
            }
        }
        this.f28704d.a(runnable, this, z);
    }
}
