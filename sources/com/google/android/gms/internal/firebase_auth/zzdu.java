package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzj;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzdu implements zzff<zzj.zzr> {
    private String zzhm;
    private boolean zzpt;

    public zzdu(String str) {
        Preconditions.b(str);
        this.zzhm = str;
        this.zzpt = true;
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzj.zzr) zzj.zzr.zzba().zzbi(this.zzhm).zzl(this.zzpt).zzhn();
    }
}
