package com.google.common.collect;

import com.google.common.collect.StandardTable;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [C, V] */
/* compiled from: StandardTable.java */
/* loaded from: classes2.dex */
public class de<C, V> implements Iterator<Map.Entry<C, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterator f2860a;
    final /* synthetic */ StandardTable.g.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public de(StandardTable.g.a aVar, Iterator it) {
        this.b = aVar;
        this.f2860a = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f2860a.hasNext();
    }

    @Override // java.util.Iterator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Map.Entry<C, V> next() {
        return new df(this, (Map.Entry) this.f2860a.next());
    }

    @Override // java.util.Iterator
    public void remove() {
        this.f2860a.remove();
        StandardTable.g.this.c();
    }
}
