package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.ads.zzzc;
import com.google.android.gms.internal.ads.zzzf;

/* loaded from: classes.dex */
public class MobileAds {

    /* loaded from: classes.dex */
    public static final class Settings {

        /* renamed from: a, reason: collision with root package name */
        private final zzzf f9942a = new zzzf();

        final zzzf a() {
            return this.f9942a;
        }
    }

    private MobileAds() {
    }

    public static void a(Context context, String str) {
        a(context, str, null);
    }

    @Deprecated
    public static void a(Context context, String str, Settings settings) {
        zzzc.zzqq().zza(context, str, settings == null ? null : settings.a());
    }

    public static RewardedVideoAd a(Context context) {
        return zzzc.zzqq().getRewardedVideoAdInstance(context);
    }
}
