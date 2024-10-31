package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;

@zzark
/* loaded from: classes2.dex */
public final class zzawz {
    public static String zzb(String str, Context context, boolean z) {
        String zzz;
        if ((((Boolean) zzwu.zzpz().zzd(zzaan.zzcqz)).booleanValue() && !z) || !com.google.android.gms.ads.internal.zzbv.E().zzv(context) || TextUtils.isEmpty(str) || (zzz = com.google.android.gms.ads.internal.zzbv.E().zzz(context)) == null) {
            return str;
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcqs)).booleanValue()) {
            CharSequence charSequence = (String) zzwu.zzpz().zzd(zzaan.zzcqt);
            if (!str.contains(charSequence)) {
                return str;
            }
            if (com.google.android.gms.ads.internal.zzbv.e().zzea(str)) {
                com.google.android.gms.ads.internal.zzbv.E().zzf(context, zzz);
                return str.replace(charSequence, zzz);
            }
            if (!com.google.android.gms.ads.internal.zzbv.e().zzeb(str)) {
                return str;
            }
            com.google.android.gms.ads.internal.zzbv.E().zzg(context, zzz);
            return str.replace(charSequence, zzz);
        }
        if (str.contains("fbs_aeid")) {
            return str;
        }
        if (com.google.android.gms.ads.internal.zzbv.e().zzea(str)) {
            com.google.android.gms.ads.internal.zzbv.E().zzf(context, zzz);
            return zzb(str, "fbs_aeid", zzz).toString();
        }
        if (!com.google.android.gms.ads.internal.zzbv.e().zzeb(str)) {
            return str;
        }
        com.google.android.gms.ads.internal.zzbv.E().zzg(context, zzz);
        return zzb(str, "fbs_aeid", zzz).toString();
    }

    public static String zzb(String str, Context context) {
        String zzz;
        if (!com.google.android.gms.ads.internal.zzbv.E().zzv(context) || TextUtils.isEmpty(str) || (zzz = com.google.android.gms.ads.internal.zzbv.E().zzz(context)) == null || !com.google.android.gms.ads.internal.zzbv.e().zzeb(str)) {
            return str;
        }
        if (!((Boolean) zzwu.zzpz().zzd(zzaan.zzcqs)).booleanValue()) {
            return !str.contains("fbs_aeid") ? zzb(str, "fbs_aeid", zzz).toString() : str;
        }
        CharSequence charSequence = (String) zzwu.zzpz().zzd(zzaan.zzcqt);
        return str.contains(charSequence) ? str.replace(charSequence, zzz) : str;
    }

    public static String zzb(Uri uri, Context context) {
        if (!com.google.android.gms.ads.internal.zzbv.E().zzv(context)) {
            return uri.toString();
        }
        String zzz = com.google.android.gms.ads.internal.zzbv.E().zzz(context);
        if (zzz == null) {
            return uri.toString();
        }
        if (((Boolean) zzwu.zzpz().zzd(zzaan.zzcqs)).booleanValue()) {
            String str = (String) zzwu.zzpz().zzd(zzaan.zzcqt);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                com.google.android.gms.ads.internal.zzbv.E().zzf(context, zzz);
                return uri2.replace(str, zzz);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            uri = zzb(uri.toString(), "fbs_aeid", zzz);
            com.google.android.gms.ads.internal.zzbv.E().zzf(context, zzz);
        }
        return uri.toString();
    }

    @VisibleForTesting
    private static Uri zzb(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf != -1) {
            int i = indexOf + 1;
            return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
        }
        return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
    }
}
