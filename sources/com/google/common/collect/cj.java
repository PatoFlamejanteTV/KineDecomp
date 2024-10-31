package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class cj<K, V1, V2> implements Function<Map.Entry<K, V1>, Map.Entry<K, V2>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multimaps.f f2843a;
    final /* synthetic */ Maps.EntryTransformer b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cj(Multimaps.f fVar, Maps.EntryTransformer entryTransformer) {
        this.f2843a = fVar;
        this.b = entryTransformer;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<K, V2> apply(Map.Entry<K, V1> entry) {
        return new ck(this, entry);
    }
}
