package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase_auth.u */
/* loaded from: classes2.dex */
final class C1277u extends AbstractC1244d<Double> implements zzgb<Double>, InterfaceC1247ea, RandomAccess {

    /* renamed from: a */
    private static final C1277u f13083a;

    /* renamed from: b */
    private double[] f13084b;

    /* renamed from: c */
    private int f13085c;

    static {
        C1277u c1277u = new C1277u();
        f13083a = c1277u;
        c1277u.zzev();
    }

    C1277u() {
        this(new double[10], 0);
    }

    private final void a(int i, double d2) {
        int i2;
        zzew();
        if (i >= 0 && i <= (i2 = this.f13085c)) {
            double[] dArr = this.f13084b;
            if (i2 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
            } else {
                double[] dArr2 = new double[((i2 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f13084b, i, dArr2, i + 1, this.f13085c - i);
                this.f13084b = dArr2;
            }
            this.f13084b[i] = d2;
            this.f13085c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    private final String zzi(int i) {
        int i2 = this.f13085c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Double) obj).doubleValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Double> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof C1277u)) {
            return super.addAll(collection);
        }
        C1277u c1277u = (C1277u) collection;
        int i = c1277u.f13085c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13085c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.f13084b;
            if (i3 > dArr.length) {
                this.f13084b = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(c1277u.f13084b, 0, this.f13084b, this.f13085c, c1277u.f13085c);
            this.f13085c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public final void b(double d2) {
        a(this.f13085c, d2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1277u)) {
            return super.equals(obj);
        }
        C1277u c1277u = (C1277u) obj;
        if (this.f13085c != c1277u.f13085c) {
            return false;
        }
        double[] dArr = c1277u.f13084b;
        for (int i = 0; i < this.f13085c; i++) {
            if (Double.doubleToLongBits(this.f13084b[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Double.valueOf(this.f13084b[i]);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13085c; i2++) {
            i = (i * 31) + zzfv.zzk(Double.doubleToLongBits(this.f13084b[i2]));
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.f13085c; i++) {
            if (obj.equals(Double.valueOf(this.f13084b[i]))) {
                double[] dArr = this.f13084b;
                System.arraycopy(dArr, i + 1, dArr, i, (this.f13085c - i) - 1);
                this.f13085c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzew();
        if (i2 >= i) {
            double[] dArr = this.f13084b;
            System.arraycopy(dArr, i2, dArr, i, this.f13085c - i2);
            this.f13085c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        double doubleValue = ((Double) obj).doubleValue();
        zzew();
        a(i);
        double[] dArr = this.f13084b;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13085c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb<Double> zzj(int i) {
        if (i >= this.f13085c) {
            return new C1277u(Arrays.copyOf(this.f13084b, i), this.f13085c);
        }
        throw new IllegalArgumentException();
    }

    private C1277u(double[] dArr, int i) {
        this.f13084b = dArr;
        this.f13085c = i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        a(i);
        double[] dArr = this.f13084b;
        double d2 = dArr[i];
        if (i < this.f13085c - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (r3 - i) - 1);
        }
        this.f13085c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13085c) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }
}
