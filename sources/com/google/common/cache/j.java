package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class j<K, V> extends LocalCache.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    LocalCache.i<K, V> f2631a = this;
    LocalCache.i<K, V> b = this;
    final /* synthetic */ LocalCache.aa c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(LocalCache.aa aaVar) {
        this.c = aaVar;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public long getWriteTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setWriteTime(long j) {
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public LocalCache.i<K, V> getNextInWriteQueue() {
        return this.f2631a;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setNextInWriteQueue(LocalCache.i<K, V> iVar) {
        this.f2631a = iVar;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public LocalCache.i<K, V> getPreviousInWriteQueue() {
        return this.b;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setPreviousInWriteQueue(LocalCache.i<K, V> iVar) {
        this.b = iVar;
    }
}
