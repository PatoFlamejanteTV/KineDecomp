package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class Hh extends AbstractC1069rh<Double> implements zzbrk<Double>, InterfaceC1043pi, RandomAccess {

    /* renamed from: a */
    private static final Hh f11571a;

    /* renamed from: b */
    private double[] f11572b;

    /* renamed from: c */
    private int f11573c;

    static {
        Hh hh = new Hh();
        f11571a = hh;
        hh.zzakj();
    }

    Hh() {
        this(new double[10], 0);
    }

    private final void a(int i, double d2) {
        int i2;
        zzakk();
        if (i >= 0 && i <= (i2 = this.f11573c)) {
            double[] dArr = this.f11572b;
            if (i2 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
            } else {
                double[] dArr2 = new double[((i2 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f11572b, i, dArr2, i + 1, this.f11573c - i);
                this.f11572b = dArr2;
            }
            this.f11572b[i] = d2;
            this.f11573c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof Hh)) {
            return super.addAll(collection);
        }
        Hh hh = (Hh) collection;
        int i = hh.f11573c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f11573c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f11572b;
            if (i3 > dArr.length) {
                this.f11572b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(hh.f11572b, 0, this.f11572b, this.f11573c, hh.f11573c);
            this.f11573c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void b(double d2) {
        a(this.f11573c, d2);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Hh)) {
            return super.equals(obj);
        }
        Hh hh = (Hh) obj;
        if (this.f11573c != hh.f11573c) {
            return false;
        }
        double[] dArr = hh.f11572b;
        for (int i = 0; i < this.f11573c; i++) {
            if (this.f11572b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.f11572b[i]);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f11573c; i2++) {
            i = (i * 31) + zzbrf.zzbi(Double.doubleToLongBits(this.f11572b[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.f11573c; i++) {
            if (obj.equals(Double.valueOf(this.f11572b[i]))) {
                double[] dArr = this.f11572b;
                System.arraycopy(dArr, i + 1, dArr, i, this.f11573c - i);
                this.f11573c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzakk();
        if (i2 >= i) {
            double[] dArr = this.f11572b;
            System.arraycopy(dArr, i2, dArr, i, this.f11573c - i2);
            this.f11573c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzakk();
        a(i);
        double[] dArr = this.f11572b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11573c;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Double> zzel(int i) {
        if (i >= this.f11573c) {
            return new Hh(Arrays.copyOf(this.f11572b, i), this.f11573c);
        }
        throw new IllegalArgumentException();
    }

    private Hh(double[] dArr, int i) {
        this.f11572b = dArr;
        this.f11573c = i;
    }

    private final String b(int i) {
        int i2 = this.f11573c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        a(i);
        double[] dArr = this.f11572b;
        double d2 = dArr[i];
        int i2 = this.f11573c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, i2 - i);
        }
        this.f11573c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f11573c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
