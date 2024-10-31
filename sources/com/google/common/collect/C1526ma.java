package com.google.common.collect;

import java.util.NoSuchElementException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.ma */
/* loaded from: classes2.dex */
public class C1526ma<T> extends UnmodifiableIterator<T> {

    /* renamed from: a */
    boolean f15824a;

    /* renamed from: b */
    final /* synthetic */ Object f15825b;

    public C1526ma(Object obj) {
        this.f15825b = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return !this.f15824a;
    }

    @Override // java.util.Iterator
    public T next() {
        if (!this.f15824a) {
            this.f15824a = true;
            return (T) this.f15825b;
        }
        throw new NoSuchElementException();
    }
}
