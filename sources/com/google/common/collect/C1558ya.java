package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.ListIterator;
import java.util.Map;

/* compiled from: LinkedListMultimap.java */
/* renamed from: com.google.common.collect.ya */
/* loaded from: classes2.dex */
class C1558ya<K, V> extends Cb<Map.Entry<K, V>, V> {

    /* renamed from: b */
    final /* synthetic */ LinkedListMultimap.d f15869b;

    /* renamed from: c */
    final /* synthetic */ C1560za f15870c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1558ya(C1560za c1560za, ListIterator listIterator, LinkedListMultimap.d dVar) {
        super(listIterator);
        this.f15870c = c1560za;
        this.f15869b = dVar;
    }

    @Override // com.google.common.collect.Cb, java.util.ListIterator
    public void set(V v) {
        this.f15869b.a((LinkedListMultimap.d) v);
    }

    @Override // com.google.common.collect.Bb
    public V a(Map.Entry<K, V> entry) {
        return entry.getValue();
    }
}
