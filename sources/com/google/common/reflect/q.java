package com.google.common.reflect;

import com.google.common.collect.Ordering;
import java.util.Comparator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K] */
/* compiled from: TypeToken.java */
/* loaded from: classes2.dex */
public class q<K> extends Ordering<K> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Comparator f16102a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f16103b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(Comparator comparator, Map map) {
        this.f16102a = comparator;
        this.f16103b = map;
    }

    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(K k, K k2) {
        return this.f16102a.compare(this.f16103b.get(k), this.f16103b.get(k2));
    }
}
