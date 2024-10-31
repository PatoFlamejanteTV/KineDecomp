package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

@Beta
@GwtIncompatible
/* loaded from: classes2.dex */
public abstract class ImmutableSortedMultiset<E> extends ImmutableSortedMultisetFauxverideShim<E> implements SortedMultiset<E> {

    /* renamed from: a, reason: collision with root package name */
    private static final Comparator<Comparable> f2703a = Ordering.natural();
    private static final ImmutableSortedMultiset<Comparable> b = new EmptyImmutableSortedMultiset(f2703a);
    transient ImmutableSortedMultiset<E> descendingMultiset;

    @Override // com.google.common.collect.Multiset
    public abstract ImmutableSortedSet<E> elementSet();

    public abstract ImmutableSortedMultiset<E> headMultiset(E e, BoundType boundType);

    public abstract ImmutableSortedMultiset<E> tailMultiset(E e, BoundType boundType);

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset headMultiset(Object obj, BoundType boundType) {
        return headMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return subMultiset((BoundType) obj, boundType, (BoundType) obj2, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* bridge */ /* synthetic */ SortedMultiset tailMultiset(Object obj, BoundType boundType) {
        return tailMultiset((ImmutableSortedMultiset<E>) obj, boundType);
    }

    public static <E> ImmutableSortedMultiset<E> of() {
        return (ImmutableSortedMultiset<E>) b;
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable) {
        return new RegularImmutableSortedMultiset((RegularImmutableSortedSet) ImmutableSortedSet.of(comparable), new int[]{1}, new long[]{0, 1}, 0, 1);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5) {
        return copyOf(Ordering.natural(), Arrays.asList(comparable, comparable2, comparable3, comparable4, comparable5));
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>(TE;TE;TE;TE;TE;TE;[TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset of(Comparable comparable, Comparable comparable2, Comparable comparable3, Comparable comparable4, Comparable comparable5, Comparable comparable6, Comparable... comparableArr) {
        ArrayList b2 = Lists.b(comparableArr.length + 6);
        Collections.addAll(b2, comparable, comparable2, comparable3, comparable4, comparable5, comparable6);
        Collections.addAll(b2, comparableArr);
        return copyOf(Ordering.natural(), b2);
    }

    /* JADX WARN: Incorrect types in method signature: <E::Ljava/lang/Comparable<-TE;>;>([TE;)Lcom/google/common/collect/ImmutableSortedMultiset<TE;>; */
    public static ImmutableSortedMultiset copyOf(Comparable[] comparableArr) {
        return copyOf(Ordering.natural(), Arrays.asList(comparableArr));
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterable<? extends E> iterable) {
        return copyOf(Ordering.natural(), iterable);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Iterator<? extends E> it) {
        return copyOf(Ordering.natural(), it);
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterator<? extends E> it) {
        Preconditions.a(comparator);
        return new Builder(comparator).a((Iterator) it).a();
    }

    public static <E> ImmutableSortedMultiset<E> copyOf(Comparator<? super E> comparator, Iterable<? extends E> iterable) {
        if (iterable instanceof ImmutableSortedMultiset) {
            ImmutableSortedMultiset<E> immutableSortedMultiset = (ImmutableSortedMultiset) iterable;
            if (comparator.equals(immutableSortedMultiset.comparator())) {
                if (immutableSortedMultiset.isPartialView()) {
                    return a(comparator, immutableSortedMultiset.entrySet().asList());
                }
                return immutableSortedMultiset;
            }
        }
        ArrayList a2 = Lists.a(iterable);
        TreeMultiset create = TreeMultiset.create((Comparator) Preconditions.a(comparator));
        Iterables.a((Collection) create, (Iterable) a2);
        return a(comparator, create.entrySet());
    }

    public static <E> ImmutableSortedMultiset<E> copyOfSorted(SortedMultiset<E> sortedMultiset) {
        return a(sortedMultiset.comparator(), Lists.a(sortedMultiset.entrySet()));
    }

    private static <E> ImmutableSortedMultiset<E> a(Comparator<? super E> comparator, Collection<Multiset.Entry<E>> collection) {
        if (collection.isEmpty()) {
            return emptyMultiset(comparator);
        }
        ImmutableList.Builder builder = new ImmutableList.Builder(collection.size());
        int[] iArr = new int[collection.size()];
        long[] jArr = new long[collection.size() + 1];
        int i = 0;
        for (Multiset.Entry<E> entry : collection) {
            builder.b((ImmutableList.Builder) entry.getElement());
            iArr[i] = entry.getCount();
            jArr[i + 1] = jArr[i] + iArr[i];
            i++;
        }
        return new RegularImmutableSortedMultiset(new RegularImmutableSortedSet(builder.a(), comparator), iArr, jArr, 0, collection.size());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <E> ImmutableSortedMultiset<E> emptyMultiset(Comparator<? super E> comparator) {
        return f2703a.equals(comparator) ? (ImmutableSortedMultiset<E>) b : new EmptyImmutableSortedMultiset(comparator);
    }

    @Override // com.google.common.collect.SortedMultiset, com.google.common.collect.ct
    public final Comparator<? super E> comparator() {
        return elementSet().comparator();
    }

    public ImmutableSortedMultiset<E> descendingMultiset() {
        ImmutableSortedMultiset<E> immutableSortedMultiset = this.descendingMultiset;
        if (immutableSortedMultiset == null) {
            DescendingImmutableSortedMultiset descendingImmutableSortedMultiset = new DescendingImmutableSortedMultiset(this);
            this.descendingMultiset = descendingImmutableSortedMultiset;
            return descendingImmutableSortedMultiset;
        }
        return immutableSortedMultiset;
    }

    public final Multiset.Entry<E> pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    public final Multiset.Entry<E> pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.SortedMultiset
    public ImmutableSortedMultiset<E> subMultiset(E e, BoundType boundType, E e2, BoundType boundType2) {
        Preconditions.a(comparator().compare(e, e2) <= 0, "Expected lowerBound <= upperBound but %s > %s", e, e2);
        return tailMultiset((ImmutableSortedMultiset<E>) e, boundType).headMultiset((ImmutableSortedMultiset<E>) e2, boundType2);
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
    public static class Builder<E> extends ImmutableMultiset.Builder<E> {
        private final Comparator<? super E> b;

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder, com.google.common.collect.ImmutableCollection.Builder
        public /* synthetic */ ImmutableCollection.Builder a(Object obj) {
            return c((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableMultiset.Builder
        public /* synthetic */ ImmutableMultiset.Builder b(Object obj) {
            return c((Builder<E>) obj);
        }

        public Builder(Comparator<? super E> comparator) {
            super(TreeMultiset.create(comparator));
            this.b = (Comparator) Preconditions.a(comparator);
        }

        public Builder<E> c(E e) {
            super.b((Builder<E>) e);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(E e, int i) {
            super.a((Builder<E>) e, i);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterable<? extends E> iterable) {
            super.a((Iterable) iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMultiset.Builder
        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder<E> a(Iterator<? extends E> it) {
            super.a((Iterator) it);
            return this;
        }

        public ImmutableSortedMultiset<E> a() {
            return ImmutableSortedMultiset.copyOfSorted((SortedMultiset) this.f2698a);
        }
    }

    /* loaded from: classes2.dex */
    private static final class SerializedForm implements Serializable {
        Comparator comparator;
        int[] counts;
        Object[] elements;

        SerializedForm(SortedMultiset<?> sortedMultiset) {
            this.comparator = sortedMultiset.comparator();
            int size = sortedMultiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            Iterator<Multiset.Entry<?>> it = sortedMultiset.entrySet().iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    Multiset.Entry<?> next = it.next();
                    this.elements[i2] = next.getElement();
                    this.counts[i2] = next.getCount();
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        Object readResolve() {
            int length = this.elements.length;
            Builder orderedBy = ImmutableSortedMultiset.orderedBy(this.comparator);
            for (int i = 0; i < length; i++) {
                orderedBy.a(this.elements[i], this.counts[i]);
            }
            return orderedBy.a();
        }
    }

    @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(this);
    }
}
