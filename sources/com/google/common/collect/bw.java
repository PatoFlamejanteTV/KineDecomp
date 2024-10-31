package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
class bw<K, V> extends Maps.c<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.b f2829a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(Maps.b bVar) {
        this.f2829a = bVar;
    }

    @Override // com.google.common.collect.Maps.c
    Map<K, V> a() {
        return this.f2829a;
    }
}
