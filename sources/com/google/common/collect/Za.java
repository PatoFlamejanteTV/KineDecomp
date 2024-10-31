package com.google.common.collect;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Collection;

/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
class Za<K, V1, V2> implements Maps.EntryTransformer<K, Collection<V1>, Collection<V2>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multimaps.e f15760a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Za(Multimaps.e eVar) {
        this.f15760a = eVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Maps.EntryTransformer
    public /* bridge */ /* synthetic */ Object a(Object obj, Object obj2) {
        return a((Za<K, V1, V2>) obj, (Collection) obj2);
    }

    public Collection<V2> a(K k, Collection<V1> collection) {
        return this.f15760a.a(k, collection);
    }
}
