package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class l<K, V> extends AbstractSequentialIterator<LocalCache.j<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LocalCache.B f15268b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(LocalCache.B b2, LocalCache.j jVar) {
        super(jVar);
        this.f15268b = b2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public LocalCache.j<K, V> a(LocalCache.j<K, V> jVar) {
        LocalCache.j<K, V> nextInWriteQueue = jVar.getNextInWriteQueue();
        if (nextInWriteQueue == this.f15268b.f15191a) {
            return null;
        }
        return nextInWriteQueue;
    }
}
