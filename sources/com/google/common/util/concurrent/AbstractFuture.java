package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import com.google.common.base.Throwables;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public abstract class AbstractFuture<V> implements ListenableFuture<V> {

    /* renamed from: a */
    private static final boolean f16108a = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    /* renamed from: b */
    private static final Logger f16109b = Logger.getLogger(AbstractFuture.class.getName());

    /* renamed from: c */
    private static final a f16110c;

    /* renamed from: d */
    private static final Object f16111d;

    /* renamed from: e */
    private volatile Object f16112e;

    /* renamed from: f */
    private volatile d f16113f;

    /* renamed from: g */
    private volatile j f16114g;

    /* loaded from: classes2.dex */
    public static abstract class a {
        private a() {
        }

        abstract void a(j jVar, j jVar2);

        abstract void a(j jVar, Thread thread);

        abstract boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2);

        abstract boolean a(AbstractFuture<?> abstractFuture, j jVar, j jVar2);

        abstract boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2);

        /* synthetic */ a(com.google.common.util.concurrent.b bVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b {

        /* renamed from: a */
        final boolean f16115a;

        /* renamed from: b */
        @Nullable
        final Throwable f16116b;

        b(boolean z, @Nullable Throwable th) {
            this.f16115a = z;
            this.f16116b = th;
        }
    }

    /* loaded from: classes2.dex */
    public static final class c {

        /* renamed from: a */
        static final c f16117a = new c(new Throwable("Failure occurred while trying to finish a future.") { // from class: com.google.common.util.concurrent.AbstractFuture$Failure$1
            @Override // java.lang.Throwable
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        });

        /* renamed from: b */
        final Throwable f16118b;

        c(Throwable th) {
            Preconditions.a(th);
            this.f16118b = th;
        }
    }

    /* loaded from: classes2.dex */
    public static final class d {

        /* renamed from: a */
        static final d f16119a = new d(null, null);

        /* renamed from: b */
        final Runnable f16120b;

        /* renamed from: c */
        final Executor f16121c;

        /* renamed from: d */
        @Nullable
        d f16122d;

        d(Runnable runnable, Executor executor) {
            this.f16120b = runnable;
            this.f16121c = executor;
        }
    }

    /* loaded from: classes2.dex */
    private static final class e extends a {

        /* renamed from: a */
        final AtomicReferenceFieldUpdater<j, Thread> f16123a;

        /* renamed from: b */
        final AtomicReferenceFieldUpdater<j, j> f16124b;

        /* renamed from: c */
        final AtomicReferenceFieldUpdater<AbstractFuture, j> f16125c;

        /* renamed from: d */
        final AtomicReferenceFieldUpdater<AbstractFuture, d> f16126d;

        /* renamed from: e */
        final AtomicReferenceFieldUpdater<AbstractFuture, Object> f16127e;

        e(AtomicReferenceFieldUpdater<j, Thread> atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater<j, j> atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater<AbstractFuture, j> atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater<AbstractFuture, d> atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater<AbstractFuture, Object> atomicReferenceFieldUpdater5) {
            super();
            this.f16123a = atomicReferenceFieldUpdater;
            this.f16124b = atomicReferenceFieldUpdater2;
            this.f16125c = atomicReferenceFieldUpdater3;
            this.f16126d = atomicReferenceFieldUpdater4;
            this.f16127e = atomicReferenceFieldUpdater5;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, Thread thread) {
            this.f16123a.lazySet(jVar, thread);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, j jVar2) {
            this.f16124b.lazySet(jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return this.f16125c.compareAndSet(abstractFuture, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return this.f16126d.compareAndSet(abstractFuture, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return this.f16127e.compareAndSet(abstractFuture, obj, obj2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class f<V> implements Runnable {

        /* renamed from: a */
        final AbstractFuture<V> f16128a;

        /* renamed from: b */
        final ListenableFuture<? extends V> f16129b;

        @Override // java.lang.Runnable
        public void run() {
            if (((AbstractFuture) this.f16128a).f16112e != this) {
                return;
            }
            if (AbstractFuture.f16110c.a((AbstractFuture<?>) this.f16128a, (Object) this, AbstractFuture.b((ListenableFuture<?>) this.f16129b))) {
                AbstractFuture.e(this.f16128a);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static final class g extends a {
        private g() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, Thread thread) {
            jVar.f16137b = thread;
        }

        /* synthetic */ g(com.google.common.util.concurrent.b bVar) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, j jVar2) {
            jVar.f16138c = jVar2;
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f16114g != jVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).f16114g = jVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f16113f != dVar) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).f16113f = dVar2;
                return true;
            }
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            synchronized (abstractFuture) {
                if (((AbstractFuture) abstractFuture).f16112e != obj) {
                    return false;
                }
                ((AbstractFuture) abstractFuture).f16112e = obj2;
                return true;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class h<V> extends AbstractFuture<V> {
        @Override // com.google.common.util.concurrent.AbstractFuture, com.google.common.util.concurrent.ListenableFuture
        public final void a(Runnable runnable, Executor executor) {
            super.a(runnable, executor);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final boolean cancel(boolean z) {
            return super.cancel(z);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get() throws InterruptedException, ExecutionException {
            return (V) super.get();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isCancelled() {
            return super.isCancelled();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        public final boolean isDone() {
            return super.isDone();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture, java.util.concurrent.Future
        @CanIgnoreReturnValue
        public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            return (V) super.get(j, timeUnit);
        }
    }

    /* loaded from: classes2.dex */
    private static final class i extends a {

        /* renamed from: a */
        static final Unsafe f16130a;

        /* renamed from: b */
        static final long f16131b;

        /* renamed from: c */
        static final long f16132c;

        /* renamed from: d */
        static final long f16133d;

        /* renamed from: e */
        static final long f16134e;

        /* renamed from: f */
        static final long f16135f;

        static {
            Unsafe unsafe;
            try {
                try {
                    unsafe = Unsafe.getUnsafe();
                } catch (SecurityException unused) {
                    unsafe = (Unsafe) AccessController.doPrivileged(new com.google.common.util.concurrent.c());
                }
                try {
                    f16132c = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("g"));
                    f16131b = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("f"));
                    f16133d = unsafe.objectFieldOffset(AbstractFuture.class.getDeclaredField("e"));
                    f16134e = unsafe.objectFieldOffset(j.class.getDeclaredField("b"));
                    f16135f = unsafe.objectFieldOffset(j.class.getDeclaredField("c"));
                    f16130a = unsafe;
                } catch (Exception e2) {
                    Throwables.d(e2);
                    throw new RuntimeException(e2);
                }
            } catch (PrivilegedActionException e3) {
                throw new RuntimeException("Could not initialize intrinsics", e3.getCause());
            }
        }

        private i() {
            super();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, Thread thread) {
            f16130a.putObject(jVar, f16134e, thread);
        }

        /* synthetic */ i(com.google.common.util.concurrent.b bVar) {
            this();
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        void a(j jVar, j jVar2) {
            f16130a.putObject(jVar, f16135f, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, j jVar, j jVar2) {
            return f16130a.compareAndSwapObject(abstractFuture, f16132c, jVar, jVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, d dVar, d dVar2) {
            return f16130a.compareAndSwapObject(abstractFuture, f16131b, dVar, dVar2);
        }

        @Override // com.google.common.util.concurrent.AbstractFuture.a
        boolean a(AbstractFuture<?> abstractFuture, Object obj, Object obj2) {
            return f16130a.compareAndSwapObject(abstractFuture, f16133d, obj, obj2);
        }
    }

    /* loaded from: classes2.dex */
    public static final class j {

        /* renamed from: a */
        static final j f16136a = new j(false);

        /* renamed from: b */
        @Nullable
        volatile Thread f16137b;

        /* renamed from: c */
        @Nullable
        volatile j f16138c;

        j(boolean z) {
        }

        void a(j jVar) {
            AbstractFuture.f16110c.a(this, jVar);
        }

        j() {
            AbstractFuture.f16110c.a(this, Thread.currentThread());
        }

        void a() {
            Thread thread = this.f16137b;
            if (thread != null) {
                this.f16137b = null;
                LockSupport.unpark(thread);
            }
        }
    }

    static {
        a gVar;
        try {
            gVar = new i();
        } catch (Throwable th) {
            try {
                gVar = new e(AtomicReferenceFieldUpdater.newUpdater(j.class, Thread.class, "b"), AtomicReferenceFieldUpdater.newUpdater(j.class, j.class, "c"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, j.class, "g"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, d.class, "f"), AtomicReferenceFieldUpdater.newUpdater(AbstractFuture.class, Object.class, "e"));
            } catch (Throwable th2) {
                f16109b.log(Level.SEVERE, "UnsafeAtomicHelper is broken!", th);
                f16109b.log(Level.SEVERE, "SafeAtomicHelper is broken!", th2);
                gVar = new g();
            }
        }
        f16110c = gVar;
        f16111d = new Object();
    }

    private void f() {
        j jVar;
        do {
            jVar = this.f16114g;
        } while (!f16110c.a((AbstractFuture<?>) this, jVar, j.f16136a));
        while (jVar != null) {
            jVar.a();
            jVar = jVar.f16138c;
        }
    }

    @Beta
    public void c() {
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public boolean cancel(boolean z) {
        Object obj = this.f16112e;
        if (!(obj == null) && !(obj instanceof f)) {
            return false;
        }
        b bVar = new b(z, f16108a ? new CancellationException("Future.cancel() was called.") : null);
        boolean z2 = false;
        Object obj2 = obj;
        AbstractFuture<V> abstractFuture = this;
        while (true) {
            if (f16110c.a((AbstractFuture<?>) abstractFuture, obj2, (Object) bVar)) {
                if (z) {
                    abstractFuture.d();
                }
                e(abstractFuture);
                if (!(obj2 instanceof f)) {
                    return true;
                }
                ListenableFuture<? extends V> listenableFuture = ((f) obj2).f16129b;
                if (listenableFuture instanceof h) {
                    abstractFuture = (AbstractFuture) listenableFuture;
                    obj2 = abstractFuture.f16112e;
                    if (!(obj2 == null) && !(obj2 instanceof f)) {
                        return true;
                    }
                    z2 = true;
                } else {
                    listenableFuture.cancel(z);
                    return true;
                }
            } else {
                obj2 = abstractFuture.f16112e;
                if (!(obj2 instanceof f)) {
                    return z2;
                }
            }
        }
    }

    protected void d() {
    }

    public final boolean e() {
        Object obj = this.f16112e;
        return (obj instanceof b) && ((b) obj).f16115a;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException, ExecutionException {
        long nanos = timeUnit.toNanos(j2);
        if (!Thread.interrupted()) {
            Object obj = this.f16112e;
            if ((obj != null) & (!(obj instanceof f))) {
                return b(obj);
            }
            long nanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
            if (nanos >= 1000) {
                j jVar = this.f16114g;
                if (jVar != j.f16136a) {
                    j jVar2 = new j();
                    do {
                        jVar2.a(jVar);
                        if (f16110c.a((AbstractFuture<?>) this, jVar, jVar2)) {
                            do {
                                LockSupport.parkNanos(this, nanos);
                                if (!Thread.interrupted()) {
                                    Object obj2 = this.f16112e;
                                    if ((obj2 != null) & (!(obj2 instanceof f))) {
                                        return b(obj2);
                                    }
                                    nanos = nanoTime - System.nanoTime();
                                } else {
                                    a(jVar2);
                                    throw new InterruptedException();
                                }
                            } while (nanos >= 1000);
                            a(jVar2);
                        } else {
                            jVar = this.f16114g;
                        }
                    } while (jVar != j.f16136a);
                }
                return b(this.f16112e);
            }
            while (nanos > 0) {
                Object obj3 = this.f16112e;
                if ((obj3 != null) & (!(obj3 instanceof f))) {
                    return b(obj3);
                }
                if (!Thread.interrupted()) {
                    nanos = nanoTime - System.nanoTime();
                } else {
                    throw new InterruptedException();
                }
            }
            throw new TimeoutException();
        }
        throw new InterruptedException();
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return this.f16112e instanceof b;
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        Object obj = this.f16112e;
        return (obj != null) & (obj instanceof f ? false : true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private V b(Object obj) throws ExecutionException {
        if (!(obj instanceof b)) {
            if (!(obj instanceof c)) {
                if (obj == f16111d) {
                    return null;
                }
                return obj;
            }
            throw new ExecutionException(((c) obj).f16118b);
        }
        throw a("Task was cancelled.", ((b) obj).f16116b);
    }

    public static void e(AbstractFuture<?> abstractFuture) {
        d dVar = null;
        while (true) {
            abstractFuture.f();
            abstractFuture.c();
            d a2 = abstractFuture.a(dVar);
            while (a2 != null) {
                dVar = a2.f16122d;
                Runnable runnable = a2.f16120b;
                if (runnable instanceof f) {
                    f fVar = (f) runnable;
                    abstractFuture = fVar.f16128a;
                    if (((AbstractFuture) abstractFuture).f16112e == fVar) {
                        if (f16110c.a((AbstractFuture<?>) abstractFuture, (Object) fVar, b((ListenableFuture<?>) fVar.f16129b))) {
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    b(runnable, a2.f16121c);
                }
                a2 = dVar;
            }
            return;
        }
    }

    private void a(j jVar) {
        jVar.f16137b = null;
        while (true) {
            j jVar2 = this.f16114g;
            if (jVar2 == j.f16136a) {
                return;
            }
            j jVar3 = null;
            while (jVar2 != null) {
                j jVar4 = jVar2.f16138c;
                if (jVar2.f16137b != null) {
                    jVar3 = jVar2;
                } else if (jVar3 != null) {
                    jVar3.f16138c = jVar4;
                    if (jVar3.f16137b == null) {
                        break;
                    }
                } else if (!f16110c.a((AbstractFuture<?>) this, jVar2, jVar4)) {
                    break;
                }
                jVar2 = jVar4;
            }
            return;
        }
    }

    public static Object b(ListenableFuture<?> listenableFuture) {
        if (listenableFuture instanceof h) {
            return ((AbstractFuture) listenableFuture).f16112e;
        }
        try {
            Object a2 = Futures.a((Future<Object>) listenableFuture);
            if (a2 == null) {
                a2 = f16111d;
            }
            return a2;
        } catch (CancellationException e2) {
            return new b(false, e2);
        } catch (ExecutionException e3) {
            return new c(e3.getCause());
        } catch (Throwable th) {
            return new c(th);
        }
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void a(Runnable runnable, Executor executor) {
        Preconditions.a(runnable, "Runnable was null.");
        Preconditions.a(executor, "Executor was null.");
        d dVar = this.f16113f;
        if (dVar != d.f16119a) {
            d dVar2 = new d(runnable, executor);
            do {
                dVar2.f16122d = dVar;
                if (f16110c.a((AbstractFuture<?>) this, dVar, dVar2)) {
                    return;
                } else {
                    dVar = this.f16113f;
                }
            } while (dVar != d.f16119a);
        }
        b(runnable, executor);
    }

    private static void b(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f16109b.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    @CanIgnoreReturnValue
    public boolean a(@Nullable V v) {
        if (v == null) {
            v = (V) f16111d;
        }
        if (!f16110c.a((AbstractFuture<?>) this, (Object) null, (Object) v)) {
            return false;
        }
        e(this);
        return true;
    }

    @CanIgnoreReturnValue
    public boolean a(Throwable th) {
        Preconditions.a(th);
        if (!f16110c.a((AbstractFuture<?>) this, (Object) null, (Object) new c(th))) {
            return false;
        }
        e(this);
        return true;
    }

    public final void a(@Nullable Future<?> future) {
        if ((future != null) && isCancelled()) {
            future.cancel(e());
        }
    }

    private d a(d dVar) {
        d dVar2;
        do {
            dVar2 = this.f16113f;
        } while (!f16110c.a((AbstractFuture<?>) this, dVar2, d.f16119a));
        d dVar3 = dVar;
        d dVar4 = dVar2;
        while (dVar4 != null) {
            d dVar5 = dVar4.f16122d;
            dVar4.f16122d = dVar3;
            dVar3 = dVar4;
            dVar4 = dVar5;
        }
        return dVar3;
    }

    @Override // java.util.concurrent.Future
    @CanIgnoreReturnValue
    public V get() throws InterruptedException, ExecutionException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.f16112e;
            if ((obj2 != null) & (!(obj2 instanceof f))) {
                return b(obj2);
            }
            j jVar = this.f16114g;
            if (jVar != j.f16136a) {
                j jVar2 = new j();
                do {
                    jVar2.a(jVar);
                    if (f16110c.a((AbstractFuture<?>) this, jVar, jVar2)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.f16112e;
                            } else {
                                a(jVar2);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof f))));
                        return b(obj);
                    }
                    jVar = this.f16114g;
                } while (jVar != j.f16136a);
            }
            return b(this.f16112e);
        }
        throw new InterruptedException();
    }

    private static CancellationException a(@Nullable String str, @Nullable Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }
}
