package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes2.dex */
public class zzbwe<E> extends AbstractList<E> {
    private static final zzbwg zzco = zzbwg.zzk(zzbwe.class);
    List<E> zzgct;
    Iterator<E> zzgcu;

    public zzbwe(List<E> list, Iterator<E> it) {
        this.zzgct = list;
        this.zzgcu = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.zzgct.size() > i) {
            return this.zzgct.get(i);
        }
        if (this.zzgcu.hasNext()) {
            this.zzgct.add(this.zzgcu.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new C0974kj(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        zzco.zzge("potentially expensive size() call");
        zzco.zzge("blowup running");
        while (this.zzgcu.hasNext()) {
            this.zzgct.add(this.zzgcu.next());
        }
        return this.zzgct.size();
    }
}
