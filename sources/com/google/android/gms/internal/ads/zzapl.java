package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.PlatformVersion;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzapl {
    public static zzazb zza(Context context, com.google.android.gms.ads.internal.zza zzaVar, zzaxg zzaxgVar, zzcu zzcuVar, zzbgg zzbggVar, zzalg zzalgVar, zzapm zzapmVar, zzaba zzabaVar) {
        zzazb zzapoVar;
        zzasm zzasmVar = zzaxgVar.zzehy;
        if (zzasmVar.zzdyd) {
            zzapoVar = new zzapr(context, zzaxgVar, zzalgVar, zzapmVar, zzabaVar, zzbggVar);
        } else if (!zzasmVar.zzckn && !(zzaVar instanceof com.google.android.gms.ads.internal.zzbb)) {
            if (PlatformVersion.f() && !PlatformVersion.h() && zzbggVar != null && zzbggVar.zzadj().zzafb()) {
                zzapoVar = new zzapq(context, zzaxgVar, zzbggVar, zzapmVar);
            } else {
                zzapoVar = new zzapn(context, zzaxgVar, zzbggVar, zzapmVar);
            }
        } else if (zzasmVar.zzckn && (zzaVar instanceof com.google.android.gms.ads.internal.zzbb)) {
            zzapoVar = new zzapt(context, (com.google.android.gms.ads.internal.zzbb) zzaVar, zzaxgVar, zzcuVar, zzapmVar, zzabaVar);
        } else {
            zzapoVar = new zzapo(zzaxgVar, zzapmVar);
        }
        String valueOf = String.valueOf(zzapoVar.getClass().getName());
        zzbbd.zzdn(valueOf.length() != 0 ? "AdRenderer: ".concat(valueOf) : new String("AdRenderer: "));
        zzapoVar.zzwa();
        return zzapoVar;
    }
}
