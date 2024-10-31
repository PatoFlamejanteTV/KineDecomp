package com.google.android.gms.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public class zzme<K, V> extends zzmi<K, V> implements Map<K, V> {
    gj<K, V> zzagz;

    private gj<K, V> zzpx() {
        if (this.zzagz == null) {
            this.zzagz = new gi(this);
        }
        return this.zzagz;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return zzpx().d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return zzpx().e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureCapacity(this.mSize + map.size());
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return zzpx().f();
    }
}
