package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@Beta
@GwtCompatible
/* loaded from: classes2.dex */
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {

    /* renamed from: a */
    private final MinMaxPriorityQueue<E>.a f15590a;

    /* renamed from: b */
    private final MinMaxPriorityQueue<E>.a f15591b;

    /* renamed from: c */
    @VisibleForTesting
    final int f15592c;

    /* renamed from: d */
    private Object[] f15593d;

    /* renamed from: e */
    private int f15594e;

    /* renamed from: f */
    private int f15595f;

    @Beta
    /* loaded from: classes2.dex */
    public static final class Builder<B> {
    }

    /* loaded from: classes2.dex */
    public class a {
        int a(E e2) {
            throw null;
        }

        void a(int i, E e2) {
            throw null;
        }
    }

    /* loaded from: classes2.dex */
    public static class b<E> {

        /* renamed from: a */
        final E f15596a;

        /* renamed from: b */
        final E f15597b;
    }

    /* loaded from: classes2.dex */
    private class c implements Iterator<E> {

        /* renamed from: a */
        private int f15598a;

        /* renamed from: b */
        private int f15599b;

        /* renamed from: c */
        private Queue<E> f15600c;

        /* renamed from: d */
        private List<E> f15601d;

        /* renamed from: e */
        private E f15602e;

        /* renamed from: f */
        private boolean f15603f;

        private c() {
            this.f15598a = -1;
            this.f15599b = MinMaxPriorityQueue.this.f15595f;
        }

        private boolean a(Iterable<E> iterable, E e2) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e2) {
                    return true;
                }
            }
            return false;
        }

        void b() {
            if (MinMaxPriorityQueue.this.f15595f != this.f15599b) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            b();
            if (a(this.f15598a + 1) < MinMaxPriorityQueue.this.size()) {
                return true;
            }
            Queue<E> queue = this.f15600c;
            return (queue == null || queue.isEmpty()) ? false : true;
        }

        @Override // java.util.Iterator
        public E next() {
            b();
            int a2 = a(this.f15598a + 1);
            if (a2 < MinMaxPriorityQueue.this.size()) {
                this.f15598a = a2;
                this.f15603f = true;
                return (E) MinMaxPriorityQueue.this.a(this.f15598a);
            }
            if (this.f15600c != null) {
                this.f15598a = MinMaxPriorityQueue.this.size();
                this.f15602e = this.f15600c.poll();
                E e2 = this.f15602e;
                if (e2 != null) {
                    this.f15603f = true;
                    return e2;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        @Override // java.util.Iterator
        public void remove() {
            C1555x.a(this.f15603f);
            b();
            this.f15603f = false;
            this.f15599b++;
            if (this.f15598a < MinMaxPriorityQueue.this.size()) {
                b<E> c2 = MinMaxPriorityQueue.this.c(this.f15598a);
                if (c2 != null) {
                    if (this.f15600c == null) {
                        this.f15600c = new ArrayDeque();
                        this.f15601d = new ArrayList(3);
                    }
                    this.f15600c.add(c2.f15596a);
                    this.f15601d.add(c2.f15597b);
                }
                this.f15598a--;
                return;
            }
            Preconditions.b(a(this.f15602e));
            this.f15602e = null;
        }

        boolean a(Object obj) {
            for (int i = 0; i < MinMaxPriorityQueue.this.f15594e; i++) {
                if (MinMaxPriorityQueue.this.f15593d[i] == obj) {
                    MinMaxPriorityQueue.this.c(i);
                    return true;
                }
            }
            return false;
        }

        /* synthetic */ c(MinMaxPriorityQueue minMaxPriorityQueue, Ra ra) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int a(int i) {
            if (this.f15601d != null) {
                while (i < MinMaxPriorityQueue.this.size() && a(this.f15601d, MinMaxPriorityQueue.this.a(i))) {
                    i++;
                }
            }
            return i;
        }
    }

    private MinMaxPriorityQueue<E>.a d(int i) {
        return b(i) ? this.f15590a : this.f15591b;
    }

    private E e(int i) {
        E a2 = a(i);
        c(i);
        return a2;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection, java.util.Queue
    @CanIgnoreReturnValue
    public boolean add(E e2) {
        offer(e2);
        return true;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        boolean z = false;
        while (it.hasNext()) {
            offer(it.next());
            z = true;
        }
        return z;
    }

    @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
    public void clear() {
        for (int i = 0; i < this.f15594e; i++) {
            this.f15593d[i] = null;
        }
        this.f15594e = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<E> iterator() {
        return new c();
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public boolean offer(E e2) {
        Preconditions.a(e2);
        this.f15595f++;
        int i = this.f15594e;
        this.f15594e = i + 1;
        b();
        d(i).a(i, e2);
        throw null;
    }

    @Override // java.util.Queue
    public E peek() {
        if (isEmpty()) {
            return null;
        }
        return a(0);
    }

    @Override // java.util.Queue
    @CanIgnoreReturnValue
    public E poll() {
        if (isEmpty()) {
            return null;
        }
        return e(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.f15594e;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        int i = this.f15594e;
        Object[] objArr = new Object[i];
        System.arraycopy(this.f15593d, 0, objArr, 0, i);
        return objArr;
    }

    @VisibleForTesting
    static boolean b(int i) {
        int i2 = ((i + 1) ^ (-1)) ^ (-1);
        Preconditions.b(i2 > 0, "negative index");
        return (1431655765 & i2) > (i2 & (-1431655766));
    }

    E a(int i) {
        return (E) this.f15593d[i];
    }

    @VisibleForTesting
    @CanIgnoreReturnValue
    b<E> c(int i) {
        Preconditions.b(i, this.f15594e);
        this.f15595f++;
        this.f15594e--;
        int i2 = this.f15594e;
        if (i2 == i) {
            this.f15593d[i2] = null;
            return null;
        }
        d(this.f15594e).a(a(i2));
        throw null;
    }

    private int a() {
        int length = this.f15593d.length;
        return a(length < 64 ? (length + 1) * 2 : IntMath.b(length / 2, 3), this.f15592c);
    }

    private void b() {
        if (this.f15594e > this.f15593d.length) {
            Object[] objArr = new Object[a()];
            Object[] objArr2 = this.f15593d;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.f15593d = objArr;
        }
    }

    private static int a(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }
}
