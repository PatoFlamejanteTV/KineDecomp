package com.google.protobuf;

import android.support.v7.widget.ActivityChooserView;
import com.google.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: LongArrayList.java */
/* loaded from: classes2.dex */
public final class H extends AbstractC1647a<Long> implements Internal.LongList, RandomAccess {

    /* renamed from: b */
    private static final H f18607b = new H();

    /* renamed from: c */
    private long[] f18608c;

    /* renamed from: d */
    private int f18609d;

    static {
        f18607b.L();
    }

    H() {
        this(new long[10], 0);
    }

    public static H b() {
        return f18607b;
    }

    public long a(int i, long j) {
        a();
        a(i);
        long[] jArr = this.f18608c;
        long j2 = jArr[i];
        jArr[i] = j;
        return j2;
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends Long> collection) {
        a();
        if (collection != null) {
            if (!(collection instanceof H)) {
                return super.addAll(collection);
            }
            H h2 = (H) collection;
            int i = h2.f18609d;
            if (i == 0) {
                return false;
            }
            int i2 = this.f18609d;
            if (ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED - i2 >= i) {
                int i3 = i2 + i;
                long[] jArr = this.f18608c;
                if (i3 > jArr.length) {
                    this.f18608c = Arrays.copyOf(jArr, i3);
                }
                System.arraycopy(h2.f18608c, 0, this.f18608c, this.f18609d, h2.f18609d);
                this.f18609d = i3;
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
        if (!(obj instanceof H)) {
            return super.equals(obj);
        }
        H h2 = (H) obj;
        if (this.f18609d != h2.f18609d) {
            return false;
        }
        long[] jArr = h2.f18608c;
        for (int i = 0; i < this.f18609d; i++) {
            if (this.f18608c[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.protobuf.Internal.LongList
    public void g(long j) {
        b(this.f18609d, j);
    }

    @Override // com.google.protobuf.Internal.LongList
    public long getLong(int i) {
        a(i);
        return this.f18608c[i];
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.f18609d; i2++) {
            i = (i * 31) + Internal.a(this.f18608c[i2]);
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f18609d;
    }

    private H(long[] jArr, int i) {
        this.f18608c = jArr;
        this.f18609d = i;
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: b */
    public Long set(int i, Long l) {
        return Long.valueOf(a(i, l.longValue()));
    }

    @Override // java.util.AbstractList, java.util.List
    public Long get(int i) {
        return Long.valueOf(getLong(i));
    }

    @Override // com.google.protobuf.Internal.ProtobufList, com.google.protobuf.Internal.IntList
    /* renamed from: h */
    public Internal.ProtobufList<Long> h2(int i) {
        if (i >= this.f18609d) {
            return new H(Arrays.copyOf(this.f18608c, i), this.f18609d);
        }
        throw new IllegalArgumentException();
    }

    @Override // com.google.protobuf.AbstractC1647a, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        a();
        for (int i = 0; i < this.f18609d; i++) {
            if (obj.equals(Long.valueOf(this.f18608c[i]))) {
                long[] jArr = this.f18608c;
                System.arraycopy(jArr, i + 1, jArr, i, this.f18609d - i);
                this.f18609d--;
                ((AbstractList) this).modCount++;
                return true;
            }
        }
        return false;
    }

    private void b(int i, long j) {
        int i2;
        a();
        if (i >= 0 && i <= (i2 = this.f18609d)) {
            long[] jArr = this.f18608c;
            if (i2 < jArr.length) {
                System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
            } else {
                long[] jArr2 = new long[((i2 * 3) / 2) + 1];
                System.arraycopy(jArr, 0, jArr2, 0, i);
                System.arraycopy(this.f18608c, i, jArr2, i + 1, this.f18609d - i);
                this.f18608c = jArr2;
            }
            this.f18608c[i] = j;
            this.f18609d++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(b(i));
    }

    @Override // java.util.AbstractList, java.util.List
    /* renamed from: a */
    public void add(int i, Long l) {
        b(i, l.longValue());
    }

    private void a(int i) {
        if (i < 0 || i >= this.f18609d) {
            throw new IndexOutOfBoundsException(b(i));
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public Long remove(int i) {
        a();
        a(i);
        long[] jArr = this.f18608c;
        long j = jArr[i];
        System.arraycopy(jArr, i + 1, jArr, i, this.f18609d - i);
        this.f18609d--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j);
    }

    private String b(int i) {
        return "Index:" + i + ", Size:" + this.f18609d;
    }
}
