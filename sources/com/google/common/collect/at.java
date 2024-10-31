package com.google.common.collect;

import com.google.common.collect.LinkedHashMultimap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedHashMultimap.java */
/* loaded from: classes2.dex */
class at<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    LinkedHashMultimap.a<K, V> f2803a;
    LinkedHashMultimap.a<K, V> b;
    final /* synthetic */ LinkedHashMultimap c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(LinkedHashMultimap linkedHashMultimap) {
        this.c = linkedHashMultimap;
        this.f2803a = this.c.f2709a.h;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2803a != this.c.f2709a;
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        LinkedHashMultimap.a<K, V> aVar = this.f2803a;
        this.b = aVar;
        this.f2803a = this.f2803a.h;
        return aVar;
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterators.a(this.b != null);
        this.c.remove(this.b.getKey(), this.b.getValue());
        this.b = null;
    }
}
