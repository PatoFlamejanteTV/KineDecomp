package com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
class ImmutableEntry<K, V> extends AbstractC1513i<K, V> implements Serializable {
    private static final long serialVersionUID = 0;
    final K key;
    final V value;

    public ImmutableEntry(@Nullable K k, @Nullable V v) {
        this.key = k;
        this.value = v;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    @Nullable
    public final K getKey() {
        return this.key;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    @Nullable
    public final V getValue() {
        return this.value;
    }

    @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
    public final V setValue(V v) {
        throw new UnsupportedOperationException();
    }
}
