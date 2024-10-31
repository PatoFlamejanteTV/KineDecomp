package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableCollection<E> implements Serializable, Collection<E> {
    static final ImmutableCollection<Object> EMPTY_IMMUTABLE_COLLECTION = new EmptyImmutableCollection();

    /* renamed from: a, reason: collision with root package name */
    private transient ImmutableList<E> f2687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract boolean isPartialView();

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    public Object[] toArray() {
        return ObjectArrays.a(this);
    }

    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.a((Collection<?>) this, (Object[]) tArr);
    }

    public boolean contains(@Nullable Object obj) {
        return obj != null && Iterators.a(iterator(), obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return Collections2.a((Collection<?>) this, collection);
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public String toString() {
        return Collections2.a((Collection<?>) this);
    }

    @Override // java.util.Collection
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Collection
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.f2687a;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.f2687a = createAsList;
        return createAsList;
    }

    ImmutableList<E> createAsList() {
        switch (size()) {
            case 0:
                return ImmutableList.of();
            case 1:
                return ImmutableList.of((Object) iterator().next());
            default:
                return new RegularImmutableAsList(this, toArray());
        }
    }

    /* loaded from: classes2.dex */
    private static class EmptyImmutableCollection extends ImmutableCollection<Object> {

        /* renamed from: a, reason: collision with root package name */
        private static final Object[] f2688a = new Object[0];

        private EmptyImmutableCollection() {
        }

        @Override // java.util.Collection
        public int size() {
            return 0;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public boolean contains(@Nullable Object obj) {
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<Object> iterator() {
            return Iterators.f2706a;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public Object[] toArray() {
            return f2688a;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.List
        public <T> T[] toArray(T[] tArr) {
            if (tArr.length > 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<Object> createAsList() {
            return ImmutableList.of();
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class ArrayImmutableCollection<E> extends ImmutableCollection<E> {
        private final E[] elements;

        ArrayImmutableCollection(E[] eArr) {
            this.elements = eArr;
        }

        @Override // java.util.Collection
        public int size() {
            return this.elements.length;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return false;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public UnmodifiableIterator<E> iterator() {
            return Iterators.a((Object[]) this.elements);
        }

        @Override // com.google.common.collect.ImmutableCollection
        ImmutableList<E> createAsList() {
            return this.elements.length == 1 ? new SingletonImmutableList(this.elements[0]) : new RegularImmutableList(this.elements);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean isPartialView() {
            return false;
        }
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return this.elements.length == 0 ? ImmutableCollection.EMPTY_IMMUTABLE_COLLECTION : new ArrayImmutableCollection(cp.a(this.elements));
        }
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    /* loaded from: classes2.dex */
    public static abstract class Builder<E> {
        public abstract Builder<E> a(E e);

        /* JADX INFO: Access modifiers changed from: package-private */
        @VisibleForTesting
        public static int a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = (i >> 1) + i + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        public Builder<E> a(Iterable<? extends E> iterable) {
            Iterator<? extends E> it = iterable.iterator();
            while (it.hasNext()) {
                a((Builder<E>) it.next());
            }
            return this;
        }

        public Builder<E> a(Iterator<? extends E> it) {
            while (it.hasNext()) {
                a((Builder<E>) it.next());
            }
            return this;
        }
    }
}
