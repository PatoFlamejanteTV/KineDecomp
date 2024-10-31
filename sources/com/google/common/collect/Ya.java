package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class Ya<K, V> extends Bb<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {

    /* renamed from: b */
    final /* synthetic */ Multimaps.c f15757b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ya(Multimaps.c cVar, Iterator it) {
        super(it);
        this.f15757b = cVar;
    }

    @Override // com.google.common.collect.Bb
    public Multiset.Entry<K> a(Map.Entry<K, Collection<V>> entry) {
        return new Xa(this, entry);
    }
}
