package com.google.common.collect;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: ImmutableMultimap.java */
/* renamed from: com.google.common.collect.ba, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1493ba<V> extends ImmutableMultimap<K, V>.b<V> {

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ImmutableMultimap f15768e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1493ba(ImmutableMultimap immutableMultimap) {
        super(immutableMultimap, null);
        this.f15768e = immutableMultimap;
    }

    @Override // com.google.common.collect.ImmutableMultimap.b
    V a(K k, V v) {
        return v;
    }
}
