package kotlinx.coroutines;

/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
class ea extends AbstractC2532a<kotlin.k> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ea(kotlin.coroutines.e eVar, boolean z) {
        super(eVar, z);
        kotlin.jvm.internal.h.b(eVar, "parentContext");
    }

    @Override // kotlinx.coroutines.W
    protected void c(Throwable th) {
        kotlin.jvm.internal.h.b(th, "exception");
        C2548q.a(this.f28617c, th);
    }

    @Override // kotlinx.coroutines.W
    protected boolean d() {
        return true;
    }
}
