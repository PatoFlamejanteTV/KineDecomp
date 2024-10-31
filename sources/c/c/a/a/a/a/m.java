package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideStoreClientFactory.java */
/* loaded from: classes2.dex */
public final class m implements d.a.c<c.c.a.a.a.b.c.a.a.b> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3494a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.c.a.a.a> f3495b;

    public m(d dVar, Provider<c.c.a.a.a.b.c.a.a.a> provider) {
        this.f3494a = dVar;
        this.f3495b = provider;
    }

    public static m a(d dVar, Provider<c.c.a.a.a.b.c.a.a.a> provider) {
        return new m(dVar, provider);
    }

    public static c.c.a.a.a.b.c.a.a.b a(d dVar, c.c.a.a.a.b.c.a.a.a aVar) {
        c.c.a.a.a.b.c.a.a.b a2 = dVar.a(aVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.c.a.a.b get() {
        return a(this.f3494a, this.f3495b.get());
    }
}
