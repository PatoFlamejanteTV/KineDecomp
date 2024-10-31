package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.gtm.na */
/* loaded from: classes2.dex */
final class C1321na extends Y<Double> implements zzrj<Double>, Wa, RandomAccess {

    /* renamed from: a */
    private static final C1321na f13278a;

    /* renamed from: b */
    private double[] f13279b;

    /* renamed from: c */
    private int f13280c;

    static {
        C1321na c1321na = new C1321na(new double[0], 0);
        f13278a = c1321na;
        c1321na.zzmi();
    }

    C1321na() {
        this(new double[10], 0);
    }

    private final void a(int i, double d2) {
        int i2;
        zzmz();
        if (i >= 0 && i <= (i2 = this.f13280c)) {
            double[] dArr = this.f13279b;
            if (i2 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
            } else {
                double[] dArr2 = new double[((i2 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f13279b, i, dArr2, i + 1, this.f13280c - i);
                this.f13279b = dArr2;
            }
            this.f13279b[i] = d2;
            this.f13280c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof C1321na)) {
            return super.addAll(collection);
        }
        C1321na c1321na = (C1321na) collection;
        int i = c1321na.f13280c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13280c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f13279b;
            if (i3 > dArr.length) {
                this.f13279b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(c1321na.f13279b, 0, this.f13279b, this.f13280c, c1321na.f13280c);
            this.f13280c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void b(double d2) {
        a(this.f13280c, d2);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1321na)) {
            return super.equals(obj);
        }
        C1321na c1321na = (C1321na) obj;
        if (this.f13280c != c1321na.f13280c) {
            return false;
        }
        double[] dArr = c1321na.f13279b;
        for (int i = 0; i < this.f13280c; i++) {
            if (Double.doubleToLongBits(this.f13279b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.f13279b[i]);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13280c; i2++) {
            i = (i * 31) + zzre.zzz(Double.doubleToLongBits(this.f13279b[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.f13280c; i++) {
            if (obj.equals(Double.valueOf(this.f13279b[i]))) {
                double[] dArr = this.f13279b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f13280c - i) - 1);
                this.f13280c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzmz();
        if (i2 >= i) {
            double[] dArr = this.f13279b;
            System.arraycopy(dArr, i2, dArr, i, this.f13280c - i2);
            this.f13280c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzmz();
        a(i);
        double[] dArr = this.f13279b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13280c;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Double> zzaj(int i) {
        if (i >= this.f13280c) {
            return new C1321na(Arrays.copyOf(this.f13279b, i), this.f13280c);
        }
        throw new IllegalArgumentException();
    }

    private C1321na(double[] dArr, int i) {
        this.f13279b = dArr;
        this.f13280c = i;
    }

    private final String b(int i) {
        int i2 = this.f13280c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzmz();
        a(i);
        double[] dArr = this.f13279b;
        double d2 = dArr[i];
        if (i < this.f13280c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.f13280c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13280c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
