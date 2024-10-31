package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;

@zzark
/* loaded from: classes2.dex */
public final class zztq {
    private Context mContext;
    private zztx zzbzr;
    private zzub zzbzs;
    private final Runnable zzbzq = new Km(this);
    private final Object mLock = new Object();

    public final void connect() {
        synchronized (this.mLock) {
            if (this.mContext != null && this.zzbzr == null) {
                this.zzbzr = new zztx(this.mContext, com.google.android.gms.ads.internal.zzbv.u().zzaak(), new Mm(this), new Nm(this));
                this.zzbzr.checkAvailabilityAndConnect();
            }
        }
    }

    public final void disconnect() {
        synchronized (this.mLock) {
            if (this.zzbzr == null) {
                return;
            }
            if (this.zzbzr.isConnected() || this.zzbzr.isConnecting()) {
                this.zzbzr.disconnect();
            }
            this.zzbzr = null;
            this.zzbzs = null;
            Binder.flushPendingCommands();
        }
    }

    public final void initialize(Context context) {
        if (context == null) {
            return;
        }
        synchronized (this.mLock) {
            if (this.mContext != null) {
                return;
            }
            this.mContext = context.getApplicationContext();
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvr)).booleanValue()) {
                connect();
            } else {
                if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvq)).booleanValue()) {
                    com.google.android.gms.ads.internal.zzbv.h().zza(new Lm(this));
                }
            }
        }
    }

    public final zztv zza(zzty zztyVar) {
        synchronized (this.mLock) {
            if (this.zzbzs == null) {
                return new zztv();
            }
            try {
                return this.zzbzs.zza(zztyVar);
            } catch (RemoteException e2) {
                zzbbd.zzb("Unable to call into cache service.", e2);
                return new zztv();
            }
        }
    }

    public final void zzod() {
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcvs)).booleanValue()) {
            synchronized (this.mLock) {
                connect();
                com.google.android.gms.ads.internal.zzbv.e();
                zzayh.zzelc.removeCallbacks(this.zzbzq);
                com.google.android.gms.ads.internal.zzbv.e();
                zzayh.zzelc.postDelayed(this.zzbzq, ((Long) zzwu.zzpz().zzd(zzaan.zzcvt)).longValue());
            }
        }
    }

    public static /* synthetic */ zztx zza(zztq zztqVar, zztx zztxVar) {
        zztqVar.zzbzr = null;
        return null;
    }
}
