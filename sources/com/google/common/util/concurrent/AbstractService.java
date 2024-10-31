package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;
import com.google.common.util.concurrent.Service;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import javax.annotation.concurrent.Immutable;

@Beta
/* loaded from: classes2.dex */
public abstract class AbstractService implements Service {

    /* renamed from: a, reason: collision with root package name */
    private static final Logger f2953a = Logger.getLogger(AbstractService.class.getName());
    private final c c;
    private final c d;
    private final ReentrantLock b = new ReentrantLock();

    @GuardedBy
    private final List<a> e = Lists.a();

    @GuardedBy
    private final Queue<Runnable> f = Queues.a();

    @GuardedBy
    private volatile b g = new b(Service.State.NEW);

    /* JADX INFO: Access modifiers changed from: protected */
    public AbstractService() {
        f fVar = null;
        this.c = new c(this, fVar);
        this.d = new c(this, fVar);
        a(new f(this), MoreExecutors.a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void a(Throwable th) {
        Preconditions.a(th);
        this.b.lock();
        try {
            switch (this.g.f2956a) {
                case STARTING:
                case RUNNING:
                case STOPPING:
                    Service.State state = this.g.f2956a;
                    this.g = new b(Service.State.FAILED, false, th);
                    a(state, th);
                    break;
                case TERMINATED:
                case NEW:
                    throw new IllegalStateException("Failed while in state:" + this.g.f2956a, th);
                case FAILED:
                    break;
                default:
                    throw new AssertionError("Unexpected state: " + this.g.f2956a);
            }
        } finally {
            this.b.unlock();
            c();
        }
    }

    @Override // com.google.common.util.concurrent.Service
    public final Service.State a() {
        return this.g.a();
    }

    public final void a(Service.Listener listener, Executor executor) {
        Preconditions.a(listener, "listener");
        Preconditions.a(executor, "executor");
        this.b.lock();
        try {
            if (this.g.f2956a != Service.State.TERMINATED && this.g.f2956a != Service.State.FAILED) {
                this.e.add(new a(listener, executor));
            }
        } finally {
            this.b.unlock();
        }
    }

    public String toString() {
        return getClass().getSimpleName() + " [" + a() + "]";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class c extends AbstractFuture<Service.State> {
        private c() {
        }

        /* synthetic */ c(AbstractService abstractService, f fVar) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Service.State get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
            try {
                return (Service.State) super.get(j, timeUnit);
            } catch (TimeoutException e) {
                throw new TimeoutException(AbstractService.this.toString());
            }
        }
    }

    private void c() {
        if (!this.b.isHeldByCurrentThread()) {
            synchronized (this.f) {
                while (true) {
                    Runnable poll = this.f.poll();
                    if (poll != null) {
                        poll.run();
                    }
                }
            }
        }
    }

    @GuardedBy
    private void a(Service.State state, Throwable th) {
        Iterator<a> it = this.e.iterator();
        while (it.hasNext()) {
            this.f.add(new g(this, it.next(), state, th));
        }
        this.e.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a, reason: collision with root package name */
        final Service.Listener f2955a;
        final Executor b;

        a(Service.Listener listener, Executor executor) {
            this.f2955a = listener;
            this.b = executor;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void a(Runnable runnable) {
            try {
                this.b.execute(runnable);
            } catch (Exception e) {
                AbstractService.f2953a.log(Level.SEVERE, "Exception while executing listener " + this.f2955a + " with executor " + this.b, (Throwable) e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Immutable
    /* loaded from: classes.dex */
    public static final class b {

        /* renamed from: a, reason: collision with root package name */
        final Service.State f2956a;
        final boolean b;

        @Nullable
        final Throwable c;

        b(Service.State state) {
            this(state, false, null);
        }

        b(Service.State state, boolean z, Throwable th) {
            Preconditions.a(!z || state == Service.State.STARTING, "shudownWhenStartupFinishes can only be set if state is STARTING. Got %s instead.", state);
            Preconditions.a(!((th != null) ^ (state == Service.State.FAILED)), "A failure cause should be set if and only if the state is failed.  Got %s and %s instead.", state, th);
            this.f2956a = state;
            this.b = z;
            this.c = th;
        }

        Service.State a() {
            return (this.b && this.f2956a == Service.State.STARTING) ? Service.State.STOPPING : this.f2956a;
        }
    }
}
