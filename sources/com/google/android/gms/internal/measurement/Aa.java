package com.google.android.gms.internal.measurement;

import android.support.v7.widget.ActivityChooserView;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* loaded from: classes2.dex */
final class Aa extends AbstractC1346aa<Integer> implements zzuu<Integer>, Ya, RandomAccess {

    /* renamed from: a */
    private static final Aa f13349a;

    /* renamed from: b */
    private int[] f13350b;

    /* renamed from: c */
    private int f13351c;

    static {
        Aa aa = new Aa();
        f13349a = aa;
        aa.zzsw();
    }

    Aa() {
        this(new int[10], 0);
    }

    private final String b(int i) {
        int i2 = this.f13351c;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    private final void zzaj(int i) {
        if (i < 0 || i >= this.f13351c) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    public final void a(int i) {
        a(this.f13351c, i);
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        a(i, ((Integer) obj).intValue());
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzua();
        zzuq.checkNotNull(collection);
        if (!(collection instanceof Aa)) {
            return super.addAll(collection);
        }
        Aa aa = (Aa) collection;
        int i = aa.f13351c;
        if (i == 0) {
            return false;
        }
        int i2 = this.f13351c;
        if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.f13350b;
            if (i3 > iArr.length) {
                this.f13350b = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(aa.f13350b, 0, this.f13350b, this.f13351c, aa.f13351c);
            this.f13351c = i3;
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
        if (!(obj instanceof Aa)) {
            return super.equals(obj);
        }
        Aa aa = (Aa) obj;
        if (this.f13351c != aa.f13351c) {
            return false;
        }
        int[] iArr = aa.f13350b;
        for (int i = 0; i < this.f13351c; i++) {
            if (this.f13350b[i] != iArr[i]) {
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
        zzaj(i);
        return this.f13350b[i];
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f13351c; i2++) {
            i = (i * 31) + this.f13350b[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean remove(Object obj) {
        zzua();
        for (int i = 0; i < this.f13351c; i++) {
            if (obj.equals(Integer.valueOf(this.f13350b[i]))) {
                int[] iArr = this.f13350b;
                System.arraycopy(iArr, i + 1, iArr, i, (this.f13351c - i) - 1);
                this.f13351c--;
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
            int[] iArr = this.f13350b;
            System.arraycopy(iArr, i2, iArr, i, this.f13351c - i2);
            this.f13351c -= i2 - i;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        int intValue = ((Integer) obj).intValue();
        zzua();
        zzaj(i);
        int[] iArr = this.f13350b;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f13351c;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final /* synthetic */ zzuu<Integer> zzal(int i) {
        if (i >= this.f13351c) {
            return new Aa(Arrays.copyOf(this.f13350b, i), this.f13351c);
        }
        throw new IllegalArgumentException();
    }

    private Aa(int[] iArr, int i) {
        this.f13350b = iArr;
        this.f13351c = i;
    }

    private final void a(int i, int i2) {
        int i3;
        zzua();
        if (i >= 0 && i <= (i3 = this.f13351c)) {
            int[] iArr = this.f13350b;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f13350b, i, iArr2, i + 1, this.f13351c - i);
                this.f13350b = iArr2;
            }
            this.f13350b[i] = i2;
            this.f13351c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // com.google.android.gms.internal.measurement.AbstractC1346aa, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzua();
        zzaj(i);
        int[] iArr = this.f13350b;
        int i2 = iArr[i];
        if (i < this.f13351c - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (r2 - i) - 1);
        }
        this.f13351c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }
}
