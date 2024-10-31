package kotlinx.coroutines;

/* compiled from: Unconfined.kt */
/* loaded from: classes3.dex */
public final class ja extends AbstractC2546o {

    /* renamed from: b */
    public static final ja f28669b = new ja();

    private ja() {
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public void a(kotlin.coroutines.e eVar, Runnable runnable) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        kotlin.jvm.internal.h.b(runnable, "block");
        throw new UnsupportedOperationException();
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public boolean b(kotlin.coroutines.e eVar) {
        kotlin.jvm.internal.h.b(eVar, com.umeng.analytics.pro.b.Q);
        return false;
    }

    @Override // kotlinx.coroutines.AbstractC2546o
    public String toString() {
        return "Unconfined";
    }
}
