package com.google.common.reflect;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ForwardingMap;
import com.google.common.collect.ForwardingMapEntry;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Beta
/* loaded from: classes2.dex */
public final class MutableTypeToInstanceMap<B> extends ForwardingMap<TypeToken<? extends B>, B> implements TypeToInstanceMap<B> {

    /* renamed from: a */
    private final Map<TypeToken<? extends B>, B> f16056a = Maps.c();

    /* loaded from: classes2.dex */
    public static final class a<K, V> extends ForwardingMapEntry<K, V> {

        /* renamed from: a */
        private final Map.Entry<K, V> f16057a;

        public /* synthetic */ a(Map.Entry entry, c cVar) {
            this(entry);
        }

        public static <K, V> Iterator<Map.Entry<K, V>> b(Iterator<Map.Entry<K, V>> it) {
            return Iterators.a((Iterator) it, (Function) new e());
        }

        @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
        public V setValue(V v) {
            throw new UnsupportedOperationException();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public a(Map.Entry<K, V> entry) {
            Preconditions.a(entry);
            this.f16057a = entry;
        }

        static <K, V> Set<Map.Entry<K, V>> a(Set<Map.Entry<K, V>> set) {
            return new d(set);
        }

        @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
        public Map.Entry<K, V> delegate() {
            return this.f16057a;
        }
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @CanIgnoreReturnValue
    @Deprecated
    /* renamed from: a */
    public B put(TypeToken<? extends B> typeToken, B b2) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    public Set<Map.Entry<TypeToken<? extends B>, B>> entrySet() {
        return a.a(super.entrySet());
    }

    @Override // com.google.common.collect.ForwardingMap, java.util.Map
    @Deprecated
    public void putAll(Map<? extends TypeToken<? extends B>, ? extends B> map) {
        throw new UnsupportedOperationException("Please use putInstance() instead.");
    }

    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public Map<TypeToken<? extends B>, B> delegate() {
        return this.f16056a;
    }
}
