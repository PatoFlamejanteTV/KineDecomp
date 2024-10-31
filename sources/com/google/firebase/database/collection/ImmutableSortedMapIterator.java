package com.google.firebase.database.collection;

import java.util.AbstractMap;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: com.google.firebase:firebase-database-collection@@16.0.1 */
/* loaded from: classes2.dex */
public class ImmutableSortedMapIterator<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    private final ArrayDeque<LLRBValueNode<K, V>> f16694a = new ArrayDeque<>();

    /* renamed from: b */
    private final boolean f16695b;

    public ImmutableSortedMapIterator(LLRBNode<K, V> lLRBNode, K k, Comparator<K> comparator, boolean z) {
        int i;
        this.f16695b = z;
        while (!lLRBNode.isEmpty()) {
            if (k == null) {
                i = 1;
            } else if (z) {
                i = comparator.compare(k, lLRBNode.getKey());
            } else {
                i = comparator.compare(lLRBNode.getKey(), k);
            }
            if (i < 0) {
                if (z) {
                    lLRBNode = lLRBNode.a();
                } else {
                    lLRBNode = lLRBNode.c();
                }
            } else {
                if (i == 0) {
                    this.f16694a.push((LLRBValueNode) lLRBNode);
                    return;
                }
                this.f16694a.push((LLRBValueNode) lLRBNode);
                if (z) {
                    lLRBNode = lLRBNode.c();
                } else {
                    lLRBNode = lLRBNode.a();
                }
            }
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f16694a.size() > 0;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove called on immutable collection");
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        try {
            LLRBValueNode<K, V> pop = this.f16694a.pop();
            AbstractMap.SimpleEntry simpleEntry = new AbstractMap.SimpleEntry(pop.getKey(), pop.getValue());
            if (this.f16695b) {
                for (LLRBNode<K, V> a2 = pop.a(); !a2.isEmpty(); a2 = a2.c()) {
                    this.f16694a.push((LLRBValueNode) a2);
                }
            } else {
                for (LLRBNode<K, V> c2 = pop.c(); !c2.isEmpty(); c2 = c2.a()) {
                    this.f16694a.push((LLRBValueNode) c2);
                }
            }
            return simpleEntry;
        } catch (EmptyStackException unused) {
            throw new NoSuchElementException();
        }
    }
}
