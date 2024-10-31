package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: FluentIterable.java */
/* loaded from: classes2.dex */
final class aa<E> extends FluentIterable<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f2787a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aa(Iterable iterable, Iterable iterable2) {
        super(iterable);
        this.f2787a = iterable2;
    }

    @Override // java.lang.Iterable
    public Iterator<E> iterator() {
        return this.f2787a.iterator();
    }
}
