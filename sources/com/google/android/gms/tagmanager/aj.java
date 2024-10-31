package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import java.util.Map;

/* loaded from: classes.dex */
abstract class aj extends zzca {
    public aj(String str) {
        super(str);
    }

    @Override // com.google.android.gms.tagmanager.zzca
    protected boolean a(zzag.zza zzaVar, zzag.zza zzaVar2, Map<String, zzag.zza> map) {
        String a2 = zzdf.a(zzaVar);
        String a3 = zzdf.a(zzaVar2);
        if (a2 == zzdf.a() || a3 == zzdf.a()) {
            return false;
        }
        return a(a2, a3, map);
    }

    protected abstract boolean a(String str, String str2, Map<String, zzag.zza> map);
}
