package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.clearcut.p */
/* loaded from: classes2.dex */
final class C1217p extends AbstractC1209l<Boolean> implements zzcn<Boolean>, RandomAccess {

    /* renamed from: a */
    private static final C1217p f12875a;

    /* renamed from: b */
    private boolean[] f12876b;

    /* renamed from: c */
    private int f12877c;

    static {
        C1217p c1217p = new C1217p();
        f12875a = c1217p;
        c1217p.zzv();
    }

    C1217p() {
        this(new boolean[10], 0);
    }

    private C1217p(boolean[] zArr, int i) {
        this.f12876b = zArr;
        this.f12877c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12877c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, boolean z) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.f12877c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        boolean[] zArr = this.f12876b;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[((i2 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.f12876b, i, zArr2, i + 1, this.f12877c - i);
            this.f12876b = zArr2;
        }
        this.f12876b[i] = z;
        this.f12877c++;
        ((AbstractList) this).modCount++;
    }

    private final String b(int i) {
        int i2 = this.f12877c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(boolean z) {
        a(this.f12877c, z);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Boolean) obj).booleanValue());
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof C1217p)) {
            return super.addAll(collection);
        }
        C1217p c1217p = (C1217p) collection;
        int i = c1217p.f12877c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12877c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 < i) {
            throw new OutOfMemoryError();
        }
        int i3 = i2 + i;
        boolean[] zArr = this.f12876b;
        if (i3 > zArr.length) {
            this.f12876b = Arrays.copyOf(zArr, i3);
        }
        System.arraycopy(c1217p.f12876b, 0, this.f12876b, this.f12877c, c1217p.f12877c);
        this.f12877c = i3;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1217p)) {
            return super.equals(obj);
        }
        C1217p c1217p = (C1217p) obj;
        if (this.f12877c != c1217p.f12877c) {
            return false;
        }
        boolean[] zArr = c1217p.f12876b;
        for (int i = 0; i < this.f12877c; i++) {
            if (this.f12876b[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Boolean.valueOf(this.f12876b[i]);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12877c; i2++) {
            i = (i * 31) + zzci.zzc(this.f12876b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        a(i);
        boolean[] zArr = this.f12876b;
        boolean z = zArr[i];
        int i2 = this.f12877c;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, i2 - i);
        }
        this.f12877c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.f12877c; i++) {
            if (obj.equals(Boolean.valueOf(this.f12876b[i]))) {
                boolean[] zArr = this.f12876b;
                System.arraycopy(zArr, i + 1, zArr, i, this.f12877c - i);
                this.f12877c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzw();
        if (i2 < i) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f12876b;
        System.arraycopy(zArr, i2, zArr, i, this.f12877c - i2);
        this.f12877c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        boolean booleanValue = ((Boolean) obj).booleanValue();
        zzw();
        a(i);
        boolean[] zArr = this.f12876b;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12877c;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Boolean> zzi(int i) {
        if (i >= this.f12877c) {
            return new C1217p(Arrays.copyOf(this.f12876b, i), this.f12877c);
        }
        throw new IllegalArgumentException();
    }
}
