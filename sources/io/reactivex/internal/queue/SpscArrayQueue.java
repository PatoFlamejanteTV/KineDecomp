package io.reactivex.internal.queue;

import io.reactivex.d.b.m;
import io.reactivex.internal.util.f;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes3.dex */
public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements m<E> {

    /* renamed from: a */
    private static final Integer f28378a = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    final AtomicLong consumerIndex;
    final int lookAheadStep;
    final int mask;
    final AtomicLong producerIndex;
    long producerLookAhead;

    public SpscArrayQueue(int i) {
        super(f.a(i));
        this.mask = length() - 1;
        this.producerIndex = new AtomicLong();
        this.consumerIndex = new AtomicLong();
        this.lookAheadStep = Math.min(i / 4, f28378a.intValue());
    }

    int calcElementOffset(long j) {
        return this.mask & ((int) j);
    }

    int calcElementOffset(long j, int i) {
        return ((int) j) & i;
    }

    @Override // io.reactivex.d.b.n
    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    @Override // io.reactivex.d.b.n
    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    E lvElement(int i) {
        return get(i);
    }

    @Override // io.reactivex.d.b.n
    public boolean offer(E e2) {
        if (e2 != null) {
            int i = this.mask;
            long j = this.producerIndex.get();
            int calcElementOffset = calcElementOffset(j, i);
            if (j >= this.producerLookAhead) {
                long j2 = this.lookAheadStep + j;
                if (lvElement(calcElementOffset(j2, i)) == null) {
                    this.producerLookAhead = j2;
                } else if (lvElement(calcElementOffset) != null) {
                    return false;
                }
            }
            soElement(calcElementOffset, e2);
            soProducerIndex(j + 1);
            return true;
        }
        throw new NullPointerException("Null is not a valid element");
    }

    @Override // io.reactivex.d.b.m, io.reactivex.d.b.n
    public E poll() {
        long j = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j + 1);
        soElement(calcElementOffset, null);
        return lvElement;
    }

    void soConsumerIndex(long j) {
        this.consumerIndex.lazySet(j);
    }

    void soElement(int i, E e2) {
        lazySet(i, e2);
    }

    void soProducerIndex(long j) {
        this.producerIndex.lazySet(j);
    }

    public boolean offer(E e2, E e3) {
        return offer(e2) && offer(e3);
    }
}
