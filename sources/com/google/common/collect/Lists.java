package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.primitives.Ints;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Lists {
    private Lists() {
    }

    @GwtCompatible
    public static <E> ArrayList<E> a() {
        return new ArrayList<>();
    }

    @VisibleForTesting
    static int a(int i) {
        Preconditions.a(i >= 0);
        return Ints.a(5 + i + (i / 10));
    }

    @GwtCompatible
    public static <E> ArrayList<E> a(Iterable<? extends E> iterable) {
        Preconditions.a(iterable);
        return iterable instanceof Collection ? new ArrayList<>(Collections2.a(iterable)) : a(iterable.iterator());
    }

    @GwtCompatible
    public static <E> ArrayList<E> a(Iterator<? extends E> it) {
        Preconditions.a(it);
        ArrayList<E> a2 = a();
        while (it.hasNext()) {
            a2.add(it.next());
        }
        return a2;
    }

    @GwtCompatible
    public static <E> ArrayList<E> b(int i) {
        Preconditions.a(i >= 0);
        return new ArrayList<>(i);
    }

    @GwtCompatible
    public static <E> ArrayList<E> c(int i) {
        return new ArrayList<>(a(i));
    }

    @GwtCompatible
    public static <E> LinkedList<E> b() {
        return new LinkedList<>();
    }

    public static <E> List<E> a(@Nullable E e, E[] eArr) {
        return new OnePlusArrayList(e, eArr);
    }

    /* loaded from: classes2.dex */
    private static class OnePlusArrayList<E> extends AbstractList<E> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final E first;
        final E[] rest;

        OnePlusArrayList(@Nullable E e, E[] eArr) {
            this.first = e;
            this.rest = (E[]) ((Object[]) Preconditions.a(eArr));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.rest.length + 1;
        }

        @Override // java.util.AbstractList, java.util.List
        public E get(int i) {
            Preconditions.a(i, size());
            return i == 0 ? this.first : this.rest[i - 1];
        }
    }

    public static <F, T> List<T> a(List<F> list, Function<? super F, ? extends T> function) {
        return list instanceof RandomAccess ? new TransformingRandomAccessList(list, function) : new TransformingSequentialList(list, function);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class TransformingSequentialList<F, T> extends AbstractSequentialList<T> implements Serializable {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingSequentialList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.a(list);
            this.function = (Function) Preconditions.a(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }

        @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
        public ListIterator<T> listIterator(int i) {
            return new bi(this, this.fromList.listIterator(i));
        }
    }

    /* loaded from: classes2.dex */
    private static class TransformingRandomAccessList<F, T> extends AbstractList<T> implements Serializable, RandomAccess {
        private static final long serialVersionUID = 0;
        final List<F> fromList;
        final Function<? super F, ? extends T> function;

        TransformingRandomAccessList(List<F> list, Function<? super F, ? extends T> function) {
            this.fromList = (List) Preconditions.a(list);
            this.function = (Function) Preconditions.a(function);
        }

        @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
        public void clear() {
            this.fromList.clear();
        }

        @Override // java.util.AbstractList, java.util.List
        public T get(int i) {
            return this.function.apply(this.fromList.get(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean isEmpty() {
            return this.fromList.isEmpty();
        }

        @Override // java.util.AbstractList, java.util.List
        public T remove(int i) {
            return this.function.apply(this.fromList.remove(i));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.fromList.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int a(List<?> list) {
        int i = 1;
        Iterator<?> it = list.iterator();
        while (it.hasNext()) {
            Object next = it.next();
            i = (next == null ? 0 : next.hashCode()) + (i * 31);
        }
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(List<?> list, @Nullable Object obj) {
        if (obj == Preconditions.a(list)) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        List list2 = (List) obj;
        return list.size() == list2.size() && Iterators.a(list.iterator(), (Iterator<?>) list2.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int b(List<?> list, @Nullable Object obj) {
        ListIterator<?> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            if (Objects.a(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int c(List<?> list, @Nullable Object obj) {
        ListIterator<?> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()) {
            if (Objects.a(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }
}
