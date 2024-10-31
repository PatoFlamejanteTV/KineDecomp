package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzaxp {

    @VisibleForTesting
    private final String zzejr;
    private final zzayb zzejs;

    @VisibleForTesting
    private long zzejm = -1;

    @VisibleForTesting
    private long zzejn = -1;

    @VisibleForTesting
    private int zzejo = -1;

    @VisibleForTesting
    int zzejp = -1;

    @VisibleForTesting
    private long zzejq = 0;
    private final Object mLock = new Object();

    @VisibleForTesting
    private int zzejt = 0;

    @VisibleForTesting
    private int zzeju = 0;

    public zzaxp(String str, zzayb zzaybVar) {
        this.zzejr = str;
        this.zzejs = zzaybVar;
    }

    private static boolean zzaf(Context context) {
        int identifier = context.getResources().getIdentifier("Theme.Translucent", AnalyticsEvents.PARAMETER_LIKE_VIEW_STYLE, "android");
        if (identifier == 0) {
            zzbbd.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
        try {
            if (identifier == context.getPackageManager().getActivityInfo(new ComponentName(context.getPackageName(), "com.google.android.gms.ads.AdActivity"), 0).theme) {
                return true;
            }
            zzbbd.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
            zzbbd.zzeo("Fail to fetch AdActivity theme");
            zzbbd.zzen("Please set theme of AdActivity to @android:style/Theme.Translucent to enable transparent background interstitial ad.");
            return false;
        }
    }

    public final void zzb(zzwb zzwbVar, long j) {
        synchronized (this.mLock) {
            long zzzj = this.zzejs.zzzj();
            long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
            if (this.zzejn == -1) {
                if (a2 - zzzj > ((Long) zzwu.zzpz().zzd(zzaan.zzcrn)).longValue()) {
                    this.zzejp = -1;
                } else {
                    this.zzejp = this.zzejs.zzzk();
                }
                this.zzejn = j;
                this.zzejm = this.zzejn;
            } else {
                this.zzejm = j;
            }
            if (zzwbVar == null || zzwbVar.extras == null || zzwbVar.extras.getInt("gw", 2) != 1) {
                this.zzejo++;
                this.zzejp++;
                if (this.zzejp == 0) {
                    this.zzejq = 0L;
                    this.zzejs.zzav(a2);
                } else {
                    this.zzejq = a2 - this.zzejs.zzzl();
                }
            }
        }
    }

    public final Bundle zzl(Context context, String str) {
        Bundle bundle;
        synchronized (this.mLock) {
            bundle = new Bundle();
            bundle.putString(com.umeng.analytics.pro.q.f25955c, this.zzejr);
            bundle.putLong("basets", this.zzejn);
            bundle.putLong("currts", this.zzejm);
            bundle.putString("seq_num", str);
            bundle.putInt("preqs", this.zzejo);
            bundle.putInt("preqs_in_session", this.zzejp);
            bundle.putLong("time_in_session", this.zzejq);
            bundle.putInt("pclick", this.zzejt);
            bundle.putInt("pimp", this.zzeju);
            bundle.putBoolean("support_transparent_background", zzaf(context));
        }
        return bundle;
    }

    public final void zzxv() {
        synchronized (this.mLock) {
            this.zzeju++;
        }
    }

    public final void zzxw() {
        synchronized (this.mLock) {
            this.zzejt++;
        }
    }
}
