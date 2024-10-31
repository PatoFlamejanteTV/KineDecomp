package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Preconditions;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Collections2 {

    /* renamed from: a, reason: collision with root package name */
    static final Joiner f2661a = Joiner.a(", ").b("null");

    private Collections2() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, Object obj) {
        try {
            return collection.contains(obj);
        } catch (ClassCastException e) {
            return false;
        }
    }

    public static <F, T> Collection<T> a(Collection<F> collection, Function<? super F, T> function) {
        return new a(collection, function);
    }

    /* loaded from: classes2.dex */
    static class a<F, T> extends AbstractCollection<T> {

        /* renamed from: a, reason: collision with root package name */
        final Collection<F> f2662a;
        final Function<? super F, ? extends T> b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Collection<F> collection, Function<? super F, ? extends T> function) {
            this.f2662a = (Collection) Preconditions.a(collection);
            this.b = (Function) Preconditions.a(function);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            this.f2662a.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f2662a.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator<T> iterator() {
            return Iterators.a(this.f2662a.iterator(), this.b);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f2662a.size();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Collection<?> collection, Collection<?> collection2) {
        Preconditions.a(collection);
        Iterator<?> it = collection2.iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Collection<?> collection) {
        StringBuilder append = a(collection.size()).append('[');
        f2661a.a(append, Iterables.a((Iterable) collection, (Function) new v(collection)));
        return append.append(']').toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static StringBuilder a(int i) {
        Preconditions.a(i >= 0, "size must be non-negative");
        return new StringBuilder((int) Math.min(i * 8, 1073741824L));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Collection<T> a(Iterable<T> iterable) {
        return (Collection) iterable;
    }
}
