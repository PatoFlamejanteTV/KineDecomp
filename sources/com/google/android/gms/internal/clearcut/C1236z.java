package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.clearcut.z */
/* loaded from: classes2.dex */
final class C1236z extends AbstractC1209l<Double> implements zzcn<Double>, RandomAccess {

    /* renamed from: a */
    private static final C1236z f12909a;

    /* renamed from: b */
    private double[] f12910b;

    /* renamed from: c */
    private int f12911c;

    static {
        C1236z c1236z = new C1236z();
        f12909a = c1236z;
        c1236z.zzv();
    }

    C1236z() {
        this(new double[10], 0);
    }

    private C1236z(double[] dArr, int i) {
        this.f12910b = dArr;
        this.f12911c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12911c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, double d2) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.f12911c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        double[] dArr = this.f12910b;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[((i2 * 3) / 2) + 1];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.f12910b, i, dArr2, i + 1, this.f12911c - i);
            this.f12910b = dArr2;
        }
        this.f12910b[i] = d2;
        this.f12911c++;
        ((AbstractList) this).modCount++;
    }

    private final String b(int i) {
        int i2 = this.f12911c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof C1236z)) {
            return super.addAll(collection);
        }
        C1236z c1236z = (C1236z) collection;
        int i = c1236z.f12911c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12911c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        double[] dArr = this.f12910b;
        if (i3 > dArr.length) {
            this.f12910b = Arrays.copyOf(dArr, i3);
        }
        System.arraycopy(c1236z.f12910b, 0, this.f12910b, this.f12911c, c1236z.f12911c);
        this.f12911c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final void b(double d2) {
        a(this.f12911c, d2);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1236z)) {
            return super.equals(obj);
        }
        C1236z c1236z = (C1236z) obj;
        if (this.f12911c != c1236z.f12911c) {
            return false;
        }
        double[] dArr = c1236z.f12910b;
        for (int i = 0; i < this.f12911c; i++) {
            if (this.f12910b[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.f12910b[i]);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12911c; i2++) {
            i = (i * 31) + zzci.zzl(Double.doubleToLongBits(this.f12910b[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        a(i);
        double[] dArr = this.f12910b;
        double d2 = dArr[i];
        int i2 = this.f12911c;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, i2 - i);
        }
        this.f12911c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.f12911c; i++) {
            if (obj.equals(Double.valueOf(this.f12910b[i]))) {
                double[] dArr = this.f12910b;
                System.arraycopy(dArr, i + 1, dArr, i, this.f12911c - i);
                this.f12911c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzw();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f12910b;
        System.arraycopy(dArr, i2, dArr, i, this.f12911c - i2);
        this.f12911c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzw();
        a(i);
        double[] dArr = this.f12910b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12911c;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Double> zzi(int i) {
        if (i >= this.f12911c) {
            return new C1236z(Arrays.copyOf(this.f12910b, i), this.f12911c);
        }
        throw new IllegalArgumentException();
    }
}
