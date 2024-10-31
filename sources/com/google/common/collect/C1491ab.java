package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Iterator;

/* compiled from: Multisets.java */
/* renamed from: com.google.common.collect.ab */
/* loaded from: classes2.dex */
class C1491ab<E> extends Bb<Multiset.Entry<E>, E> {

    /* renamed from: b */
    final /* synthetic */ Multisets.b f15765b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1491ab(Multisets.b bVar, Iterator it) {
        super(it);
        this.f15765b = bVar;
    }

    @Override // com.google.common.collect.Bb
    public E a(Multiset.Entry<E> entry) {
        return entry.getElement();
    }
}
