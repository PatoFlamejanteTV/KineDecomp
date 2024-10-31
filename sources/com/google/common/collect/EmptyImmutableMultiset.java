package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.Multiset;
import java.util.Collection;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class EmptyImmutableMultiset extends ImmutableMultiset<Object> {
    static final EmptyImmutableMultiset INSTANCE = new EmptyImmutableMultiset();
    private static final long serialVersionUID = 0;

    EmptyImmutableMultiset() {
    }

    @Override // com.google.common.collect.Multiset
    public int count(@Nullable Object obj) {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<Object> iterator() {
        return Iterators.a();
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Multiset) {
            return ((Multiset) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableMultiset, java.util.Collection
    public int hashCode() {
        return 0;
    }

    @Override // com.google.common.collect.Multiset
    public ImmutableSet<Object> elementSet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
    public ImmutableSet<Multiset.Entry<Object>> entrySet() {
        return ImmutableSet.of();
    }

    @Override // com.google.common.collect.ImmutableMultiset
    ImmutableSet<Multiset.Entry<Object>> createEntrySet() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.Collection
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ObjectArrays.f2748a;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) asList().toArray(tArr);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<Object> asList() {
        return ImmutableList.of();
    }

    Object readResolve() {
        return INSTANCE;
    }
}
