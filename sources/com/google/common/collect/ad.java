package com.google.common.collect;

import com.google.common.collect.ImmutableList;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [E] */
/* compiled from: ImmutableList.java */
/* loaded from: classes2.dex */
public class ad<E> extends UnmodifiableListIterator<E> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ UnmodifiableListIterator f2789a;
    final /* synthetic */ ImmutableList.ReverseImmutableList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ImmutableList.ReverseImmutableList reverseImmutableList, UnmodifiableListIterator unmodifiableListIterator) {
        this.b = reverseImmutableList;
        this.f2789a = unmodifiableListIterator;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public boolean hasNext() {
        return this.f2789a.hasPrevious();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f2789a.hasNext();
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public E next() {
        return this.f2789a.previous();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        int a2;
        a2 = this.b.a(this.f2789a.previousIndex());
        return a2;
    }

    @Override // java.util.ListIterator
    public E previous() {
        return this.f2789a.next();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        int a2;
        a2 = this.b.a(this.f2789a.nextIndex());
        return a2;
    }
}
