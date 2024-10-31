package com.bumptech.glide.g;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.SimpleArrayMap;

/* compiled from: CachedHashCodeArrayMap.java */
/* loaded from: classes.dex */
public final class b<K, V> extends ArrayMap<K, V> {
    private int i;

    @Override // android.support.v4.util.SimpleArrayMap, java.util.Map
    public void clear() {
        this.i = 0;
        super.clear();
    }

    @Override // android.support.v4.util.SimpleArrayMap, java.util.Map
    public int hashCode() {
        if (this.i == 0) {
            this.i = super.hashCode();
        }
        return this.i;
    }

    @Override // android.support.v4.util.SimpleArrayMap, java.util.Map
    public V put(K k, V v) {
        this.i = 0;
        return (V) super.put(k, v);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public void putAll(SimpleArrayMap<? extends K, ? extends V> simpleArrayMap) {
        this.i = 0;
        super.putAll(simpleArrayMap);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public V removeAt(int i) {
        this.i = 0;
        return (V) super.removeAt(i);
    }

    @Override // android.support.v4.util.SimpleArrayMap
    public V setValueAt(int i, V v) {
        this.i = 0;
        return (V) super.setValueAt(i, v);
    }
}
