package io.reactivex.internal.queue;

import io.reactivex.d.b.m;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes3.dex */
public final class MpscLinkedQueue<T> implements m<T> {

    /* renamed from: a */
    private final AtomicReference<LinkedQueueNode<T>> f28376a = new AtomicReference<>();

    /* renamed from: b */
    private final AtomicReference<LinkedQueueNode<T>> f28377b = new AtomicReference<>();

    /* loaded from: classes3.dex */
    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue(null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e2) {
            this.value = e2;
        }

        LinkedQueueNode(E e2) {
            spValue(e2);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>();
        a(linkedQueueNode);
        b(linkedQueueNode);
    }

    LinkedQueueNode<T> a() {
        return this.f28377b.get();
    }

    LinkedQueueNode<T> b(LinkedQueueNode<T> linkedQueueNode) {
        return this.f28376a.getAndSet(linkedQueueNode);
    }

    LinkedQueueNode<T> c() {
        return this.f28376a.get();
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        while (poll() != null && !isEmpty()) {
        }
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return b() == c();
    }

    @Override // io.reactivex.d.b.n
    public boolean offer(T t) {
        if (t != null) {
            LinkedQueueNode<T> linkedQueueNode = new LinkedQueueNode<>(t);
            b(linkedQueueNode).soNext(linkedQueueNode);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.d.b.m, io.reactivex.d.b.n
    public T poll() {
        LinkedQueueNode<T> lvNext;
        LinkedQueueNode<T> a2 = a();
        LinkedQueueNode<T> lvNext2 = a2.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            a(lvNext2);
            return andNullValue;
        }
        if (a2 == c()) {
            return null;
        }
        do {
            lvNext = a2.lvNext();
        } while (lvNext == null);
        T andNullValue2 = lvNext.getAndNullValue();
        a(lvNext);
        return andNullValue2;
    }

    void a(LinkedQueueNode<T> linkedQueueNode) {
        this.f28377b.lazySet(linkedQueueNode);
    }

    LinkedQueueNode<T> b() {
        return this.f28377b.get();
    }
}
