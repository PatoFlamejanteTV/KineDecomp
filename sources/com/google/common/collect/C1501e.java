package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: AbstractMapBasedMultimap.java */
/* renamed from: com.google.common.collect.e, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1501e<K, V> extends AbstractMapBasedMultimap<K, V>.b<Map.Entry<K, V>> {

    /* renamed from: f, reason: collision with root package name */
    final /* synthetic */ AbstractMapBasedMultimap f15778f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1501e(AbstractMapBasedMultimap abstractMapBasedMultimap) {
        super();
        this.f15778f = abstractMapBasedMultimap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractMapBasedMultimap.b
    /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return a((C1501e<K, V>) obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap.b
    Map.Entry<K, V> a(K k, V v) {
        return Maps.a(k, v);
    }
}
