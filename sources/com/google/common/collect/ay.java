package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.ListIterator;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
class ay<K, V> extends dl<LinkedListMultimap.c<K, V>, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap.d f2808a;
    final /* synthetic */ ax b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ay(ax axVar, ListIterator listIterator, LinkedListMultimap.d dVar) {
        super(listIterator);
        this.b = axVar;
        this.f2808a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public V a(LinkedListMultimap.c<K, V> cVar) {
        return cVar.b;
    }

    @Override // com.google.common.collect.dl, java.util.ListIterator
    public void set(V v) {
        this.f2808a.a((LinkedListMultimap.d) v);
    }
}
