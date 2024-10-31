package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.internal.request.AdResponseParcel;
import com.google.android.gms.internal.zzhs;

@zzgr
/* loaded from: classes.dex */
public class zzgg {

    /* loaded from: classes.dex */
    public interface zza {
        void zzb(zzhs zzhsVar);
    }

    public zzgh zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzhs.zza zzaVar2, zzan zzanVar, zziz zzizVar, zzem zzemVar, zza zzaVar3, zzcg zzcgVar) {
        zzgh zzgeVar;
        AdResponseParcel adResponseParcel = zzaVar2.zzHD;
        if (adResponseParcel.h) {
            zzgeVar = new zzgk(context, zzaVar2, zzemVar, zzaVar3, zzcgVar);
        } else if (!adResponseParcel.t) {
            zzgeVar = adResponseParcel.p ? new zzge(context, zzaVar2, zzizVar, zzaVar3) : (zzby.zzvb.get().booleanValue() && zzmx.zzqB() && !zzmx.isAtLeastL() && zzizVar.zzaN().e) ? new zzgj(context, zzaVar2, zzizVar, zzaVar3) : new zzgi(context, zzaVar2, zzizVar, zzaVar3);
        } else {
            if (!(zzaVar instanceof com.google.android.gms.ads.internal.zzn)) {
                throw new IllegalArgumentException("Invalid NativeAdManager type. Found: " + (zzaVar != null ? zzaVar.getClass().getName() : "null") + "; Required: NativeAdManager.");
            }
            zzgeVar = new zzgl(context, (com.google.android.gms.ads.internal.zzn) zzaVar, new zzbc(), zzaVar2, zzanVar, zzaVar3);
        }
        com.google.android.gms.ads.internal.util.client.zzb.a("AdRenderer: " + zzgeVar.getClass().getName());
        zzgeVar.zzfu();
        return zzgeVar;
    }
}
