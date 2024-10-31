package com.google.android.gms.internal.ads;

import android.os.Build;
import java.util.Arrays;

@zzark
/* loaded from: classes2.dex */
public final class zzbfd implements zzbfr {
    @Override // com.google.android.gms.internal.ads.zzbfr
    public final zzbfk zza(zzbdz zzbdzVar, int i, String str, zzbdy zzbdyVar) {
        if (Build.VERSION.SDK_INT >= 16 && i > 0 && Arrays.asList(zzbdyVar.zzeto.split(",")).contains("3")) {
            int zzacy = zzbes.zzacy();
            if (zzacy < zzbdyVar.zzetr) {
                return new zzbfw(zzbdzVar, zzbdyVar);
            }
            if (zzacy < zzbdyVar.zzetl) {
                return new zzbfv(zzbdzVar, zzbdyVar);
            }
            return new zzbft(zzbdzVar);
        }
        return new zzbfs(zzbdzVar);
    }
}
