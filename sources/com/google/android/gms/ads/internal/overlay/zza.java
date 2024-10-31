package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zza {
    public boolean a(Context context, AdLauncherIntentInfoParcel adLauncherIntentInfoParcel, zzn zznVar) {
        int i;
        if (adLauncherIntentInfoParcel == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("No intent data for launcher overlay.");
            return false;
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.c)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Open GMSG did not contain a URL.");
            return false;
        }
        if (TextUtils.isEmpty(adLauncherIntentInfoParcel.d)) {
            intent.setData(Uri.parse(adLauncherIntentInfoParcel.c));
        } else {
            intent.setDataAndType(Uri.parse(adLauncherIntentInfoParcel.c), adLauncherIntentInfoParcel.d);
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.e)) {
            intent.setPackage(adLauncherIntentInfoParcel.e);
        }
        if (!TextUtils.isEmpty(adLauncherIntentInfoParcel.f)) {
            String[] split = adLauncherIntentInfoParcel.f.split("/", 2);
            if (split.length < 2) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse component name from open GMSG: " + adLauncherIntentInfoParcel.f);
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = adLauncherIntentInfoParcel.g;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse intent flags.");
                i = 0;
            }
            intent.addFlags(i);
        }
        try {
            com.google.android.gms.ads.internal.util.client.zzb.d("Launching an intent: " + intent.toURI());
            com.google.android.gms.ads.internal.zzp.e().zzb(context, intent);
            if (zznVar != null) {
                zznVar.zzaO();
            }
            return true;
        } catch (ActivityNotFoundException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e(e2.getMessage());
            return false;
        }
    }
}
