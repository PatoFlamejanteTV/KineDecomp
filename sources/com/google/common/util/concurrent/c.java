package com.google.common.util.concurrent;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AbstractListeningExecutorService.java */
/* loaded from: classes2.dex */
public abstract class c implements ListeningExecutorService {
    @Override // java.util.concurrent.ExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public ListenableFuture<?> submit(Runnable runnable) {
        ListenableFutureTask a2 = ListenableFutureTask.a(runnable, (Object) null);
        execute(a2);
        return a2;
    }

    @Override // java.util.concurrent.ExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public <T> ListenableFuture<T> submit(Runnable runnable, T t) {
        ListenableFutureTask a2 = ListenableFutureTask.a(runnable, t);
        execute(a2);
        return a2;
    }

    @Override // java.util.concurrent.ExecutorService
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        ListenableFutureTask a2 = ListenableFutureTask.a(callable);
        execute(a2);
        return a2;
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        try {
            return (T) MoreExecutors.a(this, collection, false, 0L);
        } catch (TimeoutException e) {
            throw new AssertionError();
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) MoreExecutors.a(this, collection, true, timeUnit.toNanos(j));
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        if (collection == null) {
            throw new NullPointerException();
        }
        ArrayList<Future> arrayList = new ArrayList(collection.size());
        try {
            Iterator<? extends Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                ListenableFutureTask a2 = ListenableFutureTask.a(it.next());
                arrayList.add(a2);
                execute(a2);
            }
            for (Future future : arrayList) {
                if (!future.isDone()) {
                    try {
                        future.get();
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    }
                }
            }
            return arrayList;
        } catch (Throwable th) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                ((Future) it2.next()).cancel(true);
            }
            throw th;
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        long j2;
        long j3;
        if (collection == null || timeUnit == null) {
            throw new NullPointerException();
        }
        long nanos = timeUnit.toNanos(j);
        ArrayList<Future> arrayList = new ArrayList(collection.size());
        try {
            Iterator<? extends Callable<T>> it = collection.iterator();
            while (it.hasNext()) {
                arrayList.add(ListenableFutureTask.a(it.next()));
            }
            long nanoTime = System.nanoTime();
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                execute((Runnable) it2.next());
                long nanoTime2 = System.nanoTime();
                nanos -= nanoTime2 - nanoTime;
                if (nanos <= 0) {
                    return arrayList;
                }
                nanoTime = nanoTime2;
            }
            for (Future future : arrayList) {
                if (future.isDone()) {
                    j2 = nanoTime;
                    j3 = nanos;
                } else {
                    if (nanos <= 0) {
                        Iterator it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            ((Future) it3.next()).cancel(true);
                        }
                        return arrayList;
                    }
                    try {
                        future.get(nanos, TimeUnit.NANOSECONDS);
                    } catch (CancellationException e) {
                    } catch (ExecutionException e2) {
                    } catch (TimeoutException e3) {
                        Iterator it4 = arrayList.iterator();
                        while (it4.hasNext()) {
                            ((Future) it4.next()).cancel(true);
                        }
                        return arrayList;
                    }
                    j2 = System.nanoTime();
                    j3 = nanos - (j2 - nanoTime);
                }
                nanos = j3;
                nanoTime = j2;
            }
            return arrayList;
        } finally {
            Iterator it5 = arrayList.iterator();
            while (it5.hasNext()) {
                ((Future) it5.next()).cancel(true);
            }
        }
    }
}
