package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class EmptyImmutableMap extends ImmutableMap<Object, Object> {
    static final EmptyImmutableMap INSTANCE = new EmptyImmutableMap();
    private static final long serialVersionUID = 0;

    private EmptyImmutableMap() {
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(@Nullable Object obj) {
        return null;
    }

    @Override // java.util.Map
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean isEmpty() {
        return true;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsKey(@Nullable Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean containsValue(@Nullable Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet<Map.Entry<Object, Object>> createEntrySet() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Map.Entry<Object, Object>> entrySet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableSet<Object> keySet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public ImmutableCollection<Object> values() {
        return ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Map) {
            return ((Map) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMap
    public String toString() {
        return "{}";
    }

    Object readResolve() {
        return INSTANCE;
    }
}
