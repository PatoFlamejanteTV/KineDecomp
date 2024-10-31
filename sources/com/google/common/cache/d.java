package com.google.common.cache;

import com.google.common.cache.LocalCache;
import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public final class d implements LocalCache.q<Object, Object> {
    @Override // com.google.common.cache.LocalCache.q
    public Object get() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.q
    public int a() {
        return 0;
    }

    @Override // com.google.common.cache.LocalCache.q
    public LocalCache.i<Object, Object> b() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.q
    public LocalCache.q<Object, Object> a(ReferenceQueue<Object> referenceQueue, @Nullable Object obj, LocalCache.i<Object, Object> iVar) {
        return this;
    }

    @Override // com.google.common.cache.LocalCache.q
    public boolean c() {
        return false;
    }

    @Override // com.google.common.cache.LocalCache.q
    public boolean d() {
        return false;
    }

    @Override // com.google.common.cache.LocalCache.q
    public Object e() {
        return null;
    }

    @Override // com.google.common.cache.LocalCache.q
    public void a(Object obj) {
    }
}
