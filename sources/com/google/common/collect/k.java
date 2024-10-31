package com.google.common.collect;

import com.google.common.collect.ForwardingNavigableMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: ForwardingNavigableMap.java */
/* loaded from: classes2.dex */
class K<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private Map.Entry<K, V> f15482a = null;

    /* renamed from: b */
    private Map.Entry<K, V> f15483b;

    /* renamed from: c */
    final /* synthetic */ ForwardingNavigableMap.StandardDescendingMap f15484c;

    public K(ForwardingNavigableMap.StandardDescendingMap standardDescendingMap) {
        this.f15484c = standardDescendingMap;
        this.f15483b = this.f15484c.d().lastEntry();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15483b != null;
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15482a != null);
        this.f15484c.d().remove(this.f15482a.getKey());
        this.f15482a = null;
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        if (hasNext()) {
            try {
                return this.f15483b;
            } finally {
                this.f15482a = this.f15483b;
                this.f15483b = this.f15484c.d().lowerEntry(this.f15483b.getKey());
            }
        }
        throw new NoSuchElementException();
    }
}
