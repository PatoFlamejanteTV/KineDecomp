package com.google.common.collect;

import com.google.common.collect.Ub;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: WellBehavedMap.java */
/* loaded from: classes2.dex */
public class Tb<K, V> extends Bb<K, Map.Entry<K, V>> {

    /* renamed from: b */
    final /* synthetic */ Ub.a f15702b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Tb(Ub.a aVar, Iterator it) {
        super(it);
        this.f15702b = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Bb
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((Tb<K, V>) obj);
    }

    @Override // com.google.common.collect.Bb
    public Map.Entry<K, V> a(K k) {
        return new Sb(this, k);
    }
}
