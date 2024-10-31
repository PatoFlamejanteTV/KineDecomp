package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Collections2 {

    /* renamed from: a, reason: collision with root package name */
    static final Joiner f15349a = Joiner.a(", ").b("null");

    /* loaded from: classes2.dex */
    static class a<E> extends AbstractCollection<E> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<E> f15350a;

        /* renamed from: b, reason: collision with root package name */
        final Predicate<? super E> f15351b;

        a(Collection<E> collection, Predicate<? super E> predicate) {
            this.f15350a = collection;
            this.f15351b = predicate;
        }

        a<E> a(Predicate<? super E> predicate) {
            return new a<>(this.f15350a, Predicates.a(this.f15351b, predicate));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(E e2) {
            Preconditions.a(this.f15351b.apply(e2));
            return this.f15350a.add(e2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection<? extends E> collection) {
            Iterator<? extends E> it = collection.iterator();
            while (it.hasNext()) {
                Preconditions.a(this.f15351b.apply(it.next()));
            }
            return this.f15350a.addAll(collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            Iterables.d(this.f15350a, this.f15351b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(@Nullable Object obj) {
            if (Collections2.a((Collection<?>) this.f15350a, obj)) {
                return this.f15351b.apply(obj);
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return Collections2.a((Collection<?>) this, collection);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return !Iterables.b(this.f15350a, this.f15351b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<E> iterator() {
            return Iterators.c(this.f15350a.iterator(), this.f15351b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            return contains(obj) && this.f15350a.remove(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return Iterables.d(this.f15350a, Predicates.a(this.f15351b, Predicates.a((Collection) collection)));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return Iterables.d(this.f15350a, Predicates.a(this.f15351b, Predicates.a(Predicates.a((Collection) collection))));
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return Iterators.g(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public Object[] toArray() {
            return Lists.a(iterator()).toArray();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) Lists.a(iterator()).toArray(tArr);
        }
    }

    /* loaded from: classes2.dex */
    static class b<F, T> extends AbstractCollection<T> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<F> f15352a;

        /* renamed from: b, reason: collision with root package name */
        final Function<? super F, ? extends T> f15353b;

        b(Collection<F> collection, Function<? super F, ? extends T> function) {
            Preconditions.a(collection);
            this.f15352a = collection;
            Preconditions.a(function);
            this.f15353b = function;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f15352a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f15352a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.a(this.f15352a.iterator(), this.f15353b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f15352a.size();
        }
    }

    private Collections2() {
    }

    public static <E> Collection<E> a(Collection<E> collection, Predicate<? super E> predicate) {
        if (collection instanceof a) {
            return ((a) collection).a(predicate);
        }
        Preconditions.a(collection);
        Preconditions.a(predicate);
        return new a(collection, predicate);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean b(Collection<?> collection, @Nullable Object obj) {
        Preconditions.a(collection);
        try {
            return collection.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, @Nullable Object obj) {
        Preconditions.a(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public static <F, T> Collection<T> a(Collection<F> collection, Function<? super F, T> function) {
        return new b(collection, function);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        return Iterables.a((Iterable) collection2, Predicates.a((Collection) collection));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Collection<?> collection) {
        StringBuilder a2 = a(collection.size());
        a2.append('[');
        f15349a.a(a2, Iterables.a((Iterable) collection, (Function) new C1557y(collection)));
        a2.append(']');
        return a2.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(int i) {
        C1555x.a(i, "size");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
