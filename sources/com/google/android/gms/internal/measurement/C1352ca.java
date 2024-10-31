package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.ca */
/* loaded from: classes2.dex */
final class C1352ca extends AbstractC1346aa<Boolean> implements zzuu<Boolean>, Ya, RandomAccess {

    /* renamed from: a */
    private static final C1352ca f13428a;

    /* renamed from: b */
    private boolean[] f13429b;

    /* renamed from: c */
    private int f13430c;

    static {
        C1352ca c1352ca = new C1352ca();
        f13428a = c1352ca;
        c1352ca.zzsw();
    }

    C1352ca() {
        this(new boolean[10], 0);
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.f13430c) {
            throw new IndexOutOfBoundsException(a(i));
        }
    }

    public final void a(boolean z) {
        a(this.f13430c, z);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof C1352ca)) {
            return super.addAll(collection);
        }
        C1352ca c1352ca = (C1352ca) collection;
        int i = c1352ca.f13430c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13430c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f13429b;
            if (i3 > zArr.length) {
                this.f13429b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(c1352ca.f13429b, 0, this.f13429b, this.f13430c, c1352ca.f13430c);
            this.f13430c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1352ca)) {
            return super.equals(obj);
        }
        C1352ca c1352ca = (C1352ca) obj;
        if (this.f13430c != c1352ca.f13430c) {
            return false;
        }
        boolean[] zArr = c1352ca.f13429b;
        for (int i = 0; i < this.f13430c; i++) {
            if (this.f13429b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Boolean.valueOf(this.f13429b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13430c; i2++) {
            i = (i * 31) + zzuq.zzu(this.f13429b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.f13430c; i++) {
            if (obj.equals(Boolean.valueOf(this.f13429b[i]))) {
                boolean[] zArr = this.f13429b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f13430c - i) - 1);
                this.f13430c--;
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
            boolean[] zArr = this.f13429b;
            System.arraycopy(zArr, i2, zArr, i, this.f13430c - i2);
            this.f13430c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzua();
        zzaj(i);
        boolean[] zArr = this.f13429b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13430c;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Boolean> zzal(int i) {
        if (i >= this.f13430c) {
            return new C1352ca(Arrays.copyOf(this.f13429b, i), this.f13430c);
        }
        throw new IllegalArgumentException();
    }

    private C1352ca(boolean[] zArr, int i) {
        this.f13429b = zArr;
        this.f13430c = i;
    }

    private final void a(int i, boolean z) {
        int i2;
        zzua();
        if (i >= 0 && i <= (i2 = this.f13430c)) {
            boolean[] zArr = this.f13429b;
            if (i2 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
            } else {
                boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                System.arraycopy(this.f13429b, i, zArr2, i + 1, this.f13430c - i);
                this.f13429b = zArr2;
            }
            this.f13429b[i] = z;
            this.f13430c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(a(i));
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        boolean[] zArr = this.f13429b;
        boolean z = zArr[i];
        if (i < this.f13430c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.f13430c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    private final String a(int i) {
        int i2 = this.f13430c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }
}
