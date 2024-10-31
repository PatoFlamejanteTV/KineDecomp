package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.gtm.ya */
/* loaded from: classes2.dex */
public final class C1342ya extends Y<Integer> implements zzrj<Integer>, Wa, RandomAccess {

    /* renamed from: a */
    private static final C1342ya f13325a;

    /* renamed from: b */
    private int[] f13326b;

    /* renamed from: c */
    private int f13327c;

    static {
        C1342ya c1342ya = new C1342ya(new int[0], 0);
        f13325a = c1342ya;
        c1342ya.zzmi();
    }

    C1342ya() {
        this(new int[10], 0);
    }

    public static C1342ya a() {
        return f13325a;
    }

    private final void b(int i) {
        if (i < 0 || i >= this.f13327c) {
            throw new IndexOutOfBoundsException(c(i));
        }
    }

    private final String c(int i) {
        int i2 = this.f13327c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof C1342ya)) {
            return super.addAll(collection);
        }
        C1342ya c1342ya = (C1342ya) collection;
        int i = c1342ya.f13327c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13327c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f13326b;
            if (i3 > iArr.length) {
                this.f13326b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(c1342ya.f13326b, 0, this.f13326b, this.f13327c, c1342ya.f13327c);
            this.f13327c = i3;
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
        if (!(obj instanceof C1342ya)) {
            return super.equals(obj);
        }
        C1342ya c1342ya = (C1342ya) obj;
        if (this.f13327c != c1342ya.f13327c) {
            return false;
        }
        int[] iArr = c1342ya.f13326b;
        for (int i = 0; i < this.f13327c; i++) {
            if (this.f13326b[i] != iArr[i]) {
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
        return this.f13326b[i];
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13327c; i2++) {
            i = (i * 31) + this.f13326b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.f13327c; i++) {
            if (obj.equals(Integer.valueOf(this.f13326b[i]))) {
                int[] iArr = this.f13326b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f13327c - i) - 1);
                this.f13327c--;
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
            int[] iArr = this.f13326b;
            System.arraycopy(iArr, i2, iArr, i, this.f13327c - i2);
            this.f13327c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzmz();
        b(i);
        int[] iArr = this.f13326b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13327c;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Integer> zzaj(int i) {
        if (i >= this.f13327c) {
            return new C1342ya(Arrays.copyOf(this.f13326b, i), this.f13327c);
        }
        throw new IllegalArgumentException();
    }

    private C1342ya(int[] iArr, int i) {
        this.f13326b = iArr;
        this.f13327c = i;
    }

    public final void a(int i) {
        a(this.f13327c, i);
    }

    private final void a(int i, int i2) {
        int i3;
        zzmz();
        if (i >= 0 && i <= (i3 = this.f13327c)) {
            int[] iArr = this.f13326b;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f13326b, i, iArr2, i + 1, this.f13327c - i);
                this.f13326b = iArr2;
            }
            this.f13326b[i] = i2;
            this.f13327c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(c(i));
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzmz();
        b(i);
        int[] iArr = this.f13326b;
        int i2 = iArr[i];
        if (i < this.f13327c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f13327c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }
}
