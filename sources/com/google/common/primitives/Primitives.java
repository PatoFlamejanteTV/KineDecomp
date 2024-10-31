package com.google.common.primitives;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class Primitives {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f16040a;

    /* renamed from: b */
    private static final Map<Class<?>, Class<?>> f16041b;

    static {
        HashMap hashMap = new HashMap(16);
        HashMap hashMap2 = new HashMap(16);
        a(hashMap, hashMap2, Boolean.TYPE, Boolean.class);
        a(hashMap, hashMap2, Byte.TYPE, Byte.class);
        a(hashMap, hashMap2, Character.TYPE, Character.class);
        a(hashMap, hashMap2, Double.TYPE, Double.class);
        a(hashMap, hashMap2, Float.TYPE, Float.class);
        a(hashMap, hashMap2, Integer.TYPE, Integer.class);
        a(hashMap, hashMap2, Long.TYPE, Long.class);
        a(hashMap, hashMap2, Short.TYPE, Short.class);
        a(hashMap, hashMap2, Void.TYPE, Void.class);
        f16040a = Collections.unmodifiableMap(hashMap);
        f16041b = Collections.unmodifiableMap(hashMap2);
    }

    private Primitives() {
    }

    private static void a(Map<Class<?>, Class<?>> map, Map<Class<?>, Class<?>> map2, Class<?> cls, Class<?> cls2) {
        map.put(cls, cls2);
        map2.put(cls2, cls);
    }

    public static <T> Class<T> b(Class<T> cls) {
        Preconditions.a(cls);
        Class<T> cls2 = (Class) f16040a.get(cls);
        return cls2 == null ? cls : cls2;
    }

    public static Set<Class<?>> a() {
        return f16041b.keySet();
    }

    public static <T> Class<T> a(Class<T> cls) {
        Preconditions.a(cls);
        Class<T> cls2 = (Class) f16041b.get(cls);
        return cls2 == null ? cls : cls2;
    }
}
