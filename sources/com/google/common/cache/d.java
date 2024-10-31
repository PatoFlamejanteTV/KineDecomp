package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class d implements LocalCache.r<Object, Object> {
    @Override // com.google.common.cache.LocalCache.r
    public LocalCache.j<Object, Object> a() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.r
    public LocalCache.r<Object, Object> a(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, LocalCache.j<Object, Object> jVar) {
        return this;
    }

    @Override // com.google.common.cache.LocalCache.r
    public void a(Object obj) {
    }

    @Override // com.google.common.cache.LocalCache.r
    public int b() {
        return 0;
    }

    @Override // com.google.common.cache.LocalCache.r
    public Object c() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.r
    public Object get() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.r
    public boolean isActive() {
        return false;
    }

    @Override // com.google.common.cache.LocalCache.r
    public boolean isLoading() {
        return false;
    }
}
