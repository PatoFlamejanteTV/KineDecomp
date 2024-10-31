package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ImmutableMultimap.java */
/* renamed from: com.google.common.collect.aa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1490aa<K, V> extends ImmutableMultimap<K, V>.b<Map.Entry<K, V>> {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableMultimap f15764e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1490aa(ImmutableMultimap immutableMultimap) {
        super(immutableMultimap, null);
        this.f15764e = immutableMultimap;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.ImmutableMultimap.b
    /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return a((C1490aa<K, V>) obj, obj2);
    }

    @Override // com.google.common.collect.ImmutableMultimap.b
    Map.Entry<K, V> a(K k, V v) {
        return Maps.a(k, v);
    }
}
