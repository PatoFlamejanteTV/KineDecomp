package com.google.android.gms.internal;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public class zzhi extends zzhz implements zzhj, zzhm {
    private final Context mContext;
    private final zzhs.zza zzDe;
    private final String zzGY;
    private final zzhh zzHg;
    private final zzhm zzHh;
    private final String zzHi;
    private final String zzzj;
    private int zzHj = 0;
    private int zzDv = 3;
    private final Object zzpd = new Object();

    public zzhi(Context context, String str, String str2, String str3, zzhs.zza zzaVar, zzhh zzhhVar, zzhm zzhmVar) {
        this.mContext = context;
        this.zzzj = str;
        this.zzGY = str2;
        this.zzHi = str3;
        this.zzDe = zzaVar;
        this.zzHg = zzhhVar;
        this.zzHh = zzhmVar;
    }

    private void zzk(long j) {
        while (true) {
            synchronized (this.zzpd) {
                if (this.zzHj != 0) {
                    return;
                }
                if (!zzf(j)) {
                    return;
                }
            }
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void onStop() {
    }

    @Override // com.google.android.gms.internal.zzhj
    public void zzK(int i) {
        zzb(this.zzzj, 0);
    }

    @Override // com.google.android.gms.internal.zzhm
    public void zzav(String str) {
        synchronized (this.zzpd) {
            this.zzHj = 1;
            this.zzpd.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzhm
    public void zzb(String str, int i) {
        synchronized (this.zzpd) {
            this.zzHj = 2;
            this.zzDv = i;
            this.zzpd.notify();
        }
    }

    @Override // com.google.android.gms.internal.zzhz
    public void zzbn() {
        if (this.zzHg == null || this.zzHg.zzgd() == null || this.zzHg.zzgc() == null) {
            return;
        }
        zzhl zzgd = this.zzHg.zzgd();
        zzgd.zza((zzhm) this);
        zzgd.zza((zzhj) this);
        AdRequestParcel adRequestParcel = this.zzDe.zzHC.c;
        zzen zzgc = this.zzHg.zzgc();
        try {
            if (zzgc.isInitialized()) {
                com.google.android.gms.ads.internal.util.client.zza.f654a.post(new dg(this, zzgc, adRequestParcel));
            } else {
                com.google.android.gms.ads.internal.util.client.zza.f654a.post(new dh(this, zzgc, adRequestParcel, zzgd));
            }
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to check if adapter is initialized.", e);
            zzb(this.zzzj, 0);
        }
        zzk(com.google.android.gms.ads.internal.zzp.i().elapsedRealtime());
        zzgd.zza((zzhm) null);
        zzgd.zza((zzhj) null);
        if (this.zzHj == 1) {
            this.zzHh.zzav(this.zzzj);
        } else {
            this.zzHh.zzb(this.zzzj, this.zzDv);
        }
    }

    protected boolean zzf(long j) {
        long elapsedRealtime = 20000 - (com.google.android.gms.ads.internal.zzp.i().elapsedRealtime() - j);
        if (elapsedRealtime <= 0) {
            return false;
        }
        try {
            this.zzpd.wait(elapsedRealtime);
            return true;
        } catch (InterruptedException e) {
            return false;
        }
    }

    @Override // com.google.android.gms.internal.zzhj
    public void zzge() {
        this.zzHg.zzgd();
        AdRequestParcel adRequestParcel = this.zzDe.zzHC.c;
        try {
            this.zzHg.zzgc().zza(adRequestParcel, this.zzHi);
        } catch (RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Fail to load ad from adapter.", e);
            zzb(this.zzzj, 0);
        }
    }
}
