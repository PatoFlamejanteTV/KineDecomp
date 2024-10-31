package kotlinx.coroutines.internal;

import java.lang.Comparable;
import java.util.Arrays;
import kotlinx.coroutines.internal.u;

/* compiled from: ThreadSafeHeap.kt */
/* loaded from: classes3.dex */
public final class t<T extends u & Comparable<? super T>> {

    /* renamed from: a */
    private T[] f28662a;
    public volatile int size;

    private final T[] e() {
        T[] tArr = this.f28662a;
        if (tArr == null) {
            T[] tArr2 = (T[]) new u[4];
            this.f28662a = tArr2;
            return tArr2;
        }
        if (this.size < tArr.length) {
            return tArr;
        }
        Object[] copyOf = Arrays.copyOf(tArr, this.size * 2);
        kotlin.jvm.internal.h.a((Object) copyOf, "java.util.Arrays.copyOf(this, newSize)");
        T[] tArr3 = (T[]) ((u[]) copyOf);
        this.f28662a = tArr3;
        return tArr3;
    }

    public final T a() {
        T[] tArr = this.f28662a;
        if (tArr != null) {
            return tArr[0];
        }
        return null;
    }

    public final boolean b() {
        return this.size == 0;
    }

    public final synchronized T c() {
        return a();
    }

    public final synchronized T d() {
        return this.size > 0 ? a(0) : null;
    }

    private final void b(int i) {
        while (true) {
            int i2 = (i * 2) + 1;
            if (i2 >= this.size) {
                return;
            }
            T[] tArr = this.f28662a;
            if (tArr != null) {
                int i3 = i2 + 1;
                if (i3 < this.size) {
                    T t = tArr[i3];
                    if (t == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    Comparable comparable = (Comparable) t;
                    T t2 = tArr[i2];
                    if (t2 == null) {
                        kotlin.jvm.internal.h.a();
                        throw null;
                    }
                    if (comparable.compareTo(t2) < 0) {
                        i2 = i3;
                    }
                }
                T t3 = tArr[i];
                if (t3 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                Comparable comparable2 = (Comparable) t3;
                T t4 = tArr[i2];
                if (t4 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (comparable2.compareTo(t4) <= 0) {
                    return;
                }
                a(i, i2);
                i = i2;
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    private final void c(int i) {
        while (i > 0) {
            T[] tArr = this.f28662a;
            if (tArr != null) {
                int i2 = (i - 1) / 2;
                T t = tArr[i2];
                if (t == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                Comparable comparable = (Comparable) t;
                T t2 = tArr[i];
                if (t2 == null) {
                    kotlin.jvm.internal.h.a();
                    throw null;
                }
                if (comparable.compareTo(t2) <= 0) {
                    return;
                }
                a(i, i2);
                i = i2;
            } else {
                kotlin.jvm.internal.h.a();
                throw null;
            }
        }
    }

    public final T a(int i) {
        if (this.size > 0) {
            T[] tArr = this.f28662a;
            if (tArr != null) {
                this.size--;
                if (i < this.size) {
                    a(i, this.size);
                    int i2 = (i - 1) / 2;
                    if (i > 0) {
                        T t = tArr[i];
                        if (t == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        Comparable comparable = (Comparable) t;
                        T t2 = tArr[i2];
                        if (t2 == null) {
                            kotlin.jvm.internal.h.a();
                            throw null;
                        }
                        if (comparable.compareTo(t2) < 0) {
                            a(i, i2);
                            c(i2);
                        }
                    }
                    b(i);
                }
                T t3 = tArr[this.size];
                if (t3 != null) {
                    if (t3.d() == this) {
                        t3.a(null);
                        t3.setIndex(-1);
                        tArr[this.size] = null;
                        return t3;
                    }
                    throw new IllegalStateException("Check failed.");
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        throw new IllegalStateException("Check failed.");
    }

    public final void a(T t) {
        kotlin.jvm.internal.h.b(t, "node");
        if (t.d() == null) {
            t.a(this);
            T[] e2 = e();
            int i = this.size;
            this.size = i + 1;
            e2[i] = t;
            t.setIndex(i);
            c(i);
            return;
        }
        throw new IllegalStateException("Check failed.");
    }

    private final void a(int i, int i2) {
        T[] tArr = this.f28662a;
        if (tArr != null) {
            T t = tArr[i2];
            if (t != null) {
                T t2 = tArr[i];
                if (t2 != null) {
                    tArr[i] = t;
                    tArr[i2] = t2;
                    t.setIndex(i);
                    t2.setIndex(i2);
                    return;
                }
                kotlin.jvm.internal.h.a();
                throw null;
            }
            kotlin.jvm.internal.h.a();
            throw null;
        }
        kotlin.jvm.internal.h.a();
        throw null;
    }
}
