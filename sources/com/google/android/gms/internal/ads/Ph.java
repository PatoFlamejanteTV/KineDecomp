package com.google.android.gms.internal.ads;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class Ph extends AbstractC1069rh<Float> implements zzbrk<Float>, InterfaceC1043pi, RandomAccess {

    /* renamed from: a */
    private static final Ph f11754a;

    /* renamed from: b */
    private float[] f11755b;

    /* renamed from: c */
    private int f11756c;

    static {
        Ph ph = new Ph();
        f11754a = ph;
        ph.zzakj();
    }

    Ph() {
        this(new float[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f11756c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(float f2) {
        a(this.f11756c, f2);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzakk();
        zzbrf.checkNotNull(collection);
        if (!(collection instanceof Ph)) {
            return super.addAll(collection);
        }
        Ph ph = (Ph) collection;
        int i = ph.f11756c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f11756c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f11755b;
            if (i3 > fArr.length) {
                this.f11755b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(ph.f11755b, 0, this.f11755b, this.f11756c, ph.f11756c);
            this.f11756c = i3;
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
        if (!(obj instanceof Ph)) {
            return super.equals(obj);
        }
        Ph ph = (Ph) obj;
        if (this.f11756c != ph.f11756c) {
            return false;
        }
        float[] fArr = ph.f11755b;
        for (int i = 0; i < this.f11756c; i++) {
            if (this.f11755b[i] != fArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Float.valueOf(this.f11755b[i]);
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f11756c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f11755b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzakk();
        for (int i = 0; i < this.f11756c; i++) {
            if (obj.equals(Float.valueOf(this.f11755b[i]))) {
                float[] fArr = this.f11755b;
                System.arraycopy(fArr, i + 1, fArr, i, this.f11756c - i);
                this.f11756c--;
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
            float[] fArr = this.f11755b;
            System.arraycopy(fArr, i2, fArr, i, this.f11756c - i2);
            this.f11756c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzakk();
        a(i);
        float[] fArr = this.f11755b;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f11756c;
    }

    @Override // com.google.android.gms.internal.ads.zzbrk
    public final /* synthetic */ zzbrk<Float> zzel(int i) {
        if (i >= this.f11756c) {
            return new Ph(Arrays.copyOf(this.f11755b, i), this.f11756c);
        }
        throw new IllegalArgumentException();
    }

    private Ph(float[] fArr, int i) {
        this.f11755b = fArr;
        this.f11756c = i;
    }

    private final void a(int i, float f2) {
        int i2;
        zzakk();
        if (i >= 0 && i <= (i2 = this.f11756c)) {
            float[] fArr = this.f11755b;
            if (i2 < fArr.length) {
                System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
            } else {
                float[] fArr2 = new float[((i2 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                System.arraycopy(this.f11755b, i, fArr2, i + 1, this.f11756c - i);
                this.f11755b = fArr2;
            }
            this.f11755b[i] = f2;
            this.f11756c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.ads.AbstractC1069rh, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzakk();
        a(i);
        float[] fArr = this.f11755b;
        float f2 = fArr[i];
        int i2 = this.f11756c;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, i2 - i);
        }
        this.f11756c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f11756c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
