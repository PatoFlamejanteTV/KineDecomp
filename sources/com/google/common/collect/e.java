package com.google.common.collect;

import com.google.common.collect.Multisets;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: AbstractMapBasedMultiset.java */
/* loaded from: classes2.dex */
class e<E> extends Multisets.a<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map.Entry f2874a;
    final /* synthetic */ d b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar, Map.Entry entry) {
        this.b = dVar;
        this.f2874a = entry;
    }

    @Override // com.google.common.collect.Multiset.Entry
    public E getElement() {
        return (E) this.f2874a.getKey();
    }

    @Override // com.google.common.collect.Multiset.Entry
    public int getCount() {
        Count count;
        int i = ((Count) this.f2874a.getValue()).get();
        return (i != 0 || (count = (Count) this.b.c.f2639a.get(getElement())) == null) ? i : count.get();
    }
}
