package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashBiMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: HashBiMap.java */
/* loaded from: classes2.dex */
class M<K, V> extends HashBiMap<K, V>.a<Map.Entry<V, K>> {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ N f15531e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: HashBiMap.java */
    /* loaded from: classes2.dex */
    public class a extends AbstractC1513i<V, K> {

        /* renamed from: a, reason: collision with root package name */
        HashBiMap.BiEntry<K, V> f15532a;

        a(HashBiMap.BiEntry<K, V> biEntry) {
            this.f15532a = biEntry;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public V getKey() {
            return this.f15532a.value;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public K getValue() {
            return this.f15532a.key;
        }

        @Override // com.google.common.collect.AbstractC1513i, java.util.Map.Entry
        public K setValue(K k) {
            K k2 = this.f15532a.key;
            int a2 = Q.a(k);
            if (a2 == this.f15532a.keyHash && Objects.a(k, k2)) {
                return k;
            }
            Preconditions.a(HashBiMap.this.a(k, a2) == null, "value already present: %s", k);
            HashBiMap.this.a(this.f15532a);
            HashBiMap.BiEntry<K, V> biEntry = this.f15532a;
            HashBiMap.BiEntry<K, V> biEntry2 = new HashBiMap.BiEntry<>(k, a2, biEntry.value, biEntry.valueHash);
            this.f15532a = biEntry2;
            HashBiMap.this.a(biEntry2, (HashBiMap.BiEntry) null);
            M m = M.this;
            m.f15408c = HashBiMap.this.f15403g;
            return k2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public M(N n) {
        super();
        this.f15531e = n;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.HashBiMap.a
    public Map.Entry<V, K> a(HashBiMap.BiEntry<K, V> biEntry) {
        return new a(biEntry);
    }
}
