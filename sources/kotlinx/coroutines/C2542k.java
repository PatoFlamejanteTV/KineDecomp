package kotlinx.coroutines;

/* compiled from: CompletedExceptionally.kt */
/* renamed from: kotlinx.coroutines.k */
/* loaded from: classes3.dex */
public class C2542k {

    /* renamed from: a */
    public final Throwable f28670a;

    public C2542k(Throwable th) {
        kotlin.jvm.internal.h.b(th, "cause");
        this.f28670a = th;
    }

    public String toString() {
        return C2553w.a(this) + '[' + this.f28670a + ']';
    }
}
