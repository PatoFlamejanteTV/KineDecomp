package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: TopKSelector.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Ab<T> {

    /* renamed from: a */
    private final int f15272a;

    /* renamed from: b */
    private final Comparator<? super T> f15273b;

    /* renamed from: c */
    private final T[] f15274c;

    /* renamed from: d */
    private int f15275d;

    /* renamed from: e */
    private T f15276e;

    private Ab(Comparator<? super T> comparator, int i) {
        Preconditions.a(comparator, "comparator");
        this.f15273b = comparator;
        this.f15272a = i;
        Preconditions.a(i >= 0, "k must be nonnegative, was %s", i);
        this.f15274c = (T[]) new Object[i * 2];
        this.f15275d = 0;
        this.f15276e = null;
    }

    public static <T> Ab<T> a(int i, Comparator<? super T> comparator) {
        return new Ab<>(comparator, i);
    }

    private void b() {
        int i = (this.f15272a * 2) - 1;
        int a2 = IntMath.a(i + 0, RoundingMode.CEILING) * 3;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i2 >= i) {
                break;
            }
            int a3 = a(i2, i, ((i2 + i) + 1) >>> 1);
            int i5 = this.f15272a;
            if (a3 <= i5) {
                if (a3 >= i5) {
                    break;
                }
                i2 = Math.max(a3, i2 + 1);
                i4 = a3;
            } else {
                i = a3 - 1;
            }
            i3++;
            if (i3 >= a2) {
                Arrays.sort(this.f15274c, i2, i, this.f15273b);
                break;
            }
        }
        this.f15275d = this.f15272a;
        this.f15276e = this.f15274c[i4];
        while (true) {
            i4++;
            if (i4 >= this.f15272a) {
                return;
            }
            if (this.f15273b.compare(this.f15274c[i4], this.f15276e) > 0) {
                this.f15276e = this.f15274c[i4];
            }
        }
    }

    public void a(@Nullable T t) {
        int i = this.f15272a;
        if (i == 0) {
            return;
        }
        int i2 = this.f15275d;
        if (i2 == 0) {
            this.f15274c[0] = t;
            this.f15276e = t;
            this.f15275d = 1;
            return;
        }
        if (i2 < i) {
            T[] tArr = this.f15274c;
            this.f15275d = i2 + 1;
            tArr[i2] = t;
            if (this.f15273b.compare(t, this.f15276e) > 0) {
                this.f15276e = t;
                return;
            }
            return;
        }
        if (this.f15273b.compare(t, this.f15276e) < 0) {
            T[] tArr2 = this.f15274c;
            int i3 = this.f15275d;
            this.f15275d = i3 + 1;
            tArr2[i3] = t;
            if (this.f15275d == this.f15272a * 2) {
                b();
            }
        }
    }

    private int a(int i, int i2, int i3) {
        T[] tArr = this.f15274c;
        T t = tArr[i3];
        tArr[i3] = tArr[i2];
        int i4 = i;
        while (i < i2) {
            if (this.f15273b.compare(this.f15274c[i], t) < 0) {
                a(i4, i);
                i4++;
            }
            i++;
        }
        T[] tArr2 = this.f15274c;
        tArr2[i2] = tArr2[i4];
        tArr2[i4] = t;
        return i4;
    }

    private void a(int i, int i2) {
        T[] tArr = this.f15274c;
        T t = tArr[i];
        tArr[i] = tArr[i2];
        tArr[i2] = t;
    }

    public void a(Iterator<? extends T> it) {
        while (it.hasNext()) {
            a((Ab<T>) it.next());
        }
    }

    public List<T> a() {
        Arrays.sort(this.f15274c, 0, this.f15275d, this.f15273b);
        int i = this.f15275d;
        int i2 = this.f15272a;
        if (i > i2) {
            T[] tArr = this.f15274c;
            Arrays.fill(tArr, i2, tArr.length, (Object) null);
            int i3 = this.f15272a;
            this.f15275d = i3;
            this.f15276e = this.f15274c[i3 - 1];
        }
        return Collections.unmodifiableList(Arrays.asList(Arrays.copyOf(this.f15274c, this.f15275d)));
    }
}
