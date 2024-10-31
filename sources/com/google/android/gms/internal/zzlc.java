package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class zzlc<R extends Result> extends PendingResult<R> {
    private boolean zzL;
    private volatile R zzaaX;
    protected final zza<R> zzabi;
    private ResultCallback<? super R> zzabk;
    private volatile boolean zzabl;
    private boolean zzabm;
    private com.google.android.gms.common.internal.zzq zzabn;
    private Integer zzabo;
    private volatile zzlq<R> zzabp;
    private final Object zzabh = new Object();
    private final CountDownLatch zzoS = new CountDownLatch(1);
    private final ArrayList<PendingResult.zza> zzabj = new ArrayList<>();

    /* loaded from: classes.dex */
    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    zzb((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzlc) message.obj).zzw(Status.d);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzlc<R> zzlcVar, long j) {
            sendMessageDelayed(obtainMessage(2, zzlcVar), j);
        }

        /* JADX WARN: Multi-variable type inference failed */
        protected void zzb(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzlc.zzd(r);
                throw e;
            }
        }

        public void zznM() {
            removeMessages(2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Deprecated
    public zzlc(Looper looper) {
        this.zzabi = new zza<>(looper);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public zzlc(GoogleApiClient googleApiClient) {
        this.zzabi = new zza<>(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private R get() {
        R r;
        synchronized (this.zzabh) {
            com.google.android.gms.common.internal.zzx.a(this.zzabl ? false : true, "Result has already been consumed.");
            com.google.android.gms.common.internal.zzx.a(isReady(), "Result is not ready.");
            r = this.zzaaX;
            this.zzaaX = null;
            this.zzabk = null;
            this.zzabl = true;
        }
        zznL();
        return r;
    }

    private void zzc(R r) {
        this.zzaaX = r;
        this.zzabn = null;
        this.zzoS.countDown();
        Status status = this.zzaaX.getStatus();
        if (this.zzabk != null) {
            this.zzabi.zznM();
            if (!this.zzL) {
                this.zzabi.zza((ResultCallback<? super ResultCallback<? super R>>) this.zzabk, (ResultCallback<? super R>) get());
            }
        }
        Iterator<PendingResult.zza> it = this.zzabj.iterator();
        while (it.hasNext()) {
            it.next().a(status);
        }
        this.zzabj.clear();
    }

    public static void zzd(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e) {
                Log.w("BasePendingResult", "Unable to release " + result, e);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await() {
        com.google.android.gms.common.internal.zzx.a(Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread");
        com.google.android.gms.common.internal.zzx.a(!this.zzabl, "Result has already been consumed");
        com.google.android.gms.common.internal.zzx.a(this.zzabp == null, "Cannot await if then() has been called.");
        try {
            this.zzoS.await();
        } catch (InterruptedException e) {
            zzw(Status.b);
        }
        com.google.android.gms.common.internal.zzx.a(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R await(long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzx.a(j <= 0 || Looper.myLooper() != Looper.getMainLooper(), "await must not be called on the UI thread when time is greater than zero.");
        com.google.android.gms.common.internal.zzx.a(!this.zzabl, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzx.a(this.zzabp == null, "Cannot await if then() has been called.");
        try {
            if (!this.zzoS.await(j, timeUnit)) {
                zzw(Status.d);
            }
        } catch (InterruptedException e) {
            zzw(Status.b);
        }
        com.google.android.gms.common.internal.zzx.a(isReady(), "Result is not ready.");
        return get();
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public void cancel() {
        synchronized (this.zzabh) {
            if (this.zzL || this.zzabl) {
                return;
            }
            if (this.zzabn != null) {
                try {
                    this.zzabn.a();
                } catch (RemoteException e) {
                }
            }
            zzd(this.zzaaX);
            this.zzabk = null;
            this.zzL = true;
            zzc(zzb(Status.e));
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public boolean isCanceled() {
        boolean z;
        synchronized (this.zzabh) {
            z = this.zzL;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zzoS.getCount() == 0;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback) {
        com.google.android.gms.common.internal.zzx.a(!this.zzabl, "Result has already been consumed.");
        synchronized (this.zzabh) {
            com.google.android.gms.common.internal.zzx.a(this.zzabp == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzabi.zza((ResultCallback<? super ResultCallback<? super R>>) resultCallback, (ResultCallback<? super R>) get());
            } else {
                this.zzabk = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void setResultCallback(ResultCallback<? super R> resultCallback, long j, TimeUnit timeUnit) {
        com.google.android.gms.common.internal.zzx.a(!this.zzabl, "Result has already been consumed.");
        synchronized (this.zzabh) {
            com.google.android.gms.common.internal.zzx.a(this.zzabp == null, "Cannot set callbacks if then() has been called.");
            if (isCanceled()) {
                return;
            }
            if (isReady()) {
                this.zzabi.zza((ResultCallback<? super ResultCallback<? super R>>) resultCallback, (ResultCallback<? super R>) get());
            } else {
                this.zzabk = resultCallback;
                this.zzabi.zza(this, timeUnit.toMillis(j));
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void zza(PendingResult.zza zzaVar) {
        com.google.android.gms.common.internal.zzx.a(!this.zzabl, "Result has already been consumed.");
        com.google.android.gms.common.internal.zzx.b(zzaVar != null, "Callback cannot be null.");
        synchronized (this.zzabh) {
            if (isReady()) {
                zzaVar.a(this.zzaaX.getStatus());
            } else {
                this.zzabj.add(zzaVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void zza(com.google.android.gms.common.internal.zzq zzqVar) {
        synchronized (this.zzabh) {
            this.zzabn = zzqVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract R zzb(Status status);

    public final void zzb(R r) {
        synchronized (this.zzabh) {
            if (this.zzabm || this.zzL) {
                zzd(r);
                return;
            }
            com.google.android.gms.common.internal.zzx.a(!isReady(), "Results have already been set");
            com.google.android.gms.common.internal.zzx.a(this.zzabl ? false : true, "Result has already been consumed");
            zzc(r);
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public Integer zznF() {
        return this.zzabo;
    }

    protected void zznL() {
    }

    public final void zzw(Status status) {
        synchronized (this.zzabh) {
            if (!isReady()) {
                zzb((zzlc<R>) zzb(status));
                this.zzabm = true;
            }
        }
    }
}
