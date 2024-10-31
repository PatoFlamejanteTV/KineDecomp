package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import com.google.common.primitives.Primitives;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends MapConstraints.c<Class<? extends B>, B> implements ClassToInstanceMap<B> {
    private static final MapConstraint<Class<?>, Object> b = new cn();

    @Override // com.google.common.collect.MapConstraints.c, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.MapConstraints.c, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static <B, T extends B> T b(Class<T> cls, B b2) {
        return (T) Primitives.a(cls).cast(b2);
    }
}
