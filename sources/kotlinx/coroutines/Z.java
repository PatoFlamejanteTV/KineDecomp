package kotlinx.coroutines;

/* compiled from: Builders.common.kt */
/* loaded from: classes3.dex */
final class Z extends ea {

    /* renamed from: d, reason: collision with root package name */
    private kotlin.jvm.a.c<? super InterfaceC2550t, ? super kotlin.coroutines.b<? super kotlin.k>, ? extends Object> f28615d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Z(kotlin.coroutines.e eVar, kotlin.jvm.a.c<? super InterfaceC2550t, ? super kotlin.coroutines.b<? super kotlin.k>, ? extends Object> cVar) {
        super(eVar, false);
        kotlin.jvm.internal.h.b(eVar, "parentContext");
        kotlin.jvm.internal.h.b(cVar, "block");
        this.f28615d = cVar;
    }

    @Override // kotlinx.coroutines.AbstractC2532a
    protected void n() {
        kotlin.jvm.a.c<? super InterfaceC2550t, ? super kotlin.coroutines.b<? super kotlin.k>, ? extends Object> cVar = this.f28615d;
        if (cVar != null) {
            this.f28615d = null;
            kotlinx.coroutines.a.a.a(cVar, this, this);
            return;
        }
        throw new IllegalStateException("Already started");
    }
}
