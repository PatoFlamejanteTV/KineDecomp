package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
class ce<K> extends Multisets.a<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2838a;
    final /* synthetic */ cd b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ce(cd cdVar, Map.Entry entry) {
        this.b = cdVar;
        this.f2838a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public K getElement() {
        return (K) this.f2838a.getKey();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        return ((Collection) this.f2838a.getValue()).size();
    }
}
