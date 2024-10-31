package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes2.dex */
public final class MoreExecutors {
    private MoreExecutors() {
    }

    public static ListeningExecutorService a() {
        return new a(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a extends c {

        /* renamed from: a, reason: collision with root package name */
        private final Lock f2967a;
        private final Condition b;
        private int c;
        private boolean d;

        private a() {
            this.f2967a = new ReentrantLock();
            this.b = this.f2967a.newCondition();
            this.c = 0;
            this.d = false;
        }

        /* synthetic */ a(k kVar) {
            this();
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            a();
            try {
                runnable.run();
            } finally {
                b();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            this.f2967a.lock();
            try {
                return this.d;
            } finally {
                this.f2967a.unlock();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            this.f2967a.lock();
            try {
                this.d = true;
            } finally {
                this.f2967a.unlock();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z;
            this.f2967a.lock();
            try {
                if (this.d) {
                    if (this.c == 0) {
                        z = true;
                        return z;
                    }
                }
                z = false;
                return z;
            } finally {
                this.f2967a.unlock();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            Lock lock;
            long nanos = timeUnit.toNanos(j);
            this.f2967a.lock();
            while (!isTerminated()) {
                try {
                    if (nanos > 0) {
                        nanos = this.b.awaitNanos(nanos);
                    } else {
                        return false;
                    }
                } finally {
                    this.f2967a.unlock();
                }
            }
            return true;
        }

        private void a() {
            this.f2967a.lock();
            try {
                if (isShutdown()) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.c++;
            } finally {
                this.f2967a.unlock();
            }
        }

        private void b() {
            this.f2967a.lock();
            try {
                this.c--;
                if (isTerminated()) {
                    this.b.signalAll();
                }
            } finally {
                this.f2967a.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T> T a(ListeningExecutorService listeningExecutorService, Collection<? extends Callable<T>> collection, boolean z, long j) throws InterruptedException, ExecutionException, TimeoutException {
        long nanoTime;
        long j2;
        int i;
        Future future;
        int i2;
        ExecutionException e;
        int size = collection.size();
        Preconditions.a(size > 0);
        ArrayList b = Lists.b(size);
        LinkedBlockingQueue b2 = Queues.b();
        ExecutionException executionException = null;
        if (z) {
            try {
                nanoTime = System.nanoTime();
            } finally {
                Iterator it = b.iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
            }
        } else {
            nanoTime = 0;
        }
        Iterator<? extends Callable<T>> it2 = collection.iterator();
        b.add(a(listeningExecutorService, it2.next(), b2));
        int i3 = size - 1;
        int i4 = 1;
        long j3 = j;
        while (true) {
            Future future2 = (Future) b2.poll();
            if (future2 != null) {
                j2 = j3;
                int i5 = i4;
                i = i3;
                future = future2;
                i2 = i5;
            } else if (i3 > 0) {
                int i6 = i3 - 1;
                b.add(a(listeningExecutorService, it2.next(), b2));
                int i7 = i4 + 1;
                i = i6;
                j2 = j3;
                i2 = i7;
                future = future2;
            } else {
                if (i4 == 0) {
                    if (executionException == null) {
                        throw new ExecutionException((Throwable) null);
                    }
                    throw executionException;
                }
                if (z) {
                    Future future3 = (Future) b2.poll(j3, TimeUnit.NANOSECONDS);
                    if (future3 == null) {
                        throw new TimeoutException();
                    }
                    long nanoTime2 = System.nanoTime();
                    i2 = i4;
                    i = i3;
                    future = future3;
                    j2 = j3 - (nanoTime2 - nanoTime);
                    nanoTime = nanoTime2;
                } else {
                    j2 = j3;
                    int i8 = i4;
                    i = i3;
                    future = (Future) b2.take();
                    i2 = i8;
                }
            }
            if (future != null) {
                i2--;
                try {
                    return (T) future.get();
                } catch (RuntimeException e2) {
                    e = new ExecutionException(e2);
                } catch (ExecutionException e3) {
                    e = e3;
                }
            } else {
                e = executionException;
            }
            executionException = e;
            j3 = j2;
            i3 = i;
            i4 = i2;
        }
    }

    private static <T> ListenableFuture<T> a(ListeningExecutorService listeningExecutorService, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        ListenableFuture<T> submit = listeningExecutorService.submit(callable);
        submit.a(new l(blockingQueue, submit), a());
        return submit;
    }
}
