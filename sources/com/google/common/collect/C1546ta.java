package com.google.common.collect;

import com.google.common.collect.LinkedHashMultimap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

/* compiled from: LinkedHashMultimap.java */
/* renamed from: com.google.common.collect.ta */
/* loaded from: classes2.dex */
public class C1546ta<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    LinkedHashMultimap.ValueEntry<K, V> f15846a;

    /* renamed from: b */
    LinkedHashMultimap.ValueEntry<K, V> f15847b;

    /* renamed from: c */
    final /* synthetic */ LinkedHashMultimap f15848c;

    public C1546ta(LinkedHashMultimap linkedHashMultimap) {
        this.f15848c = linkedHashMultimap;
        this.f15846a = this.f15848c.f15494h.successorInMultimap;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15846a != this.f15848c.f15494h;
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15847b != null);
        this.f15848c.remove(this.f15847b.getKey(), this.f15847b.getValue());
        this.f15847b = null;
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        if (hasNext()) {
            LinkedHashMultimap.ValueEntry<K, V> valueEntry = this.f15846a;
            this.f15847b = valueEntry;
            this.f15846a = valueEntry.successorInMultimap;
            return valueEntry;
        }
        throw new NoSuchElementException();
    }
}
