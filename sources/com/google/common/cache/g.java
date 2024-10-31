package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class g<K, V> extends AbstractSequentialIterator<LocalCache.j<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LocalCache.C1488c f15256b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LocalCache.C1488c c1488c, LocalCache.j jVar) {
        super(jVar);
        this.f15256b = c1488c;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractSequentialIterator
    public LocalCache.j<K, V> a(LocalCache.j<K, V> jVar) {
        LocalCache.j<K, V> nextInAccessQueue = jVar.getNextInAccessQueue();
        if (nextInAccessQueue == this.f15256b.f15197a) {
            return null;
        }
        return nextInAccessQueue;
    }
}
