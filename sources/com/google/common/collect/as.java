package com.google.common.collect;

import com.google.common.collect.Iterators;
import java.util.Comparator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterators.java */
/* loaded from: classes2.dex */
public class as<T> implements Comparator<PeekingIterator<T>> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterators.a f2802a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public as(Iterators.a aVar) {
        this.f2802a = aVar;
    }

    @Override // java.util.Comparator
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(PeekingIterator<T> peekingIterator, PeekingIterator<T> peekingIterator2) {
        return this.f2802a.b.compare(peekingIterator.a(), peekingIterator2.a());
    }
}
