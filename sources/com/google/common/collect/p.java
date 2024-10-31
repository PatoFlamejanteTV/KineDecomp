package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ArrayTable.java */
/* loaded from: classes2.dex */
public class p<K, V> extends Maps.a<K, V> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ArrayTable.a f2886a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(ArrayTable.a aVar) {
        this.f2886a = aVar;
    }

    @Override // com.google.common.collect.Maps.a
    Map<K, V> a() {
        return this.f2886a;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator<Map.Entry<K, V>> iterator() {
        return new q(this, size());
    }
}
