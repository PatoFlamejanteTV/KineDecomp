package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzaan;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzaxz;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzwu;

@zzark
/* loaded from: classes.dex */
public final class zza {
    public static boolean a(Context context, zzc zzcVar, zzt zztVar) {
        int i = 0;
        if (zzcVar == null) {
            zzbbd.zzeo("No intent data for launcher overlay.");
            return false;
        }
        zzaan.initialize(context);
        Intent intent = zzcVar.f10125h;
        if (intent != null) {
            return a(context, intent, zztVar);
        }
        Intent intent2 = new Intent();
        if (TextUtils.isEmpty(zzcVar.f10119b)) {
            zzbbd.zzeo("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzcVar.f10120c)) {
            intent2.setDataAndType(Uri.parse(zzcVar.f10119b), zzcVar.f10120c);
        } else {
            intent2.setData(Uri.parse(zzcVar.f10119b));
        }
        intent2.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzcVar.f10121d)) {
            intent2.setPackage(zzcVar.f10121d);
        }
        if (!TextUtils.isEmpty(zzcVar.f10122e)) {
            String[] split = zzcVar.f10122e.split("/", 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzcVar.f10122e);
                zzbbd.zzeo(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent2.setClassName(split[0], split[1]);
        }
        String str = zzcVar.f10123f;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzbbd.zzeo("Could not parse intent flags.");
            }
            intent2.addFlags(i);
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwc)).booleanValue()) {
            intent2.addFlags(268435456);
            intent2.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcwb)).booleanValue()) {
                zzbv.e();
                zzayh.zzb(context, intent2);
            }
        }
        return a(context, intent2, zztVar);
    }

    private static boolean a(Context context, Intent intent, zzt zztVar) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzaxz.v(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzbv.e();
            zzayh.zza(context, intent);
            if (zztVar == null) {
                return true;
            }
            zztVar.zzig();
            return true;
        } catch (ActivityNotFoundException e2) {
            zzbbd.zzeo(e2.getMessage());
            return false;
        }
    }
}
