package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzf;
import com.google.android.gms.common.internal.zzt;
import com.google.android.gms.internal.zzlb;
import com.google.android.gms.internal.zzli;
import com.google.android.gms.signin.internal.AuthAccountResult;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public class zzlg implements zzlj {
    private final Context mContext;
    private final GoogleApiAvailability zzaaP;
    private final Api.zza<? extends zzqw, zzqx> zzaaQ;
    private zzqw zzabB;
    private int zzabC;
    private boolean zzabD;
    private boolean zzabE;
    private com.google.android.gms.common.internal.zzp zzabF;
    private boolean zzabG;
    private boolean zzabH;
    private final com.google.android.gms.common.internal.zzf zzabI;
    private final Map<Api<?>, Integer> zzabJ;
    private final zzli zzabr;
    private final Lock zzabt;
    private ConnectionResult zzabu;
    private int zzabv;
    private int zzaby;
    private int zzabw = 0;
    private boolean zzabx = false;
    private final Bundle zzabz = new Bundle();
    private final Set<Api.zzc> zzabA = new HashSet();
    private ArrayList<Future<?>> zzabK = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a extends com.google.android.gms.signin.internal.zzb {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<zzlg> f1750a;

        a(zzlg zzlgVar) {
            this.f1750a = new WeakReference<>(zzlgVar);
        }

        @Override // com.google.android.gms.signin.internal.zzb, com.google.android.gms.signin.internal.zze
        public void a(ConnectionResult connectionResult, AuthAccountResult authAccountResult) {
            zzlg zzlgVar = this.f1750a.get();
            if (zzlgVar == null) {
                return;
            }
            zzlgVar.zzabr.zza(new fn(this, zzlgVar, zzlgVar, connectionResult));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class b extends zzt.zza {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<zzlg> f1751a;

        b(zzlg zzlgVar) {
            this.f1751a = new WeakReference<>(zzlgVar);
        }

        @Override // com.google.android.gms.common.internal.zzt
        public void a(ResolveAccountResponse resolveAccountResponse) {
            zzlg zzlgVar = this.f1751a.get();
            if (zzlgVar == null) {
                return;
            }
            zzlgVar.zzabr.zza(new fo(this, zzlgVar, zzlgVar, resolveAccountResponse));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class c extends i {
        private c() {
            super(zzlg.this, null);
        }

        /* synthetic */ c(zzlg zzlgVar, fm fmVar) {
            this();
        }

        @Override // com.google.android.gms.internal.zzlg.i
        public void a() {
            zzlg.this.zzabB.zza(zzlg.this.zzabF, zzlg.this.zzabr.zzaci, new a(zzlg.this));
        }
    }

    /* loaded from: classes.dex */
    private static class d implements GoogleApiClient.zza {

        /* renamed from: a, reason: collision with root package name */
        private final WeakReference<zzlg> f1753a;
        private final Api<?> b;
        private final int c;

        public d(zzlg zzlgVar, Api<?> api, int i) {
            this.f1753a = new WeakReference<>(zzlgVar);
            this.b = api;
            this.c = i;
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void a(ConnectionResult connectionResult) {
            zzlg zzlgVar = this.f1753a.get();
            if (zzlgVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzx.a(Looper.myLooper() == zzlgVar.zzabr.getLooper(), "onReportServiceBinding must be called on the GoogleApiClient handler thread");
            zzlgVar.zzabt.lock();
            try {
                if (zzlgVar.zzbn(0)) {
                    if (!connectionResult.b()) {
                        zzlgVar.zzb(connectionResult, this.b, this.c);
                    }
                    if (zzlgVar.zznP()) {
                        zzlgVar.zznQ();
                    }
                }
            } finally {
                zzlgVar.zzabt.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.zza
        public void b(ConnectionResult connectionResult) {
            zzlg zzlgVar = this.f1753a.get();
            if (zzlgVar == null) {
                return;
            }
            com.google.android.gms.common.internal.zzx.a(Looper.myLooper() == zzlgVar.zzabr.getLooper(), "onReportAccountValidation must be called on the GoogleApiClient handler thread");
            zzlgVar.zzabt.lock();
            try {
                if (zzlgVar.zzbn(1)) {
                    if (!connectionResult.b()) {
                        zzlgVar.zzb(connectionResult, this.b, this.c);
                    }
                    if (zzlgVar.zznP()) {
                        zzlgVar.zznS();
                    }
                }
            } finally {
                zzlgVar.zzabt.unlock();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class e extends i {
        private final Map<Api.zzb, GoogleApiClient.zza> c;

        public e(Map<Api.zzb, GoogleApiClient.zza> map) {
            super(zzlg.this, null);
            this.c = map;
        }

        @Override // com.google.android.gms.internal.zzlg.i
        public void a() {
            int a2 = zzlg.this.zzaaP.a(zzlg.this.mContext);
            if (a2 != 0) {
                zzlg.this.zzabr.zza(new fp(this, zzlg.this, new ConnectionResult(a2, null)));
                return;
            }
            if (zzlg.this.zzabD) {
                zzlg.this.zzabB.connect();
            }
            for (Api.zzb zzbVar : this.c.keySet()) {
                zzbVar.zza(this.c.get(zzbVar));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class f extends i {
        private final ArrayList<Api.zzb> c;

        public f(ArrayList<Api.zzb> arrayList) {
            super(zzlg.this, null);
            this.c = arrayList;
        }

        @Override // com.google.android.gms.internal.zzlg.i
        public void a() {
            Set<Scope> set = zzlg.this.zzabr.zzaci;
            Set<Scope> zznX = set.isEmpty() ? zzlg.this.zznX() : set;
            Iterator<Api.zzb> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().zza(zzlg.this.zzabF, zznX);
            }
        }
    }

    /* loaded from: classes.dex */
    private class g implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {
        private g() {
        }

        /* synthetic */ g(zzlg zzlgVar, fm fmVar) {
            this();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a(Bundle bundle) {
            zzlg.this.zzabB.zza(new b(zzlg.this));
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void a(ConnectionResult connectionResult) {
            zzlg.this.zzabt.lock();
            try {
                if (zzlg.this.zze(connectionResult)) {
                    zzlg.this.zznV();
                    zzlg.this.zznT();
                } else {
                    zzlg.this.zzf(connectionResult);
                }
            } finally {
                zzlg.this.zzabt.unlock();
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a_(int i) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class h extends i {
        private final ArrayList<Api.zzb> c;

        public h(ArrayList<Api.zzb> arrayList) {
            super(zzlg.this, null);
            this.c = arrayList;
        }

        @Override // com.google.android.gms.internal.zzlg.i
        public void a() {
            Iterator<Api.zzb> it = this.c.iterator();
            while (it.hasNext()) {
                it.next().zza(zzlg.this.zzabF);
            }
        }
    }

    /* loaded from: classes.dex */
    private abstract class i implements Runnable {
        private i() {
        }

        /* synthetic */ i(zzlg zzlgVar, fm fmVar) {
            this();
        }

        protected abstract void a();

        @Override // java.lang.Runnable
        public void run() {
            zzlg.this.zzabt.lock();
            try {
                if (Thread.interrupted()) {
                    return;
                }
                a();
            } catch (RuntimeException e) {
                zzlg.this.zzabr.zza(e);
            } finally {
                zzlg.this.zzabt.unlock();
            }
        }
    }

    public zzlg(zzli zzliVar, com.google.android.gms.common.internal.zzf zzfVar, Map<Api<?>, Integer> map, GoogleApiAvailability googleApiAvailability, Api.zza<? extends zzqw, zzqx> zzaVar, Lock lock, Context context) {
        this.zzabr = zzliVar;
        this.zzabI = zzfVar;
        this.zzabJ = map;
        this.zzaaP = googleApiAvailability;
        this.zzaaQ = zzaVar;
        this.zzabt = lock;
        this.mContext = context;
    }

    private void zzY(boolean z) {
        if (this.zzabB != null) {
            if (this.zzabB.isConnected() && z) {
                this.zzabB.zzCe();
            }
            this.zzabB.disconnect();
            this.zzabF = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zza(ResolveAccountResponse resolveAccountResponse) {
        if (zzbn(0)) {
            ConnectionResult b2 = resolveAccountResponse.b();
            if (b2.b()) {
                this.zzabF = resolveAccountResponse.a();
                this.zzabE = true;
                this.zzabG = resolveAccountResponse.c();
                this.zzabH = resolveAccountResponse.d();
                zznQ();
                return;
            }
            if (!zze(b2)) {
                zzf(b2);
            } else {
                zznV();
                zznQ();
            }
        }
    }

    private boolean zza(int i2, int i3, ConnectionResult connectionResult) {
        if (i3 != 1 || zzd(connectionResult)) {
            return this.zzabu == null || i2 < this.zzabv;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzb(ConnectionResult connectionResult, Api<?> api, int i2) {
        if (i2 != 2) {
            int priority = api.a().getPriority();
            if (zza(priority, i2, connectionResult)) {
                this.zzabu = connectionResult;
                this.zzabv = priority;
            }
        }
        this.zzabr.zzach.put(api.c(), connectionResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zzbn(int i2) {
        if (this.zzabw == i2) {
            return true;
        }
        Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
        Log.wtf("GoogleApiClientConnecting", "GoogleApiClient connecting is in step " + zzbo(this.zzabw) + " but received callback for step " + zzbo(i2), new Exception());
        zzf(new ConnectionResult(8, null));
        return false;
    }

    private String zzbo(int i2) {
        switch (i2) {
            case 0:
                return "STEP_GETTING_SERVICE_BINDINGS";
            case 1:
                return "STEP_VALIDATING_ACCOUNT";
            case 2:
                return "STEP_AUTHENTICATING";
            case 3:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzc(ConnectionResult connectionResult) {
        if (zzbn(2)) {
            if (connectionResult.b()) {
                zznT();
            } else if (!zze(connectionResult)) {
                zzf(connectionResult);
            } else {
                zznV();
                zznT();
            }
        }
    }

    private boolean zzd(ConnectionResult connectionResult) {
        return connectionResult.a() || this.zzaaP.b(connectionResult.c()) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zze(ConnectionResult connectionResult) {
        if (this.zzabC != 2) {
            return this.zzabC == 1 && !connectionResult.a();
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zzf(ConnectionResult connectionResult) {
        zznW();
        zzY(!connectionResult.a());
        this.zzabr.zzach.clear();
        this.zzabr.zzg(connectionResult);
        if (!this.zzaaP.a(this.mContext, connectionResult.c())) {
            this.zzabr.zzof();
        }
        if (!this.zzabx && !this.zzabr.zzoc()) {
            this.zzabr.zzabZ.a(connectionResult);
        }
        this.zzabx = false;
        this.zzabr.zzabZ.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean zznP() {
        this.zzaby--;
        if (this.zzaby > 0) {
            return false;
        }
        if (this.zzaby < 0) {
            Log.i("GoogleApiClientConnecting", this.zzabr.zzog());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            zzf(new ConnectionResult(8, null));
            return false;
        }
        if (this.zzabu == null) {
            return true;
        }
        zzf(this.zzabu);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznQ() {
        if (this.zzaby != 0) {
            return;
        }
        if (!this.zzabD) {
            zznT();
        } else if (this.zzabE) {
            zznR();
        }
    }

    private void zznR() {
        ArrayList arrayList = new ArrayList();
        this.zzabw = 1;
        this.zzaby = this.zzabr.zzacg.size();
        for (Api.zzc<?> zzcVar : this.zzabr.zzacg.keySet()) {
            if (!this.zzabr.zzach.containsKey(zzcVar)) {
                arrayList.add(this.zzabr.zzacg.get(zzcVar));
            } else if (zznP()) {
                zznS();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.zzabK.add(zzlk.zzoj().submit(new h(arrayList)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznS() {
        this.zzabw = 2;
        this.zzabr.zzaci = zznX();
        this.zzabK.add(zzlk.zzoj().submit(new c(this, null)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznT() {
        ArrayList arrayList = new ArrayList();
        this.zzabw = 3;
        this.zzaby = this.zzabr.zzacg.size();
        for (Api.zzc<?> zzcVar : this.zzabr.zzacg.keySet()) {
            if (!this.zzabr.zzach.containsKey(zzcVar)) {
                arrayList.add(this.zzabr.zzacg.get(zzcVar));
            } else if (zznP()) {
                zznU();
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.zzabK.add(zzlk.zzoj().submit(new f(arrayList)));
    }

    private void zznU() {
        this.zzabr.zzob();
        zzlk.zzoj().execute(new fm(this));
        if (this.zzabB != null) {
            if (this.zzabG) {
                this.zzabB.zza(this.zzabF, this.zzabH);
            }
            zzY(false);
        }
        Iterator<Api.zzc<?>> it = this.zzabr.zzach.keySet().iterator();
        while (it.hasNext()) {
            this.zzabr.zzacg.get(it.next()).disconnect();
        }
        if (!this.zzabx) {
            this.zzabr.zzabZ.a(this.zzabz.isEmpty() ? null : this.zzabz);
        } else {
            this.zzabx = false;
            disconnect();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zznV() {
        this.zzabD = false;
        this.zzabr.zzaci = Collections.emptySet();
        for (Api.zzc<?> zzcVar : this.zzabA) {
            if (!this.zzabr.zzach.containsKey(zzcVar)) {
                this.zzabr.zzach.put(zzcVar, new ConnectionResult(17, null));
            }
        }
    }

    private void zznW() {
        Iterator<Future<?>> it = this.zzabK.iterator();
        while (it.hasNext()) {
            it.next().cancel(true);
        }
        this.zzabK.clear();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Set<Scope> zznX() {
        HashSet hashSet = new HashSet(this.zzabI.e());
        Map<Api<?>, zzf.zza> g2 = this.zzabI.g();
        for (Api<?> api : g2.keySet()) {
            if (!this.zzabr.zzach.containsKey(api.c())) {
                hashSet.addAll(g2.get(api).f1006a);
            }
        }
        return hashSet;
    }

    @Override // com.google.android.gms.internal.zzlj
    public void begin() {
        fm fmVar = null;
        this.zzabr.zzabZ.b();
        this.zzabr.zzach.clear();
        this.zzabx = false;
        this.zzabD = false;
        this.zzabu = null;
        this.zzabw = 0;
        this.zzabC = 2;
        this.zzabE = false;
        this.zzabG = false;
        HashMap hashMap = new HashMap();
        boolean z = false;
        for (Api<?> api : this.zzabJ.keySet()) {
            Api.zzb zzbVar = this.zzabr.zzacg.get(api.c());
            int intValue = this.zzabJ.get(api).intValue();
            boolean z2 = (api.a().getPriority() == 1) | z;
            if (zzbVar.zzlN()) {
                this.zzabD = true;
                if (intValue < this.zzabC) {
                    this.zzabC = intValue;
                }
                if (intValue != 0) {
                    this.zzabA.add(api.c());
                }
            }
            hashMap.put(zzbVar, new d(this, api, intValue));
            z = z2;
        }
        if (z) {
            this.zzabD = false;
        }
        if (this.zzabD) {
            this.zzabI.a(Integer.valueOf(this.zzabr.getSessionId()));
            g gVar = new g(this, fmVar);
            this.zzabB = this.zzaaQ.zza(this.mContext, this.zzabr.getLooper(), this.zzabI, this.zzabI.k(), gVar, gVar);
        }
        this.zzaby = this.zzabr.zzacg.size();
        this.zzabK.add(zzlk.zzoj().submit(new e(hashMap)));
    }

    @Override // com.google.android.gms.internal.zzlj
    public void connect() {
        this.zzabx = false;
    }

    @Override // com.google.android.gms.internal.zzlj
    public void disconnect() {
        Iterator<zzli.f<?>> it = this.zzabr.zzaca.iterator();
        while (it.hasNext()) {
            zzli.f<?> next = it.next();
            if (next.zznK() != 1) {
                next.cancel();
                it.remove();
            }
        }
        this.zzabr.zznY();
        if (this.zzabu == null && !this.zzabr.zzaca.isEmpty()) {
            this.zzabx = true;
            return;
        }
        zznW();
        zzY(true);
        this.zzabr.zzach.clear();
        this.zzabr.zzg(null);
        this.zzabr.zzabZ.a();
    }

    @Override // com.google.android.gms.internal.zzlj
    public String getName() {
        return "CONNECTING";
    }

    @Override // com.google.android.gms.internal.zzlj
    public void onConnected(Bundle bundle) {
        if (zzbn(3)) {
            if (bundle != null) {
                this.zzabz.putAll(bundle);
            }
            if (zznP()) {
                zznU();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzlj
    public void onConnectionSuspended(int i2) {
        zzf(new ConnectionResult(8, null));
    }

    @Override // com.google.android.gms.internal.zzlj
    public <A extends Api.zzb, R extends Result, T extends zzlb.zza<R, A>> T zza(T t) {
        this.zzabr.zzaca.add(t);
        return t;
    }

    @Override // com.google.android.gms.internal.zzlj
    public void zza(ConnectionResult connectionResult, Api<?> api, int i2) {
        if (zzbn(3)) {
            zzb(connectionResult, api, i2);
            if (zznP()) {
                zznU();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzlj
    public <A extends Api.zzb, T extends zzlb.zza<? extends Result, A>> T zzb(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
