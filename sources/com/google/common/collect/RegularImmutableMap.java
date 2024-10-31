package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMapEntry;
import com.google.common.collect.ImmutableMapEntrySet;
import com.google.common.collect.ImmutableSet;
import com.google.j2objc.annotations.Weak;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class RegularImmutableMap<K, V> extends ImmutableMap<K, V> {
    private static final long serialVersionUID = 0;

    /* renamed from: e, reason: collision with root package name */
    private final transient Map.Entry<K, V>[] f15649e;

    /* renamed from: f, reason: collision with root package name */
    private final transient ImmutableMapEntry<K, V>[] f15650f;

    /* renamed from: g, reason: collision with root package name */
    private final transient int f15651g;

    /* loaded from: classes2.dex */
    private static final class KeySet<K, V> extends ImmutableSet.Indexed<K> {

        @Weak
        private final RegularImmutableMap<K, V> map;

        @GwtIncompatible
        /* loaded from: classes2.dex */
        private static class SerializedForm<K> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<K, ?> map;

            SerializedForm(ImmutableMap<K, ?> immutableMap) {
                this.map = immutableMap;
            }

            Object readResolve() {
                return this.map.keySet();
            }
        }

        KeySet(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.map.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableSet.Indexed
        K get(int i) {
            return (K) ((RegularImmutableMap) this.map).f15649e[i].getKey();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new SerializedForm(this.map);
        }
    }

    /* loaded from: classes2.dex */
    private static final class Values<K, V> extends ImmutableList<V> {

        @Weak
        final RegularImmutableMap<K, V> map;

        @GwtIncompatible
        /* loaded from: classes2.dex */
        private static class SerializedForm<V> implements Serializable {
            private static final long serialVersionUID = 0;
            final ImmutableMap<?, V> map;

            SerializedForm(ImmutableMap<?, V> immutableMap) {
                this.map = immutableMap;
            }

            Object readResolve() {
                return this.map.values();
            }
        }

        Values(RegularImmutableMap<K, V> regularImmutableMap) {
            this.map = regularImmutableMap;
        }

        @Override // java.util.List
        public V get(int i) {
            return (V) ((RegularImmutableMap) this.map).f15649e[i].getValue();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableCollection
        public boolean isPartialView() {
            return true;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.map.size();
        }

        @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
        @GwtIncompatible
        Object writeReplace() {
            return new SerializedForm(this.map);
        }
    }

    private RegularImmutableMap(Map.Entry<K, V>[] entryArr, ImmutableMapEntry<K, V>[] immutableMapEntryArr, int i) {
        this.f15649e = entryArr;
        this.f15650f = immutableMapEntryArr;
        this.f15651g = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkNoConflictInKeyBucket(Object obj, Map.Entry<?, ?> entry, @Nullable ImmutableMapEntry<?, ?> immutableMapEntry) {
        while (immutableMapEntry != null) {
            ImmutableMap.checkNoConflict(!obj.equals(immutableMapEntry.getKey()), "key", entry, immutableMapEntry);
            immutableMapEntry = immutableMapEntry.getNextInKeyBucket();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> fromEntries(Map.Entry<K, V>... entryArr) {
        return fromEntryArray(entryArr.length, entryArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> RegularImmutableMap<K, V> fromEntryArray(int i, Map.Entry<K, V>[] entryArr) {
        ImmutableMapEntry nonTerminalImmutableMapEntry;
        Preconditions.b(i, entryArr.length);
        Map.Entry<K, V>[] createEntryArray = i == entryArr.length ? entryArr : ImmutableMapEntry.createEntryArray(i);
        int a2 = Q.a(i, 1.2d);
        ImmutableMapEntry[] createEntryArray2 = ImmutableMapEntry.createEntryArray(a2);
        int i2 = a2 - 1;
        for (int i3 = 0; i3 < i; i3++) {
            Map.Entry<K, V> entry = entryArr[i3];
            K key = entry.getKey();
            V value = entry.getValue();
            C1555x.a(key, value);
            int a3 = Q.a(key.hashCode()) & i2;
            ImmutableMapEntry immutableMapEntry = createEntryArray2[a3];
            if (immutableMapEntry == null) {
                nonTerminalImmutableMapEntry = (entry instanceof ImmutableMapEntry) && ((ImmutableMapEntry) entry).isReusable() ? (ImmutableMapEntry) entry : new ImmutableMapEntry(key, value);
            } else {
                nonTerminalImmutableMapEntry = new ImmutableMapEntry.NonTerminalImmutableMapEntry(key, value, immutableMapEntry);
            }
            createEntryArray2[a3] = nonTerminalImmutableMapEntry;
            createEntryArray[i3] = nonTerminalImmutableMapEntry;
            checkNoConflictInKeyBucket(key, nonTerminalImmutableMapEntry, immutableMapEntry);
        }
        return new RegularImmutableMap<>(createEntryArray, createEntryArray2, i2);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        return new ImmutableMapEntrySet.RegularEntrySet(this, this.f15649e);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public ImmutableSet<K> createKeySet() {
        return new KeySet(this);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection<V> createValues() {
        return new Values(this);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        return (V) get(obj, this.f15650f, this.f15651g);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.Map
    public int size() {
        return this.f15649e.length;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Nullable
    public static <V> V get(@Nullable Object obj, ImmutableMapEntry<?, V>[] immutableMapEntryArr, int i) {
        if (obj == null) {
            return null;
        }
        for (ImmutableMapEntry<?, V> immutableMapEntry = immutableMapEntryArr[i & Q.a(obj.hashCode())]; immutableMapEntry != null; immutableMapEntry = immutableMapEntry.getNextInKeyBucket()) {
            if (obj.equals(immutableMapEntry.getKey())) {
                return immutableMapEntry.getValue();
            }
        }
        return null;
    }
}
