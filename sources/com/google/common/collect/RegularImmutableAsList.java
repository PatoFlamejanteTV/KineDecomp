package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableAsList
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        return this.delegateList.listIterator(i);
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return this.delegateList.toArray();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        return (T[]) this.delegateList.toArray(tArr);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(Object obj) {
        return this.delegateList.indexOf(obj);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(Object obj) {
        return this.delegateList.lastIndexOf(obj);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        return this.delegateList.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.delegateList.hashCode();
    }

    @Override // java.util.List
    public E get(int i) {
        return this.delegateList.get(i);
    }
}
