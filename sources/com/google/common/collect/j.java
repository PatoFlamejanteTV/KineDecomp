package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes2.dex */
public class j<K, V> extends Multimaps.b<K, V> {

    /* renamed from: a */
    final /* synthetic */ AbstractMultimap f2878a;

    public j(AbstractMultimap abstractMultimap) {
        this.f2878a = abstractMultimap;
    }

    @Override // com.google.common.collect.Multimaps.b
    Multimap<K, V> a() {
        return this.f2878a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f2878a.createEntryIterator();
    }
}
