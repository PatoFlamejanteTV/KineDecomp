package com.google.common.eventbus;

import com.google.common.annotations.Beta;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Multimaps;
import com.google.common.collect.SetMultimap;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

@Beta
/* loaded from: classes2.dex */
public class EventBus {

    /* renamed from: a, reason: collision with root package name */
    private final SetMultimap<Class<?>, Object> f2896a;
    private final Logger b;
    private final f c;
    private final ThreadLocal<ConcurrentLinkedQueue<Object>> d;
    private final ThreadLocal<Boolean> e;
    private final LoadingCache<Class<?>, Set<Class<?>>> f;

    public EventBus() {
        this("default");
    }

    public EventBus(String str) {
        this.f2896a = Multimaps.a(new ConcurrentHashMap(), new b(this));
        this.c = new a();
        this.d = new c(this);
        this.e = new d(this);
        this.f = CacheBuilder.a().h().a(new e(this));
        this.b = Logger.getLogger(EventBus.class.getName() + "." + str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set<Object> a() {
        return new CopyOnWriteArraySet();
    }
}
