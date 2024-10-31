package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap;
import java.util.Map;

/* compiled from: HashBiMap.java */
/* loaded from: classes2.dex */
public class L<K, V> extends HashBiMap<K, V>.a<Map.Entry<K, V>> {

    /* renamed from: e */
    final /* synthetic */ HashBiMap f15486e;

    /* compiled from: HashBiMap.java */
    /* loaded from: classes2.dex */
    public class a extends AbstractC1513i<K, V> {

        /* renamed from: a */
        HashBiMap.BiEntry<K, V> f15487a;

        a(HashBiMap.BiEntry<K, V> biEntry) {
            this.f15487a = biEntry;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public K getKey() {
            return this.f15487a.key;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V getValue() {
            return this.f15487a.value;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V setValue(V v) {
            V v2 = this.f15487a.value;
            int a2 = Q.a(v);
            if (a2 == this.f15487a.valueHash && Objects.a(v, v2)) {
                return v;
            }
            Preconditions.a(L.this.f15486e.b(v, a2) == null, "value already present: %s", v);
            L.this.f15486e.a(this.f15487a);
            HashBiMap.BiEntry<K, V> biEntry = this.f15487a;
            HashBiMap.BiEntry<K, V> biEntry2 = new HashBiMap.BiEntry<>(biEntry.key, biEntry.keyHash, v, a2);
            L.this.f15486e.a(biEntry2, this.f15487a);
            HashBiMap.BiEntry<K, V> biEntry3 = this.f15487a;
            biEntry3.prevInKeyInsertionOrder = null;
            biEntry3.nextInKeyInsertionOrder = null;
            L l = L.this;
            l.f15408c = l.f15486e.f15403g;
            L l2 = L.this;
            if (l2.f15407b == this.f15487a) {
                l2.f15407b = biEntry2;
            }
            this.f15487a = biEntry2;
            return v2;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public L(HashBiMap hashBiMap) {
        super();
        this.f15486e = hashBiMap;
    }

    @Override // com.google.common.collect.HashBiMap.a
    public Map.Entry<K, V> a(HashBiMap.BiEntry<K, V> biEntry) {
        return new a(biEntry);
    }
}
