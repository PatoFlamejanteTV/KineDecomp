package com.google.firebase.components;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* compiled from: com.google.firebase:firebase-common@@16.0.4 */
/* loaded from: classes2.dex */
class e {

    /* compiled from: com.google.firebase:firebase-common@@16.0.4 */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a */
        private final Component<?> f16582a;

        /* renamed from: b */
        private final Set<a> f16583b = new HashSet();

        /* renamed from: c */
        private final Set<a> f16584c = new HashSet();

        a(Component<?> component) {
            this.f16582a = component;
        }

        void a(a aVar) {
            this.f16583b.add(aVar);
        }

        void b(a aVar) {
            this.f16584c.add(aVar);
        }

        void c(a aVar) {
            this.f16584c.remove(aVar);
        }

        boolean d() {
            return this.f16584c.isEmpty();
        }

        Component<?> a() {
            return this.f16582a;
        }

        Set<a> b() {
            return this.f16583b;
        }

        boolean c() {
            return this.f16583b.isEmpty();
        }
    }

    public static List<Component<?>> a(List<Component<?>> list) {
        Set<a> b2 = b(list);
        Set<a> a2 = a(b2);
        ArrayList arrayList = new ArrayList();
        while (!a2.isEmpty()) {
            a next = a2.iterator().next();
            a2.remove(next);
            arrayList.add(next.a());
            for (a aVar : next.b()) {
                aVar.c(next);
                if (aVar.d()) {
                    a2.add(aVar);
                }
            }
        }
        if (arrayList.size() == list.size()) {
            Collections.reverse(arrayList);
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList();
        for (a aVar2 : b2) {
            if (!aVar2.d() && !aVar2.c()) {
                arrayList2.add(aVar2.a());
            }
        }
        throw new DependencyCycleException(arrayList2);
    }

    private static Set<a> b(List<Component<?>> list) {
        a aVar;
        HashMap hashMap = new HashMap(list.size());
        for (Component<?> component : list) {
            a aVar2 = new a(component);
            for (Class<? super Object> cls : component.c()) {
                if (hashMap.put(cls, aVar2) != null) {
                    throw new IllegalArgumentException(String.format("Multiple components provide %s.", cls));
                }
            }
        }
        for (a aVar3 : hashMap.values()) {
            for (Dependency dependency : aVar3.a().a()) {
                if (dependency.b() && (aVar = (a) hashMap.get(dependency.a())) != null) {
                    aVar3.a(aVar);
                    aVar.b(aVar3);
                }
            }
        }
        return new HashSet(hashMap.values());
    }

    private static Set<a> a(Set<a> set) {
        HashSet hashSet = new HashSet();
        for (a aVar : set) {
            if (aVar.d()) {
                hashSet.add(aVar);
            }
        }
        return hashSet;
    }
}
