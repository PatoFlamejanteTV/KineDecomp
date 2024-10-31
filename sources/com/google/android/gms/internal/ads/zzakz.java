package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.AppEventsConstants;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzakz {
    public static List<String> zza(JSONObject jSONObject, String str) throws JSONException {
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(optJSONArray.length());
        for (int i = 0; i < optJSONArray.length(); i++) {
            arrayList.add(optJSONArray.getString(i));
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static String zzco(String str) {
        return (TextUtils.isEmpty(str) || !zzbax.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public static void zza(Context context, String str, zzaxf zzaxfVar, String str2, boolean z, List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String str3 = z ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO;
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String zza = zza(zza(zza(zza(zza(zza(zza(it.next(), "@gw_adlocid@", str2), "@gw_adnetrefresh@", str3), "@gw_qdata@", zzaxfVar.zzehj.zzdlw), "@gw_sdkver@", str), "@gw_sessid@", zzwu.zzqa()), "@gw_seqnum@", zzaxfVar.zzdwj), "@gw_adnetstatus@", zzaxfVar.zzehk);
            zzakq zzakqVar = zzaxfVar.zzdnb;
            if (zzakqVar != null) {
                zza = zza(zza(zza, "@gw_adnetid@", zzakqVar.zzdkv), "@gw_allocid@", zzaxfVar.zzdnb.zzdkx);
            }
            String zzb = zzawz.zzb(zza, context, zzaxfVar.zzdzf);
            com.google.android.gms.ads.internal.zzbv.e();
            zzayh.zzc(context, str, zzb);
        }
    }

    public static void zza(Context context, String str, List<String> list, String str2, String str3, zzawd zzawdVar) {
        if (list == null || list.isEmpty()) {
            return;
        }
        String zzco = zzco(str2);
        String zzco2 = zzco(str3);
        long a2 = com.google.android.gms.ads.internal.zzbv.l().a();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String zza = zza(zza(zza(it.next(), "@gw_rwd_userid@", Uri.encode(zzco)), "@gw_rwd_custom_data@", Uri.encode(zzco2)), "@gw_tmstmp@", Long.toString(a2));
            if (zzawdVar != null) {
                zza = zza(zza(zza, "@gw_rwd_itm@", Uri.encode(zzawdVar.type)), "@gw_rwd_amt@", Integer.toString(zzawdVar.zzefo));
            }
            com.google.android.gms.ads.internal.zzbv.e();
            zzayh.zzc(context, str, zza);
        }
    }

    private static String zza(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    public static boolean zza(String str, int[] iArr) {
        if (TextUtils.isEmpty(str) || iArr.length != 2) {
            return false;
        }
        String[] split = str.split(FragmentC2201x.f23219a);
        if (split.length != 2) {
            return false;
        }
        try {
            iArr[0] = Integer.parseInt(split[0]);
            iArr[1] = Integer.parseInt(split[1]);
            return true;
        } catch (NumberFormatException unused) {
            return false;
        }
    }
}
