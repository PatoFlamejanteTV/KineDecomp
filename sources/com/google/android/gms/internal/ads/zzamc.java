package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzamc implements MediationAdRequest {
    private final int zzcjv;
    private final boolean zzckh;
    private final int zzdnw;
    private final Date zzih;
    private final Set<String> zzij;
    private final boolean zzik;
    private final Location zzil;

    public zzamc(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2) {
        this.zzih = date;
        this.zzcjv = i;
        this.zzij = set;
        this.zzil = location;
        this.zzik = z;
        this.zzdnw = i2;
        this.zzckh = z2;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final Date getBirthday() {
        return this.zzih;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final int getGender() {
        return this.zzcjv;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Set<String> getKeywords() {
        return this.zzij;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final Location getLocation() {
        return this.zzil;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzckh;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final boolean isTesting() {
        return this.zzik;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdnw;
    }
}
