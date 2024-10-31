package io.fabric.sdk.android.services.concurrency;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.LinkedList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public abstract class AsyncTask<Params, Progress, Result> {

    /* renamed from: a */
    private static final int f26930a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f26931b;

    /* renamed from: c */
    private static final int f26932c;

    /* renamed from: d */
    private static final ThreadFactory f26933d;

    /* renamed from: e */
    private static final BlockingQueue<Runnable> f26934e;

    /* renamed from: f */
    public static final Executor f26935f;

    /* renamed from: g */
    public static final Executor f26936g;

    /* renamed from: h */
    private static final b f26937h;
    private static volatile Executor i;
    private volatile Status l = Status.PENDING;
    private final AtomicBoolean m = new AtomicBoolean();
    private final AtomicBoolean n = new AtomicBoolean();
    private final d<Params, Result> j = new io.fabric.sdk.android.services.concurrency.b(this);
    private final FutureTask<Result> k = new io.fabric.sdk.android.services.concurrency.c(this, this.j);

    /* loaded from: classes3.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes3.dex */
    public static class a<Data> {

        /* renamed from: a */
        final AsyncTask f26938a;

        /* renamed from: b */
        final Data[] f26939b;

        a(AsyncTask asyncTask, Data... dataArr) {
            this.f26938a = asyncTask;
            this.f26939b = dataArr;
        }
    }

    /* loaded from: classes3.dex */
    public static class b extends Handler {
        public b() {
            super(Looper.getMainLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            a aVar = (a) message.obj;
            int i = message.what;
            if (i == 1) {
                aVar.f26938a.c(aVar.f26939b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                aVar.f26938a.b((Object[]) aVar.f26939b);
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class d<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f26942a;

        private d() {
        }

        public /* synthetic */ d(io.fabric.sdk.android.services.concurrency.a aVar) {
            this();
        }
    }

    static {
        int i2 = f26930a;
        f26931b = i2 + 1;
        f26932c = (i2 * 2) + 1;
        f26933d = new io.fabric.sdk.android.services.concurrency.a();
        f26934e = new LinkedBlockingQueue(128);
        f26935f = new ThreadPoolExecutor(f26931b, f26932c, 1L, TimeUnit.SECONDS, f26934e, f26933d);
        f26936g = new c(null);
        f26937h = new b();
        i = f26936g;
    }

    private Result d(Result result) {
        f26937h.obtainMessage(1, new a(this, result)).sendToTarget();
        return result;
    }

    public void e(Result result) {
        if (this.n.get()) {
            return;
        }
        d(result);
    }

    public abstract Result a(Params... paramsArr);

    protected abstract void a(Result result);

    protected abstract void b(Result result);

    protected void b(Progress... progressArr) {
    }

    public void c() {
    }

    /* loaded from: classes3.dex */
    public static class c implements Executor {

        /* renamed from: a */
        final LinkedList<Runnable> f26940a;

        /* renamed from: b */
        Runnable f26941b;

        private c() {
            this.f26940a = new LinkedList<>();
        }

        public synchronized void a() {
            Runnable poll = this.f26940a.poll();
            this.f26941b = poll;
            if (poll != null) {
                AsyncTask.f26935f.execute(this.f26941b);
            }
        }

        @Override // java.util.concurrent.Executor
        public synchronized void execute(Runnable runnable) {
            this.f26940a.offer(new e(this, runnable));
            if (this.f26941b == null) {
                a();
            }
        }

        /* synthetic */ c(io.fabric.sdk.android.services.concurrency.a aVar) {
            this();
        }
    }

    public static /* synthetic */ Object a(AsyncTask asyncTask, Object obj) {
        asyncTask.d(obj);
        return obj;
    }

    public void c(Result result) {
        if (b()) {
            a((AsyncTask<Params, Progress, Result>) result);
        } else {
            b((AsyncTask<Params, Progress, Result>) result);
        }
        this.l = Status.FINISHED;
    }

    public final boolean b() {
        return this.m.get();
    }

    public final Status a() {
        return this.l;
    }

    public final boolean a(boolean z) {
        this.m.set(true);
        return this.k.cancel(z);
    }

    public final AsyncTask<Params, Progress, Result> a(Executor executor, Params... paramsArr) {
        if (this.l != Status.PENDING) {
            int i2 = io.fabric.sdk.android.services.concurrency.d.f26952a[this.l.ordinal()];
            if (i2 == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i2 == 2) {
                throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
            }
        }
        this.l = Status.RUNNING;
        c();
        this.j.f26942a = paramsArr;
        executor.execute(this.k);
        return this;
    }
}
