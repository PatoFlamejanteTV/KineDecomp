package com.google.android.gms.internal;

import com.google.android.gms.ads.internal.reward.client.zza;

/* loaded from: classes.dex */
public class zzhe extends zza.AbstractBinderC0028zza {
    private final int zzGV;
    private final String zzGq;

    public zzhe(String str, int i) {
        this.zzGq = str;
        this.zzGV = i;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public int getAmount() {
        return this.zzGV;
    }

    @Override // com.google.android.gms.ads.internal.reward.client.zza
    public String getType() {
        return this.zzGq;
    }
}
