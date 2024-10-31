package io.grpc.internal;

import com.google.common.base.Preconditions;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

/* compiled from: SerializingExecutor.java */
/* loaded from: classes3.dex */
public final class Dc implements Executor, Runnable {

    /* renamed from: a */
    private static final Logger f27229a = Logger.getLogger(Dc.class.getName());

    /* renamed from: b */
    private static final a f27230b = b();

    /* renamed from: c */
    private final Executor f27231c;

    /* renamed from: d */
    private final Queue<Runnable> f27232d = new ConcurrentLinkedQueue();

    /* renamed from: e */
    private volatile int f27233e = 0;

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes3.dex */
    public static abstract class a {
        private a() {
        }

        public abstract void a(Dc dc, int i);

        public abstract boolean a(Dc dc, int i, int i2);

        /* synthetic */ a(Cc cc) {
            this();
        }
    }

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes3.dex */
    public static final class b extends a {

        /* renamed from: a */
        private final AtomicIntegerFieldUpdater<Dc> f27234a;

        /* synthetic */ b(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, Cc cc) {
            this(atomicIntegerFieldUpdater);
        }

        @Override // io.grpc.internal.Dc.a
        public boolean a(Dc dc, int i, int i2) {
            return this.f27234a.compareAndSet(dc, i, i2);
        }

        private b(AtomicIntegerFieldUpdater<Dc> atomicIntegerFieldUpdater) {
            super();
            this.f27234a = atomicIntegerFieldUpdater;
        }

        @Override // io.grpc.internal.Dc.a
        public void a(Dc dc, int i) {
            this.f27234a.set(dc, i);
        }
    }

    /* compiled from: SerializingExecutor.java */
    /* loaded from: classes3.dex */
    public static final class c extends a {
        private c() {
            super();
        }

        @Override // io.grpc.internal.Dc.a
        public boolean a(Dc dc, int i, int i2) {
            synchronized (dc) {
                if (dc.f27233e != i) {
                    return false;
                }
                dc.f27233e = i2;
                return true;
            }
        }

        /* synthetic */ c(Cc cc) {
            this();
        }

        @Override // io.grpc.internal.Dc.a
        public void a(Dc dc, int i) {
            synchronized (dc) {
                dc.f27233e = i;
            }
        }
    }

    public Dc(Executor executor) {
        Preconditions.a(executor, "'executor' must not be null.");
        this.f27231c = executor;
    }

    private static a b() {
        try {
            return new b(AtomicIntegerFieldUpdater.newUpdater(Dc.class, "e"));
        } catch (Throwable th) {
            f27229a.log(Level.SEVERE, "FieldUpdaterAtomicHelper failed", th);
            return new c();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        Queue<Runnable> queue = this.f27232d;
        Preconditions.a(runnable, "'r' must not be null.");
        queue.add(runnable);
        a(runnable);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (true) {
            try {
                Runnable poll = this.f27232d.poll();
                if (poll == null) {
                    break;
                }
                try {
                    poll.run();
                } catch (RuntimeException e2) {
                    f27229a.log(Level.SEVERE, "Exception while executing runnable " + poll, (Throwable) e2);
                }
            } catch (Throwable th) {
                f27230b.a(this, 0);
                throw th;
            }
        }
        f27230b.a(this, 0);
        if (this.f27232d.isEmpty()) {
            return;
        }
        a((Runnable) null);
    }

    private void a(@Nullable Runnable runnable) {
        if (f27230b.a(this, 0, -1)) {
            try {
                this.f27231c.execute(this);
            } catch (Throwable th) {
                if (runnable != null) {
                    this.f27232d.remove(runnable);
                }
                f27230b.a(this, 0);
                throw th;
            }
        }
    }
}
