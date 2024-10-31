package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V1, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class cf<V1, V2> implements Function<V1, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f2839a;
    final /* synthetic */ Multimaps.e b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(Multimaps.e eVar, Object obj) {
        this.b = eVar;
        this.f2839a = obj;
    }

    @Override // com.google.common.base.Function
    public V2 apply(V1 v1) {
        return this.b.b.a(this.f2839a, v1);
    }
}
