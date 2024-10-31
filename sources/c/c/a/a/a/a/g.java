package c.c.a.a.a.a;

import android.content.Context;
import javax.inject.Provider;

/* compiled from: KinemasterServiceModule_ProvideAuthLocalCacheFactory.java */
/* loaded from: classes2.dex */
public final class g implements d.a.c<c.c.a.a.a.b.a.a.a.a> {

    /* renamed from: a, reason: collision with root package name */
    private final d f3480a;

    /* renamed from: b, reason: collision with root package name */
    private final Provider<Context> f3481b;

    public g(d dVar, Provider<Context> provider) {
        this.f3480a = dVar;
        this.f3481b = provider;
    }

    public static g a(d dVar, Provider<Context> provider) {
        return new g(dVar, provider);
    }

    public static c.c.a.a.a.b.a.a.a.a a(d dVar, Context context) {
        c.c.a.a.a.b.a.a.a.a a2 = dVar.a(context);
        d.a.f.a(a2, "Cannot return null from a non-@Nullable @Provides method");
        return a2;
    }

    @Override // javax.inject.Provider
    public c.c.a.a.a.b.a.a.a.a get() {
        return a(this.f3480a, this.f3481b.get());
    }
}
