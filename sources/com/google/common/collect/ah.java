package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableSetMultimap;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ImmutableSetMultimap.java */
/* loaded from: classes2.dex */
class ah<K, V> implements Function<Map.Entry<K, Collection<V>>, K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImmutableSetMultimap.Builder f2793a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(ImmutableSetMultimap.Builder builder) {
        this.f2793a = builder;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public K apply(Map.Entry<K, Collection<V>> entry) {
        return entry.getKey();
    }
}
