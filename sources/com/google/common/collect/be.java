package com.google.common.collect;

import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class be<K, V> extends f<K, Collection<V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2815a;
    final /* synthetic */ bd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(bd bdVar, Object obj) {
        this.b = bdVar;
        this.f2815a = obj;
    }

    @Override // com.google.common.collect.f, java.util.Map.Entry
    public K getKey() {
        return (K) this.f2815a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.f, java.util.Map.Entry
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Collection<V> getValue() {
        return this.b.f2814a.f2813a.get((LinkedListMultimap) this.f2815a);
    }
}
