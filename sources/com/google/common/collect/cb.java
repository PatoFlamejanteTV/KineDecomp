package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
class cb<K, V2> extends Maps.f<K, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.d f2835a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(Maps.d dVar) {
        this.f2835a = dVar;
    }

    @Override // com.google.common.collect.Maps.f
    Map<K, V2> a() {
        return this.f2835a;
    }
}
