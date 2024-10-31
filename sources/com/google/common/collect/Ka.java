package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: Maps.java */
/* loaded from: classes2.dex */
public class Ka<K, V> extends UnmodifiableIterator<Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f15485a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(Iterator it) {
        this.f15485a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15485a.hasNext();
    }

    @Override // java.util.Iterator
    public Map.Entry<K, V> next() {
        return Maps.b((Map.Entry) this.f15485a.next());
    }
}
