package com.google.common.collect;

import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: ImmutableMap.java */
/* loaded from: classes2.dex */
public class Y<K, V> extends UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>> {

    /* renamed from: a */
    final /* synthetic */ Iterator f15755a;

    /* renamed from: b */
    final /* synthetic */ ImmutableMap.MapViewOfValuesAsSingletonSets f15756b;

    public Y(ImmutableMap.MapViewOfValuesAsSingletonSets mapViewOfValuesAsSingletonSets, Iterator it) {
        this.f15756b = mapViewOfValuesAsSingletonSets;
        this.f15755a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15755a.hasNext();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, ImmutableSet<V>> next() {
        return new X(this, (Map.Entry) this.f15755a.next());
    }
}
