package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.gtm.aa */
/* loaded from: classes2.dex */
final class C1290aa extends Y<Boolean> implements zzrj<Boolean>, Wa, RandomAccess {

    /* renamed from: a */
    private static final C1290aa f13201a;

    /* renamed from: b */
    private boolean[] f13202b;

    /* renamed from: c */
    private int f13203c;

    static {
        C1290aa c1290aa = new C1290aa(new boolean[0], 0);
        f13201a = c1290aa;
        c1290aa.zzmi();
    }

    C1290aa() {
        this(new boolean[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f13203c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(boolean z) {
        a(this.f13203c, z);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof C1290aa)) {
            return super.addAll(collection);
        }
        C1290aa c1290aa = (C1290aa) collection;
        int i = c1290aa.f13203c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13203c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f13202b;
            if (i3 > zArr.length) {
                this.f13202b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(c1290aa.f13202b, 0, this.f13202b, this.f13203c, c1290aa.f13203c);
            this.f13203c = i3;
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
        if (!(obj instanceof C1290aa)) {
            return super.equals(obj);
        }
        C1290aa c1290aa = (C1290aa) obj;
        if (this.f13203c != c1290aa.f13203c) {
            return false;
        }
        boolean[] zArr = c1290aa.f13202b;
        for (int i = 0; i < this.f13203c; i++) {
            if (this.f13202b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.f13202b[i]);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13203c; i2++) {
            i = (i * 31) + zzre.zzk(this.f13202b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.f13203c; i++) {
            if (obj.equals(Boolean.valueOf(this.f13202b[i]))) {
                boolean[] zArr = this.f13202b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f13203c - i) - 1);
                this.f13203c--;
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
            boolean[] zArr = this.f13202b;
            System.arraycopy(zArr, i2, zArr, i, this.f13203c - i2);
            this.f13203c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzmz();
        a(i);
        boolean[] zArr = this.f13202b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13203c;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Boolean> zzaj(int i) {
        if (i >= this.f13203c) {
            return new C1290aa(Arrays.copyOf(this.f13202b, i), this.f13203c);
        }
        throw new IllegalArgumentException();
    }

    private C1290aa(boolean[] zArr, int i) {
        this.f13202b = zArr;
        this.f13203c = i;
    }

    private final void a(int i, boolean z) {
        int i2;
        zzmz();
        if (i >= 0 && i <= (i2 = this.f13203c)) {
            boolean[] zArr = this.f13202b;
            if (i2 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
            } else {
                boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                System.arraycopy(this.f13202b, i, zArr2, i + 1, this.f13203c - i);
                this.f13202b = zArr2;
            }
            this.f13202b[i] = z;
            this.f13203c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzmz();
        a(i);
        boolean[] zArr = this.f13202b;
        boolean z = zArr[i];
        if (i < this.f13203c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.f13203c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13203c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
