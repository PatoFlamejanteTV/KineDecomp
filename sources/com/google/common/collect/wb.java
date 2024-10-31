package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
public class wb<C, V> extends ForwardingMapEntry<C, V> {

    /* renamed from: a */
    final /* synthetic */ Map.Entry f15863a;

    /* renamed from: b */
    final /* synthetic */ xb f15864b;

    public wb(xb xbVar, Map.Entry entry) {
        this.f15864b = xbVar;
        this.f15863a = entry;
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public boolean equals(Object obj) {
        return standardEquals(obj);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
    public V setValue(V v) {
        Preconditions.a(v);
        return (V) super.setValue(v);
    }

    @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
    public Map.Entry<C, V> delegate() {
        return this.f15863a;
    }
}
