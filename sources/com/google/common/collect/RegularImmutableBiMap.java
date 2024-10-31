package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import java.util.Iterator;
import java.util.Map;

@GwtCompatible
/* loaded from: classes2.dex */
class RegularImmutableBiMap<K, V> extends ImmutableBiMap<K, V> {
    final transient ImmutableMap<K, V> delegate;
    final transient ImmutableBiMap<V, K> inverse;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public RegularImmutableBiMap(ImmutableMap<K, V> immutableMap) {
        this.delegate = immutableMap;
        ImmutableMap.Builder builder = ImmutableMap.builder();
        Iterator it = immutableMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            builder.b(entry.getValue(), entry.getKey());
        }
        this.inverse = new RegularImmutableBiMap(builder.b(), this);
    }

    RegularImmutableBiMap(ImmutableMap<K, V> immutableMap, ImmutableBiMap<V, K> immutableBiMap) {
        this.delegate = immutableMap;
        this.inverse = immutableBiMap;
    }

    @Override // com.google.common.collect.ImmutableBiMap
    ImmutableMap<K, V> delegate() {
        return this.delegate;
    }

    @Override // com.google.common.collect.ImmutableBiMap, com.google.common.collect.BiMap
    public ImmutableBiMap<V, K> inverse() {
        return this.inverse;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableMap
    public boolean isPartialView() {
        return this.delegate.isPartialView() || this.inverse.delegate().isPartialView();
    }
}
