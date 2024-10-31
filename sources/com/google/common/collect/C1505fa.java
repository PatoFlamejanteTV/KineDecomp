package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.fa, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1505fa<T> extends FluentIterable<T> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f15785b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Predicate f15786c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1505fa(Iterable iterable, Predicate predicate) {
        this.f15785b = iterable;
        this.f15786c = predicate;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return Iterators.c(this.f15785b.iterator(), this.f15786c);
    }
}
