package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class Ia extends AbstractC1346aa<Long> implements zzuu<Long>, Ya, RandomAccess {

    /* renamed from: a */
    private static final Ia f13373a;

    /* renamed from: b */
    private long[] f13374b;

    /* renamed from: c */
    private int f13375c;

    static {
        Ia ia = new Ia();
        f13373a = ia;
        ia.zzsw();
    }

    Ia() {
        this(new long[10], 0);
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.f13375c) {
            throw new IndexOutOfBoundsException(a(i));
        }
    }

    public final void a(long j) {
        a(this.f13375c, j);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof Ia)) {
            return super.addAll(collection);
        }
        Ia ia = (Ia) collection;
        int i = ia.f13375c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13375c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f13374b;
            if (i3 > jArr.length) {
                this.f13374b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(ia.f13374b, 0, this.f13374b, this.f13375c, ia.f13375c);
            this.f13375c = i3;
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
        if (!(obj instanceof Ia)) {
            return super.equals(obj);
        }
        Ia ia = (Ia) obj;
        if (this.f13375c != ia.f13375c) {
            return false;
        }
        long[] jArr = ia.f13374b;
        for (int i = 0; i < this.f13375c; i++) {
            if (this.f13374b[i] != jArr[i]) {
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
        zzaj(i);
        return this.f13374b[i];
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13375c; i2++) {
            i = (i * 31) + zzuq.zzbd(this.f13374b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.f13375c; i++) {
            if (obj.equals(Long.valueOf(this.f13374b[i]))) {
                long[] jArr = this.f13374b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f13375c - i) - 1);
                this.f13375c--;
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
            long[] jArr = this.f13374b;
            System.arraycopy(jArr, i2, jArr, i, this.f13375c - i2);
            this.f13375c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzua();
        zzaj(i);
        long[] jArr = this.f13374b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13375c;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Long> zzal(int i) {
        if (i >= this.f13375c) {
            return new Ia(Arrays.copyOf(this.f13374b, i), this.f13375c);
        }
        throw new IllegalArgumentException();
    }

    private Ia(long[] jArr, int i) {
        this.f13374b = jArr;
        this.f13375c = i;
    }

    private final void a(int i, long j) {
        int i2;
        zzua();
        if (i >= 0 && i <= (i2 = this.f13375c)) {
            long[] jArr = this.f13374b;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f13374b, i, jArr2, i + 1, this.f13375c - i);
                this.f13374b = jArr2;
            }
            this.f13374b[i] = j;
            this.f13375c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(a(i));
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        long[] jArr = this.f13374b;
        long j = jArr[i];
        if (i < this.f13375c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f13375c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    private final String a(int i) {
        int i2 = this.f13375c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }
}
