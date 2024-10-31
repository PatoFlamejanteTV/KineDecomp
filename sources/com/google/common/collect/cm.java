package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: Multisets.java */
/* loaded from: classes2.dex */
class cm<E> extends dk<Multiset.Entry<E>, E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Multisets.b f2845a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cm(Multisets.b bVar, Iterator it) {
        super(it);
        this.f2845a = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.dk
    public E a(Multiset.Entry<E> entry) {
        return entry.getElement();
    }
}
