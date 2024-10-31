package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.pa */
/* loaded from: classes2.dex */
final class C1384pa extends AbstractC1346aa<Double> implements zzuu<Double>, Ya, RandomAccess {

    /* renamed from: a */
    private static final C1384pa f13508a;

    /* renamed from: b */
    private double[] f13509b;

    /* renamed from: c */
    private int f13510c;

    static {
        C1384pa c1384pa = new C1384pa();
        f13508a = c1384pa;
        c1384pa.zzsw();
    }

    C1384pa() {
        this(new double[10], 0);
    }

    private final void a(int i, double d2) {
        int i2;
        zzua();
        if (i >= 0 && i <= (i2 = this.f13510c)) {
            double[] dArr = this.f13509b;
            if (i2 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
            } else {
                double[] dArr2 = new double[((i2 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f13509b, i, dArr2, i + 1, this.f13510c - i);
                this.f13509b = dArr2;
            }
            this.f13509b[i] = d2;
            this.f13510c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(a(i));
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.f13510c) {
            throw new IndexOutOfBoundsException(a(i));
        }
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof C1384pa)) {
            return super.addAll(collection);
        }
        C1384pa c1384pa = (C1384pa) collection;
        int i = c1384pa.f13510c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13510c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f13509b;
            if (i3 > dArr.length) {
                this.f13509b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(c1384pa.f13509b, 0, this.f13509b, this.f13510c, c1384pa.f13510c);
            this.f13510c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void b(double d2) {
        a(this.f13510c, d2);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1384pa)) {
            return super.equals(obj);
        }
        C1384pa c1384pa = (C1384pa) obj;
        if (this.f13510c != c1384pa.f13510c) {
            return false;
        }
        double[] dArr = c1384pa.f13509b;
        for (int i = 0; i < this.f13510c; i++) {
            if (Double.doubleToLongBits(this.f13509b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Double.valueOf(this.f13509b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13510c; i2++) {
            i = (i * 31) + zzuq.zzbd(Double.doubleToLongBits(this.f13509b[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.f13510c; i++) {
            if (obj.equals(Double.valueOf(this.f13509b[i]))) {
                double[] dArr = this.f13509b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f13510c - i) - 1);
                this.f13510c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            double[] dArr = this.f13509b;
            System.arraycopy(dArr, i2, dArr, i, this.f13510c - i2);
            this.f13510c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzua();
        zzaj(i);
        double[] dArr = this.f13509b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13510c;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Double> zzal(int i) {
        if (i >= this.f13510c) {
            return new C1384pa(Arrays.copyOf(this.f13509b, i), this.f13510c);
        }
        throw new IllegalArgumentException();
    }

    private C1384pa(double[] dArr, int i) {
        this.f13509b = dArr;
        this.f13510c = i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        double[] dArr = this.f13509b;
        double d2 = dArr[i];
        if (i < this.f13510c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.f13510c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    private final String a(int i) {
        int i2 = this.f13510c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }
}
