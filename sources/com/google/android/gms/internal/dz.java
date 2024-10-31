package com.google.android.gms.internal;

import com.google.android.gms.internal.zzm;
import java.util.Map;

/* loaded from: classes.dex */
class dz extends zzab {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f1518a;
    final /* synthetic */ zzih b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dz(zzih zzihVar, String str, zzm.zzb zzbVar, zzm.zza zzaVar, Map map) {
        super(str, zzbVar, zzaVar);
        this.b = zzihVar;
        this.f1518a = map;
    }

    @Override // com.google.android.gms.internal.zzk
    public Map<String, String> getHeaders() throws zza {
        return this.f1518a == null ? super.getHeaders() : this.f1518a;
    }
}
