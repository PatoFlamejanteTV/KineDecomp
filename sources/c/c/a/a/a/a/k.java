package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideDciServiceFactory.java */
/* loaded from: classes2.dex */
public final class k implements d.a.c<c.c.a.a.a.b.b.c> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3489a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.b.a.b.c> f3490b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.e> f3491c;

    public k(d dVar, Provider<c.c.a.a.a.b.b.a.b.c> provider, Provider<c.c.a.a.a.b.a.e> provider2) {
        this.f3489a = dVar;
        this.f3490b = provider;
        this.f3491c = provider2;
    }

    public static k a(d dVar, Provider<c.c.a.a.a.b.b.a.b.c> provider, Provider<c.c.a.a.a.b.a.e> provider2) {
        return new k(dVar, provider, provider2);
    }

    public static c.c.a.a.a.b.b.c a(d dVar, c.c.a.a.a.b.b.a.b.c cVar, c.c.a.a.a.b.a.e eVar) {
        c.c.a.a.a.b.b.c a2 = dVar.a(cVar, eVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.b.c get() {
        return a(this.f3489a, this.f3490b.get(), this.f3491c.get());
    }
}
