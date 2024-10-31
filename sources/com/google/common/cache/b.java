package com.google.common.cache;

import com.google.common.base.Supplier;
import com.google.common.cache.AbstractCache;

/* compiled from: CacheBuilder.java */
/* loaded from: classes2.dex */
final class b implements Supplier<AbstractCache.StatsCounter> {
    @Override // com.google.common.base.Supplier
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public AbstractCache.StatsCounter get() {
        return new AbstractCache.SimpleStatsCounter();
    }
}
