package com.nexstreaming.app.general.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: NonZeroIntSet.java */
/* loaded from: classes2.dex */
public class z implements Set<Integer> {

    /* renamed from: a */
    private int[] f19909a = new int[8];

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        Iterator<? extends Integer> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= a(it.next().intValue());
        }
        return z;
    }

    public boolean b(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f19909a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f19909a[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public boolean c(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f19909a.length;
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr = this.f19909a;
            if (iArr[i2] == i) {
                iArr[i2] = 0;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        int length = this.f19909a.length;
        for (int i = 0; i < length; i++) {
            this.f19909a[i] = 0;
        }
    }

    @Override // java.util.Set, java.util.Collection
    public boolean contains(Object obj) {
        if (obj instanceof Integer) {
            return b(((Integer) obj).intValue());
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean isEmpty() {
        int length = this.f19909a.length;
        for (int i = 0; i < length; i++) {
            if (this.f19909a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Integer> iterator() {
        int length = this.f19909a.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (this.f19909a[i] != 0) {
                break;
            }
            i++;
        }
        return new y(this, i);
    }

    @Override // java.util.Set, java.util.Collection
    public boolean remove(Object obj) {
        if (obj instanceof Integer) {
            return c(((Integer) obj).intValue());
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            z |= remove(it.next());
        }
        return z;
    }

    @Override // java.util.Set, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Set, java.util.Collection
    public int size() {
        int length = this.f19909a.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f19909a[i2] != 0) {
                i++;
            }
        }
        return i;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        int size = size();
        int length = this.f19909a.length;
        Integer[] numArr = new Integer[size];
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            int[] iArr = this.f19909a;
            if (iArr[i2] != 0) {
                numArr[i] = Integer.valueOf(iArr[i2]);
                i++;
            }
        }
        return numArr;
    }

    public boolean a(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f19909a.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            int[] iArr = this.f19909a;
            if (iArr[i3] == i) {
                return false;
            }
            if (iArr[i3] == 0 && i2 < 0) {
                i2 = i3;
            }
        }
        if (i2 < 0) {
            int length2 = this.f19909a.length;
            if (length2 < 0) {
                length2 = 1;
            }
            if (length2 > 4096) {
                length2 = 4096;
            }
            int[] iArr2 = this.f19909a;
            int[] iArr3 = new int[iArr2.length + length2];
            System.arraycopy(iArr2, 0, iArr3, 0, iArr2.length);
            iArr3[this.f19909a.length] = i;
            this.f19909a = iArr3;
        } else {
            this.f19909a[i2] = i;
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr instanceof Integer[]) {
            return (T[]) toArray();
        }
        throw new ClassCastException();
    }

    @Override // java.util.Set, java.util.Collection
    /* renamed from: a */
    public boolean add(Integer num) {
        return a(num.intValue());
    }
}
