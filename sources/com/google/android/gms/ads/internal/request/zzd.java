package com.google.android.gms.ads.internal.request;

import android.content.Context;
import android.os.Binder;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.RemoteException;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.request.zzc;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.internal.zzbr;
import com.google.android.gms.internal.zzby;
import com.google.android.gms.internal.zzgr;
import com.google.android.gms.internal.zzgs;
import com.google.android.gms.internal.zzgt;
import com.google.android.gms.internal.zzhz;

@zzgr
/* loaded from: classes.dex */
public abstract class zzd extends zzhz implements zzc.zza {

    /* renamed from: a */
    private final AdRequestInfoParcel f635a;
    private final zzc.zza b;
    private final Object c = new Object();
    private AdResponseParcel d;

    @zzgr
    /* loaded from: classes.dex */
    public static final class zza extends zzd {

        /* renamed from: a */
        private final Context f636a;

        public zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzc.zza zzaVar) {
            super(adRequestInfoParcel, zzaVar);
            this.f636a = context;
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public void a() {
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public zzj b() {
            return zzgt.zza(this.f636a, new zzbr(zzby.zzul.get()), zzgs.zzfQ());
        }
    }

    @zzgr
    /* loaded from: classes.dex */
    public static class zzb extends zzd implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener {

        /* renamed from: a */
        protected zze f637a;
        private Context b;
        private AdRequestInfoParcel c;
        private final zzc.zza d;
        private final Object e;
        private boolean f;

        public zzb(Context context, AdRequestInfoParcel adRequestInfoParcel, zzc.zza zzaVar) {
            super(adRequestInfoParcel, zzaVar);
            Looper mainLooper;
            this.e = new Object();
            this.b = context;
            this.c = adRequestInfoParcel;
            this.d = zzaVar;
            if (zzby.zzuK.get().booleanValue()) {
                this.f = true;
                mainLooper = zzp.p().zzgM();
            } else {
                mainLooper = context.getMainLooper();
            }
            this.f637a = new zze(context, mainLooper, this, this, adRequestInfoParcel.k.d);
            c();
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public void a() {
            synchronized (this.e) {
                if (this.f637a.isConnected() || this.f637a.isConnecting()) {
                    this.f637a.disconnect();
                }
                Binder.flushPendingCommands();
                if (this.f) {
                    zzp.p().zzgN();
                    this.f = false;
                }
            }
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a(Bundle bundle) {
            zzfu();
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener
        public void a(ConnectionResult connectionResult) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Cannot connect to remote service, fallback to local instance.");
            d().zzfu();
            Bundle bundle = new Bundle();
            bundle.putString(NativeProtocol.WEB_DIALOG_ACTION, "gms_connection_failed_fallback_to_local");
            zzp.e().zzb(this.b, this.c.k.b, "gmob-apps", bundle, true);
        }

        @Override // com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks
        public void a_(int i) {
            com.google.android.gms.ads.internal.util.client.zzb.a("Disconnected from remote ad request service.");
        }

        @Override // com.google.android.gms.ads.internal.request.zzd
        public zzj b() {
            zzj zzjVar;
            synchronized (this.e) {
                try {
                    zzjVar = this.f637a.a();
                } catch (DeadObjectException | IllegalStateException e) {
                    zzjVar = null;
                }
            }
            return zzjVar;
        }

        protected void c() {
            this.f637a.zzoZ();
        }

        zzhz d() {
            return new zza(this.b, this.c, this.d);
        }
    }

    public zzd(AdRequestInfoParcel adRequestInfoParcel, zzc.zza zzaVar) {
        this.f635a = adRequestInfoParcel;
        this.b = zzaVar;
    }

    public abstract void a();

    protected void a(long j) {
        synchronized (this.c) {
            do {
                if (this.d != null) {
                    this.b.a(this.d);
                    return;
                }
            } while (b(j));
            if (this.d != null) {
                this.b.a(this.d);
            } else {
                this.b.a(new AdResponseParcel(0));
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.request.zzc.zza
    public void a(AdResponseParcel adResponseParcel) {
        synchronized (this.c) {
            this.d = adResponseParcel;
            this.c.notify();
        }
    }

    boolean a(zzj zzjVar, AdRequestInfoParcel adRequestInfoParcel) {
        try {
            zzjVar.zza(adRequestInfoParcel, new zzg(this));
            return true;
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not fetch ad response from ad request service.", e);
            zzp.h().zzc(e, true);
            this.b.a(new AdResponseParcel(0));
            return false;
        } catch (NullPointerException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not fetch ad response from ad request service due to an Exception.", e2);
            zzp.h().zzc(e2, true);
            this.b.a(new AdResponseParcel(0));
            return false;
        } catch (SecurityException e3) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not fetch ad response from ad request service due to an Exception.", e3);
            zzp.h().zzc(e3, true);
            this.b.a(new AdResponseParcel(0));
            return false;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not fetch ad response from ad request service due to an Exception.", th);
            zzp.h().zzc(th, true);
            this.b.a(new AdResponseParcel(0));
            return false;
        }
    }

    public abstract zzj b();

    protected boolean b(long j) {
        long elapsedRealtime = 60000 - (zzp.i().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.c.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public final void onStop() {
        a();
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        try {
            zzj b = b();
            if (b == null) {
                this.b.a(new AdResponseParcel(0));
            } else if (a(b, this.f635a)) {
                a(zzp.i().elapsedRealtime());
            }
        } finally {
            a();
        }
    }
}
