package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
/* loaded from: classes2.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    final int f2739a;
    private final MinMaxPriorityQueue<E>.a b;
    private final MinMaxPriorityQueue<E>.a c;
    private Object[] d;
    private int e;
    private int f;

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder<B> {
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.e;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    public boolean add(E e) {
        offer(e);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        Iterator<? extends E> it = collection.iterator();
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @Override // java.util.Queue
    public boolean offer(E e) {
        Preconditions.a(e);
        this.f++;
        int i = this.e;
        this.e = i + 1;
        c();
        e(i).a(i, (int) e);
        return this.e <= this.f2739a || a() != e;
    }

    @Override // java.util.Queue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return d(0);
    }

    E a(int i) {
        return (E) this.d[i];
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return a(0);
    }

    private int b() {
        switch (this.e) {
            case 1:
                return 0;
            case 2:
                return 1;
            default:
                return this.c.a(1, 2) <= 0 ? 1 : 2;
        }
    }

    public E a() {
        if (isEmpty()) {
            return null;
        }
        return d(b());
    }

    @VisibleForTesting
    b<E> b(int i) {
        Preconditions.b(i, this.e);
        this.f++;
        this.e--;
        if (this.e == i) {
            this.d[this.e] = null;
            return null;
        }
        E a2 = a(this.e);
        int a3 = e(this.e).a((MinMaxPriorityQueue<E>.a) a2);
        E a4 = a(this.e);
        this.d[this.e] = null;
        b<E> a5 = a(i, (int) a4);
        if (a3 >= i) {
            return a5;
        }
        if (a5 == null) {
            return new b<>(a2, a4);
        }
        return new b<>(a2, a5.b);
    }

    private b<E> a(int i, E e) {
        MinMaxPriorityQueue<E>.a e2 = e(i);
        int c2 = e2.c(i);
        int b2 = e2.b(c2, (int) e);
        if (b2 == c2) {
            return e2.a(i, c2, e);
        }
        if (b2 < i) {
            return new b<>(e, a(i));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class b<E> {

        /* renamed from: a, reason: collision with root package name */
        final E f2741a;
        final E b;

        b(E e, E e2) {
            this.f2741a = e;
            this.b = e2;
        }
    }

    private E d(int i) {
        E a2 = a(i);
        b(i);
        return a2;
    }

    private MinMaxPriorityQueue<E>.a e(int i) {
        return c(i) ? this.b : this.c;
    }

    @VisibleForTesting
    static boolean c(int i) {
        int i2 = i + 1;
        Preconditions.b(i2 > 0, "negative index");
        return (1431655765 & i2) > (i2 & (-1431655766));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a {

        /* renamed from: a, reason: collision with root package name */
        final Ordering<E> f2740a;
        MinMaxPriorityQueue<E>.a b;
        final /* synthetic */ MinMaxPriorityQueue c;

        int a(int i, int i2) {
            return this.f2740a.compare(this.c.a(i), this.c.a(i2));
        }

        b<E> a(int i, int i2, E e) {
            Object a2;
            int d = d(i2, e);
            if (d == i2) {
                return null;
            }
            if (d < i) {
                a2 = this.c.a(i);
            } else {
                a2 = this.c.a(f(i));
            }
            if (this.b.b(d, (int) e) < i) {
                return new b<>(e, a2);
            }
            return null;
        }

        void a(int i, E e) {
            int c = c(i, e);
            if (c != i) {
                this = this.b;
                i = c;
            }
            this.b(i, (int) e);
        }

        int b(int i, E e) {
            while (i > 2) {
                int g = g(i);
                Object a2 = this.c.a(g);
                if (this.f2740a.compare(a2, e) <= 0) {
                    break;
                }
                this.c.d[i] = a2;
                i = g;
            }
            this.c.d[i] = e;
            return i;
        }

        int b(int i, int i2) {
            if (i >= this.c.e) {
                return -1;
            }
            Preconditions.b(i > 0);
            int min = Math.min(i, this.c.e - i2) + i2;
            int i3 = i;
            for (int i4 = i + 1; i4 < min; i4++) {
                if (a(i4, i3) < 0) {
                    i3 = i4;
                }
            }
            return i3;
        }

        int a(int i) {
            return b(d(i), 2);
        }

        int b(int i) {
            int d = d(i);
            if (d < 0) {
                return -1;
            }
            return b(d(d), 4);
        }

        /* JADX WARN: Removed duplicated region for block: B:17:0x0045  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        int c(int r6, E r7) {
            /*
                r5 = this;
                r1 = 0
                if (r6 != 0) goto Lc
                com.google.common.collect.MinMaxPriorityQueue r0 = r5.c
                java.lang.Object[] r0 = com.google.common.collect.MinMaxPriorityQueue.a(r0)
                r0[r1] = r7
            Lb:
                return r1
            Lc:
                int r3 = r5.f(r6)
                com.google.common.collect.MinMaxPriorityQueue r0 = r5.c
                java.lang.Object r1 = r0.a(r3)
                if (r3 == 0) goto L60
                int r0 = r5.f(r3)
                int r2 = r5.e(r0)
                if (r2 == r3) goto L60
                int r0 = r5.d(r2)
                com.google.common.collect.MinMaxPriorityQueue r4 = r5.c
                int r4 = com.google.common.collect.MinMaxPriorityQueue.b(r4)
                if (r0 < r4) goto L60
                com.google.common.collect.MinMaxPriorityQueue r0 = r5.c
                java.lang.Object r0 = r0.a(r2)
                com.google.common.collect.Ordering<E> r4 = r5.f2740a
                int r4 = r4.compare(r0, r1)
                if (r4 >= 0) goto L60
                r1 = r2
            L3d:
                com.google.common.collect.Ordering<E> r2 = r5.f2740a
                int r2 = r2.compare(r0, r7)
                if (r2 >= 0) goto L56
                com.google.common.collect.MinMaxPriorityQueue r2 = r5.c
                java.lang.Object[] r2 = com.google.common.collect.MinMaxPriorityQueue.a(r2)
                r2[r6] = r0
                com.google.common.collect.MinMaxPriorityQueue r0 = r5.c
                java.lang.Object[] r0 = com.google.common.collect.MinMaxPriorityQueue.a(r0)
                r0[r1] = r7
                goto Lb
            L56:
                com.google.common.collect.MinMaxPriorityQueue r0 = r5.c
                java.lang.Object[] r0 = com.google.common.collect.MinMaxPriorityQueue.a(r0)
                r0[r6] = r7
                r1 = r6
                goto Lb
            L60:
                r0 = r1
                r1 = r3
                goto L3d
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MinMaxPriorityQueue.a.c(int, java.lang.Object):int");
        }

        int a(E e) {
            int e2;
            int f = f(this.c.e);
            if (f != 0 && (e2 = e(f(f))) != f && d(e2) >= this.c.e) {
                Object a2 = this.c.a(e2);
                if (this.f2740a.compare(a2, e) < 0) {
                    this.c.d[e2] = e;
                    this.c.d[this.c.e] = a2;
                    return e2;
                }
            }
            return this.c.e;
        }

        int d(int i, E e) {
            int a2 = a(i);
            if (a2 <= 0 || this.f2740a.compare(this.c.a(a2), e) >= 0) {
                return c(i, e);
            }
            this.c.d[i] = this.c.a(a2);
            this.c.d[a2] = e;
            return a2;
        }

        int c(int i) {
            while (true) {
                int b = b(i);
                if (b > 0) {
                    this.c.d[i] = this.c.a(b);
                    i = b;
                } else {
                    return i;
                }
            }
        }

        private int d(int i) {
            return (i * 2) + 1;
        }

        private int e(int i) {
            return (i * 2) + 2;
        }

        private int f(int i) {
            return (i - 1) / 2;
        }

        private int g(int i) {
            return f(f(i));
        }
    }

    /* loaded from: classes2.dex */
    private class c implements Iterator<E> {
        private int b;
        private int c;
        private Queue<E> d;
        private List<E> e;
        private E f;
        private boolean g;

        private c() {
            this.b = -1;
            this.c = MinMaxPriorityQueue.this.f;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            a();
            return a(this.b + 1) < MinMaxPriorityQueue.this.size() || !(this.d == null || this.d.isEmpty());
        }

        @Override // java.util.Iterator
        public E next() {
            a();
            int a2 = a(this.b + 1);
            if (a2 < MinMaxPriorityQueue.this.size()) {
                this.b = a2;
                this.g = true;
                return (E) MinMaxPriorityQueue.this.a(this.b);
            }
            if (this.d != null) {
                this.b = MinMaxPriorityQueue.this.size();
                this.f = this.d.poll();
                if (this.f != null) {
                    this.g = true;
                    return this.f;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.b(this.g, "no calls to remove() since the last call to next()");
            a();
            this.g = false;
            this.c++;
            if (this.b < MinMaxPriorityQueue.this.size()) {
                b<E> b = MinMaxPriorityQueue.this.b(this.b);
                if (b != null) {
                    if (this.d == null) {
                        this.d = new LinkedList();
                        this.e = new ArrayList(3);
                    }
                    this.d.add(b.f2741a);
                    this.e.add(b.b);
                }
                this.b--;
                return;
            }
            Preconditions.b(a(this.f));
            this.f = null;
        }

        private boolean a(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    return true;
                }
            }
            return false;
        }

        boolean a(Object obj) {
            for (int i = 0; i < MinMaxPriorityQueue.this.e; i++) {
                if (MinMaxPriorityQueue.this.d[i] == obj) {
                    MinMaxPriorityQueue.this.b(i);
                    return true;
                }
            }
            return false;
        }

        void a() {
            if (MinMaxPriorityQueue.this.f != this.c) {
                throw new ConcurrentModificationException();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int a(int i) {
            if (this.e != null) {
                while (i < MinMaxPriorityQueue.this.size() && a(this.e, MinMaxPriorityQueue.this.a(i))) {
                    i++;
                }
            }
            return i;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c();
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.e; i++) {
            this.d[i] = null;
        }
        this.e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        Object[] objArr = new Object[this.e];
        System.arraycopy(this.d, 0, objArr, 0, this.e);
        return objArr;
    }

    private void c() {
        if (this.e > this.d.length) {
            Object[] objArr = new Object[d()];
            System.arraycopy(this.d, 0, objArr, 0, this.d.length);
            this.d = objArr;
        }
    }

    private int d() {
        int length = this.d.length;
        return a(length < 64 ? (length + 1) * 2 : IntMath.b(length / 2, 3), this.f2739a);
    }

    private static int a(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }
}
