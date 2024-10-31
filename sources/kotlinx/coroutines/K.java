package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* loaded from: classes3.dex */
public final class K implements L {

    /* renamed from: a */
    private final aa f28595a;

    public K(aa aaVar) {
        kotlin.jvm.internal.h.b(aaVar, "list");
        this.f28595a = aaVar;
    }

    @Override // kotlinx.coroutines.L
    public aa a() {
        return this.f28595a;
    }

    @Override // kotlinx.coroutines.L
    public boolean isActive() {
        return false;
    }

    public String toString() {
        return a().a("New");
    }
}
