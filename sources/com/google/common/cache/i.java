package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.concurrent.Callable;

/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class i<V> extends CacheLoader<Object, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Callable f15258a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ LocalCache.LocalManualCache f15259b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(LocalCache.LocalManualCache localManualCache, Callable callable) {
        this.f15259b = localManualCache;
        this.f15258a = callable;
    }

    @Override // com.google.common.cache.CacheLoader
    public V load(Object obj) throws Exception {
        return (V) this.f15258a.call();
    }
}
