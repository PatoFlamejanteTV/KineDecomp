package com.google.common.eventbus;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.annotation.Nullable;

/* compiled from: SubscriberRegistry.java */
/* loaded from: classes2.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private static final LoadingCache<Class<?>, ImmutableList<Method>> f15910a = CacheBuilder.o().p().a(new e());

    /* renamed from: b, reason: collision with root package name */
    private static final LoadingCache<Class<?>, ImmutableSet<Class<?>>> f15911b = CacheBuilder.o().p().a(new f());

    /* renamed from: c, reason: collision with root package name */
    private final ConcurrentMap<Class<?>, CopyOnWriteArraySet<Object>> f15912c = Maps.b();

    /* renamed from: d, reason: collision with root package name */
    @Weak
    private final EventBus f15913d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubscriberRegistry.java */
    /* loaded from: classes2.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        private final String f15914a;

        /* renamed from: b, reason: collision with root package name */
        private final List<Class<?>> f15915b;

        a(Method method) {
            this.f15914a = method.getName();
            this.f15915b = Arrays.asList(method.getParameterTypes());
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return this.f15914a.equals(aVar.f15914a) && this.f15915b.equals(aVar.f15915b);
        }

        public int hashCode() {
            return Objects.a(this.f15914a, this.f15915b);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(EventBus eventBus) {
        Preconditions.a(eventBus);
        this.f15913d = eventBus;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableList<Method> b(Class<?> cls) {
        Set rawTypes = TypeToken.of((Class) cls).getTypes().rawTypes();
        HashMap c2 = Maps.c();
        Iterator it = rawTypes.iterator();
        while (it.hasNext()) {
            for (Method method : ((Class) it.next()).getDeclaredMethods()) {
                if (method.isAnnotationPresent(Subscribe.class) && !method.isSynthetic()) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    Preconditions.a(parameterTypes.length == 1, "Method %s has @Subscribe annotation but has %s parameters.Subscriber methods must have exactly 1 parameter.", method, parameterTypes.length);
                    a aVar = new a(method);
                    if (!c2.containsKey(aVar)) {
                        c2.put(aVar, method);
                    }
                }
            }
        }
        return ImmutableList.copyOf(c2.values());
    }
}
