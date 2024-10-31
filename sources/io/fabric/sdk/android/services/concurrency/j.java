package io.fabric.sdk.android.services.concurrency;

import io.fabric.sdk.android.services.concurrency.AsyncTask;
import java.util.Collection;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* compiled from: PriorityAsyncTask.java */
/* loaded from: classes3.dex */
public abstract class j<Params, Progress, Result> extends AsyncTask<Params, Progress, Result> implements g<p>, m, p, f {
    private final n o = new n();

    /* compiled from: PriorityAsyncTask.java */
    /* loaded from: classes3.dex */
    public static class a<Result> implements Executor {

        /* renamed from: a */
        private final Executor f26956a;

        /* renamed from: b */
        private final j f26957b;

        public a(Executor executor, j jVar) {
            this.f26956a = executor;
            this.f26957b = jVar;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f26956a.execute(new i(this, runnable, null));
        }
    }

    public final void a(ExecutorService executorService, Params... paramsArr) {
        super.a(new a(executorService, this), paramsArr);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public boolean areDependenciesMet() {
        return ((g) ((m) d())).areDependenciesMet();
    }

    @Override // java.lang.Comparable
    public int compareTo(Object obj) {
        return Priority.compareTo(this, obj);
    }

    public g d() {
        return this.o;
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    public Collection<p> getDependencies() {
        return ((g) ((m) d())).getDependencies();
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public boolean isFinished() {
        return ((p) ((m) d())).isFinished();
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public void setError(Throwable th) {
        ((p) ((m) d())).setError(th);
    }

    @Override // io.fabric.sdk.android.services.concurrency.p
    public void setFinished(boolean z) {
        ((p) ((m) d())).setFinished(z);
    }

    @Override // io.fabric.sdk.android.services.concurrency.g
    /* renamed from: a */
    public void addDependency(p pVar) {
        if (a() == AsyncTask.Status.PENDING) {
            ((g) ((m) d())).addDependency(pVar);
            return;
        }
        throw new IllegalStateException("Must not add Dependency after task is running");
    }
}
