package com.google.common.collect;

import com.google.common.collect.MultimapBuilder;
import java.util.Collection;
import java.util.Map;

/* compiled from: MultimapBuilder.java */
/* loaded from: classes2.dex */
class Ta extends MultimapBuilder.MultimapBuilderWithKeys<Object> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f15700a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ta(int i) {
        this.f15700a = i;
    }

    @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
    <K, V> Map<K, Collection<V>> b() {
        return Maps.c(this.f15700a);
    }
}
