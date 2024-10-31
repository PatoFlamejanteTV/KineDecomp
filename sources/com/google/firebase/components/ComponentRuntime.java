package com.google.firebase.components;

import com.google.android.gms.common.internal.Preconditions;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
public class ComponentRuntime extends a {

    /* renamed from: a, reason: collision with root package name */
    private final List<Component<?>> f16575a;

    /* renamed from: b, reason: collision with root package name */
    private final Map<Class<?>, i<?>> f16576b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    private final g f16577c;

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this.f16577c = new g(executor);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.a(this.f16577c, g.class, Subscriber.class, Publisher.class));
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getComponents());
        }
        Collections.addAll(arrayList, componentArr);
        this.f16575a = Collections.unmodifiableList(e.a(arrayList));
        Iterator<Component<?>> it2 = this.f16575a.iterator();
        while (it2.hasNext()) {
            a(it2.next());
        }
        a();
    }

    @Override // com.google.firebase.components.a, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object a(Class cls) {
        return super.a(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Provider<T> b(Class<T> cls) {
        Preconditions.a(cls, "Null interface requested.");
        return this.f16576b.get(cls);
    }

    public void a(boolean z) {
        for (Component<?> component : this.f16575a) {
            if (component.e() || (component.f() && z)) {
                a(component.c().iterator().next());
            }
        }
        this.f16577c.a();
    }

    private <T> void a(Component<T> component) {
        i<?> iVar = new i<>(component.b(), new j(component, this));
        Iterator<Class<? super T>> it = component.c().iterator();
        while (it.hasNext()) {
            this.f16576b.put(it.next(), iVar);
        }
    }

    private void a() {
        for (Component<?> component : this.f16575a) {
            for (Dependency dependency : component.a()) {
                if (dependency.c() && !this.f16576b.containsKey(dependency.a())) {
                    throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.a()));
                }
            }
        }
    }
}
