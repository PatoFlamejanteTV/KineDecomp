package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.Enum;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class EnumHashBiMap<K extends Enum<K>, V> extends AbstractBiMap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

    /* renamed from: a, reason: collision with root package name */
    private transient Class<K> f2676a;

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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap
    public /* bridge */ /* synthetic */ Object forcePut(Object obj, Object obj2) {
        return forcePut((EnumHashBiMap<K, V>) obj, (Enum) obj2);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.BiMap
    public /* bridge */ /* synthetic */ BiMap inverse() {
        return super.inverse();
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Object put(Object obj, Object obj2) {
        return put((EnumHashBiMap<K, V>) obj, (Enum) obj2);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ void putAll(Map map) {
        super.putAll(map);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Class<K> cls) {
        return new EnumHashBiMap<>(cls);
    }

    public static <K extends Enum<K>, V> EnumHashBiMap<K, V> create(Map<K, ? extends V> map) {
        EnumHashBiMap<K, V> create = create(EnumBiMap.inferKeyType(map));
        create.putAll(map);
        return create;
    }

    private EnumHashBiMap(Class<K> cls) {
        super(dr.a(new EnumMap(cls)), Maps.a(cls.getEnumConstants().length));
        this.f2676a = cls;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractBiMap
    public K checkKey(K k) {
        return (K) Preconditions.a(k);
    }

    public V put(K k, @Nullable V v) {
        return (V) super.put((EnumHashBiMap<K, V>) k, (K) v);
    }

    public V forcePut(K k, @Nullable V v) {
        return (V) super.forcePut((EnumHashBiMap<K, V>) k, (K) v);
    }

    public Class<K> keyType() {
        return this.f2676a;
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f2676a);
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.f2676a = (Class) objectInputStream.readObject();
        setDelegates(dr.a(new EnumMap(this.f2676a)), new HashMap((this.f2676a.getEnumConstants().length * 3) / 2));
        cs.a(this, objectInputStream);
    }
}
