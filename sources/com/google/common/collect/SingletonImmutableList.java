package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import java.util.List;
import javax.annotation.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@GwtCompatible
/* loaded from: classes2.dex */
public final class SingletonImmutableList<E> extends ImmutableList<E> {
    final transient E element;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SingletonImmutableList(E e) {
        this.element = (E) Preconditions.a(e);
    }

    @Override // java.util.List
    public E get(int i) {
        Preconditions.a(i, 1);
        return this.element;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int indexOf(@Nullable Object obj) {
        return this.element.equals(obj) ? 0 : -1;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public UnmodifiableIterator<E> iterator() {
        return Iterators.a(this.element);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public int lastIndexOf(@Nullable Object obj) {
        return indexOf(obj);
    }

    @Override // java.util.Collection, java.util.List
    public int size() {
        return 1;
    }

    @Override // com.google.common.collect.ImmutableList, java.util.List
    public ImmutableList<E> subList(int i, int i2) {
        Preconditions.a(i, i2, 1);
        return i == i2 ? ImmutableList.of() : this;
    }

    @Override // com.google.common.collect.ImmutableList
    public ImmutableList<E> reverse() {
        return this;
    }

    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public boolean contains(@Nullable Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list = (List) obj;
        return list.size() == 1 && this.element.equals(list.get(0));
    }

    @Override // com.google.common.collect.ImmutableList, java.util.Collection, java.util.List
    public int hashCode() {
        return this.element.hashCode() + 31;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public String toString() {
        String obj = this.element.toString();
        return new StringBuilder(obj.length() + 2).append('[').append(obj).append(']').toString();
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public Object[] toArray() {
        return new Object[]{this.element};
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
    public <T> T[] toArray(T[] tArr) {
        if (tArr.length == 0) {
            tArr = (T[]) ObjectArrays.a((Object[]) tArr, 1);
        } else if (tArr.length > 1) {
            tArr[1] = null;
        }
        tArr[0] = this.element;
        return tArr;
    }
}
