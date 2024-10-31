package com.google.common.collect;

import com.google.common.collect.Multimaps;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes2.dex */
public class g<K, V> extends Multimaps.d<K, V> {

    /* renamed from: a */
    final /* synthetic */ AbstractMultimap f2875a;

    public g(AbstractMultimap abstractMultimap) {
        this.f2875a = abstractMultimap;
    }

    @Override // com.google.common.collect.Multimaps.d
    Multimap<K, V> a() {
        return this.f2875a;
    }
}
