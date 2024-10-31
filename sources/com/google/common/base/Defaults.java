package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class Defaults {

    /* renamed from: a */
    private static final Map<Class<?>, Object> f15083a;

    static {
        HashMap hashMap = new HashMap();
        a(hashMap, Boolean.TYPE, false);
        a(hashMap, Character.TYPE, (char) 0);
        a(hashMap, Byte.TYPE, (byte) 0);
        a(hashMap, Short.TYPE, (short) 0);
        a(hashMap, Integer.TYPE, 0);
        a(hashMap, Long.TYPE, 0L);
        a(hashMap, Float.TYPE, Float.valueOf(0.0f));
        a(hashMap, Double.TYPE, Double.valueOf(0.0d));
        f15083a = Collections.unmodifiableMap(hashMap);
    }

    private Defaults() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void a(Map<Class<?>, Object> map, Class<T> cls, T t) {
        map.put(cls, t);
    }
}
