package com.google.common.collect;

import com.google.common.collect.LinkedListMultimap;
import java.util.ListIterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LinkedListMultimap.java */
/* loaded from: classes2.dex */
class bb<K, V> extends dl<LinkedListMultimap.c<K, V>, Map.Entry<K, V>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f2812a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bb(ba baVar, ListIterator listIterator) {
        super(listIterator);
        this.f2812a = baVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public Map.Entry<K, V> a(LinkedListMultimap.c<K, V> cVar) {
        Map.Entry<K, V> b;
        b = LinkedListMultimap.b((LinkedListMultimap.c) cVar);
        return b;
    }
}
