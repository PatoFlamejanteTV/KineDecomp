package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
final class ao<T> extends UnmodifiableIterator<T> {

    /* renamed from: a, reason: collision with root package name */
    boolean f2799a;
    final /* synthetic */ Object b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(Object obj) {
        this.b = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f2799a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (this.f2799a) {
            throw new NoSuchElementException();
        }
        this.f2799a = true;
        return (T) this.b;
    }
}
