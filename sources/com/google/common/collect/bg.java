package com.google.common.collect;

import com.google.common.collect.Multisets;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
public class bg<K> extends Multisets.a<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2817a;
    final /* synthetic */ bf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bg(bf bfVar, Object obj) {
        this.b = bfVar;
        this.f2817a = obj;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public K getElement() {
        return (K) this.f2817a;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        return LinkedListMultimap.this.c.count(this.f2817a);
    }
}
