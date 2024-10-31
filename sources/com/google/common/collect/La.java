package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class La<K, V1, V2> implements Maps.EntryTransformer<K, V1, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Function f15489a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public La(Function function) {
        this.f15489a = function;
    }

    @Override // com.google.common.collect.Maps.EntryTransformer
    public V2 a(K k, V1 v1) {
        return (V2) this.f15489a.apply(v1);
    }
}
