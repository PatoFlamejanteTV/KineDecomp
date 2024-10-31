package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
class bd<K, V> extends dk<K, Map.Entry<K, Collection<V>>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bc f2814a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bd(bc bcVar, Iterator it) {
        super(it);
        this.f2814a = bcVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, Collection<V>> a(K k) {
        return new be(this, k);
    }
}
