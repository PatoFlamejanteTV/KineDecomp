package retrofit2;

import javax.annotation.Nullable;
import okhttp3.M;
import okhttp3.O;

/* compiled from: Response.java */
/* loaded from: classes3.dex */
public final class D<T> {

    /* renamed from: a */
    private final M f29419a;

    /* renamed from: b */
    @Nullable
    private final T f29420b;

    /* renamed from: c */
    @Nullable
    private final O f29421c;

    private D(M m, @Nullable T t, @Nullable O o) {
        this.f29419a = m;
        this.f29420b = t;
        this.f29421c = o;
    }

    public static <T> D<T> a(@Nullable T t, M m) {
        H.a(m, "rawResponse == null");
        if (m.u()) {
            return new D<>(m, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public int b() {
        return this.f29419a.c();
    }

    public boolean c() {
        return this.f29419a.u();
    }

    public String d() {
        return this.f29419a.v();
    }

    public String toString() {
        return this.f29419a.toString();
    }

    public static <T> D<T> a(O o, M m) {
        H.a(o, "body == null");
        H.a(m, "rawResponse == null");
        if (!m.u()) {
            return new D<>(m, null, o);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    @Nullable
    public T a() {
        return this.f29420b;
    }
}
