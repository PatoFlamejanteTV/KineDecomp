package com.google.android.gms.internal.firebase_auth;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_auth.zzjm;
import com.google.firebase.auth.api.internal.zzff;

/* loaded from: classes2.dex */
public final class zzcp implements zzff<zzjm.zza> {
    private String zzow;
    private String zzox;
    private final String zzoy;

    public zzcp(String str) {
        this(str, null);
    }

    public final /* synthetic */ zzhc zzds() {
        return (zzjm.zza) zzjm.zza.zzka().zzdf(this.zzow).zzdg(this.zzox).zzhn();
    }

    private zzcp(String str, String str2) {
        this.zzow = zzco.REFRESH_TOKEN.toString();
        Preconditions.b(str);
        this.zzox = str;
        this.zzoy = null;
    }
}
