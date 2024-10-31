package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes.dex */
public abstract class Ordering<T> implements Comparator<T> {
    static final int LEFT_IS_GREATER = 1;
    static final int RIGHT_IS_GREATER = -1;

    /* loaded from: classes2.dex */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        static final Ordering<Object> f2750a = new a();
    }

    @Override // java.util.Comparator
    public abstract int compare(@Nullable T t, @Nullable T t2);

    @GwtCompatible
    public static <C extends Comparable> Ordering<C> natural() {
        return NaturalOrdering.INSTANCE;
    }

    @GwtCompatible
    public static <T> Ordering<T> from(Comparator<T> comparator) {
        return comparator instanceof Ordering ? (Ordering) comparator : new ComparatorOrdering(comparator);
    }

    @GwtCompatible
    @Deprecated
    public static <T> Ordering<T> from(Ordering<T> ordering) {
        return (Ordering) Preconditions.a(ordering);
    }

    @GwtCompatible
    public static <T> Ordering<T> explicit(List<T> list) {
        return new ExplicitOrdering(list);
    }

    @GwtCompatible
    public static <T> Ordering<T> explicit(T t, T... tArr) {
        return explicit(Lists.a(t, tArr));
    }

    @GwtCompatible
    public static Ordering<Object> allEqual() {
        return AllEqualOrdering.INSTANCE;
    }

    @GwtCompatible
    public static Ordering<Object> usingToString() {
        return UsingToStringOrdering.INSTANCE;
    }

    public static Ordering<Object> arbitrary() {
        return b.f2750a;
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class a extends Ordering<Object> {

        /* renamed from: a, reason: collision with root package name */
        private Map<Object, Integer> f2749a = cp.a(new MapMaker()).a(new co(this));

        a() {
        }

        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Object obj, Object obj2) {
            if (obj == obj2) {
                return 0;
            }
            if (obj == null) {
                return -1;
            }
            if (obj2 == null) {
                return 1;
            }
            int a2 = a(obj);
            int a3 = a(obj2);
            if (a2 != a3) {
                return a2 >= a3 ? 1 : -1;
            }
            int compareTo = this.f2749a.get(obj).compareTo(this.f2749a.get(obj2));
            if (compareTo == 0) {
                throw new AssertionError();
            }
            return compareTo;
        }

        public String toString() {
            return "Ordering.arbitrary()";
        }

        int a(Object obj) {
            return System.identityHashCode(obj);
        }
    }

    @GwtCompatible
    public <S extends T> Ordering<S> reverse() {
        return new ReverseOrdering(this);
    }

    @GwtCompatible
    public <S extends T> Ordering<S> nullsFirst() {
        return new NullsFirstOrdering(this);
    }

    @GwtCompatible
    public <S extends T> Ordering<S> nullsLast() {
        return new NullsLastOrdering(this);
    }

    @GwtCompatible
    public <F> Ordering<F> onResultOf(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }

    @GwtCompatible
    public <U extends T> Ordering<U> compound(Comparator<? super U> comparator) {
        return new CompoundOrdering(this, (Comparator) Preconditions.a(comparator));
    }

    @GwtCompatible
    public static <T> Ordering<T> compound(Iterable<? extends Comparator<? super T>> iterable) {
        return new CompoundOrdering(iterable);
    }

    @GwtCompatible
    public <S extends T> Ordering<Iterable<S>> lexicographical() {
        return new LexicographicalOrdering(this);
    }

    @Beta
    public <E extends T> E min(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) min(next, it.next());
        }
        return next;
    }

    public <E extends T> E min(Iterable<E> iterable) {
        return (E) min(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E min(@Nullable E e, @Nullable E e2) {
        return compare(e, e2) <= 0 ? e : e2;
    }

    public <E extends T> E min(@Nullable E e, @Nullable E e2, @Nullable E e3, E... eArr) {
        E e4 = (E) min(min(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) min(e4, e5);
        }
        return e4;
    }

    @Beta
    public <E extends T> E max(Iterator<E> it) {
        E next = it.next();
        while (it.hasNext()) {
            next = (E) max(next, it.next());
        }
        return next;
    }

    public <E extends T> E max(Iterable<E> iterable) {
        return (E) max(iterable.iterator());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public <E extends T> E max(@Nullable E e, @Nullable E e2) {
        return compare(e, e2) >= 0 ? e : e2;
    }

    public <E extends T> E max(@Nullable E e, @Nullable E e2, @Nullable E e3, E... eArr) {
        E e4 = (E) max(max(e, e2), e3);
        for (E e5 : eArr) {
            e4 = (E) max(e4, e5);
        }
        return e4;
    }

    @Beta
    public <E extends T> List<E> leastOf(Iterable<E> iterable, int i) {
        Preconditions.a(i >= 0, "%d is negative", Integer.valueOf(i));
        Object[] c = Iterables.c(iterable);
        if (c.length <= i) {
            Arrays.sort(c, this);
        } else {
            a(c, 0, c.length - 1, i);
            Object[] objArr = new Object[i];
            System.arraycopy(c, 0, objArr, 0, i);
            c = objArr;
        }
        return Collections.unmodifiableList(Arrays.asList(c));
    }

    @Beta
    public <E extends T> List<E> greatestOf(Iterable<E> iterable, int i) {
        return reverse().leastOf(iterable, i);
    }

    private <E extends T> void a(E[] eArr, int i, int i2, int i3) {
        if (i2 > i) {
            int b2 = b(eArr, i, i2, (i + i2) >>> 1);
            a(eArr, i, b2 - 1, i3);
            if (b2 < i3) {
                a(eArr, b2 + 1, i2, i3);
            }
        }
    }

    private <E extends T> int b(E[] eArr, int i, int i2, int i3) {
        E e = eArr[i3];
        eArr[i3] = eArr[i2];
        eArr[i2] = e;
        int i4 = i;
        while (i < i2) {
            if (compare(eArr[i], e) < 0) {
                ObjectArrays.a(eArr, i4, i);
                i4++;
            }
            i++;
        }
        ObjectArrays.a(eArr, i2, i4);
        return i4;
    }

    public <E extends T> List<E> sortedCopy(Iterable<E> iterable) {
        Object[] c = Iterables.c(iterable);
        Arrays.sort(c, this);
        return Lists.a((Iterable) Arrays.asList(c));
    }

    public <E extends T> ImmutableList<E> immutableSortedCopy(Iterable<E> iterable) {
        Object[] c = Iterables.c(iterable);
        for (Object obj : c) {
            Preconditions.a(obj);
        }
        Arrays.sort(c, this);
        return ImmutableList.asImmutableList(c);
    }

    public boolean isOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) > 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    public boolean isStrictlyOrdered(Iterable<? extends T> iterable) {
        Iterator<? extends T> it = iterable.iterator();
        if (it.hasNext()) {
            T next = it.next();
            while (it.hasNext()) {
                T next2 = it.next();
                if (compare(next, next2) >= 0) {
                    return false;
                }
                next = next2;
            }
        }
        return true;
    }

    public int binarySearch(List<? extends T> list, @Nullable T t) {
        return Collections.binarySearch(list, t, this);
    }

    @VisibleForTesting
    /* loaded from: classes2.dex */
    static class IncomparableValueException extends ClassCastException {
        private static final long serialVersionUID = 0;
        final Object value;

        /* JADX INFO: Access modifiers changed from: package-private */
        public IncomparableValueException(Object obj) {
            super("Cannot compare value: " + obj);
            this.value = obj;
        }
    }
}
