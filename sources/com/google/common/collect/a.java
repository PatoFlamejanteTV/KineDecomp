package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.AbstractBiMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: AbstractBiMap.java */
/* loaded from: classes2.dex */
class a<K, V> implements Iterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    Map.Entry<K, V> f2786a;
    final /* synthetic */ Iterator b;
    final /* synthetic */ AbstractBiMap.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(AbstractBiMap.a aVar, Iterator it) {
        this.c = aVar;
        this.b = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.b.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        this.f2786a = (Map.Entry) this.b.next();
        return new b(this, this.f2786a);
    }

    @Override // java.util.Iterator
    public void remove() {
        Preconditions.b(this.f2786a != null);
        V value = this.f2786a.getValue();
        this.b.remove();
        AbstractBiMap.this.b(value);
    }
}
