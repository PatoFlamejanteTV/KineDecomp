package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Ha<K, V> extends Bb<K, Map.Entry<K, V>> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function f15396b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Ha(Iterator it, Function function) {
        super(it);
        this.f15396b = function;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.Bb
    public /* bridge */ /* synthetic */ Object a(Object obj) {
        return a((Ha<K, V>) obj);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.Bb
    public Map.Entry<K, V> a(K k) {
        return Maps.a(k, this.f15396b.apply(k));
    }
}
