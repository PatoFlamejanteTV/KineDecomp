package com.google.common.collect;

import com.google.common.collect.Iterators;
import java.util.Comparator;

/* compiled from: Iterators.java */
/* renamed from: com.google.common.collect.sa */
/* loaded from: classes2.dex */
public class C1543sa<T> implements Comparator<PeekingIterator<T>> {

    /* renamed from: a */
    final /* synthetic */ Comparator f15840a;

    /* renamed from: b */
    final /* synthetic */ Iterators.a f15841b;

    public C1543sa(Iterators.a aVar, Comparator comparator) {
        this.f15841b = aVar;
        this.f15840a = comparator;
    }

    @Override // java.util.Comparator
    /* renamed from: a */
    public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
        return this.f15840a.compare(peekingIterator.peek(), peekingIterator2.peek());
    }
}
