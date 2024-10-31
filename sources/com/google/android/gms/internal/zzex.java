package com.google.android.gms.internal;

import android.location.Location;
import com.facebook.appevents.AppEventsConstants;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.Date;
import java.util.List;
import java.util.Set;

@zzgr
/* loaded from: classes.dex */
public final class zzex implements NativeMediationAdRequest {
    private final Date zzaT;
    private final Set<String> zzaV;
    private final boolean zzaW;
    private final Location zzaX;
    private final NativeAdOptionsParcel zzoY;
    private final List<String> zzoZ;
    private final int zzsR;
    private final int zzzI;

    public zzex(Date date, int i, Set<String> set, Location location, boolean z, int i2, NativeAdOptionsParcel nativeAdOptionsParcel, List<String> list) {
        this.zzaT = date;
        this.zzsR = i;
        this.zzaV = set;
        this.zzaX = location;
        this.zzaW = z;
        this.zzzI = i2;
        this.zzoY = nativeAdOptionsParcel;
        this.zzoZ = list;
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

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public NativeAdOptions getNativeAdOptions() {
        if (this.zzoY == null) {
            return null;
        }
        return new NativeAdOptions.Builder().a(this.zzoY.b).a(this.zzoY.c).b(this.zzoY.d).a();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public boolean isAppInstallAdRequested() {
        return this.zzoZ != null && this.zzoZ.contains("2");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public boolean isContentAdRequested() {
        return this.zzoZ != null && this.zzoZ.contains(AppEventsConstants.EVENT_PARAM_VALUE_YES);
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
