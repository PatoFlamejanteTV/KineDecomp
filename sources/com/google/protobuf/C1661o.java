package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: DoubleArrayList.java */
/* renamed from: com.google.protobuf.o */
/* loaded from: classes2.dex */
public final class C1661o extends AbstractC1647a<Double> implements Internal.DoubleList, RandomAccess {

    /* renamed from: b */
    private static final C1661o f18790b = new C1661o();

    /* renamed from: c */
    private double[] f18791c;

    /* renamed from: d */
    private int f18792d;

    static {
        f18790b.L();
    }

    C1661o() {
        this(new double[10], 0);
    }

    public static C1661o b() {
        return f18790b;
    }

    public double a(int i, double d2) {
        a();
        a(i);
        double[] dArr = this.f18791c;
        double d3 = dArr[i];
        dArr[i] = d2;
        return d3;
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Double> collection) {
        a();
        if (collection != null) {
            if (!(collection instanceof C1661o)) {
                return super.addAll(collection);
            }
            C1661o c1661o = (C1661o) collection;
            int i = c1661o.f18792d;
            if (i == 0) {
                return false;
            }
            int i2 = this.f18792d;
            if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
                int i3 = i2 + i;
                double[] dArr = this.f18791c;
                if (i3 > dArr.length) {
                    this.f18791c = Arrays.copyOf(dArr, i3);
                }
                System.arraycopy(c1661o.f18791c, 0, this.f18791c, this.f18792d, c1661o.f18792d);
                this.f18792d = i3;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1661o)) {
            return super.equals(obj);
        }
        C1661o c1661o = (C1661o) obj;
        if (this.f18792d != c1661o.f18792d) {
            return false;
        }
        double[] dArr = c1661o.f18791c;
        for (int i = 0; i < this.f18792d; i++) {
            if (this.f18791c[i] != dArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public double getDouble(int i) {
        a(i);
        return this.f18791c[i];
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f18792d; i2++) {
            i = (i * 31) + Internal.a(Double.doubleToLongBits(this.f18791c[i2]));
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18792d;
    }

    private C1661o(double[] dArr, int i) {
        this.f18791c = dArr;
        this.f18792d = i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public Double set(int i, Double d2) {
        return Double.valueOf(a(i, d2.doubleValue()));
    }

    @Override // java.util.AbstractList, java.util.List
    public Double get(int i) {
        return Double.valueOf(getDouble(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
    /* renamed from: h */
    public Internal.ProtobufList<Double> h2(int i) {
        if (i >= this.f18792d) {
            return new C1661o(Arrays.copyOf(this.f18791c, i), this.f18792d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f18792d; i++) {
            if (obj.equals(Double.valueOf(this.f18791c[i]))) {
                double[] dArr = this.f18791c;
                System.arraycopy(dArr, i + 1, dArr, i, this.f18792d - i);
                this.f18792d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i, double d2) {
        int i2;
        a();
        if (i >= 0 && i <= (i2 = this.f18792d)) {
            double[] dArr = this.f18791c;
            if (i2 < dArr.length) {
                System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
            } else {
                double[] dArr2 = new double[((i2 * 3) / 2) + 1];
                System.arraycopy(dArr, 0, dArr2, 0, i);
                System.arraycopy(this.f18791c, i, dArr2, i + 1, this.f18792d - i);
                this.f18791c = dArr2;
            }
            this.f18791c[i] = d2;
            this.f18792d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i, Double d2) {
        b(i, d2.doubleValue());
    }

    @Override // com.google.protobuf.Internal.DoubleList
    public void a(double d2) {
        b(this.f18792d, d2);
    }

    private void a(int i) {
        if (i < 0 || i >= this.f18792d) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Double remove(int i) {
        a();
        a(i);
        double[] dArr = this.f18791c;
        double d2 = dArr[i];
        System.arraycopy(dArr, i + 1, dArr, i, this.f18792d - i);
        this.f18792d--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d2);
    }

    private String b(int i) {
        return "Index:" + i + ", Size:" + this.f18792d;
    }
}
