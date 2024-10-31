package com.squareup.wire;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExtensionRegistry.java */
/* loaded from: classes.dex */
public final class g {

    /* renamed from: a */
    private final Map<Class<? extends ExtendableMessage>, Map<Integer, e<?, ?>>> f25720a = new LinkedHashMap();

    /* renamed from: b */
    private final Map<Class<? extends ExtendableMessage>, Map<String, e<?, ?>>> f25721b = new LinkedHashMap();

    public <T extends ExtendableMessage<?>, E> void a(e<T, E> eVar) {
        Class<T> e2 = eVar.e();
        Map<Integer, e<?, ?>> map = this.f25720a.get(e2);
        Map<String, e<?, ?>> map2 = this.f25721b.get(e2);
        if (map == null) {
            map = new LinkedHashMap<>();
            map2 = new LinkedHashMap<>();
            this.f25720a.put(e2, map);
            this.f25721b.put(e2, map2);
        }
        map.put(Integer.valueOf(eVar.i()), eVar);
        map2.put(eVar.h(), eVar);
    }

    public <T extends ExtendableMessage<?>, E> e<T, E> a(Class<T> cls, int i) {
        Map<Integer, e<?, ?>> map = this.f25720a.get(cls);
        if (map == null) {
            return null;
        }
        return (e) map.get(Integer.valueOf(i));
    }
}
