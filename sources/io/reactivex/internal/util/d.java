package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: HalfSerializer.java */
/* loaded from: classes3.dex */
public final class d {
    /* JADX WARN: Multi-variable type inference failed */
    public static <T> void a(g.b.b<? super T> bVar, T t, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.get() == 0 && atomicInteger.compareAndSet(0, 1)) {
            bVar.onNext(t);
            if (atomicInteger.decrementAndGet() != 0) {
                Throwable terminate = atomicThrowable.terminate();
                if (terminate != null) {
                    bVar.onError(terminate);
                } else {
                    bVar.onComplete();
                }
            }
        }
    }

    public static void a(g.b.b<?> bVar, Throwable th, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicThrowable.addThrowable(th)) {
            if (atomicInteger.getAndIncrement() == 0) {
                bVar.onError(atomicThrowable.terminate());
                return;
            }
            return;
        }
        io.reactivex.f.a.b(th);
    }

    public static void a(g.b.b<?> bVar, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        if (atomicInteger.getAndIncrement() == 0) {
            Throwable terminate = atomicThrowable.terminate();
            if (terminate != null) {
                bVar.onError(terminate);
            } else {
                bVar.onComplete();
            }
        }
    }
}
