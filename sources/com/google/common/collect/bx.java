package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
class bx<K, V> extends Maps.f<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.b f2830a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(Maps.b bVar) {
        this.f2830a = bVar;
    }

    @Override // com.google.common.collect.Maps.f
    Map<K, V> a() {
        return this.f2830a;
    }
}
