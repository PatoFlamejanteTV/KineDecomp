package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Objects;
import java.util.Map;
import javax.annotation.Nullable;

/* compiled from: AbstractMapEntry.java */
@GwtCompatible
/* loaded from: classes2.dex */
abstract class f<K, V> implements Map.Entry<K, V> {
    @Override // java.util.Map.Entry
    public abstract K getKey();

    @Override // java.util.Map.Entry
    public abstract V getValue();

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return Objects.a(getKey(), entry.getKey()) && Objects.a(getValue(), entry.getValue());
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        K key = getKey();
        V value = getValue();
        return (value != null ? value.hashCode() : 0) ^ (key == null ? 0 : key.hashCode());
    }

    public String toString() {
        return getKey() + "=" + getValue();
    }
}
