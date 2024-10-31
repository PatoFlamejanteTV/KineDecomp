package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;

@zzark
@ParametersAreNonnullByDefault
/* loaded from: classes2.dex */
public final class zzaaz {
    private final zzaba zzbln;
    private final Map<String, zzaay> zzczi = new HashMap();

    public zzaaz(zzaba zzabaVar) {
        this.zzbln = zzabaVar;
    }

    public final void zza(String str, zzaay zzaayVar) {
        this.zzczi.put(str, zzaayVar);
    }

    public final void zzb(String str, String str2, long j) {
        zzaba zzabaVar = this.zzbln;
        zzaay zzaayVar = this.zzczi.get(str2);
        String[] strArr = {str};
        if (zzabaVar != null && zzaayVar != null) {
            zzabaVar.zza(zzaayVar, j, strArr);
        }
        Map<String, zzaay> map = this.zzczi;
        zzaba zzabaVar2 = this.zzbln;
        map.put(str, zzabaVar2 == null ? null : zzabaVar2.zzao(j));
    }

    public final zzaba zzrf() {
        return this.zzbln;
    }
}
