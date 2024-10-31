package c.c.a.a.a.a;

/* compiled from: KinemasterServiceModule_ProvideAuthApiFactory.java */
/* loaded from: classes2.dex */
public final class e implements d.a.c<c.c.a.a.a.b.a.a.c.a> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3477a;

    public e(d dVar) {
        this.f3477a = dVar;
    }

    public static e a(d dVar) {
        return new e(dVar);
    }

    public static c.c.a.a.a.b.a.a.c.a b(d dVar) {
        c.c.a.a.a.b.a.a.c.a a2 = dVar.a();
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.a.a.c.a get() {
        return b(this.f3477a);
    }
}
