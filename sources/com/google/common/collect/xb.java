package com.google.common.collect;

import com.google.common.collect.StandardTable;
import java.util.Iterator;
import java.util.Map;

/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
public class xb<C, V> implements Iterator<Map.Entry<C, V>> {

    /* renamed from: a */
    final /* synthetic */ Iterator f15866a;

    /* renamed from: b */
    final /* synthetic */ StandardTable.f f15867b;

    public xb(StandardTable.f fVar, Iterator it) {
        this.f15867b = fVar;
        this.f15866a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f15866a.hasNext();
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f15866a.remove();
        this.f15867b.c();
    }

    @Override // java.util.Iterator
    public Map.Entry<C, V> next() {
        return new wb(this, (Map.Entry) this.f15866a.next());
    }
}
