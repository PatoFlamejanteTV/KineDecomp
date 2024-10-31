package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
public final class F extends AbstractC1244d<Integer> implements zzfz, InterfaceC1247ea, RandomAccess {

    /* renamed from: a */
    private static final F f12962a;

    /* renamed from: b */
    private int[] f12963b;

    /* renamed from: c */
    private int f12964c;

    static {
        F f2 = new F();
        f12962a = f2;
        f2.zzev();
    }

    F() {
        this(new int[10], 0);
    }

    public static F a() {
        return f12962a;
    }

    private final String zzi(int i) {
        int i2 = this.f12964c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof F)) {
            return super.addAll(collection);
        }
        F f2 = (F) collection;
        int i = f2.f12964c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12964c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f12963b;
            if (i3 > iArr.length) {
                this.f12963b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(f2.f12963b, 0, this.f12963b, this.f12964c, f2.f12964c);
            this.f12964c = i3;
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
        if (!(obj instanceof F)) {
            return super.equals(obj);
        }
        F f2 = (F) obj;
        if (this.f12964c != f2.f12964c) {
            return false;
        }
        int[] iArr = f2.f12963b;
        for (int i = 0; i < this.f12964c; i++) {
            if (this.f12963b[i] != iArr[i]) {
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
        a(i);
        return this.f12963b[i];
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12964c; i2++) {
            i = (i * 31) + this.f12963b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.f12964c; i++) {
            if (obj.equals(Integer.valueOf(this.f12963b[i]))) {
                int[] iArr = this.f12963b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f12964c - i) - 1);
                this.f12964c--;
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
            int[] iArr = this.f12963b;
            System.arraycopy(iArr, i2, iArr, i, this.f12964c - i2);
            this.f12964c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzew();
        a(i);
        int[] iArr = this.f12963b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12964c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    /* renamed from: zzar */
    public final zzfz zzj(int i) {
        if (i >= this.f12964c) {
            return new F(Arrays.copyOf(this.f12963b, i), this.f12964c);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzfz
    public final void zzas(int i) {
        a(this.f12964c, i);
    }

    private F(int[] iArr, int i) {
        this.f12963b = iArr;
        this.f12964c = i;
    }

    private final void a(int i, int i2) {
        int i3;
        zzew();
        if (i >= 0 && i <= (i3 = this.f12964c)) {
            int[] iArr = this.f12963b;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f12963b, i, iArr2, i + 1, this.f12964c - i);
                this.f12963b = iArr2;
            }
            this.f12963b[i] = i2;
            this.f12964c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        a(i);
        int[] iArr = this.f12963b;
        int i2 = iArr[i];
        if (i < this.f12964c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f12964c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12964c) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }
}
