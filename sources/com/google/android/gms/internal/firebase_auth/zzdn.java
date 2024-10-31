package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdn implements zzff<zzj.zzn> {
    private String zzgh;
    private String zzgi;
    private String zzgw;
    private String zzhw;

    public zzdn(String str) {
        this.zzgw = str;
    }

    public final /* synthetic */ zzhc zzds() {
        zzj.zzn.zza zzap = zzj.zzn.zzap();
        String str = this.zzgh;
        if (str != null) {
            zzap.zzau(str);
        }
        String str2 = this.zzgi;
        if (str2 != null) {
            zzap.zzav(str2);
        }
        String str3 = this.zzgw;
        if (str3 != null) {
            zzap.zzaw(str3);
        }
        return (zzj.zzn) zzap.zzhn();
    }

    public zzdn(String str, String str2, String str3, String str4) {
        Preconditions.b(str);
        this.zzgh = str;
        Preconditions.b(str2);
        this.zzgi = str2;
        this.zzhw = null;
        this.zzgw = str4;
    }
}
