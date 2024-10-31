package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Na<K, V1, V2> implements Function<Map.Entry<K, V1>, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.EntryTransformer f15620a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Na(Maps.EntryTransformer entryTransformer) {
        this.f15620a = entryTransformer;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public V2 apply(Map.Entry<K, V1> entry) {
        return (V2) this.f15620a.a(entry.getKey(), entry.getValue());
    }
}
