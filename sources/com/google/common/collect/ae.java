package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMultimap;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ImmutableMultimap.java */
/* loaded from: classes2.dex */
public class ae<K, V> implements Function<Map.Entry<K, Collection<V>>, K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ImmutableMultimap.Builder f2790a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(ImmutableMultimap.Builder builder) {
        this.f2790a = builder;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public K apply(Map.Entry<K, Collection<V>> entry) {
        return entry.getKey();
    }
}
