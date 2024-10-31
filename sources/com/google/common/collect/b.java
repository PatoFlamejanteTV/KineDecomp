package com.google.common.collect;

import com.google.common.collect.Multiset;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ConcurrentHashMultiset.java */
/* loaded from: classes2.dex */
class B<E> extends AbstractIterator<Multiset.Entry<E>> {

    /* renamed from: c, reason: collision with root package name */
    private final Iterator<Map.Entry<E, AtomicInteger>> f15340c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ ConcurrentHashMultiset f15341d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public B(ConcurrentHashMultiset concurrentHashMultiset) {
        ConcurrentMap concurrentMap;
        this.f15341d = concurrentHashMultiset;
        concurrentMap = this.f15341d.f15358c;
        this.f15340c = concurrentMap.entrySet().iterator();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.AbstractIterator
    public Multiset.Entry<E> b() {
        while (this.f15340c.hasNext()) {
            Map.Entry<E, AtomicInteger> next = this.f15340c.next();
            int i = next.getValue().get();
            if (i != 0) {
                return Multisets.a(next.getKey(), i);
            }
        }
        return c();
    }
}
