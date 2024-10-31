package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: ExtensionRegistry.java */
/* loaded from: classes.dex */
final class g {

    /* renamed from: a, reason: collision with root package name */
    private final Map<Class<? extends ExtendableMessage>, Map<Integer, e<?, ?>>> f4859a = new LinkedHashMap();
    private final Map<Class<? extends ExtendableMessage>, Map<String, e<?, ?>>> b = new LinkedHashMap();

    public <T extends ExtendableMessage<?>, E> void a(e<T, E> eVar) {
        Class<T> a2 = eVar.a();
        Map<Integer, e<?, ?>> map = this.f4859a.get(a2);
        Map<String, e<?, ?>> map2 = this.b.get(a2);
        if (map == null) {
            map = new LinkedHashMap<>();
            map2 = new LinkedHashMap<>();
            this.f4859a.put(a2, map);
            this.b.put(a2, map2);
        }
        map.put(Integer.valueOf(eVar.e()), eVar);
        map2.put(eVar.d(), eVar);
    }

    public <T extends ExtendableMessage<?>, E> e<T, E> a(Class<T> cls, int i) {
        Map<Integer, e<?, ?>> map = this.f4859a.get(cls);
        if (map == null) {
            return null;
        }
        return (e) map.get(Integer.valueOf(i));
    }
}
