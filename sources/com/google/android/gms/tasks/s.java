package com.google.android.gms.tasks;

import android.app.Activity;
import com.google.android.gms.common.api.internal.LifecycleCallback;
import com.google.android.gms.common.api.internal.LifecycleFragment;
import com.google.android.gms.common.internal.Preconditions;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public final class s<TResult> extends Task<TResult> {

    /* renamed from: a */
    private final Object f14315a = new Object();

    /* renamed from: b */
    private final p<TResult> f14316b = new p<>();

    /* renamed from: c */
    private boolean f14317c;

    /* renamed from: d */
    private volatile boolean f14318d;

    /* renamed from: e */
    private TResult f14319e;

    /* renamed from: f */
    private Exception f14320f;

    /* loaded from: classes2.dex */
    private static class a extends LifecycleCallback {

        /* renamed from: b */
        private final List<WeakReference<o<?>>> f14321b;

        private a(LifecycleFragment lifecycleFragment) {
            super(lifecycleFragment);
            this.f14321b = new ArrayList();
            this.f10774a.a("TaskOnStopCallback", this);
        }

        public static a b(Activity activity) {
            LifecycleFragment a2 = LifecycleCallback.a(activity);
            a aVar = (a) a2.a("TaskOnStopCallback", a.class);
            return aVar == null ? new a(a2) : aVar;
        }

        public final <T> void a(o<T> oVar) {
            synchronized (this.f14321b) {
                this.f14321b.add(new WeakReference<>(oVar));
            }
        }

        @Override // com.google.android.gms.common.api.internal.LifecycleCallback
        public void e() {
            synchronized (this.f14321b) {
                Iterator<WeakReference<o<?>>> it = this.f14321b.iterator();
                while (it.hasNext()) {
                    o<?> oVar = it.next().get();
                    if (oVar != null) {
                        oVar.cancel();
                    }
                }
                this.f14321b.clear();
            }
        }
    }

    private final void g() {
        Preconditions.b(this.f14317c, "Task is not yet complete");
    }

    private final void h() {
        Preconditions.b(!this.f14317c, "Task is already complete");
    }

    private final void i() {
        if (this.f14318d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    private final void j() {
        synchronized (this.f14315a) {
            if (this.f14317c) {
                this.f14316b.a(this);
            }
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        TResult tresult;
        synchronized (this.f14315a) {
            g();
            i();
            if (!cls.isInstance(this.f14320f)) {
                if (this.f14320f == null) {
                    tresult = this.f14319e;
                } else {
                    throw new RuntimeExecutionException(this.f14320f);
                }
            } else {
                throw cls.cast(this.f14320f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final TResult b() {
        TResult tresult;
        synchronized (this.f14315a) {
            g();
            i();
            if (this.f14320f == null) {
                tresult = this.f14319e;
            } else {
                throw new RuntimeExecutionException(this.f14320f);
            }
        }
        return tresult;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean c() {
        return this.f14318d;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean d() {
        boolean z;
        synchronized (this.f14315a) {
            z = this.f14317c;
        }
        return z;
    }

    @Override // com.google.android.gms.tasks.Task
    public final boolean e() {
        boolean z;
        synchronized (this.f14315a) {
            z = this.f14317c && !this.f14318d && this.f14320f == null;
        }
        return z;
    }

    public final boolean f() {
        synchronized (this.f14315a) {
            if (this.f14317c) {
                return false;
            }
            this.f14317c = true;
            this.f14318d = true;
            this.f14316b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return b(TaskExecutors.f14268a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> b(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        s sVar = new s();
        this.f14316b.a(new e(executor, continuation, sVar));
        j();
        return sVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Exception a() {
        Exception exc;
        synchronized (this.f14315a) {
            exc = this.f14320f;
        }
        return exc;
    }

    public final boolean b(TResult tresult) {
        synchronized (this.f14315a) {
            if (this.f14317c) {
                return false;
            }
            this.f14317c = true;
            this.f14319e = tresult;
            this.f14316b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(OnSuccessListener<? super TResult> onSuccessListener) {
        return a(TaskExecutors.f14268a, onSuccessListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        this.f14316b.a(new m(executor, onSuccessListener));
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        m mVar = new m(TaskExecutors.f14268a, onSuccessListener);
        this.f14316b.a(mVar);
        a.b(activity).a(mVar);
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(OnFailureListener onFailureListener) {
        return a(TaskExecutors.f14268a, onFailureListener);
    }

    public final boolean b(Exception exc) {
        Preconditions.a(exc, "Exception must not be null");
        synchronized (this.f14315a) {
            if (this.f14317c) {
                return false;
            }
            this.f14317c = true;
            this.f14320f = exc;
            this.f14316b.a(this);
            return true;
        }
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnFailureListener onFailureListener) {
        this.f14316b.a(new k(executor, onFailureListener));
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Activity activity, OnFailureListener onFailureListener) {
        k kVar = new k(TaskExecutors.f14268a, onFailureListener);
        this.f14316b.a(kVar);
        a.b(activity).a(kVar);
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(OnCompleteListener<TResult> onCompleteListener) {
        return a(TaskExecutors.f14268a, onCompleteListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        this.f14316b.a(new i(executor, onCompleteListener));
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        i iVar = new i(TaskExecutors.f14268a, onCompleteListener);
        this.f14316b.a(iVar);
        a.b(activity).a(iVar);
        j();
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> continuation) {
        return a(TaskExecutors.f14268a, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    public final <TContinuationResult> Task<TContinuationResult> a(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        s sVar = new s();
        this.f14316b.a(new c(executor, continuation, sVar));
        j();
        return sVar;
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(OnCanceledListener onCanceledListener) {
        return a(TaskExecutors.f14268a, onCanceledListener);
    }

    @Override // com.google.android.gms.tasks.Task
    public final Task<TResult> a(Executor executor, OnCanceledListener onCanceledListener) {
        this.f14316b.a(new g(executor, onCanceledListener));
        j();
        return this;
    }

    public final void a(TResult tresult) {
        synchronized (this.f14315a) {
            h();
            this.f14317c = true;
            this.f14319e = tresult;
        }
        this.f14316b.a(this);
    }

    public final void a(Exception exc) {
        Preconditions.a(exc, "Exception must not be null");
        synchronized (this.f14315a) {
            h();
            this.f14317c = true;
            this.f14320f = exc;
        }
        this.f14316b.a(this);
    }
}
