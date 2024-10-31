package com.google.common.eventbus;

import com.google.common.cache.CacheLoader;
import com.google.common.reflect.TypeToken;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: EventBus.java */
/* loaded from: classes2.dex */
public class e extends CacheLoader<Class<?>, Set<Class<?>>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ EventBus f2900a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(EventBus eventBus) {
        this.f2900a = eventBus;
    }

    @Override // com.google.common.cache.CacheLoader
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Set<Class<?>> load(Class<?> cls) throws Exception {
        return TypeToken.of((Class) cls).getTypes().rawTypes();
    }
}
