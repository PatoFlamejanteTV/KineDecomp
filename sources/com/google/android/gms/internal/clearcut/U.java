package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class U extends AbstractC1209l<Long> implements zzcn<Long>, RandomAccess {

    /* renamed from: a */
    private static final U f12811a;

    /* renamed from: b */
    private long[] f12812b;

    /* renamed from: c */
    private int f12813c;

    static {
        U u = new U();
        f12811a = u;
        u.zzv();
    }

    U() {
        this(new long[10], 0);
    }

    private U(long[] jArr, int i) {
        this.f12812b = jArr;
        this.f12813c = i;
    }

    public static U a() {
        return f12811a;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12813c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, long j) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.f12813c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        long[] jArr = this.f12812b;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[((i2 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.f12812b, i, jArr2, i + 1, this.f12813c - i);
            this.f12812b = jArr2;
        }
        this.f12812b[i] = j;
        this.f12813c++;
        ((AbstractList) this).modCount++;
    }

    private final String b(int i) {
        int i2 = this.f12813c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(long j) {
        a(this.f12813c, j);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof U)) {
            return super.addAll(collection);
        }
        U u = (U) collection;
        int i = u.f12813c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12813c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        long[] jArr = this.f12812b;
        if (i3 > jArr.length) {
            this.f12812b = Arrays.copyOf(jArr, i3);
        }
        System.arraycopy(u.f12812b, 0, this.f12812b, this.f12813c, u.f12813c);
        this.f12813c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof U)) {
            return super.equals(obj);
        }
        U u = (U) obj;
        if (this.f12813c != u.f12813c) {
            return false;
        }
        long[] jArr = u.f12812b;
        for (int i = 0; i < this.f12813c; i++) {
            if (this.f12812b[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    public final long getLong(int i) {
        a(i);
        return this.f12812b[i];
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12813c; i2++) {
            i = (i * 31) + zzci.zzl(this.f12812b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        a(i);
        long[] jArr = this.f12812b;
        long j = jArr[i];
        int i2 = this.f12813c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.f12813c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.f12813c; i++) {
            if (obj.equals(Long.valueOf(this.f12812b[i]))) {
                long[] jArr = this.f12812b;
                System.arraycopy(jArr, i + 1, jArr, i, this.f12813c - i);
                this.f12813c--;
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
        long[] jArr = this.f12812b;
        System.arraycopy(jArr, i2, jArr, i, this.f12813c - i2);
        this.f12813c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzw();
        a(i);
        long[] jArr = this.f12812b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12813c;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Long> zzi(int i) {
        if (i >= this.f12813c) {
            return new U(Arrays.copyOf(this.f12812b, i), this.f12813c);
        }
        throw new IllegalArgumentException();
    }
}
