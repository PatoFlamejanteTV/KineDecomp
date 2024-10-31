package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.TypeToken;
import java.util.Collection;

/* compiled from: SubscriberRegistry.java */
/* loaded from: classes2.dex */
class f extends CacheLoader<Class<?>, ImmutableSet<Class<?>>> {
    @Override // com.google.common.cache.CacheLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImmutableSet<Class<?>> load(Class<?> cls) {
        return ImmutableSet.copyOf((Collection) TypeToken.of((Class) cls).getTypes().rawTypes());
    }
}
