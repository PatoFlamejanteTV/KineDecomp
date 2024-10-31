package com.nexstreaming.app.general.util;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* compiled from: NonZeroIntSet.java */
/* loaded from: classes.dex */
public class q implements Set<Integer> {

    /* renamed from: a, reason: collision with root package name */
    private int[] f3236a = new int[8];

    public boolean a(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f3236a.length;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f3236a[i3] == i) {
                return false;
            }
            if (this.f3236a[i3] == 0 && i2 < 0) {
                i2 = i3;
            }
        }
        if (i2 < 0) {
            int length2 = this.f3236a.length;
            if (length2 < 0) {
                length2 = 1;
            }
            if (length2 > 4096) {
                length2 = 4096;
            }
            int[] iArr = new int[length2 + this.f3236a.length];
            System.arraycopy(this.f3236a, 0, iArr, 0, this.f3236a.length);
            iArr[this.f3236a.length] = i;
            this.f3236a = iArr;
        } else {
            this.f3236a[i2] = i;
        }
        return true;
    }

    public boolean b(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f3236a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f3236a[i2] == i) {
                return true;
            }
        }
        return false;
    }

    public boolean c(int i) {
        if (i == 0) {
            return false;
        }
        int length = this.f3236a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f3236a[i2] == i) {
                this.f3236a[i2] = 0;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Set, java.util.Collection
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        return a(num.intValue());
    }

    @Override // java.util.Set, java.util.Collection
    public boolean addAll(Collection<? extends Integer> collection) {
        boolean z = false;
        Iterator<? extends Integer> it = collection.iterator();
        while (true) {
            boolean z2 = z;
            if (it.hasNext()) {
                z = a(it.next().intValue()) | z2;
            } else {
                return z2;
            }
        }
    }

    @Override // java.util.Set, java.util.Collection
    public void clear() {
        int length = this.f3236a.length;
        for (int i = 0; i < length; i++) {
            this.f3236a[i] = 0;
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
        int length = this.f3236a.length;
        for (int i = 0; i < length; i++) {
            if (this.f3236a[i] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.Set, java.util.Collection, java.lang.Iterable
    public Iterator<Integer> iterator() {
        int length = this.f3236a.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            if (this.f3236a[i] != 0) {
                break;
            }
            i++;
        }
        return new r(this, i);
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
        boolean z = false;
        Iterator<?> it = collection.iterator();
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
        int i = 0;
        int length = this.f3236a.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (this.f3236a[i2] != 0) {
                i++;
            }
        }
        return i;
    }

    @Override // java.util.Set, java.util.Collection
    public Object[] toArray() {
        int i;
        int i2 = 0;
        int size = size();
        int length = this.f3236a.length;
        Integer[] numArr = new Integer[size];
        int i3 = 0;
        while (i3 < length) {
            if (this.f3236a[i3] != 0) {
                i = i2 + 1;
                numArr[i2] = Integer.valueOf(this.f3236a[i3]);
            } else {
                i = i2;
            }
            i3++;
            i2 = i;
        }
        return numArr;
    }

    @Override // java.util.Set, java.util.Collection
    public <T> T[] toArray(T[] tArr) {
        if (tArr instanceof Integer[]) {
            return (T[]) toArray();
        }
        throw new ClassCastException();
    }
}
