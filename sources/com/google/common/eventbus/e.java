package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.collect.ImmutableList;
import java.lang.reflect.Method;

/* compiled from: SubscriberRegistry.java */
/* loaded from: classes2.dex */
class e extends CacheLoader<Class<?>, ImmutableList<Method>> {
    @Override // com.google.common.cache.CacheLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ImmutableList<Method> load(Class<?> cls) throws Exception {
        ImmutableList<Method> b2;
        b2 = g.b(cls);
        return b2;
    }
}
