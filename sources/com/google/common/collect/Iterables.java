package com.google.common.collect;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public final class Iterables {
    private Iterables() {
    }

    private static <T> boolean a(List<T> list, Predicate<? super T> predicate) {
        int i = 0;
        int i2 = 0;
        while (i < list.size()) {
            T t = list.get(i);
            if (!predicate.apply(t)) {
                if (i > i2) {
                    try {
                        list.set(i2, t);
                    } catch (IllegalArgumentException unused) {
                        a(list, predicate, i2, i);
                        return true;
                    } catch (UnsupportedOperationException unused2) {
                        a(list, predicate, i2, i);
                        return true;
                    }
                }
                i2++;
            }
            i++;
        }
        list.subList(i2, list.size()).clear();
        return i != i2;
    }

    public static <T> T b(Iterable<T> iterable) {
        return (T) Iterators.d(iterable.iterator());
    }

    public static <T> Iterable<T> c(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.a(iterable);
        Preconditions.a(predicate);
        return new C1505fa(iterable, predicate);
    }

    @CanIgnoreReturnValue
    public static <T> boolean d(Iterable<T> iterable, Predicate<? super T> predicate) {
        if ((iterable instanceof RandomAccess) && (iterable instanceof List)) {
            Preconditions.a(predicate);
            return a((List) iterable, (Predicate) predicate);
        }
        return Iterators.e(iterable.iterator(), predicate);
    }

    public static String e(Iterable<?> iterable) {
        return Iterators.h(iterable.iterator());
    }

    private static <E> Collection<E> f(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.a(iterable.iterator());
    }

    @GwtIncompatible
    public static <T> T[] b(Iterable<? extends T> iterable, Class<T> cls) {
        return (T[]) a((Iterable) iterable, ObjectArrays.a((Class) cls, 0));
    }

    public static <T> boolean b(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.b((Iterator) iterable.iterator(), (Predicate) predicate);
    }

    public static boolean c(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] d(Iterable<?> iterable) {
        return f(iterable).toArray();
    }

    private static <T> void a(List<T> list, Predicate<? super T> predicate, int i, int i2) {
        for (int size = list.size() - 1; size > i2; size--) {
            if (predicate.apply(list.get(size))) {
                list.remove(size);
            }
        }
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            list.remove(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T[] a(Iterable<? extends T> iterable, T[] tArr) {
        return (T[]) f(iterable).toArray(tArr);
    }

    @CanIgnoreReturnValue
    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        if (iterable instanceof Collection) {
            return collection.addAll(Collections2.a(iterable));
        }
        Preconditions.a(iterable);
        return Iterators.a(collection, iterable.iterator());
    }

    @GwtIncompatible
    public static <T> Iterable<T> a(Iterable<?> iterable, Class<T> cls) {
        Preconditions.a(iterable);
        Preconditions.a(cls);
        return new C1508ga(iterable, cls);
    }

    public static <T> boolean a(Iterable<T> iterable, Predicate<? super T> predicate) {
        return Iterators.a(iterable.iterator(), predicate);
    }

    public static <F, T> Iterable<T> a(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        Preconditions.a(iterable);
        Preconditions.a(function);
        return new C1511ha(iterable, function);
    }

    @Nullable
    public static <T> T a(Iterable<? extends T> iterable, @Nullable T t) {
        return (T) Iterators.b(iterable.iterator(), t);
    }

    public static <T> T a(Iterable<T> iterable) {
        if (iterable instanceof List) {
            List list = (List) iterable;
            if (!list.isEmpty()) {
                return (T) a(list);
            }
            throw new NoSuchElementException();
        }
        return (T) Iterators.c(iterable.iterator());
    }

    private static <T> T a(List<T> list) {
        return list.get(list.size() - 1);
    }

    public static <T> Iterable<T> a(Iterable<T> iterable, int i) {
        Preconditions.a(iterable);
        Preconditions.a(i >= 0, "number to skip cannot be negative");
        if (iterable instanceof List) {
            return new C1514ia((List) iterable, i);
        }
        return new C1520ka(iterable, i);
    }
}
