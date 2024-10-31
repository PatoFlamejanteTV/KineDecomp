package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.inject.Provider;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
final class j extends com.google.firebase.components.a {

    /* renamed from: a */
    private final Set<Class<?>> f16595a;

    /* renamed from: b */
    private final Set<Class<?>> f16596b;

    /* renamed from: c */
    private final Set<Class<?>> f16597c;

    /* renamed from: d */
    private final ComponentContainer f16598d;

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    /* loaded from: classes2.dex */
    private static class a implements Publisher {

        /* renamed from: a */
        private final Set<Class<?>> f16599a;

        /* renamed from: b */
        private final Publisher f16600b;

        public a(Set<Class<?>> set, Publisher publisher) {
            this.f16599a = set;
            this.f16600b = publisher;
        }
    }

    public j(Component<?> component, ComponentContainer componentContainer) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Dependency dependency : component.a()) {
            if (dependency.b()) {
                hashSet.add(dependency.a());
            } else {
                hashSet2.add(dependency.a());
            }
        }
        if (!component.d().isEmpty()) {
            hashSet.add(Publisher.class);
        }
        this.f16595a = Collections.unmodifiableSet(hashSet);
        this.f16596b = Collections.unmodifiableSet(hashSet2);
        this.f16597c = component.d();
        this.f16598d = componentContainer;
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.ComponentContainer
    public <T> T a(Class<T> cls) {
        if (this.f16595a.contains(cls)) {
            T t = (T) this.f16598d.a(cls);
            return !cls.equals(Publisher.class) ? t : (T) new a(this.f16597c, (Publisher) t);
        }
        throw new IllegalArgumentException(String.format("Requesting %s is not allowed.", cls));
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> b(Class<T> cls) {
        if (this.f16596b.contains(cls)) {
            return this.f16598d.b(cls);
        }
        throw new IllegalArgumentException(String.format("Requesting Provider<%s> is not allowed.", cls));
    }
}
