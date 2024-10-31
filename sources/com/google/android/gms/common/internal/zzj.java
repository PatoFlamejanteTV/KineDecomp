package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.common.internal.zzr;
import com.google.android.gms.common.internal.zzs;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class zzj<T extends IInterface> implements Api.zzb, zzk.zza {
    public static final String[] zzafI = {"service_esmobile", "service_googleme"};
    private final Context mContext;
    final Handler mHandler;
    private final Account zzQd;
    private final Set<Scope> zzTm;
    private final Looper zzaaO;
    private final GoogleApiAvailability zzaaP;
    private final com.google.android.gms.common.internal.zzf zzabI;
    private T zzafA;
    private final ArrayList<zzj<T>.zzc<?>> zzafB;
    private zzj<T>.zze zzafC;
    private int zzafD;
    private final GoogleApiClient.ConnectionCallbacks zzafE;
    private final GoogleApiClient.OnConnectionFailedListener zzafF;
    private final int zzafG;
    protected AtomicInteger zzafH;
    private final zzl zzafx;
    private zzs zzafy;
    private GoogleApiClient.zza zzafz;
    private final Object zzpd;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public abstract class a extends zzj<T>.zzc<Boolean> {

        /* renamed from: a */
        public final int f1008a;
        public final Bundle b;

        protected a(int i, Bundle bundle) {
            super(true);
            this.f1008a = i;
            this.b = bundle;
        }

        protected abstract void a(ConnectionResult connectionResult);

        @Override // com.google.android.gms.common.internal.zzj.zzc
        public void a(Boolean bool) {
            if (bool == null) {
                zzj.this.zzb(1, null);
                return;
            }
            switch (this.f1008a) {
                case 0:
                    if (a()) {
                        return;
                    }
                    zzj.this.zzb(1, null);
                    a(new ConnectionResult(8, null));
                    return;
                case 10:
                    zzj.this.zzb(1, null);
                    throw new IllegalStateException("A fatal developer error has occurred. Check the logs for further information.");
                default:
                    zzj.this.zzb(1, null);
                    a(new ConnectionResult(this.f1008a, this.b != null ? (PendingIntent) this.b.getParcelable("pendingIntent") : null));
                    return;
            }
        }

        protected abstract boolean a();

        @Override // com.google.android.gms.common.internal.zzj.zzc
        protected void b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public final class b extends Handler {
        public b(Looper looper) {
            super(looper);
        }

        private void a(Message message) {
            zzc zzcVar = (zzc) message.obj;
            zzcVar.b();
            zzcVar.d();
        }

        private boolean b(Message message) {
            return message.what == 2 || message.what == 1 || message.what == 5 || message.what == 6;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (zzj.this.zzafH.get() != message.arg1) {
                if (b(message)) {
                    a(message);
                    return;
                }
                return;
            }
            if ((message.what == 1 || message.what == 5 || message.what == 6) && !zzj.this.isConnecting()) {
                a(message);
                return;
            }
            if (message.what == 3) {
                ConnectionResult connectionResult = new ConnectionResult(message.arg2, null);
                zzj.this.zzafz.a(connectionResult);
                zzj.this.onConnectionFailed(connectionResult);
                return;
            }
            if (message.what == 4) {
                zzj.this.zzb(4, null);
                if (zzj.this.zzafE != null) {
                    zzj.this.zzafE.a_(message.arg2);
                }
                zzj.this.onConnectionSuspended(message.arg2);
                zzj.this.zza(4, 1, (int) null);
                return;
            }
            if (message.what == 2 && !zzj.this.isConnected()) {
                a(message);
            } else if (b(message)) {
                ((zzc) message.obj).c();
            } else {
                Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
            }
        }
    }

    /* loaded from: classes.dex */
    public abstract class zzc<TListener> {

        /* renamed from: a */
        private TListener f1010a;
        private boolean b = false;

        public zzc(TListener tlistener) {
            this.f1010a = tlistener;
        }

        protected abstract void a(TListener tlistener);

        protected abstract void b();

        public void c() {
            TListener tlistener;
            synchronized (this) {
                tlistener = this.f1010a;
                if (this.b) {
                    Log.w("GmsClient", "Callback proxy " + this + " being reused. This is not safe.");
                }
            }
            if (tlistener != null) {
                try {
                    a(tlistener);
                } catch (RuntimeException e) {
                    b();
                    throw e;
                }
            } else {
                b();
            }
            synchronized (this) {
                this.b = true;
            }
            d();
        }

        public void d() {
            e();
            synchronized (zzj.this.zzafB) {
                zzj.this.zzafB.remove(this);
            }
        }

        public void e() {
            synchronized (this) {
                this.f1010a = null;
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class zzd extends zzr.zza {

        /* renamed from: a */
        private zzj f1011a;
        private final int b;

        public zzd(zzj zzjVar, int i) {
            this.f1011a = zzjVar;
            this.b = i;
        }

        private void a() {
            this.f1011a = null;
        }

        @Override // com.google.android.gms.common.internal.zzr
        public void a(int i, Bundle bundle) {
            zzx.a(this.f1011a, "onAccountValidationComplete can be called only once per call to validateAccount");
            this.f1011a.zza(i, bundle, this.b);
            a();
        }

        @Override // com.google.android.gms.common.internal.zzr
        public void a(int i, IBinder iBinder, Bundle bundle) {
            zzx.a(this.f1011a, "onPostInitComplete can be called only once per call to getRemoteService");
            this.f1011a.zza(i, iBinder, bundle, this.b);
            a();
        }
    }

    /* loaded from: classes.dex */
    public final class zze implements ServiceConnection {
        private final int b;

        public zze(int i) {
            this.b = i;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            zzx.a(iBinder, "Expecting a valid IBinder");
            zzj.this.zzafy = zzs.zza.a(iBinder);
            zzj.this.zzbF(this.b);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            zzj.this.mHandler.sendMessage(zzj.this.mHandler.obtainMessage(4, this.b, 1));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes.dex */
    public class zzf implements GoogleApiClient.zza {
        public zzf() {
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void a(ConnectionResult connectionResult) {
            if (connectionResult.b()) {
                zzj.this.zza((zzp) null, zzj.this.zzTm);
            } else if (zzj.this.zzafF != null) {
                zzj.this.zzafF.a(connectionResult);
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void b(ConnectionResult connectionResult) {
            throw new IllegalStateException("Legacy GmsClient received onReportAccountValidation callback.");
        }
    }

    /* loaded from: classes.dex */
    public final class zzg extends zzj<T>.a {
        public final IBinder e;

        public zzg(int i, IBinder iBinder, Bundle bundle) {
            super(i, bundle);
            this.e = iBinder;
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected void a(ConnectionResult connectionResult) {
            if (zzj.this.zzafF != null) {
                zzj.this.zzafF.a(connectionResult);
            }
            zzj.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected boolean a() {
            try {
                String interfaceDescriptor = this.e.getInterfaceDescriptor();
                if (!zzj.this.zzfL().equals(interfaceDescriptor)) {
                    Log.e("GmsClient", "service descriptor mismatch: " + zzj.this.zzfL() + " vs. " + interfaceDescriptor);
                    return false;
                }
                IInterface zzW = zzj.this.zzW(this.e);
                if (zzW == null || !zzj.this.zza(2, 3, (int) zzW)) {
                    return false;
                }
                Bundle zzmS = zzj.this.zzmS();
                if (zzj.this.zzafE != null) {
                    zzj.this.zzafE.a(zzmS);
                }
                return true;
            } catch (RemoteException e) {
                Log.w("GmsClient", "service probably died");
                return false;
            }
        }
    }

    /* loaded from: classes.dex */
    public final class zzh extends zzj<T>.a {
        public zzh() {
            super(0, null);
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected void a(ConnectionResult connectionResult) {
            zzj.this.zzafz.a(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected boolean a() {
            zzj.this.zzafz.a(ConnectionResult.f860a);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public final class zzi extends zzj<T>.a {
        public zzi(int i, Bundle bundle) {
            super(i, bundle);
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected void a(ConnectionResult connectionResult) {
            zzj.this.zzafz.b(connectionResult);
            zzj.this.onConnectionFailed(connectionResult);
        }

        @Override // com.google.android.gms.common.internal.zzj.a
        protected boolean a() {
            zzj.this.zzafz.b(ConnectionResult.f860a);
            return true;
        }
    }

    public zzj(Context context, Looper looper, int i, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzl.a(context), GoogleApiAvailability.a(), i, zzfVar, (GoogleApiClient.ConnectionCallbacks) zzx.a(connectionCallbacks), (GoogleApiClient.OnConnectionFailedListener) zzx.a(onConnectionFailedListener));
    }

    protected zzj(Context context, Looper looper, zzl zzlVar, GoogleApiAvailability googleApiAvailability, int i, com.google.android.gms.common.internal.zzf zzfVar, GoogleApiClient.ConnectionCallbacks connectionCallbacks, GoogleApiClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.zzpd = new Object();
        this.zzafB = new ArrayList<>();
        this.zzafD = 1;
        this.zzafH = new AtomicInteger(0);
        this.mContext = (Context) zzx.a(context, "Context must not be null");
        this.zzaaO = (Looper) zzx.a(looper, "Looper must not be null");
        this.zzafx = (zzl) zzx.a(zzlVar, "Supervisor must not be null");
        this.zzaaP = (GoogleApiAvailability) zzx.a(googleApiAvailability, "API availability must not be null");
        this.mHandler = new b(looper);
        this.zzafG = i;
        this.zzabI = (com.google.android.gms.common.internal.zzf) zzx.a(zzfVar);
        this.zzQd = zzfVar.b();
        this.zzTm = zza(zzfVar.f());
        this.zzafE = connectionCallbacks;
        this.zzafF = onConnectionFailedListener;
    }

    private Set<Scope> zza(Set<Scope> set) {
        Set<Scope> zzb = zzb(set);
        if (zzb == null) {
            return zzb;
        }
        Iterator<Scope> it = zzb.iterator();
        while (it.hasNext()) {
            if (!set.contains(it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return zzb;
    }

    public boolean zza(int i, int i2, T t) {
        boolean z;
        synchronized (this.zzpd) {
            if (this.zzafD != i) {
                z = false;
            } else {
                zzb(i2, t);
                z = true;
            }
        }
        return z;
    }

    public void zzb(int i, T t) {
        zzx.b((i == 3) == (t != null));
        synchronized (this.zzpd) {
            this.zzafD = i;
            this.zzafA = t;
            zzc(i, t);
            switch (i) {
                case 1:
                    zzoY();
                    break;
                case 2:
                    zzoX();
                    break;
                case 3:
                    zzoW();
                    break;
            }
        }
    }

    private void zzoX() {
        if (this.zzafC != null) {
            Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + zzfK());
            this.zzafx.b(zzfK(), this.zzafC, zzoV());
            this.zzafH.incrementAndGet();
        }
        this.zzafC = new zze(this.zzafH.get());
        if (this.zzafx.a(zzfK(), this.zzafC, zzoV())) {
            return;
        }
        Log.e("GmsClient", "unable to connect to service: " + zzfK());
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzafH.get(), 9));
    }

    private void zzoY() {
        if (this.zzafC != null) {
            this.zzafx.b(zzfK(), this.zzafC, zzoV());
            this.zzafC = null;
        }
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void disconnect() {
        this.zzafH.incrementAndGet();
        synchronized (this.zzafB) {
            int size = this.zzafB.size();
            for (int i = 0; i < size; i++) {
                this.zzafB.get(i).e();
            }
            this.zzafB.clear();
        }
        zzb(1, null);
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i;
        T t;
        synchronized (this.zzpd) {
            i = this.zzafD;
            t = this.zzafA;
        }
        printWriter.append((CharSequence) str).append("mConnectState=");
        switch (i) {
            case 1:
                printWriter.print("DISCONNECTED");
                break;
            case 2:
                printWriter.print("CONNECTING");
                break;
            case 3:
                printWriter.print("CONNECTED");
                break;
            case 4:
                printWriter.print("DISCONNECTING");
                break;
            default:
                printWriter.print("UNKNOWN");
                break;
        }
        printWriter.append(" mService=");
        if (t == null) {
            printWriter.println("null");
        } else {
            printWriter.append((CharSequence) zzfL()).append("@").println(Integer.toHexString(System.identityHashCode(t.asBinder())));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final Looper getLooper() {
        return this.zzaaO;
    }

    @Override // com.google.android.gms.common.api.Api.zzb, com.google.android.gms.common.internal.zzk.zza
    public boolean isConnected() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzafD == 3;
        }
        return z;
    }

    public boolean isConnecting() {
        boolean z;
        synchronized (this.zzpd) {
            z = this.zzafD == 2;
        }
        return z;
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
    }

    protected void onConnectionSuspended(int i) {
    }

    protected abstract T zzW(IBinder iBinder);

    protected void zza(int i, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(5, i2, -1, new zzi(i, bundle)));
    }

    public void zza(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(1, i2, -1, new zzg(i, iBinder, bundle)));
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void zza(GoogleApiClient.zza zzaVar) {
        this.zzafz = (GoogleApiClient.zza) zzx.a(zzaVar, "Connection progress callbacks cannot be null.");
        zzb(2, null);
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void zza(zzp zzpVar) {
        try {
            this.zzafy.a(new zzd(this, this.zzafH.get()), new ValidateAccountRequest(zzpVar, (Scope[]) this.zzTm.toArray(new Scope[this.zzTm.size()]), this.mContext.getPackageName(), zzpd()));
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbE(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public void zza(zzp zzpVar, Set<Scope> set) {
        try {
            GetServiceRequest a2 = new GetServiceRequest(this.zzafG).a(this.mContext.getPackageName()).a(zzly());
            if (set != null) {
                a2.a(set);
            }
            if (zzlN()) {
                a2.a(zzoI()).a(zzpVar);
            } else if (zzpe()) {
                a2.a(this.zzQd);
            }
            this.zzafy.a(new zzd(this, this.zzafH.get()), a2);
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "service died");
            zzbE(1);
        } catch (RemoteException e2) {
            Log.w("GmsClient", "Remote exception occurred", e2);
        }
    }

    protected Set<Scope> zzb(Set<Scope> set) {
        return set;
    }

    public void zzbE(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(4, this.zzafH.get(), i));
    }

    protected void zzbF(int i) {
        this.mHandler.sendMessage(this.mHandler.obtainMessage(6, i, -1, new zzh()));
    }

    protected void zzc(int i, T t) {
    }

    protected abstract String zzfK();

    protected abstract String zzfL();

    @Override // com.google.android.gms.common.api.Api.zzb
    public boolean zzlN() {
        return false;
    }

    protected Bundle zzly() {
        return new Bundle();
    }

    public Bundle zzmS() {
        return null;
    }

    @Override // com.google.android.gms.common.api.Api.zzb
    public IBinder zznz() {
        if (this.zzafy == null) {
            return null;
        }
        return this.zzafy.asBinder();
    }

    public final Account zzoI() {
        return this.zzQd != null ? this.zzQd : new Account("<<default account>>", "com.google");
    }

    protected final String zzoV() {
        return this.zzabI.i();
    }

    public void zzoW() {
    }

    public void zzoZ() {
        int a2 = this.zzaaP.a(this.mContext);
        if (a2 == 0) {
            zza(new zzf());
            return;
        }
        zzb(1, null);
        this.zzafz = new zzf();
        this.mHandler.sendMessage(this.mHandler.obtainMessage(3, this.zzafH.get(), a2));
    }

    public final com.google.android.gms.common.internal.zzf zzpa() {
        return this.zzabI;
    }

    public final void zzpb() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public final T zzpc() throws DeadObjectException {
        T t;
        synchronized (this.zzpd) {
            if (this.zzafD == 4) {
                throw new DeadObjectException();
            }
            zzpb();
            zzx.a(this.zzafA != null, "Client is connected but service is null");
            t = this.zzafA;
        }
        return t;
    }

    protected Bundle zzpd() {
        return null;
    }

    public boolean zzpe() {
        return false;
    }
}
