package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
final class h<K> extends Ordering<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Comparator f2948a;
    final /* synthetic */ Map b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(Comparator comparator, Map map) {
        this.f2948a = comparator;
        this.b = map;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(K k, K k2) {
        return this.f2948a.compare(this.b.get(k), this.b.get(k2));
    }
}
