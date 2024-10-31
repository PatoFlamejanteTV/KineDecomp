package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;

/* JADX INFO: Add missing generic type declarations: [K0] */
/* compiled from: MultimapBuilder.java */
/* loaded from: classes2.dex */
class Va<K0> extends MultimapBuilder.SetMultimapBuilder<K0, Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15746a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ MultimapBuilder.MultimapBuilderWithKeys f15747b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Va(MultimapBuilder.MultimapBuilderWithKeys multimapBuilderWithKeys, int i) {
        this.f15747b = multimapBuilderWithKeys;
        this.f15746a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder
    public <K extends K0, V> SetMultimap<K, V> b() {
        return Multimaps.b(this.f15747b.b(), new MultimapBuilder.LinkedHashSetSupplier(this.f15746a));
    }
}
