package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WellBehavedMap.java */
@GwtCompatible
/* loaded from: classes2.dex */
public final class dr<K, V> extends ForwardingMap<K, V> {

    /* renamed from: a, reason: collision with root package name */
    private final Map<K, V> f2870a;
    private Set<Map.Entry<K, V>> b;

    private dr(Map<K, V> map) {
        this.f2870a = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <K, V> dr<K, V> a(Map<K, V> map) {
        return new dr<>(map);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<K, V> delegate() {
        return this.f2870a;
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = this.b;
        if (set != null) {
            return set;
        }
        a aVar = new a();
        this.b = aVar;
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: WellBehavedMap.java */
    /* loaded from: classes2.dex */
    public final class a extends Maps.a<K, V> {
        private a() {
        }

        @Override // com.google.common.collect.Maps.a
        Map<K, V> a() {
            return dr.this;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<Map.Entry<K, V>> iterator() {
            return new ds(this, dr.this.keySet().iterator());
        }
    }
}
