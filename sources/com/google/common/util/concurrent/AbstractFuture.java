package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import javax.annotation.Nullable;

/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* renamed from: a, reason: collision with root package name */
    private final Sync<V> f2950a = new Sync<>();
    private final ExecutionList b = new ExecutionList();

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        return this.f2950a.get(timeUnit.toNanos(j));
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return this.f2950a.get();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return this.f2950a.isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f2950a.isCancelled();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        if (!this.f2950a.cancel()) {
            return false;
        }
        this.b.a();
        if (z) {
            a();
        }
        return true;
    }

    protected void a() {
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void a(Runnable runnable, Executor executor) {
        this.b.a(runnable, executor);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(@Nullable V v) {
        boolean z = this.f2950a.set(v);
        if (z) {
            this.b.a();
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean a(Throwable th) {
        boolean exception = this.f2950a.setException((Throwable) Preconditions.a(th));
        if (exception) {
            this.b.a();
        }
        if (th instanceof Error) {
            throw ((Error) th);
        }
        return exception;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static final class Sync<V> extends AbstractQueuedSynchronizer {
        static final int CANCELLED = 4;
        static final int COMPLETED = 2;
        static final int COMPLETING = 1;
        static final int RUNNING = 0;
        private static final long serialVersionUID = 0;
        private Throwable exception;
        private V value;

        Sync() {
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected int tryAcquireShared(int i) {
            return isDone() ? 1 : -1;
        }

        @Override // java.util.concurrent.locks.AbstractQueuedSynchronizer
        protected boolean tryReleaseShared(int i) {
            setState(i);
            return true;
        }

        V get(long j) throws TimeoutException, CancellationException, ExecutionException, InterruptedException {
            if (!tryAcquireSharedNanos(-1, j)) {
                throw new TimeoutException("Timeout waiting for task.");
            }
            return a();
        }

        V get() throws CancellationException, ExecutionException, InterruptedException {
            acquireSharedInterruptibly(-1);
            return a();
        }

        private V a() throws CancellationException, ExecutionException {
            int state = getState();
            switch (state) {
                case 2:
                    if (this.exception != null) {
                        throw new ExecutionException(this.exception);
                    }
                    return this.value;
                case 3:
                default:
                    throw new IllegalStateException("Error, synchronizer in invalid state: " + state);
                case 4:
                    throw new CancellationException("Task was cancelled.");
            }
        }

        boolean isDone() {
            return (getState() & 6) != 0;
        }

        boolean isCancelled() {
            return getState() == 4;
        }

        boolean set(@Nullable V v) {
            return a(v, null, 2);
        }

        boolean setException(Throwable th) {
            return a(null, th, 2);
        }

        boolean cancel() {
            return a(null, null, 4);
        }

        private boolean a(@Nullable V v, @Nullable Throwable th, int i) {
            boolean compareAndSetState = compareAndSetState(0, 1);
            if (compareAndSetState) {
                this.value = v;
                this.exception = th;
                releaseShared(i);
            } else if (getState() == 1) {
                acquireShared(-1);
            }
            return compareAndSetState;
        }
    }
}
