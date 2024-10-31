package com.google.common.collect;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
class q<K, V> extends c<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ p f2887a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(p pVar, int i) {
        super(i);
        this.f2887a = pVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.c
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> a(int i) {
        return new r(this, i);
    }
}
