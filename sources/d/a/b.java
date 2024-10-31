package d.a;

import javax.inject.Provider;

/* compiled from: DoubleCheck.java */
/* loaded from: classes3.dex */
public final class b<T> implements Provider<T>, d.a<T> {

    /* renamed from: a */
    private static final Object f26662a = new Object();

    /* renamed from: b */
    private volatile Provider<T> f26663b;

    /* renamed from: c */
    private volatile Object f26664c = f26662a;

    private b(Provider<T> provider) {
        this.f26663b = provider;
    }

    public static Object a(Object obj, Object obj2) {
        if (!(obj != f26662a) || obj == obj2) {
            return obj2;
        }
        throw new IllegalStateException("Scoped provider was invoked recursively returning different results: " + obj + " & " + obj2 + ". This is likely due to a circular dependency.");
    }

    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.f26664c;
        if (t == f26662a) {
            synchronized (this) {
                t = (T) this.f26664c;
                if (t == f26662a) {
                    t = this.f26663b.get();
                    a(this.f26664c, t);
                    this.f26664c = t;
                    this.f26663b = null;
                }
            }
        }
        return t;
    }

    public static <P extends Provider<T>, T> Provider<T> a(P p) {
        f.a(p);
        return p instanceof b ? p : new b(p);
    }
}
