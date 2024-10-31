package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdx implements zzff<zzj.zzt> {
    private String zzgh;
    private String zzgi;
    private final String zzgw;
    private boolean zzpt;

    public zzdx(String str, String str2, String str3) {
        Preconditions.b(str);
        this.zzgh = str;
        Preconditions.b(str2);
        this.zzgi = str2;
        this.zzgw = str3;
        this.zzpt = true;
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzt.zza zzm = zzj.zzt.zzbd().zzbj(this.zzgh).zzbk(this.zzgi).zzm(this.zzpt);
        String str = this.zzgw;
        if (str != null) {
            zzm.zzbl(str);
        }
        return (zzj.zzt) zzm.zzhn();
    }
}
