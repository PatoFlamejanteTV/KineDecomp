package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import java.util.ArrayList;
import java.util.List;

@zzgr
/* loaded from: classes.dex */
public class zzek implements zzec {
    private final Context mContext;
    private final zzcg zzoo;
    private final zzem zzox;
    private final zzee zzzA;
    private final long zzzB;
    private final long zzzC;
    private zzeh zzzE;
    private final boolean zzzn;
    private final AdRequestInfoParcel zzzz;
    private final Object zzpd = new Object();
    private boolean zzzD = false;

    public zzek(Context context, AdRequestInfoParcel adRequestInfoParcel, zzem zzemVar, zzee zzeeVar, boolean z, long j, long j2, zzcg zzcgVar) {
        this.mContext = context;
        this.zzzz = adRequestInfoParcel;
        this.zzox = zzemVar;
        this.zzzA = zzeeVar;
        this.zzzn = z;
        this.zzzB = j;
        this.zzzC = j2;
        this.zzoo = zzcgVar;
    }

    @Override // com.google.android.gms.internal.zzec
    public void cancel() {
        synchronized (this.zzpd) {
            this.zzzD = true;
            if (this.zzzE != null) {
                this.zzzE.cancel();
            }
        }
    }

    @Override // com.google.android.gms.internal.zzec
    public zzei zzc(List<zzed> list) {
        com.google.android.gms.ads.internal.util.client.zzb.a("Starting mediation.");
        ArrayList arrayList = new ArrayList();
        zzce zzdn = this.zzoo.zzdn();
        for (zzed zzedVar : list) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Trying mediation network: " + zzedVar.zzyN);
            for (String str : zzedVar.zzyO) {
                zzce zzdn2 = this.zzoo.zzdn();
                synchronized (this.zzpd) {
                    if (this.zzzD) {
                        return new zzei(-1);
                    }
                    this.zzzE = new zzeh(this.mContext, str, this.zzox, this.zzzA, zzedVar, this.zzzz.c, this.zzzz.d, this.zzzz.k, this.zzzn, this.zzzz.z, this.zzzz.n);
                    zzei zza = this.zzzE.zza(this.zzzB, this.zzzC);
                    if (zza.zzzt == 0) {
                        com.google.android.gms.ads.internal.util.client.zzb.a("Adapter succeeded.");
                        this.zzoo.zze("mediation_network_succeed", str);
                        if (!arrayList.isEmpty()) {
                            this.zzoo.zze("mediation_networks_fail", TextUtils.join(",", arrayList));
                        }
                        this.zzoo.zza(zzdn2, "mls");
                        this.zzoo.zza(zzdn, "ttm");
                        return zza;
                    }
                    arrayList.add(str);
                    this.zzoo.zza(zzdn2, "mlf");
                    if (zza.zzzv != null) {
                        zzid.zzIE.post(new bs(this, zza));
                    }
                }
            }
        }
        if (!arrayList.isEmpty()) {
            this.zzoo.zze("mediation_networks_fail", TextUtils.join(",", arrayList));
        }
        return new zzei(1);
    }
}
