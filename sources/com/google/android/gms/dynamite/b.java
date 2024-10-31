package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

/* loaded from: classes.dex */
final class b implements DynamiteModule.VersionPolicy {
    @Override // com.google.android.gms.dynamite.DynamiteModule.VersionPolicy
    public final DynamiteModule.VersionPolicy.zzb a(Context context, String str, DynamiteModule.VersionPolicy.zza zzaVar) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.zzb zzbVar = new DynamiteModule.VersionPolicy.zzb();
        zzbVar.f11328b = zzaVar.a(context, str, true);
        if (zzbVar.f11328b != 0) {
            zzbVar.f11329c = 1;
        } else {
            zzbVar.f11327a = zzaVar.a(context, str);
            if (zzbVar.f11327a != 0) {
                zzbVar.f11329c = -1;
            }
        }
        return zzbVar;
    }
}
