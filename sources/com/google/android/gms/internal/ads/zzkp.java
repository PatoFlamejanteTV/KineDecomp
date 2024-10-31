package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzki;

/* loaded from: classes2.dex */
public abstract class zzkp implements zzki.zza {
    public final String zzze;

    public zzkp(String str) {
        zzpo.checkNotNull(str);
        this.zzze = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }
}
