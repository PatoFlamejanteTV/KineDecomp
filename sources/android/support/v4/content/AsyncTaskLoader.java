package android.support.v4.content;

import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.os.OperationCanceledException;
import android.support.v4.util.TimeUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AsyncTaskLoader<D> extends Loader<D> {
    private final Executor j;
    volatile AsyncTaskLoader<D>.LoadTask k;
    volatile AsyncTaskLoader<D>.LoadTask l;
    long m;
    long n;
    Handler o;

    /* loaded from: classes.dex */
    public final class LoadTask extends ModernAsyncTask<Void, Void, D> implements Runnable {
        private final CountDownLatch j = new CountDownLatch(1);
        boolean k;

        LoadTask() {
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void b(D d2) {
            try {
                AsyncTaskLoader.this.a(this, d2);
            } finally {
                this.j.countDown();
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        protected void c(D d2) {
            try {
                AsyncTaskLoader.this.b(this, d2);
            } finally {
                this.j.countDown();
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            this.k = false;
            AsyncTaskLoader.this.g();
        }

        public void waitForLoader() {
            try {
                this.j.await();
            } catch (InterruptedException unused) {
            }
        }

        @Override // android.support.v4.content.ModernAsyncTask
        public D a(Void... voidArr) {
            try {
                return (D) AsyncTaskLoader.this.h();
            } catch (OperationCanceledException e2) {
                if (isCancelled()) {
                    return null;
                }
                throw e2;
            }
        }
    }

    public AsyncTaskLoader(Context context) {
        this(context, ModernAsyncTask.THREAD_POOL_EXECUTOR);
    }

    void a(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        onCanceled(d2);
        if (this.l == loadTask) {
            rollbackContentChanged();
            this.n = SystemClock.uptimeMillis();
            this.l = null;
            deliverCancellation();
            g();
        }
    }

    @Override // android.support.v4.content.Loader
    protected boolean b() {
        if (this.k == null) {
            return false;
        }
        if (!this.f1065e) {
            this.f1068h = true;
        }
        if (this.l != null) {
            if (this.k.k) {
                this.k.k = false;
                this.o.removeCallbacks(this.k);
            }
            this.k = null;
            return false;
        }
        if (this.k.k) {
            this.k.k = false;
            this.o.removeCallbacks(this.k);
            this.k = null;
            return false;
        }
        boolean cancel = this.k.cancel(false);
        if (cancel) {
            this.l = this.k;
            cancelLoadInBackground();
        }
        this.k = null;
        return cancel;
    }

    @Override // android.support.v4.content.Loader
    public void c() {
        super.c();
        cancelLoad();
        this.k = new LoadTask();
        g();
    }

    public void cancelLoadInBackground() {
    }

    @Override // android.support.v4.content.Loader
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        super.dump(str, fileDescriptor, printWriter, strArr);
        if (this.k != null) {
            printWriter.print(str);
            printWriter.print("mTask=");
            printWriter.print(this.k);
            printWriter.print(" waiting=");
            printWriter.println(this.k.k);
        }
        if (this.l != null) {
            printWriter.print(str);
            printWriter.print("mCancellingTask=");
            printWriter.print(this.l);
            printWriter.print(" waiting=");
            printWriter.println(this.l.k);
        }
        if (this.m != 0) {
            printWriter.print(str);
            printWriter.print("mUpdateThrottle=");
            TimeUtils.formatDuration(this.m, printWriter);
            printWriter.print(" mLastLoadCompleteTime=");
            TimeUtils.formatDuration(this.n, SystemClock.uptimeMillis(), printWriter);
            printWriter.println();
        }
    }

    void g() {
        if (this.l != null || this.k == null) {
            return;
        }
        if (this.k.k) {
            this.k.k = false;
            this.o.removeCallbacks(this.k);
        }
        if (this.m > 0 && SystemClock.uptimeMillis() < this.n + this.m) {
            this.k.k = true;
            this.o.postAtTime(this.k, this.n + this.m);
        } else {
            this.k.executeOnExecutor(this.j, null);
        }
    }

    protected D h() {
        return loadInBackground();
    }

    public boolean isLoadInBackgroundCanceled() {
        return this.l != null;
    }

    public abstract D loadInBackground();

    public void onCanceled(D d2) {
    }

    public void setUpdateThrottle(long j) {
        this.m = j;
        if (j != 0) {
            this.o = new Handler();
        }
    }

    public void waitForLoader() {
        AsyncTaskLoader<D>.LoadTask loadTask = this.k;
        if (loadTask != null) {
            loadTask.waitForLoader();
        }
    }

    private AsyncTaskLoader(Context context, Executor executor) {
        super(context);
        this.n = -10000L;
        this.j = executor;
    }

    void b(AsyncTaskLoader<D>.LoadTask loadTask, D d2) {
        if (this.k != loadTask) {
            a(loadTask, d2);
            return;
        }
        if (isAbandoned()) {
            onCanceled(d2);
            return;
        }
        commitContentChanged();
        this.n = SystemClock.uptimeMillis();
        this.k = null;
        deliverResult(d2);
    }
}
