package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableSet;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements ct<E>, SortedSet<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f2704a = Ordering.natural();
    private static final ImmutableSortedSet<Comparable> b = new EmptyImmutableSortedSet(f2704a);
    final transient Comparator<? super E> comparator;

    @GwtIncompatible
    transient ImmutableSortedSet<E> descendingSet;

    @GwtIncompatible
    abstract ImmutableSortedSet<E> createDescendingSet();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract ImmutableSortedSet<E> headSetImpl(E e, boolean z);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int indexOf(@Nullable Object obj);

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public abstract UnmodifiableIterator<E> iterator();

    abstract ImmutableSortedSet<E> subSetImpl(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> tailSetImpl(E e, boolean z);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet((ImmutableSortedSet<E>) obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet((ImmutableSortedSet<E>) obj);
    }

    private static <E> ImmutableSortedSet<E> a() {
        return (ImmutableSortedSet<E>) b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableSortedSet<E> emptySet(Comparator<? super E> comparator) {
        return f2704a.equals(comparator) ? a() : new EmptyImmutableSortedSet(comparator);
    }

    public static <E> ImmutableSortedSet<E> of() {
        return a();
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable) {
        return new RegularImmutableSortedSet(ImmutableList.of(comparable), Ordering.natural());
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2) {
        return copyOf((Comparator) Ordering.natural(), (Collection) Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf((Comparator) Ordering.natural(), (Collection) Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf((Comparator) Ordering.natural(), (Collection) Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf((Comparator) Ordering.natural(), (Collection) Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList arrayList = new ArrayList(comparableArr.length + 6);
        Collections.addAll(arrayList, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(arrayList, comparableArr);
        return copyOf((Comparator) Ordering.natural(), (Collection) arrayList);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedSet<TE;>; */
    public static ImmutableSortedSet copyOf(Comparable[] comparableArr) {
        return copyOf((Comparator) Ordering.natural(), (Collection) Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Collection<? extends E> collection) {
        return copyOf((Comparator) Ordering.natural(), (Collection) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        return copyOf((Comparator) comparator, (Collection) Lists.a(it));
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        Preconditions.a(comparator);
        if (cu.a(comparator, iterable) && (iterable instanceof ImmutableSortedSet)) {
            ImmutableSortedSet<E> immutableSortedSet = (ImmutableSortedSet) iterable;
            if (!immutableSortedSet.isPartialView()) {
                return immutableSortedSet;
            }
        }
        Object[] c = Iterables.c(iterable);
        return construct(comparator, c.length, c);
    }

    public static <E> ImmutableSortedSet<E> copyOf(Comparator<? super E> comparator, Collection<? extends E> collection) {
        return copyOf((Comparator) comparator, (Iterable) collection);
    }

    public static <E> ImmutableSortedSet<E> copyOfSorted(SortedSet<E> sortedSet) {
        Comparator a2 = cu.a(sortedSet);
        Object[] array = sortedSet.toArray();
        return array.length == 0 ? emptySet(a2) : new RegularImmutableSortedSet(ImmutableList.asImmutableList(array), a2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static <E> int sortAndUnique(Comparator<? super E> comparator, int i, E... eArr) {
        int i2;
        int i3 = 0;
        if (i != 0) {
            for (int i4 = 0; i4 < i; i4++) {
                ObjectArrays.a((Object) eArr[i4], i4);
            }
            Arrays.sort(eArr, 0, i, comparator);
            int i5 = 1;
            i3 = 1;
            while (i5 < i) {
                a.a aVar = (Object) eArr[i5];
                if (comparator.compare(aVar, (Object) eArr[i3 - 1]) != 0) {
                    i2 = i3 + 1;
                    eArr[i3] = aVar;
                } else {
                    i2 = i3;
                }
                i5++;
                i3 = i2;
            }
            Arrays.fill(eArr, i3, i, (Object) null);
        }
        return i3;
    }

    static <E> ImmutableSortedSet<E> construct(Comparator<? super E> comparator, int i, E... eArr) {
        int sortAndUnique = sortAndUnique(comparator, i, eArr);
        if (sortAndUnique == 0) {
            return emptySet(comparator);
        }
        if (sortAndUnique < eArr.length) {
            eArr = (E[]) ObjectArrays.b(eArr, sortAndUnique);
        }
        return new RegularImmutableSortedSet(ImmutableList.asImmutableList(eArr), comparator);
    }

    public static <E> Builder<E> orderedBy(Comparator<E> comparator) {
        return new Builder<>(comparator);
    }

    public static <E extends Comparable<E>> Builder<E> reverseOrder() {
        return new Builder<>(Ordering.natural().reverse());
    }

    public static <E extends Comparable<E>> Builder<E> naturalOrder() {
        return new Builder<>(Ordering.natural());
    }

    /* loaded from: classes2.dex */
    public static final class Builder<E> extends ImmutableSet.Builder<E> {
        private final Comparator<? super E> c;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return c((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableSet.Builder
        public /* synthetic */ ImmutableSet.Builder b(Object obj) {
            return c((Builder<E>) obj);
        }

        public Builder(Comparator<? super E> comparator) {
            this.c = (Comparator) Preconditions.a(comparator);
        }

        public Builder<E> c(E e) {
            super.b((Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(E... eArr) {
            super.a((Object[]) eArr);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterable<? extends E> iterable) {
            super.a((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        @Override // com.google.common.collect.ImmutableSet.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedSet<E> a() {
            ImmutableSortedSet<E> construct = ImmutableSortedSet.construct(this.c, this.b, this.f2700a);
            this.b = construct.size();
            return construct;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int unsafeCompare(Object obj, Object obj2) {
        return unsafeCompare(this.comparator, obj, obj2);
    }

    static int unsafeCompare(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ImmutableSortedSet(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    @Override // com.google.common.collect.ct
    public Comparator<? super E> comparator() {
        return this.comparator;
    }

    public ImmutableSortedSet<E> headSet(E e) {
        return headSet(e, false);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ImmutableSortedSet<E> headSet(E e, boolean z) {
        return headSetImpl(Preconditions.a(e), z);
    }

    @Override // java.util.SortedSet
    public ImmutableSortedSet<E> subSet(E e, E e2) {
        return subSet(e, true, e2, false);
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> subSet(E e, boolean z, E e2, boolean z2) {
        Preconditions.a(e);
        Preconditions.a(e2);
        Preconditions.a(this.comparator.compare(e, e2) <= 0);
        return subSetImpl(e, z, e2, z2);
    }

    public ImmutableSortedSet<E> tailSet(E e) {
        return tailSet(e, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @GwtIncompatible
    public ImmutableSortedSet<E> tailSet(E e, boolean z) {
        return tailSetImpl(Preconditions.a(e), z);
    }

    @GwtIncompatible
    public E lower(E e) {
        return (E) Iterables.a(headSet(e, false).descendingSet(), (Object) null);
    }

    @GwtIncompatible
    public E floor(E e) {
        return (E) Iterables.a(headSet(e, true).descendingSet(), (Object) null);
    }

    @GwtIncompatible
    public E ceiling(E e) {
        return (E) Iterables.a(tailSet(e, true), (Object) null);
    }

    @GwtIncompatible
    public E higher(E e) {
        return (E) Iterables.a(tailSet(e, false), (Object) null);
    }

    @GwtIncompatible
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    @GwtIncompatible
    public ImmutableSortedSet<E> descendingSet() {
        ImmutableSortedSet<E> immutableSortedSet = this.descendingSet;
        if (immutableSortedSet == null) {
            ImmutableSortedSet<E> createDescendingSet = createDescendingSet();
            this.descendingSet = createDescendingSet;
            createDescendingSet.descendingSet = this;
            return createDescendingSet;
        }
        return immutableSortedSet;
    }

    @GwtIncompatible
    public UnmodifiableIterator<E> descendingIterator() {
        return descendingSet().iterator();
    }

    /* loaded from: classes2.dex */
    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            return new Builder(this.comparator).a(this.elements).a();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this.comparator, toArray());
    }
}
