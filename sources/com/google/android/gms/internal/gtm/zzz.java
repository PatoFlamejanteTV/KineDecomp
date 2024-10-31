package com.google.android.gms.internal.gtm;

import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.util.HashMap;

@ShowFirstParty
/* loaded from: classes2.dex */
public final class zzz extends com.google.android.gms.analytics.zzi<zzz> {
    private String zzus;
    private String zzut;
    private String zzuu;
    private String zzuv;
    private boolean zzuw;
    private String zzux;
    private boolean zzuy;
    private double zzuz;

    public final void setClientId(String str) {
        this.zzut = str;
    }

    public final void setUserId(String str) {
        this.zzuu = str;
    }

    public final String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("hitType", this.zzus);
        hashMap.put("clientId", this.zzut);
        hashMap.put("userId", this.zzuu);
        hashMap.put("androidAdId", this.zzuv);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.zzuw));
        hashMap.put("sessionControl", this.zzux);
        hashMap.put("nonInteraction", Boolean.valueOf(this.zzuy));
        hashMap.put("sampleRate", Double.valueOf(this.zzuz));
        return com.google.android.gms.analytics.zzi.zza((Object) hashMap);
    }

    public final void zza(boolean z) {
        this.zzuw = z;
    }

    public final void zzb(boolean z) {
        this.zzuy = true;
    }

    public final String zzbs() {
        return this.zzus;
    }

    public final String zzbt() {
        return this.zzut;
    }

    public final String zzbu() {
        return this.zzuu;
    }

    public final String zzbv() {
        return this.zzuv;
    }

    public final boolean zzbw() {
        return this.zzuw;
    }

    public final String zzbx() {
        return this.zzux;
    }

    public final boolean zzby() {
        return this.zzuy;
    }

    public final double zzbz() {
        return this.zzuz;
    }

    public final void zzl(String str) {
        this.zzus = str;
    }

    public final void zzm(String str) {
        this.zzuv = str;
    }

    @Override // com.google.android.gms.analytics.zzi
    public final /* synthetic */ void zzb(zzz zzzVar) {
        zzz zzzVar2 = zzzVar;
        if (!TextUtils.isEmpty(this.zzus)) {
            zzzVar2.zzus = this.zzus;
        }
        if (!TextUtils.isEmpty(this.zzut)) {
            zzzVar2.zzut = this.zzut;
        }
        if (!TextUtils.isEmpty(this.zzuu)) {
            zzzVar2.zzuu = this.zzuu;
        }
        if (!TextUtils.isEmpty(this.zzuv)) {
            zzzVar2.zzuv = this.zzuv;
        }
        if (this.zzuw) {
            zzzVar2.zzuw = true;
        }
        if (!TextUtils.isEmpty(this.zzux)) {
            zzzVar2.zzux = this.zzux;
        }
        boolean z = this.zzuy;
        if (z) {
            zzzVar2.zzuy = z;
        }
        double d2 = this.zzuz;
        if (d2 != 0.0d) {
            Preconditions.a(d2 >= 0.0d && d2 <= 100.0d, "Sample rate must be between 0% and 100%");
            zzzVar2.zzuz = d2;
        }
    }
}
