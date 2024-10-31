package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideAuthClientFactory.java */
/* loaded from: classes2.dex */
public final class f implements d.a.c<c.c.a.a.a.b.a.a.c.b> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3478a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.a.a.c.a> f3479b;

    public f(d dVar, Provider<c.c.a.a.a.b.a.a.c.a> provider) {
        this.f3478a = dVar;
        this.f3479b = provider;
    }

    public static f a(d dVar, Provider<c.c.a.a.a.b.a.a.c.a> provider) {
        return new f(dVar, provider);
    }

    public static c.c.a.a.a.b.a.a.c.b a(d dVar, c.c.a.a.a.b.a.a.c.a aVar) {
        c.c.a.a.a.b.a.a.c.b a2 = dVar.a(aVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.a.a.c.b get() {
        return a(this.f3478a, this.f3479b.get());
    }
}
