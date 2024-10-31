package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class K extends AbstractC1209l<Integer> implements zzcn<Integer>, RandomAccess {

    /* renamed from: a */
    private static final K f12787a;

    /* renamed from: b */
    private int[] f12788b;

    /* renamed from: c */
    private int f12789c;

    static {
        K k = new K();
        f12787a = k;
        k.zzv();
    }

    K() {
        this(new int[10], 0);
    }

    private K(int[] iArr, int i) {
        this.f12788b = iArr;
        this.f12789c = i;
    }

    public static K a() {
        return f12787a;
    }

    private final void a(int i, int i2) {
        int i3;
        zzw();
        if (i < 0 || i > (i3 = this.f12789c)) {
            throw new IndexOutOfBoundsException(c(i));
        }
        int[] iArr = this.f12788b;
        if (i3 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
        } else {
            int[] iArr2 = new int[((i3 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.f12788b, i, iArr2, i + 1, this.f12789c - i);
            this.f12788b = iArr2;
        }
        this.f12788b[i] = i2;
        this.f12789c++;
        ((AbstractList) this).modCount++;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.f12789c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        int i2 = this.f12789c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(int i) {
        a(this.f12789c, i);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof K)) {
            return super.addAll(collection);
        }
        K k = (K) collection;
        int i = k.f12789c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12789c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        int[] iArr = this.f12788b;
        if (i3 > iArr.length) {
            this.f12788b = Arrays.copyOf(iArr, i3);
        }
        System.arraycopy(k.f12788b, 0, this.f12788b, this.f12789c, k.f12789c);
        this.f12789c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K)) {
            return super.equals(obj);
        }
        K k = (K) obj;
        if (this.f12789c != k.f12789c) {
            return false;
        }
        int[] iArr = k.f12788b;
        for (int i = 0; i < this.f12789c; i++) {
            if (this.f12788b[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    public final int getInt(int i) {
        b(i);
        return this.f12788b[i];
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12789c; i2++) {
            i = (i * 31) + this.f12788b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        b(i);
        int[] iArr = this.f12788b;
        int i2 = iArr[i];
        int i3 = this.f12789c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.f12789c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.f12789c; i++) {
            if (obj.equals(Integer.valueOf(this.f12788b[i]))) {
                int[] iArr = this.f12788b;
                System.arraycopy(iArr, i + 1, iArr, i, this.f12789c - i);
                this.f12789c--;
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
        int[] iArr = this.f12788b;
        System.arraycopy(iArr, i2, iArr, i, this.f12789c - i2);
        this.f12789c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzw();
        b(i);
        int[] iArr = this.f12788b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12789c;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Integer> zzi(int i) {
        if (i >= this.f12789c) {
            return new K(Arrays.copyOf(this.f12788b, i), this.f12789c);
        }
        throw new IllegalArgumentException();
    }
}
