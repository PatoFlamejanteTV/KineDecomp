package com.google.common.cache;

import com.google.common.collect.ImmutableSet;
import java.util.AbstractQueue;
import java.util.Iterator;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class e extends AbstractQueue<Object> {
    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Object> iterator() {
        return ImmutableSet.of().iterator();
    }

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
}