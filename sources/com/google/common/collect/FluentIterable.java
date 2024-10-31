package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Iterator;

/* loaded from: classes2.dex */
public abstract class FluentIterable<E> implements Iterable<E> {

    /* renamed from: a */
    private final Optional<Iterable<E>> f15382a;

    public FluentIterable() {
        this.f15382a = Optional.absent();
    }

    public static <E> FluentIterable<E> a(Iterable<E> iterable) {
        return iterable instanceof FluentIterable ? (FluentIterable) iterable : new J(iterable, iterable);
    }

    private Iterable<E> d() {
        return this.f15382a.or((Optional<Iterable<E>>) this);
    }

    @GwtIncompatible
    public final E[] b(Class<E> cls) {
        return (E[]) Iterables.b(d(), cls);
    }

    public final Optional<E> first() {
        Iterator<E> it = d().iterator();
        return it.hasNext() ? Optional.of(it.next()) : Optional.absent();
    }

    public String toString() {
        return Iterables.e(d());
    }

    public final FluentIterable<E> a(Predicate<? super E> predicate) {
        return a(Iterables.c(d(), predicate));
    }

    public FluentIterable(Iterable<E> iterable) {
        Preconditions.a(iterable);
        this.f15382a = Optional.fromNullable(this == iterable ? null : iterable);
    }

    @GwtIncompatible
    public final <T> FluentIterable<T> a(Class<T> cls) {
        return a(Iterables.a((Iterable<?>) d(), (Class) cls));
    }

    public final ImmutableSet<E> a() {
        return ImmutableSet.copyOf(d());
    }
}
