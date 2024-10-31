package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class y<E> extends AbstractIterator<Multiset.Entry<E>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ConcurrentHashMultiset f2894a;
    private Iterator<Map.Entry<E, AtomicInteger>> b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(ConcurrentHashMultiset concurrentHashMultiset) {
        ConcurrentMap concurrentMap;
        this.f2894a = concurrentHashMultiset;
        concurrentMap = this.f2894a.f2668a;
        this.b = concurrentMap.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public Multiset.Entry<E> a() {
        while (this.b.hasNext()) {
            Map.Entry<E, AtomicInteger> next = this.b.next();
            int i = next.getValue().get();
            if (i != 0) {
                return Multisets.a(next.getKey(), i);
            }
        }
        return b();
    }
}
