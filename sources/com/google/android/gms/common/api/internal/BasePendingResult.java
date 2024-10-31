package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.base.zap;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepForSdk
@KeepName
/* loaded from: classes.dex */
public abstract class BasePendingResult<R extends Result> extends PendingResult<R> {

    /* renamed from: a */
    static final ThreadLocal<Boolean> f10720a = new T();

    /* renamed from: b */
    private final Object f10721b;

    /* renamed from: c */
    private final CallbackHandler<R> f10722c;

    /* renamed from: d */
    private final WeakReference<GoogleApiClient> f10723d;

    /* renamed from: e */
    private final CountDownLatch f10724e;

    /* renamed from: f */
    private final ArrayList<PendingResult.StatusListener> f10725f;

    /* renamed from: g */
    private ResultCallback<? super R> f10726g;

    /* renamed from: h */
    private final AtomicReference<N> f10727h;
    private R i;
    private Status j;
    private volatile boolean k;
    private boolean l;
    private boolean m;

    @KeepName
    private a mResultGuardian;
    private ICancelToken n;
    private volatile zacm<R> o;
    private boolean p;

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class CallbackHandler<R extends Result> extends zap {
        public CallbackHandler() {
            this(Looper.getMainLooper());
        }

        public final void a(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i != 2) {
                    StringBuilder sb = new StringBuilder(45);
                    sb.append("Don't know how to handle message: ");
                    sb.append(i);
                    Log.wtf("BasePendingResult", sb.toString(), new Exception());
                    return;
                }
                ((BasePendingResult) message.obj).b(Status.f10707d);
                return;
            }
            Pair pair = (Pair) message.obj;
            ResultCallback resultCallback = (ResultCallback) pair.first;
            Result result = (Result) pair.second;
            try {
                resultCallback.onResult(result);
            } catch (RuntimeException e2) {
                BasePendingResult.b(result);
                throw e2;
            }
        }

        public CallbackHandler(Looper looper) {
            super(looper);
        }
    }

    /* loaded from: classes.dex */
    public final class a {
        private a() {
        }

        protected final void finalize() throws Throwable {
            BasePendingResult.b(BasePendingResult.this.i);
            super.finalize();
        }

        /* synthetic */ a(BasePendingResult basePendingResult, T t) {
            this();
        }
    }

    @Deprecated
    BasePendingResult() {
        this.f10721b = new Object();
        this.f10724e = new CountDownLatch(1);
        this.f10725f = new ArrayList<>();
        this.f10727h = new AtomicReference<>();
        this.p = false;
        this.f10722c = new CallbackHandler<>(Looper.getMainLooper());
        this.f10723d = new WeakReference<>(null);
    }

    private final R g() {
        R r;
        synchronized (this.f10721b) {
            Preconditions.b(!this.k, "Result has already been consumed.");
            Preconditions.b(c(), "Result is not ready.");
            r = this.i;
            this.i = null;
            this.f10726g = null;
            this.k = true;
        }
        N andSet = this.f10727h.getAndSet(null);
        if (andSet != null) {
            andSet.a(this);
        }
        return r;
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final R a(long j, TimeUnit timeUnit) {
        if (j > 0) {
            Preconditions.c("await must not be called on the UI thread when time is greater than zero.");
        }
        Preconditions.b(!this.k, "Result has already been consumed.");
        Preconditions.b(this.o == null, "Cannot await if then() has been called.");
        try {
            if (!this.f10724e.await(j, timeUnit)) {
                b(Status.f10707d);
            }
        } catch (InterruptedException unused) {
            b(Status.f10705b);
        }
        Preconditions.b(c(), "Result is not ready.");
        return g();
    }

    @KeepForSdk
    public abstract R a(Status status);

    public boolean b() {
        boolean z;
        synchronized (this.f10721b) {
            z = this.l;
        }
        return z;
    }

    @KeepForSdk
    public final boolean c() {
        return this.f10724e.getCount() == 0;
    }

    public final Integer d() {
        return null;
    }

    public final boolean e() {
        boolean b2;
        synchronized (this.f10721b) {
            if (this.f10723d.get() == null || !this.p) {
                a();
            }
            b2 = b();
        }
        return b2;
    }

    public final void f() {
        this.p = this.p || f10720a.get().booleanValue();
    }

    private final void c(R r) {
        this.i = r;
        this.n = null;
        this.f10724e.countDown();
        this.j = this.i.getStatus();
        if (this.l) {
            this.f10726g = null;
        } else if (this.f10726g == null) {
            if (this.i instanceof Releasable) {
                this.mResultGuardian = new a(this, null);
            }
        } else {
            this.f10722c.removeMessages(2);
            this.f10722c.a(this.f10726g, g());
        }
        ArrayList<PendingResult.StatusListener> arrayList = this.f10725f;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            PendingResult.StatusListener statusListener = arrayList.get(i);
            i++;
            statusListener.a(this.j);
        }
        this.f10725f.clear();
    }

    public final void b(Status status) {
        synchronized (this.f10721b) {
            if (!c()) {
                a((BasePendingResult<R>) a(status));
                this.m = true;
            }
        }
    }

    @KeepForSdk
    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.f10721b = new Object();
        this.f10724e = new CountDownLatch(1);
        this.f10725f = new ArrayList<>();
        this.f10727h = new AtomicReference<>();
        this.p = false;
        this.f10722c = new CallbackHandler<>(googleApiClient != null ? googleApiClient.g() : Looper.getMainLooper());
        this.f10723d = new WeakReference<>(googleApiClient);
    }

    public static void b(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(result);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("BasePendingResult", sb.toString(), e2);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public final void a(ResultCallback<? super R> resultCallback) {
        synchronized (this.f10721b) {
            if (resultCallback == null) {
                this.f10726g = null;
                return;
            }
            boolean z = true;
            Preconditions.b(!this.k, "Result has already been consumed.");
            if (this.o != null) {
                z = false;
            }
            Preconditions.b(z, "Cannot set callbacks if then() has been called.");
            if (b()) {
                return;
            }
            if (c()) {
                this.f10722c.a(resultCallback, g());
            } else {
                this.f10726g = resultCallback;
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    public final void a(PendingResult.StatusListener statusListener) {
        Preconditions.a(statusListener != null, "Callback cannot be null.");
        synchronized (this.f10721b) {
            if (c()) {
                statusListener.a(this.j);
            } else {
                this.f10725f.add(statusListener);
            }
        }
    }

    @Override // com.google.android.gms.common.api.PendingResult
    @KeepForSdk
    public void a() {
        synchronized (this.f10721b) {
            if (!this.l && !this.k) {
                if (this.n != null) {
                    try {
                        this.n.cancel();
                    } catch (RemoteException unused) {
                    }
                }
                b(this.i);
                this.l = true;
                c(a(Status.f10708e));
            }
        }
    }

    @KeepForSdk
    public final void a(R r) {
        synchronized (this.f10721b) {
            if (!this.m && !this.l) {
                c();
                boolean z = true;
                Preconditions.b(!c(), "Results have already been set");
                if (this.k) {
                    z = false;
                }
                Preconditions.b(z, "Result has already been consumed");
                c(r);
                return;
            }
            b(r);
        }
    }

    public final void a(N n) {
        this.f10727h.set(n);
    }
}
