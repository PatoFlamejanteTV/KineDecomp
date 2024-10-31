package com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

/* compiled from: MapMakerInternalMap.java */
/* loaded from: classes2.dex */
final class bm extends AbstractQueue<Object> {
    @Override // java.util.Queue
    public boolean offer(Object obj) {
        return true;
    }

    @Override // java.util.Queue
    public Object peek() {
        return null;
    }

    @Override // java.util.Queue
    public Object poll() {
        return null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return Iterators.a();
    }
}
