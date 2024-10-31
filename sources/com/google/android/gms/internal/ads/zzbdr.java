package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.Arrays;

@zzark
/* loaded from: classes2.dex */
public final class zzbdr extends zzbdj {
    @Override // com.google.android.gms.internal.ads.zzbdj
    public final zzbdi zza(Context context, zzbdz zzbdzVar, int i, boolean z, zzaba zzabaVar, zzbdy zzbdyVar) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (!(PlatformVersion.a() && (applicationInfo == null || applicationInfo.targetSdkVersion >= 11))) {
            return null;
        }
        zzbea zzbeaVar = new zzbea(context, zzbdzVar.zzabz(), zzbdzVar.zzabx(), zzabaVar, zzbdzVar.zzabv());
        if ((Build.VERSION.SDK_INT >= 16 && i == 2) && Arrays.asList(zzbdyVar.zzeto.split(",")).contains("3")) {
            return new zzbee(context, zzbeaVar, zzbdzVar, z, zzbdj.zza(zzbdzVar), zzbdyVar);
        }
        return new zzbcx(context, z, zzbdj.zza(zzbdzVar), zzbdyVar, new zzbea(context, zzbdzVar.zzabz(), zzbdzVar.zzabx(), zzabaVar, zzbdzVar.zzabv()));
    }
}
