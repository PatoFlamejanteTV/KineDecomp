package c.c.a.a.a.a;

import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideDciClientFactory.java */
/* loaded from: classes2.dex */
public final class j implements d.a.c<c.c.a.a.a.b.b.a.b.c> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3487a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<c.c.a.a.a.b.b.a.b.b> f3488b;

    public j(d dVar, Provider<c.c.a.a.a.b.b.a.b.b> provider) {
        this.f3487a = dVar;
        this.f3488b = provider;
    }

    public static j a(d dVar, Provider<c.c.a.a.a.b.b.a.b.b> provider) {
        return new j(dVar, provider);
    }

    public static c.c.a.a.a.b.b.a.b.c a(d dVar, c.c.a.a.a.b.b.a.b.b bVar) {
        c.c.a.a.a.b.b.a.b.c a2 = dVar.a(bVar);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.b.a.b.c get() {
        return a(this.f3487a, this.f3488b.get());
    }
}
