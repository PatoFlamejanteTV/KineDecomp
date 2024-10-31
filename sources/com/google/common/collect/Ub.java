package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* compiled from: WellBehavedMap.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class Ub<K, V> extends ForwardingMap<K, V> {

    /* renamed from: a */
    private final Map<K, V> f15742a;

    /* renamed from: b */
    private Set<Map.Entry<K, V>> f15743b;

    /* compiled from: WellBehavedMap.java */
    /* loaded from: classes2.dex */
    public final class a extends Maps.c<K, V> {
        private a() {
        }

        @Override // com.google.common.collect.Maps.c
        Map<K, V> a() {
            return Ub.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new Tb(this, Ub.this.keySet().iterator());
        }

        /* synthetic */ a(Ub ub, Rb rb) {
            this();
        }
    }

    private Ub(Map<K, V> map) {
        this.f15742a = map;
    }

    public static <K, V> Ub<K, V> a(Map<K, V> map) {
        return new Ub<>(map);
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.f15743b;
        if (set != null) {
            return set;
        }
        a aVar = new a();
        this.f15743b = aVar;
        return aVar;
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<K, V> delegate() {
        return this.f15742a;
    }
}
