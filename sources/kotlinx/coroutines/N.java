package kotlinx.coroutines;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class N extends Q<P> {

    /* renamed from: e, reason: collision with root package name */
    private static final AtomicIntegerFieldUpdater f28597e = AtomicIntegerFieldUpdater.newUpdater(N.class, "_invoked");
    private volatile int _invoked;

    /* renamed from: f, reason: collision with root package name */
    private final kotlin.jvm.a.b<Throwable, kotlin.k> f28598f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public N(P p, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar) {
        super(p);
        kotlin.jvm.internal.h.b(p, "job");
        kotlin.jvm.internal.h.b(bVar, "handler");
        this.f28598f = bVar;
        this._invoked = 0;
    }

    @Override // kotlinx.coroutines.AbstractC2544m
    public void b(Throwable th) {
        if (f28597e.compareAndSet(this, 0, 1)) {
            this.f28598f.invoke(th);
        }
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.k invoke(Throwable th) {
        b(th);
        return kotlin.k.f28545a;
    }

    @Override // kotlinx.coroutines.internal.k
    public String toString() {
        return "InvokeOnCancelling[" + C2553w.a(this) + '@' + C2553w.b(this) + ']';
    }
}
