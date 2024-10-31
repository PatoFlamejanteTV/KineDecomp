package com.google.android.gms.internal.firebase_auth;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class C extends AbstractC1244d<Float> implements zzgb<Float>, InterfaceC1247ea, RandomAccess {

    /* renamed from: a */
    private static final C f12954a;

    /* renamed from: b */
    private float[] f12955b;

    /* renamed from: c */
    private int f12956c;

    static {
        C c2 = new C();
        f12954a = c2;
        c2.zzev();
    }

    C() {
        this(new float[10], 0);
    }

    private final String zzi(int i) {
        int i2 = this.f12956c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(float f2) {
        a(this.f12956c, f2);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzew();
        zzfv.checkNotNull(collection);
        if (!(collection instanceof C)) {
            return super.addAll(collection);
        }
        C c2 = (C) collection;
        int i = c2.f12956c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f12956c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f12955b;
            if (i3 > fArr.length) {
                this.f12955b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(c2.f12955b, 0, this.f12955b, this.f12956c, c2.f12956c);
            this.f12956c = i3;
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
        if (!(obj instanceof C)) {
            return super.equals(obj);
        }
        C c2 = (C) obj;
        if (this.f12956c != c2.f12956c) {
            return false;
        }
        float[] fArr = c2.f12955b;
        for (int i = 0; i < this.f12956c; i++) {
            if (Float.floatToIntBits(this.f12955b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Float.valueOf(this.f12955b[i]);
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f12956c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f12955b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzew();
        for (int i = 0; i < this.f12956c; i++) {
            if (obj.equals(Float.valueOf(this.f12955b[i]))) {
                float[] fArr = this.f12955b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f12956c - i) - 1);
                this.f12956c--;
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
            float[] fArr = this.f12955b;
            System.arraycopy(fArr, i2, fArr, i, this.f12956c - i2);
            this.f12956c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzew();
        a(i);
        float[] fArr = this.f12955b;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f12956c;
    }

    @Override // com.google.android.gms.internal.firebase_auth.zzgb
    public final /* synthetic */ zzgb<Float> zzj(int i) {
        if (i >= this.f12956c) {
            return new C(Arrays.copyOf(this.f12955b, i), this.f12956c);
        }
        throw new IllegalArgumentException();
    }

    private C(float[] fArr, int i) {
        this.f12955b = fArr;
        this.f12956c = i;
    }

    private final void a(int i, float f2) {
        int i2;
        zzew();
        if (i >= 0 && i <= (i2 = this.f12956c)) {
            float[] fArr = this.f12955b;
            if (i2 < fArr.length) {
                System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
            } else {
                float[] fArr2 = new float[((i2 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                System.arraycopy(this.f12955b, i, fArr2, i + 1, this.f12956c - i);
                this.f12955b = fArr2;
            }
            this.f12955b[i] = f2;
            this.f12956c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(zzi(i));
    }

    @Override // com.google.android.gms.internal.firebase_auth.AbstractC1244d, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzew();
        a(i);
        float[] fArr = this.f12955b;
        float f2 = fArr[i];
        if (i < this.f12956c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.f12956c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f12956c) {
            throw new IndexOutOfBoundsException(zzi(i));
        }
    }
}
