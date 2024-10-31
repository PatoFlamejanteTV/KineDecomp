package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* renamed from: kotlinx.coroutines.b */
/* loaded from: classes3.dex */
public final class C2533b extends H {

    /* renamed from: g */
    private final Thread f28618g;

    public C2533b(Thread thread) {
        kotlin.jvm.internal.h.b(thread, "thread");
        this.f28618g = thread;
    }

    @Override // kotlinx.coroutines.H
    protected Thread y() {
        return this.f28618g;
    }
}
