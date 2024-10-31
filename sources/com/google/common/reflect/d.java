package com.google.common.reflect;

import com.google.common.collect.ForwardingSet;
import com.google.common.reflect.MutableTypeToInstanceMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: MutableTypeToInstanceMap.java */
/* loaded from: classes2.dex */
public class d<K, V> extends ForwardingSet<Map.Entry<K, V>> {

    /* renamed from: a */
    final /* synthetic */ Set f16089a;

    public d(Set set) {
        this.f16089a = set;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        Iterator<Map.Entry<K, V>> b2;
        b2 = MutableTypeToInstanceMap.a.b(super.iterator());
        return b2;
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return standardToArray();
    }

    @Override // com.google.common.collect.ForwardingCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) standardToArray(tArr);
    }

    @Override // com.google.common.collect.ForwardingSet, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public Set<Map.Entry<K, V>> delegate() {
        return this.f16089a;
    }
}
