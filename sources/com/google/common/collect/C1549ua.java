package com.google.common.collect;

import com.google.common.collect.LinkedHashMultimap;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: LinkedHashMultimap.java */
/* renamed from: com.google.common.collect.ua */
/* loaded from: classes2.dex */
class C1549ua<V> implements Iterator<V> {

    /* renamed from: a */
    LinkedHashMultimap.b<K, V> f15850a;

    /* renamed from: b */
    LinkedHashMultimap.ValueEntry<K, V> f15851b;

    /* renamed from: c */
    int f15852c;

    /* renamed from: d */
    final /* synthetic */ LinkedHashMultimap.a f15853d;

    public C1549ua(LinkedHashMultimap.a aVar) {
        LinkedHashMultimap.b<K, V> bVar;
        int i;
        this.f15853d = aVar;
        bVar = this.f15853d.f15499e;
        this.f15850a = bVar;
        i = this.f15853d.f15498d;
        this.f15852c = i;
    }

    private void b() {
        int i;
        i = this.f15853d.f15498d;
        if (i != this.f15852c) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        b();
        return this.f15850a != this.f15853d;
    }

    @Override // java.util.Iterator
    public V next() {
        if (hasNext()) {
            LinkedHashMultimap.ValueEntry<K, V> valueEntry = (LinkedHashMultimap.ValueEntry) this.f15850a;
            V value = valueEntry.getValue();
            this.f15851b = valueEntry;
            this.f15850a = valueEntry.getSuccessorInValueSet();
            return value;
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.Iterator
    public void remove() {
        int i;
        b();
        C1555x.a(this.f15851b != null);
        this.f15853d.remove(this.f15851b.getValue());
        i = this.f15853d.f15498d;
        this.f15852c = i;
        this.f15851b = null;
    }
}
