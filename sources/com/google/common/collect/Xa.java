package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class Xa<K> extends Multisets.a<K> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15753a;

    /* renamed from: b */
    final /* synthetic */ Ya f15754b;

    public Xa(Ya ya, Map.Entry entry) {
        this.f15754b = ya;
        this.f15753a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        return ((Collection) this.f15753a.getValue()).size();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public K getElement() {
        return (K) this.f15753a.getKey();
    }
}
