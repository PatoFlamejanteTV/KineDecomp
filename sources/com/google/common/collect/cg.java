package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V1, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class cg<V1, V2> implements Function<V1, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2840a;
    final /* synthetic */ Multimaps.f b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cg(Multimaps.f fVar, Object obj) {
        this.b = fVar;
        this.f2840a = obj;
    }

    @Override // com.google.common.base.Function
    public V2 apply(V1 v1) {
        return this.b.b.a(this.f2840a, v1);
    }
}
