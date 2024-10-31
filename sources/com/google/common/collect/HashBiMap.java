package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class HashBiMap<K, V> extends AbstractBiMap<K, V> {

    @GwtIncompatible
    private static final long serialVersionUID = 0;

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
    public /* bridge */ /* synthetic */ Object remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public /* bridge */ /* synthetic */ Set values() {
        return super.values();
    }

    public static <K, V> HashBiMap<K, V> create() {
        return new HashBiMap<>();
    }

    public static <K, V> HashBiMap<K, V> create(int i) {
        return new HashBiMap<>(i);
    }

    public static <K, V> HashBiMap<K, V> create(Map<? extends K, ? extends V> map) {
        HashBiMap<K, V> create = create(map.size());
        create.putAll(map);
        return create;
    }

    private HashBiMap() {
        super(new HashMap(), new HashMap());
    }

    private HashBiMap(int i) {
        super(Maps.a(i), Maps.a(i));
    }

    @Override // com.google.common.collect.AbstractBiMap, com.google.common.collect.ForwardingMap, java.util.Map
    public V put(@Nullable K k, @Nullable V v) {
        return (V) super.put(k, v);
    }

    @Override // com.google.common.collect.AbstractBiMap
    public V forcePut(@Nullable K k, @Nullable V v) {
        return (V) super.forcePut(k, v);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        cs.a(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int a2 = cs.a(objectInputStream);
        setDelegates(Maps.a(a2), Maps.a(a2));
        cs.a(this, objectInputStream, a2);
    }
}
