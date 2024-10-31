package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.xa */
/* loaded from: classes2.dex */
final class C1399xa extends AbstractC1346aa<Float> implements zzuu<Float>, Ya, RandomAccess {

    /* renamed from: a */
    private static final C1399xa f13551a;

    /* renamed from: b */
    private float[] f13552b;

    /* renamed from: c */
    private int f13553c;

    static {
        C1399xa c1399xa = new C1399xa();
        f13551a = c1399xa;
        c1399xa.zzsw();
    }

    C1399xa() {
        this(new float[10], 0);
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.f13553c) {
            throw new IndexOutOfBoundsException(a(i));
        }
    }

    public final void a(float f2) {
        a(this.f13553c, f2);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof C1399xa)) {
            return super.addAll(collection);
        }
        C1399xa c1399xa = (C1399xa) collection;
        int i = c1399xa.f13553c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13553c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f13552b;
            if (i3 > fArr.length) {
                this.f13552b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(c1399xa.f13552b, 0, this.f13552b, this.f13553c, c1399xa.f13553c);
            this.f13553c = i3;
            ((AbstractList) this).modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1399xa)) {
            return super.equals(obj);
        }
        C1399xa c1399xa = (C1399xa) obj;
        if (this.f13553c != c1399xa.f13553c) {
            return false;
        }
        float[] fArr = c1399xa.f13552b;
        for (int i = 0; i < this.f13553c; i++) {
            if (Float.floatToIntBits(this.f13552b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        zzaj(i);
        return Float.valueOf(this.f13552b[i]);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13553c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f13552b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.f13553c; i++) {
            if (obj.equals(Float.valueOf(this.f13552b[i]))) {
                float[] fArr = this.f13552b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f13553c - i) - 1);
                this.f13553c--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i, int i2) {
        zzua();
        if (i2 >= i) {
            float[] fArr = this.f13552b;
            System.arraycopy(fArr, i2, fArr, i, this.f13553c - i2);
            this.f13553c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzua();
        zzaj(i);
        float[] fArr = this.f13552b;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13553c;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Float> zzal(int i) {
        if (i >= this.f13553c) {
            return new C1399xa(Arrays.copyOf(this.f13552b, i), this.f13553c);
        }
        throw new IllegalArgumentException();
    }

    private C1399xa(float[] fArr, int i) {
        this.f13552b = fArr;
        this.f13553c = i;
    }

    private final void a(int i, float f2) {
        int i2;
        zzua();
        if (i >= 0 && i <= (i2 = this.f13553c)) {
            float[] fArr = this.f13552b;
            if (i2 < fArr.length) {
                System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
            } else {
                float[] fArr2 = new float[((i2 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                System.arraycopy(this.f13552b, i, fArr2, i + 1, this.f13553c - i);
                this.f13552b = fArr2;
            }
            this.f13552b[i] = f2;
            this.f13553c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(a(i));
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        float[] fArr = this.f13552b;
        float f2 = fArr[i];
        if (i < this.f13553c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.f13553c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    private final String a(int i) {
        int i2 = this.f13553c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }
}
