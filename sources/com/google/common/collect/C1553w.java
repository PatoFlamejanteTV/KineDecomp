package com.google.common.collect;

import com.google.common.collect.ArrayTable;
import java.util.Map;

/* compiled from: ArrayTable.java */
/* renamed from: com.google.common.collect.w */
/* loaded from: classes2.dex */
public class C1553w<K, V> extends AbstractC1492b<Map.Entry<K, V>> {

    /* renamed from: c */
    final /* synthetic */ ArrayTable.a f15861c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1553w(ArrayTable.a aVar, int i) {
        super(i);
        this.f15861c = aVar;
    }

    @Override // com.google.common.collect.AbstractC1492b
    public Map.Entry<K, V> a(int i) {
        return new C1551v(this, i);
    }
}
