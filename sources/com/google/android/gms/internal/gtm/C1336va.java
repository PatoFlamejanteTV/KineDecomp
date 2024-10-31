package com.google.android.gms.internal.gtm;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.gtm.va */
/* loaded from: classes2.dex */
final class C1336va extends Y<Float> implements zzrj<Float>, Wa, RandomAccess {

    /* renamed from: a */
    private static final C1336va f13313a;

    /* renamed from: b */
    private float[] f13314b;

    /* renamed from: c */
    private int f13315c;

    static {
        C1336va c1336va = new C1336va(new float[0], 0);
        f13313a = c1336va;
        c1336va.zzmi();
    }

    C1336va() {
        this(new float[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f13315c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    public final void a(float f2) {
        a(this.f13315c, f2);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Float) obj).floatValue());
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Float> collection) {
        zzmz();
        zzre.checkNotNull(collection);
        if (!(collection instanceof C1336va)) {
            return super.addAll(collection);
        }
        C1336va c1336va = (C1336va) collection;
        int i = c1336va.f13315c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13315c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.f13314b;
            if (i3 > fArr.length) {
                this.f13314b = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(c1336va.f13314b, 0, this.f13314b, this.f13315c, c1336va.f13315c);
            this.f13315c = i3;
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
        if (!(obj instanceof C1336va)) {
            return super.equals(obj);
        }
        C1336va c1336va = (C1336va) obj;
        if (this.f13315c != c1336va.f13315c) {
            return false;
        }
        float[] fArr = c1336va.f13314b;
        for (int i = 0; i < this.f13315c; i++) {
            if (Float.floatToIntBits(this.f13314b[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        a(i);
        return Float.valueOf(this.f13314b[i]);
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13315c; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.f13314b[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzmz();
        for (int i = 0; i < this.f13315c; i++) {
            if (obj.equals(Float.valueOf(this.f13314b[i]))) {
                float[] fArr = this.f13314b;
                System.arraycopy(fArr, i + 1, fArr, i, (this.f13315c - i) - 1);
                this.f13315c--;
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
            float[] fArr = this.f13314b;
            System.arraycopy(fArr, i2, fArr, i, this.f13315c - i2);
            this.f13315c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        float floatValue = ((Float) obj).floatValue();
        zzmz();
        a(i);
        float[] fArr = this.f13314b;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13315c;
    }

    @Override // com.google.android.gms.internal.gtm.zzrj
    public final /* synthetic */ zzrj<Float> zzaj(int i) {
        if (i >= this.f13315c) {
            return new C1336va(Arrays.copyOf(this.f13314b, i), this.f13315c);
        }
        throw new IllegalArgumentException();
    }

    private C1336va(float[] fArr, int i) {
        this.f13314b = fArr;
        this.f13315c = i;
    }

    private final void a(int i, float f2) {
        int i2;
        zzmz();
        if (i >= 0 && i <= (i2 = this.f13315c)) {
            float[] fArr = this.f13314b;
            if (i2 < fArr.length) {
                System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
            } else {
                float[] fArr2 = new float[((i2 * 3) / 2) + 1];
                System.arraycopy(fArr, 0, fArr2, 0, i);
                System.arraycopy(this.f13314b, i, fArr2, i + 1, this.f13315c - i);
                this.f13314b = fArr2;
            }
            this.f13314b[i] = f2;
            this.f13315c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.gtm.Y, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzmz();
        a(i);
        float[] fArr = this.f13314b;
        float f2 = fArr[i];
        if (i < this.f13315c - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (r2 - i) - 1);
        }
        this.f13315c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f2);
    }

    private final void a(int i) {
        if (i < 0 || i >= this.f13315c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }
}
