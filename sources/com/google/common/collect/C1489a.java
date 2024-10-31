package com.google.common.collect;

import com.google.common.collect.AbstractBiMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AbstractBiMap.java */
/* renamed from: com.google.common.collect.a */
/* loaded from: classes2.dex */
public class C1489a<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a */
    Map.Entry<K, V> f15761a;

    /* renamed from: b */
    final /* synthetic */ Iterator f15762b;

    /* renamed from: c */
    final /* synthetic */ AbstractBiMap f15763c;

    public C1489a(AbstractBiMap abstractBiMap, Iterator it) {
        this.f15763c = abstractBiMap;
        this.f15762b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15762b.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        C1555x.a(this.f15761a != null);
        V value = this.f15761a.getValue();
        this.f15762b.remove();
        this.f15763c.b(value);
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        this.f15761a = (Map.Entry) this.f15762b.next();
        return new AbstractBiMap.a(this.f15761a);
    }
}
