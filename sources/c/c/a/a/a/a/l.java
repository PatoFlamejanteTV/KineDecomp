package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideStoreApiFactory.java */
/* loaded from: classes2.dex */
public final class l implements d.a.c<c.c.a.a.a.b.c.a.a.a> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3492a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.e> f3493b;

    public l(d dVar, Provider<c.c.a.a.a.b.a.e> provider) {
        this.f3492a = dVar;
        this.f3493b = provider;
    }

    public static l a(d dVar, Provider<c.c.a.a.a.b.a.e> provider) {
        return new l(dVar, provider);
    }

    public static c.c.a.a.a.b.c.a.a.a a(d dVar, c.c.a.a.a.b.a.e eVar) {
        c.c.a.a.a.b.c.a.a.a b2 = dVar.b(eVar);
        d.a.f.a(b2, "Cannot return null from a non-@Nullable @Provides method");
        return b2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.c.a.a.a get() {
        return a(this.f3492a, this.f3493b.get());
    }
}
