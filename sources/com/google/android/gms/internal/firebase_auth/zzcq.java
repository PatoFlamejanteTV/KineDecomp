package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzcq implements zzff<zzj.zzf> {
    private String zzgc;

    public zzcq(String str) {
        Preconditions.b(str);
        this.zzgc = str;
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzj.zzf) zzj.zzf.zzv().zzo(this.zzgc).zzhn();
    }
}
