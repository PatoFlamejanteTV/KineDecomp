package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzcl implements zzff<zzj.zzc> {
    private String zzgc;

    public zzcl(String str) {
        Preconditions.b(str);
        this.zzgc = str;
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzj.zzc) zzj.zzc.zzn().zzh(this.zzgc).zzhn();
    }
}
