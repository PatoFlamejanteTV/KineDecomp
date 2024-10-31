package com.google.android.gms.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.ads.internal.client.AdRequestParcel;

@zzgr
/* loaded from: classes.dex */
public class zzhv {
    final String zzHP;
    long zzId = -1;
    long zzIe = -1;
    int zzIf = -1;
    private final Object zzpd = new Object();
    int zzIg = 0;
    int zzIh = 0;

    public zzhv(String str) {
        this.zzHP = str;
    }

    public static boolean zzF(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            com.google.android.gms.ads.internal.util.client.zzb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to fetch AdActivity theme");
            com.google.android.gms.ads.internal.util.client.zzb.c("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public void zzb(AdRequestParcel adRequestParcel, long j) {
        synchronized (this.zzpd) {
            if (this.zzIe == -1) {
                this.zzIe = j;
                this.zzId = this.zzIe;
            } else {
                this.zzId = j;
            }
            if (adRequestParcel.c == null || adRequestParcel.c.getInt("gw", 2) != 1) {
                this.zzIf++;
            }
        }
    }

    public Bundle zze(Context context, String str) {
        Bundle bundle;
        synchronized (this.zzpd) {
            bundle = new Bundle();
            bundle.putString("session_id", this.zzHP);
            bundle.putLong("basets", this.zzIe);
            bundle.putLong("currts", this.zzId);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzIf);
            bundle.putInt("pclick", this.zzIg);
            bundle.putInt("pimp", this.zzIh);
            bundle.putBoolean("support_transparent_background", zzF(context));
        }
        return bundle;
    }

    public void zzgf() {
        synchronized (this.zzpd) {
            this.zzIh++;
        }
    }

    public void zzgg() {
        synchronized (this.zzpd) {
            this.zzIg++;
        }
    }

    public long zzgx() {
        return this.zzIe;
    }
}
