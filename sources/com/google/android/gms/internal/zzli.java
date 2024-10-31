package com.google.android.gms.internal;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzlb;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: classes.dex */
public final class zzli extends GoogleApiClient {
    private final Context mContext;
    private final int zzaaM;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    final Api.zza<? extends zzqw, zzqx> zzaaQ;
    final com.google.android.gms.common.internal.zzf zzabI;
    final com.google.android.gms.common.internal.zzk zzabZ;
    private volatile boolean zzacb;
    private final a zzace;
    d zzacf;
    private com.google.android.gms.common.api.zza zzacn;
    private final Lock zzabt = new ReentrantLock();
    final Queue<f<?>> zzaca = new LinkedList();
    private long zzacc = 120000;
    private long zzacd = 5000;
    final Map<Api.zzc<?>, Api.zzb> zzacg = new HashMap();
    final Map<Api.zzc<?>, ConnectionResult> zzach = new HashMap();
    Set<Scope> zzaci = new HashSet();
    private ConnectionResult zzack = null;
    private final Set<zzlm<?>> zzacl = Collections.newSetFromMap(new WeakHashMap());
    final Set<f<?>> zzacm = Collections.newSetFromMap(new ConcurrentHashMap(16, 0.75f, 2));
    private final e zzaco = new fq(this);
    private final GoogleApiClient.ConnectionCallbacks zzacp = new fr(this);
    private final zzk.zza zzacq = new fs(this);
    final Map<Api<?>, Integer> zzabJ = new HashMap();
    private final Condition zzabY = this.zzabt.newCondition();
    private volatile zzlj zzacj = new zzlh(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    zzli.this.zzod();
                    return;
                case 2:
                    zzli.this.resume();
                    return;
                case 3:
                    ((b) message.obj).a(zzli.this);
                    return;
                case 4:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        private final zzlj f1759a;

        /* JADX INFO: Access modifiers changed from: protected */
        public b(zzlj zzljVar) {
            this.f1759a = zzljVar;
        }

        protected abstract void a();

        public final void a(zzli zzliVar) {
            zzliVar.zzabt.lock();
            try {
                if (zzliVar.zzacj != this.f1759a) {
                    return;
                }
                a();
            } finally {
                zzliVar.zzabt.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class c implements IBinder.DeathRecipient, e {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<f<?>> f1760a;
        private final WeakReference<com.google.android.gms.common.api.zza> b;
        private final WeakReference<IBinder> c;

        private c(f fVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
            this.b = new WeakReference<>(zzaVar);
            this.f1760a = new WeakReference<>(fVar);
            this.c = new WeakReference<>(iBinder);
        }

        /* synthetic */ c(f fVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder, fq fqVar) {
            this(fVar, zzaVar, iBinder);
        }

        private void a() {
            f<?> fVar = this.f1760a.get();
            com.google.android.gms.common.api.zza zzaVar = this.b.get();
            if (zzaVar != null && fVar != null) {
                zzaVar.a(fVar.zznF().intValue());
            }
            IBinder iBinder = this.c.get();
            if (this.c != null) {
                iBinder.unlinkToDeath(this, 0);
            }
        }

        @Override // com.google.android.gms.internal.zzli.e
        public void a(f<?> fVar) {
            a();
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class d extends fy {
        private WeakReference<zzli> b;

        d(zzli zzliVar) {
            this.b = new WeakReference<>(zzliVar);
        }

        @Override // com.google.android.gms.internal.fy
        public void a() {
            zzli zzliVar = this.b.get();
            if (zzliVar == null) {
                return;
            }
            zzliVar.resume();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface e {
        void a(f<?> fVar);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public interface f<A extends Api.zzb> {
        void cancel();

        boolean isReady();

        void zza(e eVar);

        void zzb(A a2) throws DeadObjectException;

        Integer zznF();

        void zznJ();

        int zznK();

        Api.zzc<A> zznx();

        void zzv(Status status);

        void zzw(Status status);
    }

    public zzli(Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzqw, zzqx> zzaVar, Map<Api<?>, Api.ApiOptions> map, ArrayList<GoogleApiClient.ConnectionCallbacks> arrayList, ArrayList<GoogleApiClient.OnConnectionFailedListener> arrayList2, int i) {
        this.mContext = context;
        this.zzabZ = new com.google.android.gms.common.internal.zzk(looper, this.zzacq);
        this.zzaaO = looper;
        this.zzace = new a(looper);
        this.zzaaP = googleApiAvailability;
        this.zzaaM = i;
        Iterator<GoogleApiClient.ConnectionCallbacks> it = arrayList.iterator();
        while (it.hasNext()) {
            this.zzabZ.a(it.next());
        }
        Iterator<GoogleApiClient.OnConnectionFailedListener> it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            this.zzabZ.a(it2.next());
        }
        Map<Api<?>, zzf.zza> g = zzfVar.g();
        for (Api<?> api : map.keySet()) {
            Api.ApiOptions apiOptions = map.get(api);
            int i2 = g.get(api) != null ? g.get(api).b ? 1 : 2 : 0;
            this.zzabJ.put(api, Integer.valueOf(i2));
            this.zzacg.put(api.c(), api.d() ? zza(api.b(), apiOptions, context, looper, zzfVar, this.zzacp, zza(api, i2)) : zza(api.a(), apiOptions, context, looper, zzfVar, this.zzacp, zza(api, i2)));
        }
        this.zzabI = zzfVar;
        this.zzaaQ = zzaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resume() {
        this.zzabt.lock();
        try {
            if (zzoc()) {
                connect();
            }
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.zzb, O> C zza(Api.zza<C, O> zzaVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return zzaVar.zza(context, looper, zzfVar, obj, connectionCallbacks, onConnectionFailedListener);
    }

    private GoogleApiClient.OnConnectionFailedListener zza(Api<?> api, int i) {
        return new ft(this, api, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <C extends Api.zzd, O> com.google.android.gms.common.internal.zzac zza(Api.zze<C, O> zzeVar, Object obj, Context context, Looper looper, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return new com.google.android.gms.common.internal.zzac(context, looper, zzeVar.a(), connectionCallbacks, onConnectionFailedListener, zzfVar, zzeVar.a(obj));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(GoogleApiClient googleApiClient, zzlo zzloVar, boolean z) {
        zzlx.zzagw.zzb(googleApiClient).setResultCallback(new fw(this, zzloVar, z, googleApiClient));
    }

    private static void zza(f<?> fVar, com.google.android.gms.common.api.zza zzaVar, IBinder iBinder) {
        fq fqVar = null;
        if (fVar.isReady()) {
            fVar.zza(new c(fVar, zzaVar, iBinder, fqVar));
            return;
        }
        if (iBinder == null || !iBinder.isBinderAlive()) {
            fVar.zza(null);
            fVar.cancel();
            zzaVar.a(fVar.zznF().intValue());
        } else {
            c cVar = new c(fVar, zzaVar, iBinder, fqVar);
            fVar.zza(cVar);
            try {
                iBinder.linkToDeath(cVar, 0);
            } catch (RemoteException e2) {
                fVar.cancel();
                zzaVar.a(fVar.zznF().intValue());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzod() {
        this.zzabt.lock();
        try {
            if (zzof()) {
                connect();
            }
        } finally {
            this.zzabt.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult blockingConnect() {
        ConnectionResult connectionResult;
        com.google.android.gms.common.internal.zzx.a(Looper.myLooper() != Looper.getMainLooper(), "blockingConnect must not be called on the UI thread");
        this.zzabt.lock();
        try {
            connect();
            while (isConnecting()) {
                this.zzabY.await();
            }
            connectionResult = isConnected() ? ConnectionResult.f860a : this.zzack != null ? this.zzack : new ConnectionResult(13, null);
        } catch (InterruptedException e2) {
            Thread.currentThread().interrupt();
            connectionResult = new ConnectionResult(15, null);
        } finally {
            this.zzabt.unlock();
        }
        return connectionResult;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:            r0 = new com.google.android.gms.common.ConnectionResult(14, null);     */
    @Override // com.google.android.gms.common.api.GoogleApiClient
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.google.android.gms.common.ConnectionResult blockingConnect(long r6, java.util.concurrent.TimeUnit r8) {
        /*
            r5 = this;
            android.os.Looper r0 = android.os.Looper.myLooper()
            android.os.Looper r1 = android.os.Looper.getMainLooper()
            if (r0 == r1) goto L41
            r0 = 1
        Lb:
            java.lang.String r1 = "blockingConnect must not be called on the UI thread"
            com.google.android.gms.common.internal.zzx.a(r0, r1)
            java.lang.String r0 = "TimeUnit must not be null"
            com.google.android.gms.common.internal.zzx.a(r8, r0)
            java.util.concurrent.locks.Lock r0 = r5.zzabt
            r0.lock()
            r5.connect()     // Catch: java.lang.Throwable -> L81
            long r0 = r8.toNanos(r6)     // Catch: java.lang.Throwable -> L81
        L21:
            boolean r2 = r5.isConnecting()     // Catch: java.lang.Throwable -> L81
            if (r2 == 0) goto L59
            java.util.concurrent.locks.Condition r2 = r5.zzabY     // Catch: java.lang.InterruptedException -> L43 java.lang.Throwable -> L81
            long r0 = r2.awaitNanos(r0)     // Catch: java.lang.InterruptedException -> L43 java.lang.Throwable -> L81
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 > 0) goto L21
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.InterruptedException -> L43 java.lang.Throwable -> L81
            r1 = 14
            r2 = 0
            r0.<init>(r1, r2)     // Catch: java.lang.InterruptedException -> L43 java.lang.Throwable -> L81
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
        L40:
            return r0
        L41:
            r0 = 0
            goto Lb
        L43:
            r0 = move-exception
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L81
            r0.interrupt()     // Catch: java.lang.Throwable -> L81
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.Throwable -> L81
            r1 = 15
            r2 = 0
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L81
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L40
        L59:
            boolean r0 = r5.isConnected()     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L67
            com.google.android.gms.common.ConnectionResult r0 = com.google.android.gms.common.ConnectionResult.f860a     // Catch: java.lang.Throwable -> L81
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L40
        L67:
            com.google.android.gms.common.ConnectionResult r0 = r5.zzack     // Catch: java.lang.Throwable -> L81
            if (r0 == 0) goto L73
            com.google.android.gms.common.ConnectionResult r0 = r5.zzack     // Catch: java.lang.Throwable -> L81
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L40
        L73:
            com.google.android.gms.common.ConnectionResult r0 = new com.google.android.gms.common.ConnectionResult     // Catch: java.lang.Throwable -> L81
            r1 = 13
            r2 = 0
            r0.<init>(r1, r2)     // Catch: java.lang.Throwable -> L81
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            goto L40
        L81:
            r0 = move-exception
            java.util.concurrent.locks.Lock r1 = r5.zzabt
            r1.unlock()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzli.blockingConnect(long, java.util.concurrent.TimeUnit):com.google.android.gms.common.ConnectionResult");
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        com.google.android.gms.common.internal.zzx.a(isConnected(), "GoogleApiClient is not connected yet.");
        zzlo zzloVar = new zzlo(this);
        if (this.zzacg.containsKey(zzlx.zzRk)) {
            zza((GoogleApiClient) this, zzloVar, false);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            fu fuVar = new fu(this, atomicReference, zzloVar);
            GoogleApiClient b2 = new GoogleApiClient.Builder(this.mContext).a(zzlx.API).a(fuVar).a(new fv(this, zzloVar)).a(this.zzace).b();
            atomicReference.set(b2);
            b2.connect();
        }
        return zzloVar;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void connect() {
        this.zzabt.lock();
        try {
            this.zzacj.connect();
        } finally {
            this.zzabt.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void disconnect() {
        this.zzabt.lock();
        try {
            zzof();
            this.zzacj.disconnect();
        } finally {
            this.zzabt.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append((CharSequence) str).append("mState=").append((CharSequence) this.zzacj.getName());
        printWriter.append(" mResuming=").print(this.zzacb);
        printWriter.append(" mWorkQueue.size()=").print(this.zzaca.size());
        printWriter.append(" mUnconsumedRunners.size()=").println(this.zzacm.size());
        String str2 = str + "  ";
        for (Api<?> api : this.zzabJ.keySet()) {
            printWriter.append((CharSequence) str).append((CharSequence) api.e()).println(":");
            this.zzacg.get(api.c()).dump(str2, fileDescriptor, printWriter, strArr);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public ConnectionResult getConnectionResult(Api<?> api) {
        ConnectionResult connectionResult;
        Api.zzc<?> c2 = api.c();
        this.zzabt.lock();
        try {
            if (!isConnected() && !zzoc()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            }
            if (!this.zzacg.containsKey(c2)) {
                this.zzabt.unlock();
                throw new IllegalArgumentException(api.e() + " was never registered with GoogleApiClient");
            }
            if (this.zzacg.get(c2).isConnected()) {
                connectionResult = ConnectionResult.f860a;
            } else if (this.zzach.containsKey(c2)) {
                connectionResult = this.zzach.get(c2);
            } else {
                Log.i("GoogleApiClientImpl", zzog());
                Log.wtf("GoogleApiClientImpl", api.e() + " requested in getConnectionResult is not connected but is not present in the failed connections map", new Exception());
                connectionResult = new ConnectionResult(8, null);
            }
            return connectionResult;
        } finally {
            this.zzabt.unlock();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Context getContext() {
        return this.mContext;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public Looper getLooper() {
        return this.zzaaO;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public int getSessionId() {
        return System.identityHashCode(this);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean hasConnectedApi(Api<?> api) {
        Api.zzb zzbVar = this.zzacg.get(api.c());
        return zzbVar != null && zzbVar.isConnected();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnected() {
        return this.zzacj instanceof zzlf;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnecting() {
        return this.zzacj instanceof zzlg;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionCallbacksRegistered(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        return this.zzabZ.b(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean isConnectionFailedListenerRegistered(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.zzabZ.b(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void reconnect() {
        disconnect();
        connect();
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzabZ.a(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void registerConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzabZ.a(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void stopAutoManage(android.support.v4.app.l lVar) {
        if (this.zzaaM < 0) {
            throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
        }
        zzlp zza = zzlp.zza(lVar);
        if (zza == null) {
            new Handler(this.mContext.getMainLooper()).post(new fx(this, lVar));
        } else {
            zza.zzbp(this.zzaaM);
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionCallbacks(GoogleApiClient.ConnectionCallbacks connectionCallbacks) {
        this.zzabZ.c(connectionCallbacks);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public void unregisterConnectionFailedListener(GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzabZ.c(onConnectionFailedListener);
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <C extends Api.zzb> C zza(Api.zzc<C> zzcVar) {
        C c2 = (C) this.zzacg.get(zzcVar);
        com.google.android.gms.common.internal.zzx.a(c2, "Appropriate Api was not requested.");
        return c2;
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T t) {
        com.google.android.gms.common.internal.zzx.b(t.zznx() != null, "This task can not be enqueued (it's probably a Batch or malformed)");
        com.google.android.gms.common.internal.zzx.b(this.zzacg.containsKey(t.zznx()), "GoogleApiClient is not configured to use the API required for this call.");
        this.zzabt.lock();
        try {
            return (T) this.zzacj.zza(t);
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(b bVar) {
        this.zzace.sendMessage(this.zzace.obtainMessage(3, bVar));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zza(RuntimeException runtimeException) {
        this.zzace.sendMessage(this.zzace.obtainMessage(4, runtimeException));
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public boolean zza(Api<?> api) {
        return this.zzacg.containsKey(api.c());
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T t) {
        com.google.android.gms.common.internal.zzx.b(t.zznx() != null, "This task can not be executed (it's probably a Batch or malformed)");
        this.zzabt.lock();
        try {
            if (zzoc()) {
                this.zzaca.add(t);
                while (!this.zzaca.isEmpty()) {
                    f<A> fVar = (f) this.zzaca.remove();
                    zzb(fVar);
                    fVar.zzv(Status.c);
                }
            } else {
                t = (T) this.zzacj.zzb(t);
            }
            return t;
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public <A extends Api.zzb> void zzb(f<A> fVar) {
        this.zzacm.add(fVar);
        fVar.zza(this.zzaco);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzg(ConnectionResult connectionResult) {
        this.zzabt.lock();
        try {
            this.zzack = connectionResult;
            this.zzacj = new zzlh(this);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zznY() {
        for (f<?> fVar : this.zzacm) {
            fVar.zza(null);
            if (fVar.zznF() == null) {
                fVar.cancel();
            } else {
                fVar.zznJ();
                zza(fVar, this.zzacn, zza(fVar.zznx()).zznz());
            }
        }
        this.zzacm.clear();
        Iterator<zzlm<?>> it = this.zzacl.iterator();
        while (it.hasNext()) {
            it.next().clear();
        }
        this.zzacl.clear();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zznZ() {
        Iterator<Api.zzb> it = this.zzacg.values().iterator();
        while (it.hasNext()) {
            it.next().disconnect();
        }
    }

    @Override // com.google.android.gms.common.api.GoogleApiClient
    public <L> zzlm<L> zzo(L l) {
        com.google.android.gms.common.internal.zzx.a(l, "Listener must not be null");
        this.zzabt.lock();
        try {
            zzlm<L> zzlmVar = new zzlm<>(this.zzaaO, l);
            this.zzacl.add(zzlmVar);
            return zzlmVar;
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzoa() {
        this.zzabt.lock();
        try {
            this.zzacj = new zzlg(this, this.zzabI, this.zzabJ, this.zzaaP, this.zzaaQ, this.zzabt, this.mContext);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzob() {
        this.zzabt.lock();
        try {
            zzof();
            this.zzacj = new zzlf(this);
            this.zzacj.begin();
            this.zzabY.signalAll();
        } finally {
            this.zzabt.unlock();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zzoc() {
        return this.zzacb;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void zzoe() {
        if (zzoc()) {
            return;
        }
        this.zzacb = true;
        if (this.zzacf == null) {
            this.zzacf = (d) fy.a(this.mContext.getApplicationContext(), new d(this), this.zzaaP);
        }
        this.zzace.sendMessageDelayed(this.zzace.obtainMessage(1), this.zzacc);
        this.zzace.sendMessageDelayed(this.zzace.obtainMessage(2), this.zzacd);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean zzof() {
        if (!zzoc()) {
            return false;
        }
        this.zzacb = false;
        this.zzace.removeMessages(2);
        this.zzace.removeMessages(1);
        if (this.zzacf != null) {
            this.zzacf.b();
            this.zzacf = null;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String zzog() {
        StringWriter stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }
}
