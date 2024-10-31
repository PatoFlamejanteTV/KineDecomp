package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.firebase_auth.f */
/* loaded from: classes2.dex */
final class C1248f extends AbstractC1244d<Boolean> implements zzgb<Boolean>, InterfaceC1247ea, RandomAccess {

    /* renamed from: a */
    private static final C1248f f13023a;

    /* renamed from: b */
    private boolean[] f13024b;

    /* renamed from: c */
    private int f13025c;

    static {
        C1248f c1248f = new C1248f();
        f13023a = c1248f;
        c1248f.zzev();
    }

    C1248f() {
        this(new boolean[10], 0);
    }

    private final String zzi(int i) {
        int i2 = this.f13025c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(boolean z) {
        a(this.f13025c, z);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof C1248f)) {
            return super.addAll(collection);
        }
        C1248f c1248f = (C1248f) collection;
        int i = c1248f.f13025c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13025c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.f13024b;
            if (i3 > zArr.length) {
                this.f13024b = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(c1248f.f13024b, 0, this.f13024b, this.f13025c, c1248f.f13025c);
            this.f13025c = i3;
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
        if (!(obj instanceof C1248f)) {
            return super.equals(obj);
        }
        C1248f c1248f = (C1248f) obj;
        if (this.f13025c != c1248f.f13025c) {
            return false;
        }
        boolean[] zArr = c1248f.f13024b;
        for (int i = 0; i < this.f13025c; i++) {
            if (this.f13024b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.f13024b[i]);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13025c; i2++) {
            i = (i * 31) + zzfv.zzu(this.f13024b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.f13025c; i++) {
            if (obj.equals(Boolean.valueOf(this.f13024b[i]))) {
                boolean[] zArr = this.f13024b;
                System.arraycopy(zArr, i + 1, zArr, i, (this.f13025c - i) - 1);
                this.f13025c--;
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
            boolean[] zArr = this.f13024b;
            System.arraycopy(zArr, i2, zArr, i, this.f13025c - i2);
            this.f13025c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzew();
        a(i);
        boolean[] zArr = this.f13024b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13025c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb<Boolean> zzj(int i) {
        if (i >= this.f13025c) {
            return new C1248f(Arrays.copyOf(this.f13024b, i), this.f13025c);
        }
        throw new IllegalArgumentException();
    }

    private C1248f(boolean[] zArr, int i) {
        this.f13024b = zArr;
        this.f13025c = i;
    }

    private final void a(int i, boolean z) {
        int i2;
        zzew();
        if (i >= 0 && i <= (i2 = this.f13025c)) {
            boolean[] zArr = this.f13024b;
            if (i2 < zArr.length) {
                System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
            } else {
                boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
                System.arraycopy(zArr, 0, zArr2, 0, i);
                System.arraycopy(this.f13024b, i, zArr2, i + 1, this.f13025c - i);
                this.f13024b = zArr2;
            }
            this.f13024b[i] = z;
            this.f13025c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        a(i);
        boolean[] zArr = this.f13024b;
        boolean z = zArr[i];
        if (i < this.f13025c - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (r2 - i) - 1);
        }
        this.f13025c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13025c) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }
}
