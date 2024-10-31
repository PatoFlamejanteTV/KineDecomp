package com.google.common.cache;

import com.google.common.cache.LocalCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class f<K, V> extends LocalCache.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    LocalCache.i<K, V> f2627a = this;
    LocalCache.i<K, V> b = this;
    final /* synthetic */ LocalCache.b c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(LocalCache.b bVar) {
        this.c = bVar;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public long getAccessTime() {
        return Long.MAX_VALUE;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setAccessTime(long j) {
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public LocalCache.i<K, V> getNextInAccessQueue() {
        return this.f2627a;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setNextInAccessQueue(LocalCache.i<K, V> iVar) {
        this.f2627a = iVar;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public LocalCache.i<K, V> getPreviousInAccessQueue() {
        return this.b;
    }

    @Override // com.google.common.cache.LocalCache.a, com.google.common.cache.LocalCache.i
    public void setPreviousInAccessQueue(LocalCache.i<K, V> iVar) {
        this.b = iVar;
    }
}
