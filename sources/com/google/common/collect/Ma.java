package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V1, V2] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Ma<V1, V2> implements Function<V1, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Maps.EntryTransformer f15534a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Object f15535b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ma(Maps.EntryTransformer entryTransformer, Object obj) {
        this.f15534a = entryTransformer;
        this.f15535b = obj;
    }

    @Override // com.google.common.base.Function
    public V2 apply(@Nullable V1 v1) {
        return (V2) this.f15534a.a(this.f15535b, v1);
    }
}
