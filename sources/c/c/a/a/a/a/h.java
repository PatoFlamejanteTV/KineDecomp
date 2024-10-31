package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideAuthServiceFactory.java */
/* loaded from: classes2.dex */
public final class h implements d.a.c<c.c.a.a.a.b.a.e> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3482a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.a.c.b> f3483b;

    /* renamed from: c, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.a.a.a> f3484c;

    public h(d dVar, Provider<c.c.a.a.a.b.a.a.c.b> provider, Provider<c.c.a.a.a.b.a.a.a.a> provider2) {
        this.f3482a = dVar;
        this.f3483b = provider;
        this.f3484c = provider2;
    }

    public static h a(d dVar, Provider<c.c.a.a.a.b.a.a.c.b> provider, Provider<c.c.a.a.a.b.a.a.a.a> provider2) {
        return new h(dVar, provider, provider2);
    }

    public static c.c.a.a.a.b.a.e a(d dVar, c.c.a.a.a.b.a.a.c.b bVar, c.c.a.a.a.b.a.a.a.a aVar) {
        c.c.a.a.a.b.a.e a2 = dVar.a(bVar, aVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.a.e get() {
        return a(this.f3482a, this.f3483b.get(), this.f3484c.get());
    }
}
