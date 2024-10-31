package com.google.android.gms.internal.ads;

import android.location.Location;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@zzark
/* loaded from: classes2.dex */
public final class zzamh implements NativeMediationAdRequest {
    private final zzacp zzbnx;
    private final int zzcjv;
    private final boolean zzckh;
    private final int zzdnw;
    private final Date zzih;
    private final Set<String> zzij;
    private final boolean zzik;
    private final Location zzil;
    private final List<String> zzdmp = new ArrayList();
    private final Map<String, Boolean> zzdof = new HashMap();

    public zzamh(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzacp zzacpVar, List<String> list, boolean z2) {
        this.zzih = date;
        this.zzcjv = i;
        this.zzij = set;
        this.zzil = location;
        this.zzik = z;
        this.zzdnw = i2;
        this.zzbnx = zzacpVar;
        this.zzckh = z2;
        if (list != null) {
            for (String str : list) {
                if (str.startsWith("custom:")) {
                    String[] split = str.split(":", 3);
                    if (split.length == 3) {
                        if (ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(split[2])) {
                            this.zzdof.put(split[1], true);
                        } else if ("false".equals(split[2])) {
                            this.zzdof.put(split[1], false);
                        }
                    }
                } else {
                    this.zzdmp.add(str);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzzc.zzqq().zzkj();
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

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final NativeAdOptions getNativeAdOptions() {
        zzzw zzzwVar;
        if (this.zzbnx == null) {
            return null;
        }
        NativeAdOptions.Builder a2 = new NativeAdOptions.Builder().b(this.zzbnx.zzdcs).b(this.zzbnx.zzdct).a(this.zzbnx.zzdcu);
        zzacp zzacpVar = this.zzbnx;
        if (zzacpVar.versionCode >= 2) {
            a2.a(zzacpVar.zzdcv);
        }
        zzacp zzacpVar2 = this.zzbnx;
        if (zzacpVar2.versionCode >= 3 && (zzzwVar = zzacpVar2.zzdcw) != null) {
            a2.a(new VideoOptions(zzzwVar));
        }
        return a2.a();
    }

    public final boolean isAdMuted() {
        return zzzc.zzqq().zzkk();
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdmp;
        if (list != null) {
            return list.contains("2") || this.zzdmp.contains("6");
        }
        return false;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isContentAdRequested() {
        List<String> list = this.zzdmp;
        if (list != null) {
            return list.contains("1") || this.zzdmp.contains("6");
        }
        return false;
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

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdmp;
        return list != null && list.contains("6");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdRequest
    public final int taggedForChildDirectedTreatment() {
        return this.zzdnw;
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final boolean zzvg() {
        List<String> list = this.zzdmp;
        return list != null && list.contains("3");
    }

    @Override // com.google.android.gms.ads.mediation.NativeMediationAdRequest
    public final Map<String, Boolean> zzvh() {
        return this.zzdof;
    }
}
