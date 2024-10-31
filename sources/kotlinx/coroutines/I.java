package kotlinx.coroutines;

/* compiled from: EventLoop.kt */
/* loaded from: classes3.dex */
public final class I {

    /* renamed from: a */
    private static final kotlinx.coroutines.internal.q f28593a = new kotlinx.coroutines.internal.q("REMOVED_TASK");

    /* renamed from: b */
    private static final kotlinx.coroutines.internal.q f28594b = new kotlinx.coroutines.internal.q("CLOSED_EMPTY");

    public static final /* synthetic */ kotlinx.coroutines.internal.q a() {
        return f28594b;
    }

    public static final /* synthetic */ kotlinx.coroutines.internal.q b() {
        return f28593a;
    }

    public static final G c() {
        Thread currentThread = Thread.currentThread();
        kotlin.jvm.internal.h.a((Object) currentThread, "Thread.currentThread()");
        return new C2533b(currentThread);
    }
}
