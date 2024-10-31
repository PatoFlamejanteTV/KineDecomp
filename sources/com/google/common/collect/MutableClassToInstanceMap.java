package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.collect.MapConstraints;
import com.google.common.primitives.Primitives;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@GwtIncompatible
/* loaded from: classes2.dex */
public final class MutableClassToInstanceMap<B> extends MapConstraints.c<Class<? extends B>, B> implements ClassToInstanceMap<B>, Serializable {

    /* renamed from: b */
    private static final MapConstraint<Class<?>, Object> f15618b = new C1494bb();

    /* loaded from: classes2.dex */
    private static final class SerializedForm<B> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Map<Class<? extends B>, B> backingMap;

        SerializedForm(Map<Class<? extends B>, B> map) {
            this.backingMap = map;
        }

        Object readResolve() {
            return MutableClassToInstanceMap.create(this.backingMap);
        }
    }

    private MutableClassToInstanceMap(Map<Class<? extends B>, B> map) {
        super(map, f15618b);
    }

    @CanIgnoreReturnValue
    public static <B, T extends B> T a(Class<T> cls, B b2) {
        return (T) Primitives.b(cls).cast(b2);
    }

    public static <B> MutableClassToInstanceMap<B> create() {
        return new MutableClassToInstanceMap<>(new HashMap());
    }

    private Object writeReplace() {
        return new SerializedForm(delegate());
    }

    @Override // com.google.common.collect.MapConstraints.c, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public <T extends B> T getInstance(Class<T> cls) {
        return (T) a(cls, get(cls));
    }

    @Override // com.google.common.collect.MapConstraints.c, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @CanIgnoreReturnValue
    public <T extends B> T putInstance(Class<T> cls, T t) {
        return (T) a(cls, put(cls, t));
    }

    public static <B> MutableClassToInstanceMap<B> create(Map<Class<? extends B>, B> map) {
        return new MutableClassToInstanceMap<>(map);
    }
}
