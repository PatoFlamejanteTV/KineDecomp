package com.google.common.collect;

import com.google.common.collect.Multimaps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes2.dex */
public class i<K, V> extends Multimaps.c<K, V> {

    /* renamed from: a */
    final /* synthetic */ AbstractMultimap f2877a;

    public i(AbstractMultimap abstractMultimap) {
        this.f2877a = abstractMultimap;
    }

    @Override // com.google.common.collect.Multimaps.b
    Multimap<K, V> a() {
        return this.f2877a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return this.f2877a.createEntryIterator();
    }
}
