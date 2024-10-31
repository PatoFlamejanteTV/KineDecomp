package android.support.v4.content;

import android.os.Binder;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public abstract class ModernAsyncTask<Params, Progress, Result> {

    /* renamed from: c */
    private static InternalHandler f1086c;

    /* renamed from: a */
    private static final ThreadFactory f1084a = new ThreadFactory() { // from class: android.support.v4.content.ModernAsyncTask.1

        /* renamed from: a */
        private final AtomicInteger f1092a = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f1092a.getAndIncrement());
        }
    };

    /* renamed from: b */
    private static final BlockingQueue<Runnable> f1085b = new LinkedBlockingQueue(10);
    public static final Executor THREAD_POOL_EXECUTOR = new ThreadPoolExecutor(5, 128, 1, TimeUnit.SECONDS, f1085b, f1084a);

    /* renamed from: d */
    private static volatile Executor f1087d = THREAD_POOL_EXECUTOR;

    /* renamed from: g */
    private volatile Status f1090g = Status.PENDING;

    /* renamed from: h */
    private final AtomicBoolean f1091h = new AtomicBoolean();
    private final AtomicBoolean i = new AtomicBoolean();

    /* renamed from: e */
    private final WorkerRunnable<Params, Result> f1088e = new WorkerRunnable<Params, Result>() { // from class: android.support.v4.content.ModernAsyncTask.2
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.i.set(true);
            Result result = null;
            try {
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.a((Object[]) this.f1098a);
                    Binder.flushPendingCommands();
                    return result;
                } catch (Throwable th) {
                    ModernAsyncTask.this.f1091h.set(true);
                    throw th;
                }
            } finally {
                ModernAsyncTask.this.d(result);
            }
        }
    };

    /* renamed from: f */
    private final FutureTask<Result> f1089f = new FutureTask<Result>(this.f1088e) { // from class: android.support.v4.content.ModernAsyncTask.3
        AnonymousClass3(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ModernAsyncTask.this.e(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.e(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    };

    /* renamed from: android.support.v4.content.ModernAsyncTask$1 */
    /* loaded from: classes.dex */
    static class AnonymousClass1 implements ThreadFactory {

        /* renamed from: a */
        private final AtomicInteger f1092a = new AtomicInteger(1);

        AnonymousClass1() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ModernAsyncTask #" + this.f1092a.getAndIncrement());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.content.ModernAsyncTask$2 */
    /* loaded from: classes.dex */
    public class AnonymousClass2 extends WorkerRunnable<Params, Result> {
        AnonymousClass2() {
        }

        @Override // java.util.concurrent.Callable
        public Result call() throws Exception {
            ModernAsyncTask.this.i.set(true);
            Result result = null;
            try {
                try {
                    Process.setThreadPriority(10);
                    result = (Result) ModernAsyncTask.this.a((Object[]) this.f1098a);
                    Binder.flushPendingCommands();
                    return result;
                } catch (Throwable th) {
                    ModernAsyncTask.this.f1091h.set(true);
                    throw th;
                }
            } finally {
                ModernAsyncTask.this.d(result);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.content.ModernAsyncTask$3 */
    /* loaded from: classes.dex */
    public class AnonymousClass3 extends FutureTask<Result> {
        AnonymousClass3(Callable callable) {
            super(callable);
        }

        @Override // java.util.concurrent.FutureTask
        protected void done() {
            try {
                ModernAsyncTask.this.e(get());
            } catch (InterruptedException e2) {
                Log.w("AsyncTask", e2);
            } catch (CancellationException unused) {
                ModernAsyncTask.this.e(null);
            } catch (ExecutionException e3) {
                throw new RuntimeException("An error occurred while executing doInBackground()", e3.getCause());
            } catch (Throwable th) {
                throw new RuntimeException("An error occurred while executing doInBackground()", th);
            }
        }
    }

    /* renamed from: android.support.v4.content.ModernAsyncTask$4 */
    /* loaded from: classes.dex */
    public static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f1095a = new int[Status.values().length];

        static {
            try {
                f1095a[Status.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1095a[Status.FINISHED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* loaded from: classes.dex */
    public static class AsyncTaskResult<Data> {

        /* renamed from: a */
        final ModernAsyncTask f1096a;

        /* renamed from: b */
        final Data[] f1097b;

        AsyncTaskResult(ModernAsyncTask modernAsyncTask, Data... dataArr) {
            this.f1096a = modernAsyncTask;
            this.f1097b = dataArr;
        }
    }

    /* loaded from: classes.dex */
    public static class InternalHandler extends Handler {
        InternalHandler() {
            super(Looper.getMainLooper());
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            AsyncTaskResult asyncTaskResult = (AsyncTaskResult) message.obj;
            int i = message.what;
            if (i == 1) {
                asyncTaskResult.f1096a.a((ModernAsyncTask) asyncTaskResult.f1097b[0]);
            } else {
                if (i != 2) {
                    return;
                }
                asyncTaskResult.f1096a.b((Object[]) asyncTaskResult.f1097b);
            }
        }
    }

    /* loaded from: classes.dex */
    public enum Status {
        PENDING,
        RUNNING,
        FINISHED
    }

    /* loaded from: classes.dex */
    public static abstract class WorkerRunnable<Params, Result> implements Callable<Result> {

        /* renamed from: a */
        Params[] f1098a;

        WorkerRunnable() {
        }
    }

    private static Handler d() {
        InternalHandler internalHandler;
        synchronized (ModernAsyncTask.class) {
            if (f1086c == null) {
                f1086c = new InternalHandler();
            }
            internalHandler = f1086c;
        }
        return internalHandler;
    }

    public static void setDefaultExecutor(Executor executor) {
        f1087d = executor;
    }

    protected abstract Result a(Params... paramsArr);

    protected void b() {
    }

    protected void b(Progress... progressArr) {
    }

    protected void c() {
    }

    protected void c(Result result) {
    }

    public final boolean cancel(boolean z) {
        this.f1091h.set(true);
        return this.f1089f.cancel(z);
    }

    void e(Result result) {
        if (this.i.get()) {
            return;
        }
        d(result);
    }

    public final ModernAsyncTask<Params, Progress, Result> execute(Params... paramsArr) {
        return executeOnExecutor(f1087d, paramsArr);
    }

    public final ModernAsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... paramsArr) {
        if (this.f1090g != Status.PENDING) {
            int i = AnonymousClass4.f1095a[this.f1090g.ordinal()];
            if (i == 1) {
                throw new IllegalStateException("Cannot execute task: the task is already running.");
            }
            if (i != 2) {
                throw new IllegalStateException("We should never reach this state");
            }
            throw new IllegalStateException("Cannot execute task: the task has already been executed (a task can be executed only once)");
        }
        this.f1090g = Status.RUNNING;
        c();
        this.f1088e.f1098a = paramsArr;
        executor.execute(this.f1089f);
        return this;
    }

    public final Result get() throws InterruptedException, ExecutionException {
        return this.f1089f.get();
    }

    public final Status getStatus() {
        return this.f1090g;
    }

    public final boolean isCancelled() {
        return this.f1091h.get();
    }

    public static void execute(Runnable runnable) {
        f1087d.execute(runnable);
    }

    void a(Result result) {
        if (isCancelled()) {
            b((ModernAsyncTask<Params, Progress, Result>) result);
        } else {
            c(result);
        }
        this.f1090g = Status.FINISHED;
    }

    protected void b(Result result) {
        b();
    }

    public final Result get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.f1089f.get(j, timeUnit);
    }

    Result d(Result result) {
        d().obtainMessage(1, new AsyncTaskResult(this, result)).sendToTarget();
        return result;
    }
}
