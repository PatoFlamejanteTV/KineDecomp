package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class Sh extends AbstractC1069rh<Integer> implements zzbrk<Integer>, InterfaceC1043pi, RandomAccess {

    /* renamed from: a */
    private static final Sh f11830a;

    /* renamed from: b */
    private int[] f11831b;

    /* renamed from: c */
    private int f11832c;

    static {
        Sh sh = new Sh();
        f11830a = sh;
        sh.zzakj();
    }

    Sh() {
        this(new int[10], 0);
    }

    public static Sh a() {
        return f11830a;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.f11832c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        int i2 = this.f11832c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof Sh)) {
            return super.addAll(collection);
        }
        Sh sh = (Sh) collection;
        int i = sh.f11832c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f11832c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f11831b;
            if (i3 > iArr.length) {
                this.f11831b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(sh.f11831b, 0, this.f11831b, this.f11832c, sh.f11832c);
            this.f11832c = i3;
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
        if (!(obj instanceof Sh)) {
            return super.equals(obj);
        }
        Sh sh = (Sh) obj;
        if (this.f11832c != sh.f11832c) {
            return false;
        }
        int[] iArr = sh.f11831b;
        for (int i = 0; i < this.f11832c; i++) {
            if (this.f11831b[i] != iArr[i]) {
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
        return this.f11831b[i];
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f11832c; i2++) {
            i = (i * 31) + this.f11831b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.f11832c; i++) {
            if (obj.equals(Integer.valueOf(this.f11831b[i]))) {
                int[] iArr = this.f11831b;
                System.arraycopy(iArr, i + 1, iArr, i, this.f11832c - i);
                this.f11832c--;
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
            int[] iArr = this.f11831b;
            System.arraycopy(iArr, i2, iArr, i, this.f11832c - i2);
            this.f11832c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzakk();
        b(i);
        int[] iArr = this.f11831b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11832c;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Integer> zzel(int i) {
        if (i >= this.f11832c) {
            return new Sh(Arrays.copyOf(this.f11831b, i), this.f11832c);
        }
        throw new IllegalArgumentException();
    }

    private Sh(int[] iArr, int i) {
        this.f11831b = iArr;
        this.f11832c = i;
    }

    public final void a(int i) {
        a(this.f11832c, i);
    }

    private final void a(int i, int i2) {
        int i3;
        zzakk();
        if (i >= 0 && i <= (i3 = this.f11832c)) {
            int[] iArr = this.f11831b;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f11831b, i, iArr2, i + 1, this.f11832c - i);
                this.f11831b = iArr2;
            }
            this.f11831b[i] = i2;
            this.f11832c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(c(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        b(i);
        int[] iArr = this.f11831b;
        int i2 = iArr[i];
        int i3 = this.f11832c;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, i3 - i);
        }
        this.f11832c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }
}
