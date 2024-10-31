package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideDciApiFactory.java */
/* loaded from: classes2.dex */
public final class i implements d.a.c<c.c.a.a.a.b.b.a.b.b> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3485a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.e> f3486b;

    public i(d dVar, Provider<c.c.a.a.a.b.a.e> provider) {
        this.f3485a = dVar;
        this.f3486b = provider;
    }

    public static i a(d dVar, Provider<c.c.a.a.a.b.a.e> provider) {
        return new i(dVar, provider);
    }

    public static c.c.a.a.a.b.b.a.b.b a(d dVar, c.c.a.a.a.b.a.e eVar) {
        c.c.a.a.a.b.b.a.b.b a2 = dVar.a(eVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.b.a.b.b get() {
        return a(this.f3485a, this.f3486b.get());
    }
}
