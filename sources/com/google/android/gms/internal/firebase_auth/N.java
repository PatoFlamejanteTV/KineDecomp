package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class N extends AbstractC1244d<Long> implements zzgb<Long>, InterfaceC1247ea, RandomAccess {

    /* renamed from: a */
    private static final N f12985a;

    /* renamed from: b */
    private long[] f12986b;

    /* renamed from: c */
    private int f12987c;

    static {
        N n = new N();
        f12985a = n;
        n.zzev();
    }

    N() {
        this(new long[10], 0);
    }

    private final String zzi(int i) {
        int i2 = this.f12987c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(long j) {
        a(this.f12987c, j);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof N)) {
            return super.addAll(collection);
        }
        N n = (N) collection;
        int i = n.f12987c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12987c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f12986b;
            if (i3 > jArr.length) {
                this.f12986b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(n.f12986b, 0, this.f12986b, this.f12987c, n.f12987c);
            this.f12987c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof N)) {
            return super.equals(obj);
        }
        N n = (N) obj;
        if (this.f12987c != n.f12987c) {
            return false;
        }
        long[] jArr = n.f12986b;
        for (int i = 0; i < this.f12987c; i++) {
            if (this.f12986b[i] != jArr[i]) {
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
        return this.f12986b[i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12987c; i2++) {
            i = (i * 31) + zzfv.zzk(this.f12986b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.f12987c; i++) {
            if (obj.equals(Long.valueOf(this.f12986b[i]))) {
                long[] jArr = this.f12986b;
                System.arraycopy(jArr, i + 1, jArr, i, (this.f12987c - i) - 1);
                this.f12987c--;
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
            long[] jArr = this.f12986b;
            System.arraycopy(jArr, i2, jArr, i, this.f12987c - i2);
            this.f12987c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzew();
        a(i);
        long[] jArr = this.f12986b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12987c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb<Long> zzj(int i) {
        if (i >= this.f12987c) {
            return new N(Arrays.copyOf(this.f12986b, i), this.f12987c);
        }
        throw new IllegalArgumentException();
    }

    private N(long[] jArr, int i) {
        this.f12986b = jArr;
        this.f12987c = i;
    }

    private final void a(int i, long j) {
        int i2;
        zzew();
        if (i >= 0 && i <= (i2 = this.f12987c)) {
            long[] jArr = this.f12986b;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f12986b, i, jArr2, i + 1, this.f12987c - i);
                this.f12986b = jArr2;
            }
            this.f12986b[i] = j;
            this.f12987c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        a(i);
        long[] jArr = this.f12986b;
        long j = jArr[i];
        if (i < this.f12987c - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (r3 - i) - 1);
        }
        this.f12987c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12987c) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }
}
