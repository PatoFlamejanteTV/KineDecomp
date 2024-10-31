package com.google.android.gms.internal.measurement;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* renamed from: com.google.android.gms.internal.measurement.aa */
/* loaded from: classes2.dex */
abstract class AbstractC1346aa<E> extends AbstractList<E> implements zzuu<E> {
    private boolean zzbtl = true;

    @Override // java.util.AbstractList, java.util.List
    public abstract void add(int i, E e2);

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(E e2) {
        zzua();
        return super.add(e2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection<? extends E> collection) {
        zzua();
        return super.addAll(collection);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        zzua();
        super.clear();
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E remove(int i);

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean remove(Object obj) {
        zzua();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(Collection<?> collection) {
        zzua();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean retainAll(Collection<?> collection) {
        zzua();
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractList, java.util.List
    public abstract E set(int i, E e2);

    @Override // com.google.android.gms.internal.measurement.zzuu
    public final void zzsw() {
        this.zzbtl = false;
    }

    @Override // com.google.android.gms.internal.measurement.zzuu
    public boolean zztz() {
        return this.zzbtl;
    }

    public final void zzua() {
        if (!this.zzbtl) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzua();
        return super.addAll(i, collection);
    }
}