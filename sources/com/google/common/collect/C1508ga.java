package com.google.common.collect;

import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.ga, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1508ga<T> extends FluentIterable<T> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f15790b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Class f15791c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1508ga(Iterable iterable, Class cls) {
        this.f15790b = iterable;
        this.f15791c = cls;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return Iterators.a((Iterator<?>) this.f15790b.iterator(), this.f15791c);
    }
}
