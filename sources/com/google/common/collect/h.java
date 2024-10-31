package com.google.common.collect;

import com.google.common.collect.Multimaps;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractMultimap.java */
/* loaded from: classes2.dex */
public class h<K, V> extends Multimaps.g<K, V> {

    /* renamed from: a */
    final /* synthetic */ AbstractMultimap f2876a;

    public h(AbstractMultimap abstractMultimap) {
        this.f2876a = abstractMultimap;
    }

    @Override // com.google.common.collect.Multimaps.g
    Multimap<K, V> a() {
        return this.f2876a;
    }
}
