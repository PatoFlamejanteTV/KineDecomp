package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.AbstractCache;

/* compiled from: CacheBuilder.java */
/* loaded from: classes2.dex */
class b implements Supplier<AbstractCache.StatsCounter> {
    @Override // com.google.common.base.Supplier
    public AbstractCache.StatsCounter get() {
        return new AbstractCache.SimpleStatsCounter();
    }
}
