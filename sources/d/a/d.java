package d.a;

/* compiled from: InstanceFactory.java */
/* loaded from: classes3.dex */
public final class d<T> implements c<T>, d.a<T> {

    /* renamed from: a */
    private static final d<Object> f26665a = new d<>(null);

    /* renamed from: b */
    private final T f26666b;

    private d(T t) {
        this.f26666b = t;
    }

    public static <T> c<T> a(T t) {
        f.a(t, "instance cannot be null");
        return new d(t);
    }

    @Override // javax.inject.Provider
    public T get() {
        return this.f26666b;
    }
}
