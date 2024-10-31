package com.google.android.gms.internal;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public final class zzes implements MediationAdRequest {
    private final Date zzaT;
    private final Set<String> zzaV;
    private final boolean zzaW;
    private final Location zzaX;
    private final int zzsR;
    private final int zzzI;

    public zzes(Date date, int i, Set<String> set, Location location, boolean z, int i2) {
        this.zzaT = date;
        this.zzsR = i;
        this.zzaV = set;
        this.zzaX = location;
        this.zzaW = z;
        this.zzzI = i2;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Date getBirthday() {
        return this.zzaT;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public int getGender() {
        return this.zzsR;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Set<String> getKeywords() {
        return this.zzaV;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public Location getLocation() {
        return this.zzaX;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public boolean isTesting() {
        return this.zzaW;
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public int taggedForChildDirectedTreatment() {
        return this.zzzI;
    }
}
