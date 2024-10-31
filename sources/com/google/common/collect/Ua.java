package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* compiled from: MultimapBuilder.java */
/* loaded from: classes2.dex */
class Ua<K0> extends MultimapBuilder.ListMultimapBuilder<K0, Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15740a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f15741b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ua(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, int i) {
        this.f15741b = multimapBuilderWithKeys;
        this.f15740a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder
    public <K extends K0, V> ListMultimap<K, V> b() {
        return Multimaps.a(this.f15741b.b(), new MultimapBuilder.ArrayListSupplier(this.f15740a));
    }
}
