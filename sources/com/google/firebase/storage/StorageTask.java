package com.google.firebase.storage;

import android.app.Activity;
import android.util.Log;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.CancellationTokenSource;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.RuntimeExecutionException;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.annotations.PublicApi;
import com.google.firebase.storage.StorageTask.ProvideError;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.Executor;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
@PublicApi
/* loaded from: classes2.dex */
public abstract class StorageTask<TResult extends ProvideError> extends ControllableTask<TResult> {

    /* renamed from: a, reason: collision with root package name */
    private static final HashMap<Integer, HashSet<Integer>> f18102a = new HashMap<>();

    /* renamed from: b, reason: collision with root package name */
    private static final HashMap<Integer, HashSet<Integer>> f18103b = new HashMap<>();

    /* renamed from: c, reason: collision with root package name */
    protected final Object f18104c = new Object();

    /* renamed from: d, reason: collision with root package name */
    final v<OnSuccessListener<? super TResult>, TResult> f18105d = new v<>(this, 128, j.a(this));

    /* renamed from: e, reason: collision with root package name */
    final v<OnFailureListener, TResult> f18106e = new v<>(this, 64, k.a(this));

    /* renamed from: f, reason: collision with root package name */
    final v<OnCompleteListener<TResult>, TResult> f18107f = new v<>(this, 448, l.a(this));

    /* renamed from: g, reason: collision with root package name */
    final v<OnCanceledListener, TResult> f18108g = new v<>(this, 256, m.a(this));

    /* renamed from: h, reason: collision with root package name */
    final v<OnProgressListener<? super TResult>, TResult> f18109h = new v<>(this, -465, n.a());
    final v<OnPausedListener<? super TResult>, TResult> i = new v<>(this, 16, o.a());
    private volatile int j = 1;
    private TResult k;

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    /* loaded from: classes2.dex */
    public interface ProvideError {
        Exception a();
    }

    /* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
    @PublicApi
    /* loaded from: classes2.dex */
    public class SnapshotBase implements ProvideError {

        /* renamed from: a, reason: collision with root package name */
        private final Exception f18110a;

        @PublicApi
        public SnapshotBase(Exception exc) {
            if (exc == null) {
                if (StorageTask.this.c()) {
                    this.f18110a = StorageException.fromErrorStatus(Status.f10708e);
                    return;
                } else if (StorageTask.this.f() == 64) {
                    this.f18110a = StorageException.fromErrorStatus(Status.f10706c);
                    return;
                } else {
                    this.f18110a = null;
                    return;
                }
            }
            this.f18110a = exc;
        }

        @Override // com.google.firebase.storage.StorageTask.ProvideError
        @PublicApi
        public Exception a() {
            return this.f18110a;
        }
    }

    static {
        f18102a.put(1, new HashSet<>(Arrays.asList(16, 256)));
        f18102a.put(2, new HashSet<>(Arrays.asList(8, 32)));
        f18102a.put(4, new HashSet<>(Arrays.asList(8, 32)));
        f18102a.put(16, new HashSet<>(Arrays.asList(2, 256)));
        f18102a.put(64, new HashSet<>(Arrays.asList(2, 256)));
        f18103b.put(1, new HashSet<>(Arrays.asList(2, 64)));
        f18103b.put(2, new HashSet<>(Arrays.asList(4, 64, 128)));
        f18103b.put(4, new HashSet<>(Arrays.asList(4, 64, 128)));
        f18103b.put(8, new HashSet<>(Arrays.asList(16, 64, 128)));
        f18103b.put(32, new HashSet<>(Arrays.asList(256, 64, 128)));
    }

    private String a(int i) {
        return i != 1 ? i != 2 ? i != 4 ? i != 8 ? i != 16 ? i != 32 ? i != 64 ? i != 128 ? i != 256 ? "Unknown Internal State!" : "INTERNAL_STATE_CANCELED" : "INTERNAL_STATE_SUCCESS" : "INTERNAL_STATE_FAILURE" : "INTERNAL_STATE_CANCELING" : "INTERNAL_STATE_PAUSED" : "INTERNAL_STATE_PAUSING" : "INTERNAL_STATE_IN_PROGRESS" : "INTERNAL_STATE_QUEUED" : "INTERNAL_STATE_NOT_STARTED";
    }

    private void v() {
        if (d() || j() || f() == 2 || a(256, false)) {
            return;
        }
        a(64, false);
    }

    private TResult w() {
        TResult tresult = this.k;
        if (tresult != null) {
            return tresult;
        }
        if (!d()) {
            return null;
        }
        if (this.k == null) {
            this.k = t();
        }
        return this.k;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public boolean c() {
        return f() == 256;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public boolean d() {
        return (f() & 448) != 0;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public boolean e() {
        return (f() & 128) != 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int f() {
        return this.j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Runnable g() {
        return f.a(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract StorageReference h();

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object i() {
        return this.f18104c;
    }

    @PublicApi
    public boolean j() {
        return (f() & 16) != 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @PublicApi
    public void k() {
    }

    @PublicApi
    protected void l() {
    }

    @PublicApi
    protected void m() {
    }

    @PublicApi
    protected void n() {
    }

    @PublicApi
    protected void o() {
    }

    @PublicApi
    protected void p() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean q() {
        if (!a(2, false)) {
            return false;
        }
        s();
        return true;
    }

    abstract void r();

    abstract void s();

    /* JADX INFO: Access modifiers changed from: package-private */
    public TResult t() {
        TResult u;
        synchronized (this.f18104c) {
            u = u();
        }
        return u;
    }

    abstract TResult u();

    private <TContinuationResult> Task<TContinuationResult> c(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        this.f18107f.a((Activity) null, executor, (Executor) p.a(this, continuation, taskCompletionSource));
        return taskCompletionSource.a();
    }

    private <TContinuationResult> Task<TContinuationResult> d(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        CancellationTokenSource cancellationTokenSource = new CancellationTokenSource();
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource(cancellationTokenSource.b());
        this.f18107f.a((Activity) null, executor, (Executor) e.a(this, continuation, taskCompletionSource, cancellationTokenSource));
        return taskCompletionSource.a();
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public TResult b() {
        if (w() != null) {
            Exception a2 = w().a();
            if (a2 == null) {
                return w();
            }
            throw new RuntimeExecutionException(a2);
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public <TContinuationResult> Task<TContinuationResult> b(Continuation<TResult, Task<TContinuationResult>> continuation) {
        return d(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public <TContinuationResult> Task<TContinuationResult> b(Executor executor, Continuation<TResult, Task<TContinuationResult>> continuation) {
        return d(executor, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, OnSuccessListener onSuccessListener, ProvideError provideError) {
        q.a().b(storageTask);
        onSuccessListener.onSuccess(provideError);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, OnFailureListener onFailureListener, ProvideError provideError) {
        q.a().b(storageTask);
        onFailureListener.onFailure(provideError.a());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, OnCompleteListener onCompleteListener, ProvideError provideError) {
        q.a().b(storageTask);
        onCompleteListener.onComplete(storageTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, OnCanceledListener onCanceledListener, ProvideError provideError) {
        q.a().b(storageTask);
        onCanceledListener.a();
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public <X extends Throwable> TResult a(Class<X> cls) throws Throwable {
        if (w() != null) {
            if (!cls.isInstance(w().a())) {
                Exception a2 = w().a();
                if (a2 == null) {
                    return w();
                }
                throw new RuntimeExecutionException(a2);
            }
            throw cls.cast(w().a());
        }
        throw new IllegalStateException();
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public Exception a() {
        if (w() == null) {
            return null;
        }
        return w().a();
    }

    boolean a(int[] iArr, boolean z) {
        HashMap<Integer, HashSet<Integer>> hashMap = z ? f18102a : f18103b;
        synchronized (this.f18104c) {
            for (int i : iArr) {
                HashSet<Integer> hashSet = hashMap.get(Integer.valueOf(f()));
                if (hashSet != null && hashSet.contains(Integer.valueOf(i))) {
                    this.j = i;
                    int i2 = this.j;
                    if (i2 == 2) {
                        q.a().a(this);
                        o();
                    } else if (i2 == 4) {
                        n();
                    } else if (i2 == 16) {
                        m();
                    } else if (i2 == 64) {
                        l();
                    } else if (i2 == 128) {
                        p();
                    } else if (i2 == 256) {
                        k();
                    }
                    this.f18105d.a();
                    this.f18106e.a();
                    this.f18108g.a();
                    this.f18107f.a();
                    this.i.a();
                    this.f18109h.a();
                    if (Log.isLoggable("StorageTask", 3)) {
                        Log.d("StorageTask", "changed internal state to: " + a(i) + " isUser: " + z + " from state:" + a(this.j));
                    }
                    return true;
                }
            }
            Log.w("StorageTask", "unable to change internal state to: " + a(iArr) + " isUser: " + z + " from state:" + a(this.j));
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i, boolean z) {
        return a(new int[]{i}, z);
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(OnSuccessListener<? super TResult> onSuccessListener) {
        Preconditions.a(onSuccessListener);
        this.f18105d.a((Activity) null, (Executor) null, (Executor) onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Executor executor, OnSuccessListener<? super TResult> onSuccessListener) {
        Preconditions.a(executor);
        Preconditions.a(onSuccessListener);
        this.f18105d.a((Activity) null, executor, (Executor) onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Activity activity, OnSuccessListener<? super TResult> onSuccessListener) {
        Preconditions.a(activity);
        Preconditions.a(onSuccessListener);
        this.f18105d.a(activity, (Executor) null, (Executor) onSuccessListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(OnFailureListener onFailureListener) {
        Preconditions.a(onFailureListener);
        this.f18106e.a((Activity) null, (Executor) null, (Executor) onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Executor executor, OnFailureListener onFailureListener) {
        Preconditions.a(onFailureListener);
        Preconditions.a(executor);
        this.f18106e.a((Activity) null, executor, (Executor) onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Activity activity, OnFailureListener onFailureListener) {
        Preconditions.a(onFailureListener);
        Preconditions.a(activity);
        this.f18106e.a(activity, (Executor) null, (Executor) onFailureListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(OnCompleteListener<TResult> onCompleteListener) {
        Preconditions.a(onCompleteListener);
        this.f18107f.a((Activity) null, (Executor) null, (Executor) onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Executor executor, OnCompleteListener<TResult> onCompleteListener) {
        Preconditions.a(onCompleteListener);
        Preconditions.a(executor);
        this.f18107f.a((Activity) null, executor, (Executor) onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Activity activity, OnCompleteListener<TResult> onCompleteListener) {
        Preconditions.a(onCompleteListener);
        Preconditions.a(activity);
        this.f18107f.a(activity, (Executor) null, (Executor) onCompleteListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(OnCanceledListener onCanceledListener) {
        Preconditions.a(onCanceledListener);
        this.f18108g.a((Activity) null, (Executor) null, (Executor) onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public StorageTask<TResult> a(Executor executor, OnCanceledListener onCanceledListener) {
        Preconditions.a(onCanceledListener);
        Preconditions.a(executor);
        this.f18108g.a((Activity) null, executor, (Executor) onCanceledListener);
        return this;
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public <TContinuationResult> Task<TContinuationResult> a(Continuation<TResult, TContinuationResult> continuation) {
        return c(null, continuation);
    }

    @Override // com.google.android.gms.tasks.Task
    @PublicApi
    public <TContinuationResult> Task<TContinuationResult> a(Executor executor, Continuation<TResult, TContinuationResult> continuation) {
        return c(executor, continuation);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, Task task) {
        try {
            Object then = continuation.then(storageTask);
            if (taskCompletionSource.a().d()) {
                return;
            }
            taskCompletionSource.a((TaskCompletionSource) then);
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                taskCompletionSource.a((Exception) e2.getCause());
            } else {
                taskCompletionSource.a((Exception) e2);
            }
        } catch (Exception e3) {
            taskCompletionSource.a(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask, Continuation continuation, TaskCompletionSource taskCompletionSource, CancellationTokenSource cancellationTokenSource, Task task) {
        try {
            Task task2 = (Task) continuation.then(storageTask);
            if (taskCompletionSource.a().d()) {
                return;
            }
            if (task2 == null) {
                taskCompletionSource.a(new NullPointerException("Continuation returned null"));
                return;
            }
            taskCompletionSource.getClass();
            task2.a(g.a(taskCompletionSource));
            taskCompletionSource.getClass();
            task2.a(h.a(taskCompletionSource));
            cancellationTokenSource.getClass();
            task2.a(i.a(cancellationTokenSource));
        } catch (RuntimeExecutionException e2) {
            if (e2.getCause() instanceof Exception) {
                taskCompletionSource.a((Exception) e2.getCause());
            } else {
                taskCompletionSource.a((Exception) e2);
            }
        } catch (Exception e3) {
            taskCompletionSource.a(e3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void a(StorageTask storageTask) {
        try {
            storageTask.r();
        } finally {
            storageTask.v();
        }
    }

    private String a(int[] iArr) {
        if (iArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i : iArr) {
            sb.append(a(i));
            sb.append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
