package io.reactivex.internal.util;

/* compiled from: OpenHashSet.java */
/* loaded from: classes3.dex */
public final class e<T> {

    /* renamed from: a */
    final float f28482a;

    /* renamed from: b */
    int f28483b;

    /* renamed from: c */
    int f28484c;

    /* renamed from: d */
    int f28485d;

    /* renamed from: e */
    T[] f28486e;

    public e() {
        this(16, 0.75f);
    }

    static int a(int i) {
        int i2 = i * (-1640531527);
        return i2 ^ (i2 >>> 16);
    }

    public boolean a(T t) {
        T t2;
        T[] tArr = this.f28486e;
        int i = this.f28483b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 != null) {
            if (t3.equals(t)) {
                return false;
            }
            do {
                a2 = (a2 + 1) & i;
                t2 = tArr[a2];
                if (t2 == null) {
                }
            } while (!t2.equals(t));
            return false;
        }
        tArr[a2] = t;
        int i2 = this.f28484c + 1;
        this.f28484c = i2;
        if (i2 >= this.f28485d) {
            b();
        }
        return true;
    }

    public boolean b(T t) {
        T t2;
        T[] tArr = this.f28486e;
        int i = this.f28483b;
        int a2 = a(t.hashCode()) & i;
        T t3 = tArr[a2];
        if (t3 == null) {
            return false;
        }
        if (t3.equals(t)) {
            return a(a2, tArr, i);
        }
        do {
            a2 = (a2 + 1) & i;
            t2 = tArr[a2];
            if (t2 == null) {
                return false;
            }
        } while (!t2.equals(t));
        return a(a2, tArr, i);
    }

    public e(int i, float f2) {
        this.f28482a = f2;
        int a2 = f.a(i);
        this.f28483b = a2 - 1;
        this.f28485d = (int) (f2 * a2);
        this.f28486e = (T[]) new Object[a2];
    }

    void b() {
        T[] tArr = this.f28486e;
        int length = tArr.length;
        int i = length << 1;
        int i2 = i - 1;
        T[] tArr2 = (T[]) new Object[i];
        int i3 = this.f28484c;
        while (true) {
            int i4 = i3 - 1;
            if (i3 == 0) {
                this.f28483b = i2;
                this.f28485d = (int) (i * this.f28482a);
                this.f28486e = tArr2;
                return;
            }
            do {
                length--;
            } while (tArr[length] == null);
            int a2 = a(tArr[length].hashCode()) & i2;
            if (tArr2[a2] == null) {
                tArr2[a2] = tArr[length];
                i3 = i4;
            }
            do {
                a2 = (a2 + 1) & i2;
            } while (tArr2[a2] != null);
            tArr2[a2] = tArr[length];
            i3 = i4;
        }
    }

    boolean a(int i, T[] tArr, int i2) {
        int i3;
        T t;
        this.f28484c--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                t = tArr[i3];
                if (t == null) {
                    tArr[i] = null;
                    return true;
                }
                int a2 = a(t.hashCode()) & i2;
                if (i > i3) {
                    if (i >= a2 && a2 > i3) {
                        break;
                    }
                    i4 = i3 + 1;
                } else if (i < a2 && a2 <= i3) {
                    i4 = i3 + 1;
                }
            }
            tArr[i] = t;
            i = i3;
        }
    }

    public Object[] a() {
        return this.f28486e;
    }
}
