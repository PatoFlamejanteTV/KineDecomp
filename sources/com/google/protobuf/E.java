package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: IntArrayList.java */
/* loaded from: classes2.dex */
public final class E extends AbstractC1647a<Integer> implements Internal.IntList, RandomAccess {

    /* renamed from: b */
    private static final E f18547b = new E();

    /* renamed from: c */
    private int[] f18548c;

    /* renamed from: d */
    private int f18549d;

    static {
        f18547b.L();
    }

    E() {
        this(new int[10], 0);
    }

    public static E b() {
        return f18547b;
    }

    public int a(int i, int i2) {
        a();
        a(i);
        int[] iArr = this.f18548c;
        int i3 = iArr[i];
        iArr[i] = i2;
        return i3;
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Integer> collection) {
        a();
        if (collection != null) {
            if (!(collection instanceof E)) {
                return super.addAll(collection);
            }
            E e2 = (E) collection;
            int i = e2.f18549d;
            if (i == 0) {
                return false;
            }
            int i2 = this.f18549d;
            if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
                int i3 = i2 + i;
                int[] iArr = this.f18548c;
                if (i3 > iArr.length) {
                    this.f18548c = Arrays.copyOf(iArr, i3);
                }
                System.arraycopy(e2.f18548c, 0, this.f18548c, this.f18549d, e2.f18549d);
                this.f18549d = i3;
                ((AbstractList) this).modCount++;
                return true;
            }
            throw new OutOfMemoryError();
        }
        throw new NullPointerException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof E)) {
            return super.equals(obj);
        }
        E e2 = (E) obj;
        if (this.f18549d != e2.f18549d) {
            return false;
        }
        int[] iArr = e2.f18548c;
        for (int i = 0; i < this.f18549d; i++) {
            if (this.f18548c[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.IntList
    public int getInt(int i) {
        a(i);
        return this.f18548c[i];
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f18549d; i2++) {
            i = (i * 31) + this.f18548c[i2];
        }
        return i;
    }

    @Override // com.google.protobuf.Internal.IntList
    public void i(int i) {
        b(this.f18549d, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18549d;
    }

    private E(int[] iArr, int i) {
        this.f18548c = iArr;
        this.f18549d = i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public Integer set(int i, Integer num) {
        return Integer.valueOf(a(i, num.intValue()));
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer get(int i) {
        return Integer.valueOf(getInt(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
    /* renamed from: h */
    public Internal.ProtobufList<Integer> h2(int i) {
        if (i >= this.f18549d) {
            return new E(Arrays.copyOf(this.f18548c, i), this.f18549d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f18549d; i++) {
            if (obj.equals(Integer.valueOf(this.f18548c[i]))) {
                int[] iArr = this.f18548c;
                System.arraycopy(iArr, i + 1, iArr, i, this.f18549d - i);
                this.f18549d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i, int i2) {
        int i3;
        a();
        if (i >= 0 && i <= (i3 = this.f18549d)) {
            int[] iArr = this.f18548c;
            if (i3 < iArr.length) {
                System.arraycopy(iArr, i, iArr, i + 1, i3 - i);
            } else {
                int[] iArr2 = new int[((i3 * 3) / 2) + 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(this.f18548c, i, iArr2, i + 1, this.f18549d - i);
                this.f18548c = iArr2;
            }
            this.f18548c[i] = i2;
            this.f18549d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i, Integer num) {
        b(i, num.intValue());
    }

    private void a(int i) {
        if (i < 0 || i >= this.f18549d) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Integer remove(int i) {
        a();
        a(i);
        int[] iArr = this.f18548c;
        int i2 = iArr[i];
        System.arraycopy(iArr, i + 1, iArr, i, this.f18549d - i);
        this.f18549d--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i2);
    }

    private String b(int i) {
        return "Index:" + i + ", Size:" + this.f18549d;
    }
}
