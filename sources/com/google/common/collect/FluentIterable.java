package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: a, reason: collision with root package name */
    private final Iterable<E> f2678a;

    /* JADX INFO: Access modifiers changed from: protected */
    public FluentIterable() {
        this.f2678a = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FluentIterable(Iterable<E> iterable) {
        this.f2678a = (Iterable) Preconditions.a(iterable);
    }

    public static <E> FluentIterable<E> a(Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new aa(iterable, iterable);
    }

    public String toString() {
        return Iterables.a(this.f2678a);
    }

    public final FluentIterable<E> a(Predicate<? super E> predicate) {
        return a(Iterables.a((Iterable) this.f2678a, (Predicate) predicate));
    }

    public final ImmutableSet<E> a() {
        return ImmutableSet.copyOf(this.f2678a);
    }
}
