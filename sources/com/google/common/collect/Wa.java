package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import java.util.Collection;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
class Wa<K, V> implements Function<K, Collection<V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multimaps.a.C0090a f15750a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Wa(Multimaps.a.C0090a c0090a) {
        this.f15750a = c0090a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.base.Function
    public /* bridge */ /* synthetic */ Object apply(Object obj) {
        return apply((Wa<K, V>) obj);
    }

    @Override // com.google.common.base.Function
    public Collection<V> apply(K k) {
        return Multimaps.a.this.f15605d.get(k);
    }
}
