package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: MapConstraints.java */
/* loaded from: classes2.dex */
class bk<K, V> extends ForwardingIterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f2821a;
    final /* synthetic */ MapConstraints.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(MapConstraints.a aVar, Iterator it) {
        this.b = aVar;
        this.f2821a = it;
    }

    @Override // com.google.common.collect.ForwardingIterator, java.util.Iterator
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> next() {
        Map.Entry<K, V> b;
        b = MapConstraints.b((Map.Entry) this.f2821a.next(), this.b.f2718a);
        return b;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    /* renamed from: a */
    public Iterator<Map.Entry<K, V>> delegate() {
        return this.f2821a;
    }
}
