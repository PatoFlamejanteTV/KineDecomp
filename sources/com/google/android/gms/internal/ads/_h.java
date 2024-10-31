package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class _h extends AbstractC1069rh<Long> implements zzbrk<Long>, InterfaceC1043pi, RandomAccess {

    /* renamed from: a */
    private static final _h f12038a;

    /* renamed from: b */
    private long[] f12039b;

    /* renamed from: c */
    private int f12040c;

    static {
        _h _hVar = new _h();
        f12038a = _hVar;
        _hVar.zzakj();
    }

    _h() {
        this(new long[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f12040c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(long j) {
        a(this.f12040c, j);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Long) obj).longValue());
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Long> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof _h)) {
            return super.addAll(collection);
        }
        _h _hVar = (_h) collection;
        int i = _hVar.f12040c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12040c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.f12039b;
            if (i3 > jArr.length) {
                this.f12039b = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(_hVar.f12039b, 0, this.f12039b, this.f12040c, _hVar.f12040c);
            this.f12040c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof _h)) {
            return super.equals(obj);
        }
        _h _hVar = (_h) obj;
        if (this.f12040c != _hVar.f12040c) {
            return false;
        }
        long[] jArr = _hVar.f12039b;
        for (int i = 0; i < this.f12040c; i++) {
            if (this.f12039b[i] != jArr[i]) {
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
        return this.f12039b[i];
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12040c; i2++) {
            i = (i * 31) + zzbrf.zzbi(this.f12039b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.f12040c; i++) {
            if (obj.equals(Long.valueOf(this.f12039b[i]))) {
                long[] jArr = this.f12039b;
                System.arraycopy(jArr, i + 1, jArr, i, this.f12040c - i);
                this.f12040c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzakk();
        if (i2 >= i) {
            long[] jArr = this.f12039b;
            System.arraycopy(jArr, i2, jArr, i, this.f12040c - i2);
            this.f12040c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        long longValue = ((Long) obj).longValue();
        zzakk();
        a(i);
        long[] jArr = this.f12039b;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12040c;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Long> zzel(int i) {
        if (i >= this.f12040c) {
            return new _h(Arrays.copyOf(this.f12039b, i), this.f12040c);
        }
        throw new IllegalArgumentException();
    }

    private _h(long[] jArr, int i) {
        this.f12039b = jArr;
        this.f12040c = i;
    }

    private final void a(int i, long j) {
        int i2;
        zzakk();
        if (i >= 0 && i <= (i2 = this.f12040c)) {
            long[] jArr = this.f12039b;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f12039b, i, jArr2, i + 1, this.f12040c - i);
                this.f12039b = jArr2;
            }
            this.f12039b[i] = j;
            this.f12040c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        a(i);
        long[] jArr = this.f12039b;
        long j = jArr[i];
        int i2 = this.f12040c;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, i2 - i);
        }
        this.f12040c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12040c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
