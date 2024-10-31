package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.internal.zzmx;

/* loaded from: classes.dex */
public class zze {
    public void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel) {
        a(context, adOverlayInfoParcel, true);
    }

    public void a(Context context, AdOverlayInfoParcel adOverlayInfoParcel, boolean z) {
        if (adOverlayInfoParcel.l == 4 && adOverlayInfoParcel.d == null) {
            if (adOverlayInfoParcel.c != null) {
                adOverlayInfoParcel.c.onAdClicked();
            }
            com.google.android.gms.ads.internal.zzp.b().a(context, adOverlayInfoParcel.b, adOverlayInfoParcel.j);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context, "com.google.android.gms.ads.AdActivity");
        intent.putExtra("com.google.android.gms.ads.internal.overlay.useClientJar", adOverlayInfoParcel.n.e);
        intent.putExtra("shouldCallOnOverlayOpened", z);
        AdOverlayInfoParcel.a(intent, adOverlayInfoParcel);
        if (!zzmx.isAtLeastL()) {
            intent.addFlags(524288);
        }
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        com.google.android.gms.ads.internal.zzp.e().zzb(context, intent);
    }
}
