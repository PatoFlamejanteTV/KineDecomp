package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class EmptyImmutableSortedMap<K, V> extends ImmutableSortedMap<K, V> {

    /* renamed from: a */
    private final transient ImmutableSortedSet<K> f2674a;

    public EmptyImmutableSortedMap(Comparator<? super K> comparator) {
        this.f2674a = ImmutableSortedSet.emptySet(comparator);
    }

    EmptyImmutableSortedMap(Comparator<? super K> comparator, ImmutableSortedMap<K, V> immutableSortedMap) {
        super(immutableSortedMap);
        this.f2674a = ImmutableSortedSet.emptySet(comparator);
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public V get(@Nullable Object obj) {
        return null;
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSortedSet<K> keySet() {
        return this.f2674a;
    }

    @Override // com.google.common.collect.ImmutableSortedMap, java.util.Map
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<V> values() {
        return ImmutableList.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public String toString() {
        return "{}";
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSortedMap, com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<K, V>> entrySet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<K, V>> createEntrySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    public ImmutableSortedMap<K, V> headMap(K k, boolean z) {
        Preconditions.a(k);
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    public ImmutableSortedMap<K, V> tailMap(K k, boolean z) {
        Preconditions.a(k);
        return this;
    }

    @Override // com.google.common.collect.ImmutableSortedMap
    ImmutableSortedMap<K, V> createDescendingMap() {
        return new EmptyImmutableSortedMap(Ordering.from(comparator()).reverse(), this);
    }
}
