package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Multimaps;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [K, V1, V2] */
/* compiled from: Multimaps.java */
/* loaded from: classes2.dex */
public class ci<K, V1, V2> implements Function<Map.Entry<K, V1>, V2> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multimaps.f f2842a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ci(Multimaps.f fVar) {
        this.f2842a = fVar;
    }

    @Override // com.google.common.base.Function
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public V2 apply(Map.Entry<K, V1> entry) {
        return this.f2842a.b.a(entry.getKey(), entry.getValue());
    }
}
