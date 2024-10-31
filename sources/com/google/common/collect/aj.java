package com.google.common.collect;

import com.google.common.base.Predicate;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.java */
/* loaded from: classes2.dex */
public final class aj<T> extends FluentIterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f2795a;
    final /* synthetic */ Predicate b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(Iterable iterable, Predicate predicate) {
        this.f2795a = iterable;
        this.b = predicate;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return Iterators.a(this.f2795a.iterator(), this.b);
    }
}
