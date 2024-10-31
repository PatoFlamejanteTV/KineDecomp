package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideStoreServiceFactory.java */
/* loaded from: classes2.dex */
public final class n implements d.a.c<c.c.a.a.a.b.c.a> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3496a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.c.a.a.b> f3497b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.e> f3498c;

    public n(d dVar, Provider<c.c.a.a.a.b.c.a.a.b> provider, Provider<c.c.a.a.a.b.a.e> provider2) {
        this.f3496a = dVar;
        this.f3497b = provider;
        this.f3498c = provider2;
    }

    public static n a(d dVar, Provider<c.c.a.a.a.b.c.a.a.b> provider, Provider<c.c.a.a.a.b.a.e> provider2) {
        return new n(dVar, provider, provider2);
    }

    public static c.c.a.a.a.b.c.a a(d dVar, c.c.a.a.a.b.c.a.a.b bVar, c.c.a.a.a.b.a.e eVar) {
        c.c.a.a.a.b.c.a a2 = dVar.a(bVar, eVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.c.a get() {
        return a(this.f3496a, this.f3497b.get(), this.f3498c.get());
    }
}
