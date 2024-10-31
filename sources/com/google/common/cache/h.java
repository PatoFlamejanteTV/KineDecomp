package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.cache.LocalCache;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V] */
/* compiled from: LocalCache.java */
/* loaded from: classes2.dex */
public class h<V> implements Function<V, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LocalCache.i f15257a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(LocalCache.i iVar) {
        this.f15257a = iVar;
    }

    @Override // com.google.common.base.Function
    public V apply(V v) {
        this.f15257a.b((LocalCache.i) v);
        return v;
    }
}
