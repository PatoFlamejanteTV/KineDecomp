package kotlinx.coroutines;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class O extends V<P> {

    /* renamed from: e, reason: collision with root package name */
    private final kotlin.jvm.a.b<Throwable, kotlin.k> f28599e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public O(P p, kotlin.jvm.a.b<? super Throwable, kotlin.k> bVar) {
        super(p);
        kotlin.jvm.internal.h.b(p, "job");
        kotlin.jvm.internal.h.b(bVar, "handler");
        this.f28599e = bVar;
    }

    @Override // kotlinx.coroutines.AbstractC2544m
    public void b(Throwable th) {
        this.f28599e.invoke(th);
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.k invoke(Throwable th) {
        b(th);
        return kotlin.k.f28545a;
    }

    @Override // kotlinx.coroutines.internal.k
    public String toString() {
        return "InvokeOnCompletion[" + C2553w.a(this) + '@' + C2553w.b(this) + ']';
    }
}
