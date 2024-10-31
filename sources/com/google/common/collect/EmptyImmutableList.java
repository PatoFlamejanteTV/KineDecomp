package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class EmptyImmutableList extends ImmutableList<Object> {
    static final EmptyImmutableList INSTANCE = new EmptyImmutableList();
    private static final long serialVersionUID = 0;

    private EmptyImmutableList() {
    }

    @Override // java.util.Collection, java.util.List
    public int size() {
        return 0;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean containsAll(Collection<?> collection) {
        return collection.isEmpty();
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<Object> iterator() {
        return listIterator();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return ObjectArrays.f2748a;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    @Override // java.util.List
    public Object get(int i) {
        Preconditions.a(i, 0);
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@Nullable Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return -1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<Object> subList(int i, int i2) {
        Preconditions.a(i, i2, 0);
        return this;
    }

    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<Object> reverse() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<Object> listIterator() {
        return Iterators.f2706a;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<Object> listIterator(int i) {
        Preconditions.b(i, 0);
        return Iterators.f2706a;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public boolean equals(@Nullable Object obj) {
        if (obj instanceof List) {
            return ((List) obj).isEmpty();
        }
        return false;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public int hashCode() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        return "[]";
    }

    Object readResolve() {
        return INSTANCE;
    }
}
