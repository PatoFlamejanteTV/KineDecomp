package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import com.google.android.gms.internal.zzce;
import com.google.android.gms.internal.zzcg;
import com.google.android.gms.internal.zziz;
import com.google.android.gms.internal.zzmx;

/* loaded from: classes.dex */
public class zzl implements zzj {
    @Override // com.google.android.gms.ads.internal.overlay.zzj
    public zzi a(Context context, zziz zzizVar, int i, zzcg zzcgVar, zzce zzceVar) {
        if (zzmx.zzqx()) {
            return new zzc(context, new zzp(context, zzizVar.zzhh(), zzizVar.getRequestId(), zzcgVar, zzceVar));
        }
        return null;
    }
}
