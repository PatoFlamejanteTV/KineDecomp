package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
class Oa<K, V> extends Maps.c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.a f15626a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oa(Maps.a aVar) {
        this.f15626a = aVar;
    }

    @Override // com.google.common.collect.Maps.c
    Map<K, V> a() {
        return this.f15626a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return Maps.b((Set) this.f15626a.d(), (Function) this.f15626a.f15575e);
    }
}
