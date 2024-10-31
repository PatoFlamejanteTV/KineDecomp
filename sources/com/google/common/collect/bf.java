package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Multiset;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
class bf<K> extends dk<K, Multiset.Entry<K>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ LinkedListMultimap.b f2816a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bf(LinkedListMultimap.b bVar, Iterator it) {
        super(it);
        this.f2816a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Multiset.Entry<K> a(K k) {
        return new bg(this, k);
    }
}
