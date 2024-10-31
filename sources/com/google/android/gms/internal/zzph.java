package com.google.android.gms.internal;

import android.text.TextUtils;
import android.util.Log;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.UUID;

/* loaded from: classes.dex */
public final class zzph extends com.google.android.gms.measurement.zze<zzph> {
    private int zzaLA;
    private String zzaLB;
    private String zzaLC;
    private boolean zzaLD;
    private boolean zzaLE;
    private boolean zzaLF;
    private String zzaLy;
    private int zzaLz;

    public zzph() {
        this(false);
    }

    public zzph(boolean z) {
        this(z, zzyL());
    }

    public zzph(boolean z, int i) {
        com.google.android.gms.common.internal.zzx.a(i);
        this.zzaLz = i;
        this.zzaLE = z;
    }

    static int zzyL() {
        UUID randomUUID = UUID.randomUUID();
        int leastSignificantBits = (int) (randomUUID.getLeastSignificantBits() & 2147483647L);
        if (leastSignificantBits != 0) {
            return leastSignificantBits;
        }
        int mostSignificantBits = (int) (randomUUID.getMostSignificantBits() & 2147483647L);
        if (mostSignificantBits != 0) {
            return mostSignificantBits;
        }
        Log.e("GAv4", "UUID.randomUUID() returned 0.");
        return Integer.MAX_VALUE;
    }

    private void zzyP() {
        if (this.zzaLF) {
            throw new IllegalStateException("ScreenViewInfo is immutable");
        }
    }

    public void setScreenName(String str) {
        zzyP();
        this.zzaLy = str;
    }

    public String toString() {
        HashMap hashMap = new HashMap();
        hashMap.put("screenName", this.zzaLy);
        hashMap.put("interstitial", Boolean.valueOf(this.zzaLD));
        hashMap.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_AUTOMATIC, Boolean.valueOf(this.zzaLE));
        hashMap.put("screenId", Integer.valueOf(this.zzaLz));
        hashMap.put("referrerScreenId", Integer.valueOf(this.zzaLA));
        hashMap.put("referrerScreenName", this.zzaLB);
        hashMap.put("referrerUri", this.zzaLC);
        return zzB(hashMap);
    }

    @Override // com.google.android.gms.measurement.zze
    public void zza(zzph zzphVar) {
        if (!TextUtils.isEmpty(this.zzaLy)) {
            zzphVar.setScreenName(this.zzaLy);
        }
        if (this.zzaLz != 0) {
            zzphVar.zzib(this.zzaLz);
        }
        if (this.zzaLA != 0) {
            zzphVar.zzic(this.zzaLA);
        }
        if (!TextUtils.isEmpty(this.zzaLB)) {
            zzphVar.zzdT(this.zzaLB);
        }
        if (!TextUtils.isEmpty(this.zzaLC)) {
            zzphVar.zzdU(this.zzaLC);
        }
        if (this.zzaLD) {
            zzphVar.zzam(this.zzaLD);
        }
        if (this.zzaLE) {
            zzphVar.zzal(this.zzaLE);
        }
    }

    public void zzal(boolean z) {
        zzyP();
        this.zzaLE = z;
    }

    public void zzam(boolean z) {
        zzyP();
        this.zzaLD = z;
    }

    public void zzdT(String str) {
        zzyP();
        this.zzaLB = str;
    }

    public void zzdU(String str) {
        zzyP();
        if (TextUtils.isEmpty(str)) {
            this.zzaLC = null;
        } else {
            this.zzaLC = str;
        }
    }

    public void zzib(int i) {
        zzyP();
        this.zzaLz = i;
    }

    public void zzic(int i) {
        zzyP();
        this.zzaLA = i;
    }

    public String zzyM() {
        return this.zzaLy;
    }

    public int zzyN() {
        return this.zzaLz;
    }

    public String zzyO() {
        return this.zzaLC;
    }
}
