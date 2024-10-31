package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class g<K, V> extends AbstractSequentialIterator<LocalCache.i<K, V>> {

    /* renamed from: a */
    final /* synthetic */ LocalCache.b f2628a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(LocalCache.b bVar, LocalCache.i iVar) {
        super(iVar);
        this.f2628a = bVar;
    }

    @Override // com.google.common.collect.AbstractSequentialIterator
    public LocalCache.i<K, V> a(LocalCache.i<K, V> iVar) {
        LocalCache.i<K, V> nextInAccessQueue = iVar.getNextInAccessQueue();
        if (nextInAccessQueue == this.f2628a.f2606a) {
            return null;
        }
        return nextInAccessQueue;
    }
}
