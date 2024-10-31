package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class k<K, V> extends LocalCache.AbstractC1487b<K, V> {

    /* renamed from: a, reason: collision with root package name */
    LocalCache.j<K, V> f15265a = this;

    /* renamed from: b, reason: collision with root package name */
    LocalCache.j<K, V> f15266b = this;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocalCache.B f15267c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(LocalCache.B b2) {
        this.f15267c = b2;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public LocalCache.j<K, V> getNextInWriteQueue() {
        return this.f15265a;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public LocalCache.j<K, V> getPreviousInWriteQueue() {
        return this.f15266b;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public long getWriteTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setNextInWriteQueue(LocalCache.j<K, V> jVar) {
        this.f15265a = jVar;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setPreviousInWriteQueue(LocalCache.j<K, V> jVar) {
        this.f15266b = jVar;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setWriteTime(long j) {
    }
}
