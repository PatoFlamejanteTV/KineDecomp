package kotlinx.coroutines;

/* compiled from: JobSupport.kt */
/* renamed from: kotlinx.coroutines.f, reason: case insensitive filesystem */
/* loaded from: classes3.dex */
public final class C2537f extends Q<W> implements InterfaceC2536e {

    /* renamed from: e, reason: collision with root package name */
    public final InterfaceC2538g f28620e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2537f(W w, InterfaceC2538g interfaceC2538g) {
        super(w);
        kotlin.jvm.internal.h.b(w, "parent");
        kotlin.jvm.internal.h.b(interfaceC2538g, "childJob");
        this.f28620e = interfaceC2538g;
    }

    @Override // kotlinx.coroutines.InterfaceC2536e
    public boolean a(Throwable th) {
        kotlin.jvm.internal.h.b(th, "cause");
        return ((W) this.f28602d).b(th);
    }

    @Override // kotlinx.coroutines.AbstractC2544m
    public void b(Throwable th) {
        this.f28620e.a((ca) this.f28602d);
    }

    @Override // kotlin.jvm.a.b
    public /* bridge */ /* synthetic */ kotlin.k invoke(Throwable th) {
        b(th);
        return kotlin.k.f28545a;
    }

    @Override // kotlinx.coroutines.internal.k
    public String toString() {
        return "ChildHandle[" + this.f28620e + ']';
    }
}
