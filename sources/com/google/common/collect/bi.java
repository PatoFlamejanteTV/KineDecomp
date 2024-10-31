package com.google.common.collect;

import com.google.common.collect.Lists;
import java.util.ListIterator;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Lists.java */
/* loaded from: classes2.dex */
class bi<T> implements ListIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ListIterator f2819a;
    final /* synthetic */ Lists.TransformingSequentialList b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(Lists.TransformingSequentialList transformingSequentialList, ListIterator listIterator) {
        this.b = transformingSequentialList;
        this.f2819a = listIterator;
    }

    @Override // java.util.ListIterator
    public void add(T t) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return this.f2819a.hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return this.f2819a.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public T next() {
        return (T) this.b.function.apply(this.f2819a.next());
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return this.f2819a.nextIndex();
    }

    @Override // java.util.ListIterator
    public T previous() {
        return (T) this.b.function.apply(this.f2819a.previous());
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return this.f2819a.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        this.f2819a.remove();
    }

    @Override // java.util.ListIterator
    public void set(T t) {
        throw new UnsupportedOperationException("not supported");
    }
}
