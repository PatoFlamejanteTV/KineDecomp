package com.google.common.collect;

import com.google.common.collect.dr;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: WellBehavedMap.java */
/* loaded from: classes2.dex */
class ds<K, V> extends dk<K, Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ dr.a f2872a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ds(dr.a aVar, Iterator it) {
        super(it);
        this.f2872a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V> a(K k) {
        return new dt(this, k);
    }
}
