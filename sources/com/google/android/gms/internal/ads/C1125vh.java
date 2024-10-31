package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.ads.vh */
/* loaded from: classes2.dex */
final class C1125vh extends AbstractC1069rh<Boolean> implements zzbrk<Boolean>, InterfaceC1043pi, RandomAccess {

    /* renamed from: a */
    private static final C1125vh f12610a;

    /* renamed from: b */
    private boolean[] f12611b;

    /* renamed from: c */
    private int f12612c;

    static {
        C1125vh c1125vh = new C1125vh();
        f12610a = c1125vh;
        c1125vh.zzakj();
    }

    C1125vh() {
        this(new boolean[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f12612c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(boolean z) {
        a(this.f12612c, z);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof C1125vh)) {
            return super.addAll(collection);
        }
        C1125vh c1125vh = (C1125vh) collection;
        int i = c1125vh.f12612c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12612c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f12611b;
            if (i3 > zArr.length) {
                this.f12611b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(c1125vh.f12611b, 0, this.f12611b, this.f12612c, c1125vh.f12612c);
            this.f12612c = i3;
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
        if (!(obj instanceof C1125vh)) {
            return super.equals(obj);
        }
        C1125vh c1125vh = (C1125vh) obj;
        if (this.f12612c != c1125vh.f12612c) {
            return false;
        }
        boolean[] zArr = c1125vh.f12611b;
        for (int i = 0; i < this.f12612c; i++) {
            if (this.f12611b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.f12611b[i]);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12612c; i2++) {
            i = (i * 31) + zzbrf.zzbf(this.f12611b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.f12612c; i++) {
            if (obj.equals(Boolean.valueOf(this.f12611b[i]))) {
                boolean[] zArr = this.f12611b;
                System.arraycopy(zArr, i + 1, zArr, i, this.f12612c - i);
                this.f12612c--;
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
            boolean[] zArr = this.f12611b;
            System.arraycopy(zArr, i2, zArr, i, this.f12612c - i2);
            this.f12612c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzakk();
        a(i);
        boolean[] zArr = this.f12611b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12612c;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Boolean> zzel(int i) {
        if (i >= this.f12612c) {
            return new C1125vh(Arrays.copyOf(this.f12611b, i), this.f12612c);
        }
        throw new IllegalArgumentException();
    }

    private C1125vh(boolean[] zArr, int i) {
        this.f12611b = zArr;
        this.f12612c = i;
    }

    private final void a(int i, boolean z) {
        int i2;
        zzakk();
        if (i >= 0 && i <= (i2 = this.f12612c)) {
            boolean[] zArr = this.f12611b;
            if (i2 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
            } else {
                boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                System.arraycopy(this.f12611b, i, zArr2, i + 1, this.f12612c - i);
                this.f12611b = zArr2;
            }
            this.f12611b[i] = z;
            this.f12612c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        a(i);
        boolean[] zArr = this.f12611b;
        boolean z = zArr[i];
        int i2 = this.f12612c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.f12612c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12612c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
