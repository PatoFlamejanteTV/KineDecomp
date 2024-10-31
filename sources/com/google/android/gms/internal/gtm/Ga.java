package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class Ga extends Y<Long> implements zzrj<Long>, Wa, RandomAccess {

    /* renamed from: a */
    private static final Ga f13151a;

    /* renamed from: b */
    private long[] f13152b;

    /* renamed from: c */
    private int f13153c;

    static {
        Ga ga = new Ga(new long[0], 0);
        f13151a = ga;
        ga.zzmi();
    }

    Ga() {
        this(new long[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f13153c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(long j) {
        a(this.f13153c, j);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof Ga)) {
            return super.addAll(collection);
        }
        Ga ga = (Ga) collection;
        int i = ga.f13153c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13153c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f13152b;
            if (i3 > jArr.length) {
                this.f13152b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(ga.f13152b, 0, this.f13152b, this.f13153c, ga.f13153c);
            this.f13153c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Ga)) {
            return super.equals(obj);
        }
        Ga ga = (Ga) obj;
        if (this.f13153c != ga.f13153c) {
            return false;
        }
        long[] jArr = ga.f13152b;
        for (int i = 0; i < this.f13153c; i++) {
            if (this.f13152b[i] != jArr[i]) {
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
        return this.f13152b[i];
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13153c; i2++) {
            i = (i * 31) + zzre.zzz(this.f13152b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.f13153c; i++) {
            if (obj.equals(Long.valueOf(this.f13152b[i]))) {
                long[] jArr = this.f13152b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f13153c - i) - 1);
                this.f13153c--;
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
            long[] jArr = this.f13152b;
            System.arraycopy(jArr, i2, jArr, i, this.f13153c - i2);
            this.f13153c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzmz();
        a(i);
        long[] jArr = this.f13152b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13153c;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Long> zzaj(int i) {
        if (i >= this.f13153c) {
            return new Ga(Arrays.copyOf(this.f13152b, i), this.f13153c);
        }
        throw new IllegalArgumentException();
    }

    private Ga(long[] jArr, int i) {
        this.f13152b = jArr;
        this.f13153c = i;
    }

    private final void a(int i, long j) {
        int i2;
        zzmz();
        if (i >= 0 && i <= (i2 = this.f13153c)) {
            long[] jArr = this.f13152b;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f13152b, i, jArr2, i + 1, this.f13153c - i);
                this.f13152b = jArr2;
            }
            this.f13152b[i] = j;
            this.f13153c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzmz();
        a(i);
        long[] jArr = this.f13152b;
        long j = jArr[i];
        if (i < this.f13153c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f13153c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13153c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
