package com.google.android.gms.internal.ads;

import android.location.Location;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzatv {
    /* JADX WARN: Removed duplicated region for block: B:307:0x084b  */
    /* JADX WARN: Removed duplicated region for block: B:311:0x084e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static org.json.JSONObject zza(android.content.Context r22, com.google.android.gms.internal.ads.zzato r23) {
        /*
            Method dump skipped, instructions count: 2471
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatv.zza(android.content.Context, com.google.android.gms.internal.ads.zzato):org.json.JSONObject");
    }

    private static Integer zzag(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }

    public static JSONObject zzb(zzasm zzasmVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String str = zzasmVar.zzbde;
        if (str != null) {
            jSONObject.put("ad_base_url", str);
        }
        String str2 = zzasmVar.zzdyg;
        if (str2 != null) {
            jSONObject.put("ad_size", str2);
        }
        jSONObject.put(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE, zzasmVar.zzckn);
        if (zzasmVar.zzckn) {
            jSONObject.put("ad_json", zzasmVar.zzdyb);
        } else {
            jSONObject.put("ad_html", zzasmVar.zzdyb);
        }
        String str3 = zzasmVar.zzdyi;
        if (str3 != null) {
            jSONObject.put("debug_dialog", str3);
        }
        String str4 = zzasmVar.zzdyy;
        if (str4 != null) {
            jSONObject.put("debug_signals", str4);
        }
        long j = zzasmVar.zzdyc;
        if (j != -1) {
            double d2 = j;
            Double.isNaN(d2);
            jSONObject.put("interstitial_timeout", d2 / 1000.0d);
        }
        if (zzasmVar.orientation == com.google.android.gms.ads.internal.zzbv.g().zzzx()) {
            jSONObject.put("orientation", "portrait");
        } else if (zzasmVar.orientation == com.google.android.gms.ads.internal.zzbv.g().zzzw()) {
            jSONObject.put("orientation", "landscape");
        }
        List<String> list = zzasmVar.zzdlq;
        if (list != null) {
            jSONObject.put("click_urls", zzm(list));
        }
        List<String> list2 = zzasmVar.zzdlr;
        if (list2 != null) {
            jSONObject.put("impression_urls", zzm(list2));
        }
        List<String> list3 = zzasmVar.zzdls;
        if (list3 != null) {
            jSONObject.put("downloaded_impression_urls", zzm(list3));
        }
        List<String> list4 = zzasmVar.zzdyf;
        if (list4 != null) {
            jSONObject.put("manual_impression_urls", zzm(list4));
        }
        String str5 = zzasmVar.zzdyl;
        if (str5 != null) {
            jSONObject.put("active_view", str5);
        }
        jSONObject.put("ad_is_javascript", zzasmVar.zzdyj);
        String str6 = zzasmVar.zzdyk;
        if (str6 != null) {
            jSONObject.put("ad_passback_url", str6);
        }
        jSONObject.put("mediation", zzasmVar.zzdyd);
        jSONObject.put("custom_render_allowed", zzasmVar.zzdym);
        jSONObject.put("content_url_opted_out", zzasmVar.zzdyn);
        jSONObject.put("content_vertical_opted_out", zzasmVar.zzdyz);
        jSONObject.put("prefetch", zzasmVar.zzdyo);
        long j2 = zzasmVar.zzdlx;
        if (j2 != -1) {
            jSONObject.put("refresh_interval_milliseconds", j2);
        }
        long j3 = zzasmVar.zzdye;
        if (j3 != -1) {
            jSONObject.put("mediation_config_cache_time_milliseconds", j3);
        }
        if (!TextUtils.isEmpty(zzasmVar.zzcgx)) {
            jSONObject.put("gws_query_id", zzasmVar.zzcgx);
        }
        jSONObject.put("fluid", zzasmVar.zzcko ? "height" : "");
        jSONObject.put("native_express", zzasmVar.zzckp);
        List<String> list5 = zzasmVar.zzdys;
        if (list5 != null) {
            jSONObject.put("video_start_urls", zzm(list5));
        }
        List<String> list6 = zzasmVar.zzdyt;
        if (list6 != null) {
            jSONObject.put("video_complete_urls", zzm(list6));
        }
        zzawd zzawdVar = zzasmVar.zzdyr;
        if (zzawdVar != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("rb_type", zzawdVar.type);
            jSONObject2.put("rb_amount", zzawdVar.zzefo);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject2);
            jSONObject.put("rewards", jSONArray);
        }
        jSONObject.put("use_displayed_impression", zzasmVar.zzdyu);
        jSONObject.put("auto_protection_configuration", zzasmVar.zzdyv);
        jSONObject.put("render_in_browser", zzasmVar.zzdlv);
        jSONObject.put("disable_closable_area", zzasmVar.zzbpi);
        return jSONObject;
    }

    private static JSONArray zzm(List<String> list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next());
        }
        return jSONArray;
    }

    private static void zza(HashMap<String, Object> hashMap, Location location) {
        HashMap hashMap2 = new HashMap();
        Float valueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
        Long valueOf2 = Long.valueOf(location.getTime() * 1000);
        Long valueOf3 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
        Long valueOf4 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
        hashMap2.put("radius", valueOf);
        hashMap2.put("lat", valueOf3);
        hashMap2.put("long", valueOf4);
        hashMap2.put("time", valueOf2);
        hashMap.put("uule", hashMap2);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x00e1 A[Catch: JSONException -> 0x0295, TryCatch #0 {JSONException -> 0x0295, blocks: (B:3:0x0007, B:5:0x0029, B:8:0x0032, B:10:0x003a, B:12:0x0042, B:14:0x004a, B:16:0x0052, B:17:0x0056, B:19:0x006a, B:20:0x007b, B:22:0x008a, B:24:0x00a8, B:26:0x00ae, B:28:0x00b4, B:31:0x00e1, B:34:0x00e7, B:38:0x00f5, B:39:0x00fa, B:43:0x0108, B:44:0x010d, B:48:0x011b, B:49:0x0124, B:53:0x0132, B:55:0x013d, B:57:0x0141, B:58:0x0145, B:60:0x014d, B:61:0x0153, B:63:0x0161, B:64:0x016c, B:66:0x022b, B:69:0x0238, B:75:0x012e, B:77:0x0117, B:78:0x0104, B:79:0x00f1, B:81:0x0095, B:83:0x009d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00e7 A[Catch: JSONException -> 0x0295, TryCatch #0 {JSONException -> 0x0295, blocks: (B:3:0x0007, B:5:0x0029, B:8:0x0032, B:10:0x003a, B:12:0x0042, B:14:0x004a, B:16:0x0052, B:17:0x0056, B:19:0x006a, B:20:0x007b, B:22:0x008a, B:24:0x00a8, B:26:0x00ae, B:28:0x00b4, B:31:0x00e1, B:34:0x00e7, B:38:0x00f5, B:39:0x00fa, B:43:0x0108, B:44:0x010d, B:48:0x011b, B:49:0x0124, B:53:0x0132, B:55:0x013d, B:57:0x0141, B:58:0x0145, B:60:0x014d, B:61:0x0153, B:63:0x0161, B:64:0x016c, B:66:0x022b, B:69:0x0238, B:75:0x012e, B:77:0x0117, B:78:0x0104, B:79:0x00f1, B:81:0x0095, B:83:0x009d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0161 A[Catch: JSONException -> 0x0295, TryCatch #0 {JSONException -> 0x0295, blocks: (B:3:0x0007, B:5:0x0029, B:8:0x0032, B:10:0x003a, B:12:0x0042, B:14:0x004a, B:16:0x0052, B:17:0x0056, B:19:0x006a, B:20:0x007b, B:22:0x008a, B:24:0x00a8, B:26:0x00ae, B:28:0x00b4, B:31:0x00e1, B:34:0x00e7, B:38:0x00f5, B:39:0x00fa, B:43:0x0108, B:44:0x010d, B:48:0x011b, B:49:0x0124, B:53:0x0132, B:55:0x013d, B:57:0x0141, B:58:0x0145, B:60:0x014d, B:61:0x0153, B:63:0x0161, B:64:0x016c, B:66:0x022b, B:69:0x0238, B:75:0x012e, B:77:0x0117, B:78:0x0104, B:79:0x00f1, B:81:0x0095, B:83:0x009d), top: B:2:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:72:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.internal.ads.zzasm zza(android.content.Context r57, com.google.android.gms.internal.ads.zzasi r58, java.lang.String r59) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatv.zza(android.content.Context, com.google.android.gms.internal.ads.zzasi, java.lang.String):com.google.android.gms.internal.ads.zzasm");
    }

    private static List<String> zza(JSONArray jSONArray, List<String> list) throws JSONException {
        if (jSONArray == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>();
        }
        for (int i = 0; i < jSONArray.length(); i++) {
            list.add(jSONArray.getString(i));
        }
        return list;
    }
}
