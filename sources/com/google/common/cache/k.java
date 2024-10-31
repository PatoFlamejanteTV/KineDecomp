package com.google.common.cache;

import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class k<K, V> extends AbstractSequentialIterator<LocalCache.i<K, V>> {

    /* renamed from: a */
    final /* synthetic */ LocalCache.aa f2632a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(LocalCache.aa aaVar, LocalCache.i iVar) {
        super(iVar);
        this.f2632a = aaVar;
    }

    @Override // com.google.common.collect.AbstractSequentialIterator
    public LocalCache.i<K, V> a(LocalCache.i<K, V> iVar) {
        LocalCache.i<K, V> nextInWriteQueue = iVar.getNextInWriteQueue();
        if (nextInWriteQueue == this.f2632a.f2604a) {
            return null;
        }
        return nextInWriteQueue;
    }
}
