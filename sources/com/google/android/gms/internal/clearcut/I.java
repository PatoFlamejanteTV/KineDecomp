package com.google.android.gms.internal.clearcut;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class I extends AbstractC1209l<Float> implements zzcn<Float>, RandomAccess {

    /* renamed from: a */
    private static final I f12780a;

    /* renamed from: b */
    private float[] f12781b;

    /* renamed from: c */
    private int f12782c;

    static {
        I i = new I();
        f12780a = i;
        i.zzv();
    }

    I() {
        this(new float[10], 0);
    }

    private I(float[] fArr, int i) {
        this.f12781b = fArr;
        this.f12782c = i;
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12782c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    private final void a(int i, float f2) {
        int i2;
        zzw();
        if (i < 0 || i > (i2 = this.f12782c)) {
            throw new IndexOutOfBoundsException(b(i));
        }
        float[] fArr = this.f12781b;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[((i2 * 3) / 2) + 1];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.f12781b, i, fArr2, i + 1, this.f12782c - i);
            this.f12781b = fArr2;
        }
        this.f12781b[i] = f2;
        this.f12782c++;
        ((AbstractList) this).modCount++;
    }

    private final String b(int i) {
        int i2 = this.f12782c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(float f2) {
        a(this.f12782c, f2);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzw();
        zzci.checkNotNull(collection);
        if (!(collection instanceof I)) {
            return super.addAll(collection);
        }
        I i = (I) collection;
        int i2 = i.f12782c;
        if (i2 == 0) {
            return false;
        }
        int i3 = this.f12782c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i3 < i2) {
            throw new OutOfMemoryError();
        }
        int i4 = i3 + i2;
        float[] fArr = this.f12781b;
        if (i4 > fArr.length) {
            this.f12781b = Arrays.copyOf(fArr, i4);
        }
        System.arraycopy(i.f12781b, 0, this.f12781b, this.f12782c, i.f12782c);
        this.f12782c = i4;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I)) {
            return super.equals(obj);
        }
        I i = (I) obj;
        if (this.f12782c != i.f12782c) {
            return false;
        }
        float[] fArr = i.f12781b;
        for (int i2 = 0; i2 < this.f12782c; i2++) {
            if (this.f12781b[i2] != fArr[i2]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Float.valueOf(this.f12781b[i]);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12782c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f12781b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzw();
        a(i);
        float[] fArr = this.f12781b;
        float f2 = fArr[i];
        int i2 = this.f12782c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.f12782c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzw();
        for (int i = 0; i < this.f12782c; i++) {
            if (obj.equals(Float.valueOf(this.f12781b[i]))) {
                float[] fArr = this.f12781b;
                System.arraycopy(fArr, i + 1, fArr, i, this.f12782c - i);
                this.f12782c--;
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
        float[] fArr = this.f12781b;
        System.arraycopy(fArr, i2, fArr, i, this.f12782c - i2);
        this.f12782c -= i2 - i;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.clearcut.AbstractC1209l, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzw();
        a(i);
        float[] fArr = this.f12781b;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12782c;
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn<Float> zzi(int i) {
        if (i >= this.f12782c) {
            return new I(Arrays.copyOf(this.f12781b, i), this.f12782c);
        }
        throw new IllegalArgumentException();
    }
}
