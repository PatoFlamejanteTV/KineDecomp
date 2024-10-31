package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.Collection;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public abstract class TransformedImmutableSet<D, E> extends ImmutableSet<E> {
    final int hashCode;
    final ImmutableCollection<D> source;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract E transform(D d);

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedImmutableSet(ImmutableCollection<D> immutableCollection) {
        this.source = immutableCollection;
        this.hashCode = Sets.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TransformedImmutableSet(ImmutableCollection<D> immutableCollection, int i) {
        this.source = immutableCollection;
        this.hashCode = i;
    }

    @Override // java.util.Collection, java.util.Set
    public int size() {
        return this.source.size();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return new dj(this, this.source.iterator());
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.a((Collection<?>) this, (Object[]) tArr);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.hashCode;
    }

    @Override // com.google.common.collect.ImmutableSet
    @GwtIncompatible
    boolean isHashCodeFast() {
        return true;
    }
}
