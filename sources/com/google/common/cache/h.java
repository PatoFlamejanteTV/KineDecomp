package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.util.concurrent.Callable;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
class h<V> extends CacheLoader<Object, V> {

    /* renamed from: a */
    final /* synthetic */ Callable f2629a;
    final /* synthetic */ LocalCache.LocalManualCache b;

    public h(LocalCache.LocalManualCache localManualCache, Callable callable) {
        this.b = localManualCache;
        this.f2629a = callable;
    }

    @Override // com.google.common.cache.CacheLoader
    public V load(Object obj) throws Exception {
        return (V) this.f2629a.call();
    }
}
