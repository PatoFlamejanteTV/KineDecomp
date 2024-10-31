package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Iterators {

    /* renamed from: a */
    static final UnmodifiableListIterator<Object> f15474a = new C1529na();

    /* renamed from: b */
    private static final Iterator<Object> f15475b = new C1532oa();

    /* loaded from: classes2.dex */
    public static class a<T> extends UnmodifiableIterator<T> {

        /* renamed from: a */
        final Queue<PeekingIterator<T>> f15476a;

        public a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.f15476a = new PriorityQueue(2, new C1543sa(this, comparator));
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f15476a.add(Iterators.e(it));
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return !this.f15476a.isEmpty();
        }

        @Override // java.util.Iterator
        public T next() {
            PeekingIterator<T> remove = this.f15476a.remove();
            T next = remove.next();
            if (remove.hasNext()) {
                this.f15476a.add(remove);
            }
            return next;
        }
    }

    /* loaded from: classes2.dex */
    public static class b<E> implements PeekingIterator<E> {

        /* renamed from: a */
        private final Iterator<? extends E> f15477a;

        /* renamed from: b */
        private boolean f15478b;

        /* renamed from: c */
        private E f15479c;

        public b(Iterator<? extends E> it) {
            Preconditions.a(it);
            this.f15477a = it;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f15478b || this.f15477a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.f15478b) {
                return this.f15477a.next();
            }
            E e2 = this.f15479c;
            this.f15478b = false;
            this.f15479c = null;
            return e2;
        }

        @Override // com.google.common.collect.PeekingIterator
        public E peek() {
            if (!this.f15478b) {
                this.f15479c = this.f15477a.next();
                this.f15478b = true;
            }
            return this.f15479c;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(!this.f15478b, "Can't remove after you've peeked at next");
            this.f15477a.remove();
        }
    }

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> a() {
        return b();
    }

    static <T> UnmodifiableListIterator<T> b() {
        return (UnmodifiableListIterator<T>) f15474a;
    }

    public static <T> Iterator<T> c() {
        return (Iterator<T>) f15475b;
    }

    @CanIgnoreReturnValue
    public static <T> T d(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <");
        sb.append(next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", ");
            sb.append(it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    @CanIgnoreReturnValue
    public static <T> boolean e(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.a(predicate);
        boolean z = false;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    @Nullable
    public static <T> T f(Iterator<T> it) {
        if (!it.hasNext()) {
            return null;
        }
        T next = it.next();
        it.remove();
        return next;
    }

    public static int g(Iterator<?> it) {
        long j = 0;
        while (it.hasNext()) {
            it.next();
            j++;
        }
        return Ints.b(j);
    }

    public static String h(Iterator<?> it) {
        Joiner joiner = Collections2.f15349a;
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        StringBuilder a2 = joiner.a(sb, it);
        a2.append(']');
        return a2.toString();
    }

    public static <T> UnmodifiableIterator<T> i(Iterator<? extends T> it) {
        Preconditions.a(it);
        if (it instanceof UnmodifiableIterator) {
            return (UnmodifiableIterator) it;
        }
        return new C1535pa(it);
    }

    public static boolean a(Iterator<?> it, @Nullable Object obj) {
        return b((Iterator) it, Predicates.a(obj));
    }

    @CanIgnoreReturnValue
    public static boolean b(Iterator<?> it, Collection<?> collection) {
        return e(it, Predicates.a(Predicates.a((Collection) collection)));
    }

    public static <T> UnmodifiableIterator<T> c(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.a(it);
        Preconditions.a(predicate);
        return new C1538qa(it, predicate);
    }

    @CanIgnoreReturnValue
    public static boolean a(Iterator<?> it, Collection<?> collection) {
        return e(it, Predicates.a((Collection) collection));
    }

    public static <T> boolean b(Iterator<T> it, Predicate<? super T> predicate) {
        return d(it, predicate) != -1;
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    @Nullable
    public static <T> T b(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? it.next() : t;
    }

    public static void b(Iterator<?> it) {
        Preconditions.a(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> T c(Iterator<T> it) {
        T next;
        do {
            next = it.next();
        } while (it.hasNext());
        return next;
    }

    public static <T> PeekingIterator<T> e(Iterator<? extends T> it) {
        if (it instanceof b) {
            return (b) it;
        }
        return new b(it);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.a(collection);
        Preconditions.a(it);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> int d(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.a(predicate, "predicate");
        int i = 0;
        while (it.hasNext()) {
            if (predicate.apply(it.next())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @GwtIncompatible
    public static <T> UnmodifiableIterator<T> a(Iterator<?> it, Class<T> cls) {
        return c(it, Predicates.a((Class<?>) cls));
    }

    public static <T> boolean a(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.a(predicate);
        while (it.hasNext()) {
            if (!predicate.apply(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, Function<? super F, ? extends T> function) {
        Preconditions.a(function);
        return new C1540ra(it, function);
    }

    @CanIgnoreReturnValue
    public static int a(Iterator<?> it, int i) {
        Preconditions.a(it);
        int i2 = 0;
        Preconditions.a(i >= 0, "numberToAdvance must be nonnegative");
        while (i2 < i && it.hasNext()) {
            it.next();
            i2++;
        }
        return i2;
    }

    @SafeVarargs
    public static <T> UnmodifiableIterator<T> a(T... tArr) {
        return a(tArr, 0, tArr.length, 0);
    }

    public static <T> UnmodifiableListIterator<T> a(T[] tArr, int i, int i2, int i3) {
        Preconditions.a(i2 >= 0);
        Preconditions.a(i, i + i2, tArr.length);
        Preconditions.b(i3, i2);
        if (i2 == 0) {
            return b();
        }
        return new C1523la(i2, i3, tArr, i);
    }

    public static <T> UnmodifiableIterator<T> a(@Nullable T t) {
        return new C1526ma(t);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.a(iterable, "iterators");
        Preconditions.a(comparator, "comparator");
        return new a(iterable, comparator);
    }

    public static <T> ListIterator<T> a(Iterator<T> it) {
        return (ListIterator) it;
    }
}
