package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Iterables {
    private Iterables() {
    }

    public static String a(Iterable<?> iterable) {
        return Iterators.b(iterable.iterator());
    }

    public static <T> T b(Iterable<T> iterable) {
        return (T) Iterators.c(iterable.iterator());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Object[] c(Iterable<?> iterable) {
        return e(iterable).toArray();
    }

    private static <E> Collection<E> e(Iterable<E> iterable) {
        return iterable instanceof Collection ? (Collection) iterable : Lists.a(iterable.iterator());
    }

    public static <T> boolean a(Collection<T> collection, Iterable<? extends T> iterable) {
        return iterable instanceof Collection ? collection.addAll(Collections2.a(iterable)) : Iterators.a(collection, iterable.iterator());
    }

    public static <T> Iterable<T> a(Iterable<T> iterable, Predicate<? super T> predicate) {
        Preconditions.a(iterable);
        Preconditions.a(predicate);
        return new aj(iterable, predicate);
    }

    public static <F, T> Iterable<T> a(Iterable<F> iterable, Function<? super F, ? extends T> function) {
        Preconditions.a(iterable);
        Preconditions.a(function);
        return new ak(iterable, function);
    }

    public static <T> T a(Iterable<? extends T> iterable, @Nullable T t) {
        return (T) Iterators.b(iterable.iterator(), t);
    }

    public static boolean d(Iterable<?> iterable) {
        if (iterable instanceof Collection) {
            return ((Collection) iterable).isEmpty();
        }
        return !iterable.iterator().hasNext();
    }
}
