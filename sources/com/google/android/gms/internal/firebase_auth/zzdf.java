package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdf implements zzff<zzj.zzi> {
    private final String zzgw;
    private final String zzib;
    private final String zzic;

    public zzdf(String str, String str2, String str3) {
        Preconditions.b(str);
        this.zzib = str;
        this.zzic = str2;
        this.zzgw = str3;
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzi.zza zzaf = zzj.zzi.zzab().zzaf(this.zzib);
        String str = this.zzic;
        if (str != null) {
            zzaf.zzag(str);
        }
        String str2 = this.zzgw;
        if (str2 != null) {
            zzaf.zzah(str2);
        }
        return (zzj.zzi) zzaf.zzhn();
    }
}
