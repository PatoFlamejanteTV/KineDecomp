package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
class bh<K, V> extends dk<LinkedListMultimap.c<K, V>, K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap.b f2818a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bh(LinkedListMultimap.b bVar, Iterator it) {
        super(it);
        this.f2818a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public K a(LinkedListMultimap.c<K, V> cVar) {
        return cVar.f2715a;
    }
}
