package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.PriorityQueue;
import java.util.Queue;
import javax.annotation.Nullable;

@GwtCompatible
/* loaded from: classes2.dex */
public final class Iterators {

    /* renamed from: a, reason: collision with root package name */
    static final UnmodifiableListIterator<Object> f2706a = new al();
    private static final Iterator<Object> b = new ap();

    private Iterators() {
    }

    public static <T> UnmodifiableIterator<T> a() {
        return b();
    }

    static <T> UnmodifiableListIterator<T> b() {
        return (UnmodifiableListIterator<T>) f2706a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> Iterator<T> c() {
        return (Iterator<T>) b;
    }

    public static int a(Iterator<?> it) {
        int i = 0;
        while (it.hasNext()) {
            it.next();
            i++;
        }
        return i;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:            return false;     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0014, code lost:            if (r2.hasNext() == false) goto L18;     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001e, code lost:            if (r3.equals(r2.next()) == false) goto L20;     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:            return true;     */
    /* JADX WARN: Code restructure failed: missing block: B:2:0x0001, code lost:            if (r3 == null) goto L4;     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0007, code lost:            if (r2.hasNext() == false) goto L15;     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x000d, code lost:            if (r2.next() != null) goto L17;     */
    /* JADX WARN: Code restructure failed: missing block: B:8:?, code lost:            return true;     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.util.Iterator<?> r2, @javax.annotation.Nullable java.lang.Object r3) {
        /*
            r0 = 1
            if (r3 != 0) goto L10
        L3:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L21
            java.lang.Object r1 = r2.next()
            if (r1 != 0) goto L3
        Lf:
            return r0
        L10:
            boolean r1 = r2.hasNext()
            if (r1 == 0) goto L21
            java.lang.Object r1 = r2.next()
            boolean r1 = r3.equals(r1)
            if (r1 == 0) goto L10
            goto Lf
        L21:
            r0 = 0
            goto Lf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.Iterators.a(java.util.Iterator, java.lang.Object):boolean");
    }

    public static boolean a(Iterator<?> it, Collection<?> collection) {
        Preconditions.a(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean b(Iterator<?> it, Collection<?> collection) {
        Preconditions.a(collection);
        boolean z = false;
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
                z = true;
            }
        }
        return z;
    }

    public static boolean a(Iterator<?> it, Iterator<?> it2) {
        while (it.hasNext()) {
            if (!it2.hasNext() || !Objects.a(it.next(), it2.next())) {
                return false;
            }
        }
        return !it2.hasNext();
    }

    public static String b(Iterator<?> it) {
        return Joiner.a(", ").b("null").a(new StringBuilder().append('['), it).append(']').toString();
    }

    public static <T> T c(Iterator<T> it) {
        T next = it.next();
        if (!it.hasNext()) {
            return next;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("expected one element but was: <" + next);
        for (int i = 0; i < 4 && it.hasNext(); i++) {
            sb.append(", " + it.next());
        }
        if (it.hasNext()) {
            sb.append(", ...");
        }
        sb.append('>');
        throw new IllegalArgumentException(sb.toString());
    }

    public static <T> boolean a(Collection<T> collection, Iterator<? extends T> it) {
        Preconditions.a(collection);
        boolean z = false;
        while (it.hasNext()) {
            z |= collection.add(it.next());
        }
        return z;
    }

    public static <T> UnmodifiableIterator<T> a(Iterator<T> it, Predicate<? super T> predicate) {
        Preconditions.a(it);
        Preconditions.a(predicate);
        return new aq(it, predicate);
    }

    public static <F, T> Iterator<T> a(Iterator<F> it, Function<? super F, ? extends T> function) {
        Preconditions.a(function);
        return new ar(it, function);
    }

    public static <T> T b(Iterator<? extends T> it, @Nullable T t) {
        return it.hasNext() ? it.next() : t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d(Iterator<?> it) {
        Preconditions.a(it);
        while (it.hasNext()) {
            it.next();
            it.remove();
        }
    }

    public static <T> UnmodifiableIterator<T> a(T... tArr) {
        Preconditions.a(tArr);
        return new am(tArr.length, tArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> UnmodifiableListIterator<T> a(T[] tArr, int i, int i2, int i3) {
        Preconditions.a(i2 >= 0);
        Preconditions.a(i, i + i2, tArr.length);
        return new an(i2, i3, tArr, i);
    }

    public static <T> UnmodifiableIterator<T> a(@Nullable T t) {
        return new ao(t);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class b<E> implements PeekingIterator<E> {

        /* renamed from: a, reason: collision with root package name */
        private final Iterator<? extends E> f2708a;
        private boolean b;
        private E c;

        public b(Iterator<? extends E> it) {
            this.f2708a = (Iterator) Preconditions.a(it);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.b || this.f2708a.hasNext();
        }

        @Override // com.google.common.collect.PeekingIterator, java.util.Iterator
        public E next() {
            if (!this.b) {
                return this.f2708a.next();
            }
            E e = this.c;
            this.b = false;
            this.c = null;
            return e;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(!this.b, "Can't remove after you've peeked at next");
            this.f2708a.remove();
        }

        @Override // com.google.common.collect.PeekingIterator
        public E a() {
            if (!this.b) {
                this.c = this.f2708a.next();
                this.b = true;
            }
            return this.c;
        }
    }

    public static <T> PeekingIterator<T> e(Iterator<? extends T> it) {
        return it instanceof b ? (b) it : new b(it);
    }

    @Beta
    public static <T> UnmodifiableIterator<T> a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
        Preconditions.a(iterable, "iterators");
        Preconditions.a(comparator, "comparator");
        return new a(iterable, comparator);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a<T> extends AbstractIterator<T> {

        /* renamed from: a, reason: collision with root package name */
        final Queue<PeekingIterator<T>> f2707a = new PriorityQueue(2, new as(this));
        final Comparator<? super T> b;

        public a(Iterable<? extends Iterator<? extends T>> iterable, Comparator<? super T> comparator) {
            this.b = comparator;
            for (Iterator<? extends T> it : iterable) {
                if (it.hasNext()) {
                    this.f2707a.add(Iterators.e(it));
                }
            }
        }

        @Override // com.google.common.collect.AbstractIterator
        protected T a() {
            if (this.f2707a.isEmpty()) {
                return b();
            }
            PeekingIterator<T> poll = this.f2707a.poll();
            T next = poll.next();
            if (poll.hasNext()) {
                this.f2707a.add(poll);
            }
            return next;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(boolean z) {
        Preconditions.b(z, "no calls to next() since the last call to remove()");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> ListIterator<T> f(Iterator<T> it) {
        return (ListIterator) it;
    }
}
