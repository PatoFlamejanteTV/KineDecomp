package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public final class az<K, V> extends f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap.c f2809a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(LinkedListMultimap.c cVar) {
        this.f2809a = cVar;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return this.f2809a.f2715a;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V getValue() {
        return this.f2809a.b;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public V setValue(V v) {
        V v2 = this.f2809a.b;
        this.f2809a.b = v;
        return v2;
    }
}
