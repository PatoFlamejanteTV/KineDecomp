package com.google.common.collect;

import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class cd<K, V> extends dk<Map.Entry<K, Collection<V>>, Multiset.Entry<K>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multimaps.d f2837a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(Multimaps.d dVar, Iterator it) {
        super(it);
        this.f2837a = dVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public Multiset.Entry<K> a(Map.Entry<K, Collection<V>> entry) {
        return new ce(this, entry);
    }
}
