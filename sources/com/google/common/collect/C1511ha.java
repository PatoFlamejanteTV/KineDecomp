package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.java */
/* renamed from: com.google.common.collect.ha, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C1511ha<T> extends FluentIterable<T> {

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Iterable f15797b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function f15798c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1511ha(Iterable iterable, Function function) {
        this.f15797b = iterable;
        this.f15798c = function;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return Iterators.a(this.f15797b.iterator(), this.f15798c);
    }
}
