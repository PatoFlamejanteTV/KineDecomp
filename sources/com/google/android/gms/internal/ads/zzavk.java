package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.Future;

@zzark
/* loaded from: classes2.dex */
public final class zzavk extends zzaxv implements zzavq, zzavt, zzavx {
    private final Context mContext;
    public final String zzdml;
    private final zzaxg zzdsk;
    private final zzavy zzeep;
    private final zzavt zzeeq;
    private final String zzeer;
    private final zzakq zzees;
    private final long zzeet;
    private zzavn zzeev;
    private Future zzeew;
    private volatile com.google.android.gms.ads.internal.gmsg.zzb zzeex;
    private int zzeeu = 0;
    private int mErrorCode = 3;
    private final Object mLock = new Object();

    public zzavk(Context context, String str, String str2, zzakq zzakqVar, zzaxg zzaxgVar, zzavy zzavyVar, zzavt zzavtVar, long j) {
        this.mContext = context;
        this.zzdml = str;
        this.zzeer = str2;
        this.zzees = zzakqVar;
        this.zzdsk = zzaxgVar;
        this.zzeep = zzavyVar;
        this.zzeeq = zzavtVar;
        this.zzeet = j;
    }

    private final boolean zzaq(long j) {
        long c2 = this.zzeet - (com.google.android.gms.ads.internal.zzbv.l().c() - j);
        if (c2 <= 0) {
            this.mErrorCode = 4;
            return false;
        }
        try {
            this.mLock.wait(c2);
            return true;
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            this.mErrorCode = 5;
            return false;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void onStop() {
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zza(String str, int i) {
        synchronized (this.mLock) {
            this.zzeeu = 2;
            this.mErrorCode = i;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavx
    public final void zzc(Bundle bundle) {
        com.google.android.gms.ads.internal.gmsg.zzb zzbVar = this.zzeex;
        if (zzbVar != null) {
            zzbVar.zza("", bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzavq
    public final void zzct(int i) {
        zza(this.zzdml, 0);
    }

    @Override // com.google.android.gms.internal.ads.zzavt
    public final void zzde(String str) {
        synchronized (this.mLock) {
            this.zzeeu = 1;
            this.mLock.notify();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxv
    public final void zzki() {
        zzavy zzavyVar = this.zzeep;
        if (zzavyVar == null || zzavyVar.zzxo() == null || this.zzeep.zzxn() == null) {
            return;
        }
        zzavs zzxo = this.zzeep.zzxo();
        zzxo.zza((zzavt) null);
        zzxo.zza((zzavq) this);
        zzxo.zza((zzavx) this);
        zzwb zzwbVar = this.zzdsk.zzeag.zzdwg;
        zzalj zzxn = this.zzeep.zzxn();
        try {
            if (zzxn.isInitialized()) {
                zzbat.zztu.post(new _c(this, zzwbVar, zzxn));
            } else {
                zzbat.zztu.post(new RunnableC0826ad(this, zzxn, zzwbVar, zzxo));
            }
        } catch (RemoteException e2) {
            zzbbd.zzc("Fail to check if adapter is initialized.", e2);
            zza(this.zzdml, 0);
        }
        long c2 = com.google.android.gms.ads.internal.zzbv.l().c();
        while (true) {
            synchronized (this.mLock) {
                if (this.zzeeu != 0) {
                    this.zzeev = new zzavp().zzar(com.google.android.gms.ads.internal.zzbv.l().c() - c2).zzcu(1 == this.zzeeu ? 6 : this.mErrorCode).zzdf(this.zzdml).zzdg(this.zzees.zzdkx).zzxm();
                } else if (!zzaq(c2)) {
                    this.zzeev = new zzavp().zzcu(this.mErrorCode).zzar(com.google.android.gms.ads.internal.zzbv.l().c() - c2).zzdf(this.zzdml).zzdg(this.zzees.zzdkx).zzxm();
                }
            }
        }
        zzxo.zza((zzavt) null);
        zzxo.zza((zzavq) null);
        if (this.zzeeu == 1) {
            this.zzeeq.zzde(this.zzdml);
        } else {
            this.zzeeq.zza(this.zzdml, this.mErrorCode);
        }
    }

    public final Future zzxi() {
        Future future = this.zzeew;
        if (future != null) {
            return future;
        }
        zzbcb zzbcbVar = (zzbcb) zzwa();
        this.zzeew = zzbcbVar;
        return zzbcbVar;
    }

    public final zzavn zzxj() {
        zzavn zzavnVar;
        synchronized (this.mLock) {
            zzavnVar = this.zzeev;
        }
        return zzavnVar;
    }

    public final zzakq zzxk() {
        return this.zzees;
    }

    @Override // com.google.android.gms.internal.ads.zzavq
    public final void zzxl() {
        zza(this.zzdsk.zzeag.zzdwg, this.zzeep.zzxn());
    }

    public final void zza(com.google.android.gms.ads.internal.gmsg.zzb zzbVar) {
        this.zzeex = zzbVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(zzwb zzwbVar, zzalj zzaljVar) {
        this.zzeep.zzxo().zza((zzavt) this);
        try {
            if ("com.google.ads.mediation.admob.AdMobAdapter".equals(this.zzdml)) {
                zzaljVar.zza(zzwbVar, this.zzeer, this.zzees.zzdku);
            } else {
                zzaljVar.zzc(zzwbVar, this.zzeer);
            }
        } catch (RemoteException e2) {
            zzbbd.zzc("Fail to load ad from adapter.", e2);
            zza(this.zzdml, 0);
        }
    }
}
