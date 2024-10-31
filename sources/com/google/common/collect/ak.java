package com.google.common.collect;

import com.google.common.base.Function;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Iterables.java */
/* loaded from: classes2.dex */
public final class ak<T> extends FluentIterable<T> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Iterable f2796a;
    final /* synthetic */ Function b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(Iterable iterable, Function function) {
        this.f2796a = iterable;
        this.b = function;
    }

    @Override // java.lang.Iterable
    public Iterator<T> iterator() {
        return Iterators.a(this.f2796a.iterator(), this.b);
    }
}
