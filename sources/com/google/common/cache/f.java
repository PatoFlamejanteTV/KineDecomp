package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class f<K, V> extends LocalCache.AbstractC1487b<K, V> {

    /* renamed from: a, reason: collision with root package name */
    LocalCache.j<K, V> f15253a = this;

    /* renamed from: b, reason: collision with root package name */
    LocalCache.j<K, V> f15254b = this;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ LocalCache.C1488c f15255c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocalCache.C1488c c1488c) {
        this.f15255c = c1488c;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public long getAccessTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public LocalCache.j<K, V> getNextInAccessQueue() {
        return this.f15253a;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public LocalCache.j<K, V> getPreviousInAccessQueue() {
        return this.f15254b;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setAccessTime(long j) {
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setNextInAccessQueue(LocalCache.j<K, V> jVar) {
        this.f15253a = jVar;
    }

    @Override // com.google.common.cache.LocalCache.AbstractC1487b, com.google.common.cache.LocalCache.j
    public void setPreviousInAccessQueue(LocalCache.j<K, V> jVar) {
        this.f15254b = jVar;
    }
}
