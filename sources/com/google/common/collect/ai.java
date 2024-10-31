package com.google.common.collect;

import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: ImmutableSortedMap.java */
/* loaded from: classes2.dex */
final class ai<K, V> implements Comparator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Comparator f2794a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(Comparator comparator) {
        this.f2794a = comparator;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Map.Entry<K, V> entry, Map.Entry<K, V> entry2) {
        return this.f2794a.compare(entry.getKey(), entry2.getKey());
    }
}
