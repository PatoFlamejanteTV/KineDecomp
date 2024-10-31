package com.google.android.gms.tasks;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class Tasks {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class a implements b {

        /* renamed from: a, reason: collision with root package name */
        private final CountDownLatch f14271a;

        private a() {
            this.f14271a = new CountDownLatch(1);
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void a() {
            this.f14271a.countDown();
        }

        public final void b() throws InterruptedException {
            this.f14271a.await();
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            this.f14271a.countDown();
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            this.f14271a.countDown();
        }

        public final boolean a(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f14271a.await(j, timeUnit);
        }

        /* synthetic */ a(t tVar) {
            this();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public interface b extends OnCanceledListener, OnFailureListener, OnSuccessListener<Object> {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static final class c implements b {

        /* renamed from: a, reason: collision with root package name */
        private final Object f14272a = new Object();

        /* renamed from: b, reason: collision with root package name */
        private final int f14273b;

        /* renamed from: c, reason: collision with root package name */
        private final s<Void> f14274c;

        /* renamed from: d, reason: collision with root package name */
        private int f14275d;

        /* renamed from: e, reason: collision with root package name */
        private int f14276e;

        /* renamed from: f, reason: collision with root package name */
        private int f14277f;

        /* renamed from: g, reason: collision with root package name */
        private Exception f14278g;

        /* renamed from: h, reason: collision with root package name */
        private boolean f14279h;

        public c(int i, s<Void> sVar) {
            this.f14273b = i;
            this.f14274c = sVar;
        }

        private final void b() {
            int i = this.f14275d;
            int i2 = this.f14276e;
            int i3 = i + i2 + this.f14277f;
            int i4 = this.f14273b;
            if (i3 == i4) {
                if (this.f14278g != null) {
                    s<Void> sVar = this.f14274c;
                    StringBuilder sb = new StringBuilder(54);
                    sb.append(i2);
                    sb.append(" out of ");
                    sb.append(i4);
                    sb.append(" underlying tasks failed");
                    sVar.a(new ExecutionException(sb.toString(), this.f14278g));
                    return;
                }
                if (this.f14279h) {
                    this.f14274c.f();
                } else {
                    this.f14274c.a((s<Void>) null);
                }
            }
        }

        @Override // com.google.android.gms.tasks.OnCanceledListener
        public final void a() {
            synchronized (this.f14272a) {
                this.f14277f++;
                this.f14279h = true;
                b();
            }
        }

        @Override // com.google.android.gms.tasks.OnFailureListener
        public final void onFailure(Exception exc) {
            synchronized (this.f14272a) {
                this.f14276e++;
                this.f14278g = exc;
                b();
            }
        }

        @Override // com.google.android.gms.tasks.OnSuccessListener
        public final void onSuccess(Object obj) {
            synchronized (this.f14272a) {
                this.f14275d++;
                b();
            }
        }
    }

    private Tasks() {
    }

    public static <TResult> Task<TResult> a(TResult tresult) {
        s sVar = new s();
        sVar.a((s) tresult);
        return sVar;
    }

    private static <TResult> TResult b(Task<TResult> task) throws ExecutionException {
        if (task.e()) {
            return task.b();
        }
        if (task.c()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(task.a());
    }

    public static <TResult> Task<TResult> a(Exception exc) {
        s sVar = new s();
        sVar.a(exc);
        return sVar;
    }

    public static <TResult> Task<TResult> a(Executor executor, Callable<TResult> callable) {
        Preconditions.a(executor, "Executor must not be null");
        Preconditions.a(callable, "Callback must not be null");
        s sVar = new s();
        executor.execute(new t(sVar, callable));
        return sVar;
    }

    public static <TResult> TResult a(Task<TResult> task) throws ExecutionException, InterruptedException {
        Preconditions.a();
        Preconditions.a(task, "Task must not be null");
        if (task.d()) {
            return (TResult) b(task);
        }
        a aVar = new a(null);
        a((Task<?>) task, (b) aVar);
        aVar.b();
        return (TResult) b(task);
    }

    public static <TResult> TResult a(Task<TResult> task, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        Preconditions.a();
        Preconditions.a(task, "Task must not be null");
        Preconditions.a(timeUnit, "TimeUnit must not be null");
        if (task.d()) {
            return (TResult) b(task);
        }
        a aVar = new a(null);
        a((Task<?>) task, (b) aVar);
        if (aVar.a(j, timeUnit)) {
            return (TResult) b(task);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static Task<Void> a(Collection<? extends Task<?>> collection) {
        if (collection.isEmpty()) {
            return a((Object) null);
        }
        Iterator<? extends Task<?>> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() == null) {
                throw new NullPointerException("null tasks are not accepted");
            }
        }
        s sVar = new s();
        c cVar = new c(collection.size(), sVar);
        Iterator<? extends Task<?>> it2 = collection.iterator();
        while (it2.hasNext()) {
            a(it2.next(), cVar);
        }
        return sVar;
    }

    public static Task<Void> a(Task<?>... taskArr) {
        if (taskArr.length == 0) {
            return a((Object) null);
        }
        return a((Collection<? extends Task<?>>) Arrays.asList(taskArr));
    }

    private static void a(Task<?> task, b bVar) {
        task.a(TaskExecutors.f14269b, (OnSuccessListener<? super Object>) bVar);
        task.a(TaskExecutors.f14269b, (OnFailureListener) bVar);
        task.a(TaskExecutors.f14269b, (OnCanceledListener) bVar);
    }
}
