package com.google.common.collect;

import com.google.common.collect.MapConstraints;
import java.util.Iterator;
import java.util.Map;

/* compiled from: MapConstraints.java */
/* loaded from: classes2.dex */
class Da<K, V> extends Bb<Map.Entry<K, V>, Map.Entry<K, V>> {

    /* renamed from: b */
    final /* synthetic */ MapConstraints.a f15364b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Da(MapConstraints.a aVar, Iterator it) {
        super(it);
        this.f15364b = aVar;
    }

    @Override // com.google.common.collect.Bb
    public Map.Entry<K, V> a(Map.Entry<K, V> entry) {
        Map.Entry<K, V> b2;
        b2 = MapConstraints.b(entry, this.f15364b.f15536a);
        return b2;
    }
}
