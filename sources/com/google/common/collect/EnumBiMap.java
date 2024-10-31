package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

@GwtCompatible
/* loaded from: classes2.dex */
public final class EnumBiMap<K extends Enum<K>, V extends Enum<V>> extends AbstractBiMap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient Class<K> f2675a;
    private transient Class<V> b;

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Class<K> cls, Class<V> cls2) {
        return new EnumBiMap<>(cls, cls2);
    }

    public static <K extends Enum<K>, V extends Enum<V>> EnumBiMap<K, V> create(Map<K, V> map) {
        EnumBiMap<K, V> create = create(inferKeyType(map), a((Map) map));
        create.putAll(map);
        return create;
    }

    private EnumBiMap(Class<K> cls, Class<V> cls2) {
        super(dr.a(new EnumMap(cls)), dr.a(new EnumMap(cls2)));
        this.f2675a = cls;
        this.b = cls2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K extends Enum<K>> Class<K> inferKeyType(Map<K, ?> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).keyType();
        }
        if (map instanceof EnumHashBiMap) {
            return ((EnumHashBiMap) map).keyType();
        }
        Preconditions.a(!map.isEmpty());
        return map.keySet().iterator().next().getDeclaringClass();
    }

    private static <V extends Enum<V>> Class<V> a(Map<?, V> map) {
        if (map instanceof EnumBiMap) {
            return ((EnumBiMap) map).b;
        }
        Preconditions.a(!map.isEmpty());
        return map.values().iterator().next().getDeclaringClass();
    }

    public Class<K> keyType() {
        return this.f2675a;
    }

    public Class<V> valueType() {
        return this.b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractBiMap
    public K checkKey(K k) {
        return (K) Preconditions.a(k);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractBiMap
    public V checkValue(V v) {
        return (V) Preconditions.a(v);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f2675a);
        objectOutputStream.writeObject(this.b);
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f2675a = (Class) objectInputStream.readObject();
        this.b = (Class) objectInputStream.readObject();
        setDelegates(dr.a(new EnumMap(this.f2675a)), dr.a(new EnumMap(this.b)));
        cs.a(this, objectInputStream);
    }
}
