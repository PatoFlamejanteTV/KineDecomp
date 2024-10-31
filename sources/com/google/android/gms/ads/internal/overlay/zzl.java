package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzvt;

@zzark
/* loaded from: classes.dex */
public final class zzl {
    public static void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.k == 4 && adOverlayInfoParcel.f10100c == null) {
            zzvt zzvtVar = adOverlayInfoParcel.f10099b;
            if (zzvtVar != null) {
                zzvtVar.onAdClicked();
            }
            zzbv.b();
            zza.a(context, adOverlayInfoParcel.f10098a, adOverlayInfoParcel.i);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.m.zzeow);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.a(intent, adOverlayInfoParcel);
        if (!PlatformVersion.h()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        zzbv.e();
        zzayh.zza(context, intent);
    }
}
