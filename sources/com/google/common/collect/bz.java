package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
class bz<K, V1, V2> extends dk<Map.Entry<K, V1>, Map.Entry<K, V2>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ by f2832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bz(by byVar, Iterator it) {
        super(it);
        this.f2832a = byVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public Map.Entry<K, V2> a(Map.Entry<K, V1> entry) {
        return new ca(this, entry);
    }
}
