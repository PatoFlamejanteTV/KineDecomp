package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.client.AdRequestParcel;
import com.google.android.gms.ads.internal.client.AdSizeParcel;
import com.google.android.gms.ads.internal.client.SearchAdRequestParcel;
import com.google.android.gms.ads.internal.formats.NativeAdOptionsParcel;
import com.google.android.gms.ads.internal.request.AdRequestInfoParcel;
import com.google.android.gms.appdatasearch.DocumentContents;
import com.google.android.gms.appdatasearch.DocumentSection;
import com.google.android.gms.appdatasearch.UsageInfo;
import com.google.android.gms.appindexing.AndroidAppUri;
import com.google.android.gms.internal.zzhb;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzgu {
    private static final SimpleDateFormat zzFN = new SimpleDateFormat("yyyyMMdd", Locale.US);

    private static String zzI(int i) {
        return String.format(Locale.US, "#%06x", Integer.valueOf(16777215 & i));
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x01d5 A[Catch: JSONException -> 0x012f, TryCatch #0 {JSONException -> 0x012f, blocks: (B:2:0x0000, B:4:0x0026, B:8:0x0030, B:9:0x0039, B:11:0x004e, B:12:0x005f, B:14:0x0072, B:15:0x007a, B:17:0x0081, B:19:0x0087, B:23:0x00d6, B:28:0x00e5, B:30:0x00eb, B:32:0x00f1, B:35:0x0159, B:40:0x0168, B:42:0x016e, B:44:0x0174, B:47:0x0182, B:52:0x0191, B:54:0x0197, B:56:0x019d, B:60:0x01ad, B:62:0x01b2, B:63:0x01b6, B:65:0x01be, B:66:0x01c0, B:68:0x01d5, B:69:0x01de, B:73:0x01a7, B:75:0x017e, B:77:0x0155, B:78:0x00b4, B:80:0x00ba, B:81:0x00fb, B:84:0x010a, B:87:0x00a3, B:89:0x00ab, B:91:0x0096), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.android.gms.ads.internal.request.AdResponseParcel zza(android.content.Context r34, com.google.android.gms.ads.internal.request.AdRequestInfoParcel r35, java.lang.String r36) {
        /*
            Method dump skipped, instructions count: 607
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgu.zza(android.content.Context, com.google.android.gms.ads.internal.request.AdRequestInfoParcel, java.lang.String):com.google.android.gms.ads.internal.request.AdResponseParcel");
    }

    public static JSONObject zza(Context context, AdRequestInfoParcel adRequestInfoParcel, zzgy zzgyVar, zzhb.zza zzaVar, Location location, zzbr zzbrVar, String str, String str2, List<String> list) {
        try {
            HashMap hashMap = new HashMap();
            if (list.size() > 0) {
                hashMap.put("eid", TextUtils.join(",", list));
            }
            if (adRequestInfoParcel.b != null) {
                hashMap.put("ad_pos", adRequestInfoParcel.b);
            }
            zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.c);
            hashMap.put("format", adRequestInfoParcel.d.b);
            if (adRequestInfoParcel.d.f == -1) {
                hashMap.put("smart_w", "full");
            }
            if (adRequestInfoParcel.d.c == -2) {
                hashMap.put("smart_h", "auto");
            }
            if (adRequestInfoParcel.d.j) {
                hashMap.put("fluid", "height");
            }
            if (adRequestInfoParcel.d.h != null) {
                StringBuilder sb = new StringBuilder();
                for (AdSizeParcel adSizeParcel : adRequestInfoParcel.d.h) {
                    if (sb.length() != 0) {
                        sb.append("|");
                    }
                    sb.append(adSizeParcel.f == -1 ? (int) (adSizeParcel.g / zzgyVar.zzEz) : adSizeParcel.f);
                    sb.append("x");
                    sb.append(adSizeParcel.c == -2 ? (int) (adSizeParcel.d / zzgyVar.zzEz) : adSizeParcel.c);
                }
                hashMap.put("sz", sb);
            }
            if (adRequestInfoParcel.m != 0) {
                hashMap.put("native_version", Integer.valueOf(adRequestInfoParcel.m));
                hashMap.put("native_templates", adRequestInfoParcel.n);
                hashMap.put("native_image_orientation", zzc(adRequestInfoParcel.z));
                if (!adRequestInfoParcel.A.isEmpty()) {
                    hashMap.put("native_custom_templates", adRequestInfoParcel.A);
                }
            }
            hashMap.put("slotname", adRequestInfoParcel.e);
            hashMap.put("pn", adRequestInfoParcel.f.packageName);
            if (adRequestInfoParcel.g != null) {
                hashMap.put("vc", Integer.valueOf(adRequestInfoParcel.g.versionCode));
            }
            hashMap.put("ms", str2);
            hashMap.put("seq_num", adRequestInfoParcel.i);
            hashMap.put("session_id", adRequestInfoParcel.j);
            hashMap.put("js", adRequestInfoParcel.k.b);
            zza((HashMap<String, Object>) hashMap, zzgyVar, zzaVar);
            hashMap.put("fdz", Integer.valueOf(zzbrVar.zzdd()));
            hashMap.put("platform", Build.MANUFACTURER);
            hashMap.put("submodel", Build.MODEL);
            if (adRequestInfoParcel.c.f533a >= 2 && adRequestInfoParcel.c.k != null) {
                zza((HashMap<String, Object>) hashMap, adRequestInfoParcel.c.k);
            }
            if (adRequestInfoParcel.f620a >= 2) {
                hashMap.put("quality_signals", adRequestInfoParcel.l);
            }
            if (adRequestInfoParcel.f620a >= 4 && adRequestInfoParcel.p) {
                hashMap.put("forceHttps", Boolean.valueOf(adRequestInfoParcel.p));
            }
            Bundle bundle = (adRequestInfoParcel.f620a < 4 || adRequestInfoParcel.o == null) ? new Bundle() : adRequestInfoParcel.o;
            zza(context, adRequestInfoParcel, bundle);
            hashMap.put("content_info", bundle);
            if (adRequestInfoParcel.f620a >= 5) {
                hashMap.put("u_sd", Float.valueOf(adRequestInfoParcel.t));
                hashMap.put("sh", Integer.valueOf(adRequestInfoParcel.s));
                hashMap.put("sw", Integer.valueOf(adRequestInfoParcel.r));
            } else {
                hashMap.put("u_sd", Float.valueOf(zzgyVar.zzEz));
                hashMap.put("sh", Integer.valueOf(zzgyVar.zzEy));
                hashMap.put("sw", Integer.valueOf(zzgyVar.zzEx));
            }
            if (adRequestInfoParcel.f620a >= 6) {
                if (!TextUtils.isEmpty(adRequestInfoParcel.u)) {
                    try {
                        hashMap.put("view_hierarchy", new JSONObject(adRequestInfoParcel.u));
                    } catch (JSONException e) {
                        com.google.android.gms.ads.internal.util.client.zzb.d("Problem serializing view hierarchy to JSON", e);
                    }
                }
                hashMap.put("correlation_id", Long.valueOf(adRequestInfoParcel.v));
            }
            if (adRequestInfoParcel.f620a >= 7) {
                hashMap.put("request_id", adRequestInfoParcel.w);
            }
            if (adRequestInfoParcel.f620a >= 11 && adRequestInfoParcel.C != null) {
                hashMap.put("capability", adRequestInfoParcel.C.a());
            }
            zza((HashMap<String, Object>) hashMap, str);
            if (adRequestInfoParcel.f620a >= 12 && !TextUtils.isEmpty(adRequestInfoParcel.D)) {
                hashMap.put("anchor", adRequestInfoParcel.D);
            }
            if (com.google.android.gms.ads.internal.util.client.zzb.a(2)) {
                com.google.android.gms.ads.internal.util.client.zzb.d("Ad Request JSON: " + com.google.android.gms.ads.internal.zzp.e().zzz(hashMap).toString(2));
            }
            return com.google.android.gms.ads.internal.zzp.e().zzz(hashMap);
        } catch (JSONException e2) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Problem serializing ad request to JSON: " + e2.getMessage());
            return null;
        }
    }

    static void zza(Context context, AdRequestInfoParcel adRequestInfoParcel, Bundle bundle) {
        if (!zzby.zzuZ.get().booleanValue()) {
            com.google.android.gms.ads.internal.util.client.zzb.c("App index is not enabled");
            return;
        }
        if (!zzmm.zzjA()) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Not on service, return");
            return;
        }
        if (com.google.android.gms.ads.internal.client.zzl.a().b()) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Cannot invoked on UI thread");
            return;
        }
        if (adRequestInfoParcel == null || adRequestInfoParcel.g == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Invalid ad request info");
            return;
        }
        String str = adRequestInfoParcel.g.packageName;
        if (TextUtils.isEmpty(str)) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Fail to get package name");
            return;
        }
        try {
            zza(zzd(context, str), str, bundle);
        } catch (RuntimeException e) {
            com.google.android.gms.ads.internal.util.client.zzb.c("Fail to add app index to content info");
        }
    }

    static void zza(UsageInfo usageInfo, String str, Bundle bundle) {
        if (usageInfo == null || usageInfo.a() == null) {
            return;
        }
        DocumentContents a2 = usageInfo.a();
        String a3 = a2.a();
        if (!TextUtils.isEmpty(a3)) {
            bundle.putString("web_url", a3);
        }
        try {
            DocumentSection a4 = a2.a("intent_data");
            if (a4 == null || TextUtils.isEmpty(a4.c)) {
                return;
            }
            bundle.putString("app_uri", AndroidAppUri.a(str, Uri.parse(a4.c)).toString());
        } catch (IllegalArgumentException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Failed to parse the third-party Android App URI");
        }
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

    private static void zza(HashMap<String, Object> hashMap, AdRequestParcel adRequestParcel) {
        String zzgy = zzhy.zzgy();
        if (zzgy != null) {
            hashMap.put("abf", zzgy);
        }
        if (adRequestParcel.b != -1) {
            hashMap.put("cust_age", zzFN.format(new Date(adRequestParcel.b)));
        }
        if (adRequestParcel.c != null) {
            hashMap.put("extras", adRequestParcel.c);
        }
        if (adRequestParcel.d != -1) {
            hashMap.put("cust_gender", Integer.valueOf(adRequestParcel.d));
        }
        if (adRequestParcel.e != null) {
            hashMap.put("kw", adRequestParcel.e);
        }
        if (adRequestParcel.g != -1) {
            hashMap.put("tag_for_child_directed_treatment", Integer.valueOf(adRequestParcel.g));
        }
        if (adRequestParcel.f) {
            hashMap.put("adtest", "on");
        }
        if (adRequestParcel.f533a >= 2) {
            if (adRequestParcel.h) {
                hashMap.put("d_imp_hdr", 1);
            }
            if (!TextUtils.isEmpty(adRequestParcel.i)) {
                hashMap.put("ppid", adRequestParcel.i);
            }
            if (adRequestParcel.j != null) {
                zza(hashMap, adRequestParcel.j);
            }
        }
        if (adRequestParcel.f533a >= 3 && adRequestParcel.l != null) {
            hashMap.put("url", adRequestParcel.l);
        }
        if (adRequestParcel.f533a >= 5) {
            if (adRequestParcel.n != null) {
                hashMap.put("custom_targeting", adRequestParcel.n);
            }
            if (adRequestParcel.o != null) {
                hashMap.put("category_exclusions", adRequestParcel.o);
            }
            if (adRequestParcel.p != null) {
                hashMap.put("request_agent", adRequestParcel.p);
            }
        }
        if (adRequestParcel.f533a < 6 || adRequestParcel.q == null) {
            return;
        }
        hashMap.put("request_pkg", adRequestParcel.q);
    }

    private static void zza(HashMap<String, Object> hashMap, SearchAdRequestParcel searchAdRequestParcel) {
        String str;
        String str2 = null;
        if (Color.alpha(searchAdRequestParcel.b) != 0) {
            hashMap.put("acolor", zzI(searchAdRequestParcel.b));
        }
        if (Color.alpha(searchAdRequestParcel.c) != 0) {
            hashMap.put("bgcolor", zzI(searchAdRequestParcel.c));
        }
        if (Color.alpha(searchAdRequestParcel.d) != 0 && Color.alpha(searchAdRequestParcel.e) != 0) {
            hashMap.put("gradientto", zzI(searchAdRequestParcel.d));
            hashMap.put("gradientfrom", zzI(searchAdRequestParcel.e));
        }
        if (Color.alpha(searchAdRequestParcel.f) != 0) {
            hashMap.put("bcolor", zzI(searchAdRequestParcel.f));
        }
        hashMap.put("bthick", Integer.toString(searchAdRequestParcel.g));
        switch (searchAdRequestParcel.h) {
            case 0:
                str = "none";
                break;
            case 1:
                str = "dashed";
                break;
            case 2:
                str = "dotted";
                break;
            case 3:
                str = "solid";
                break;
            default:
                str = null;
                break;
        }
        if (str != null) {
            hashMap.put("btype", str);
        }
        switch (searchAdRequestParcel.i) {
            case 0:
                str2 = "light";
                break;
            case 1:
                str2 = "medium";
                break;
            case 2:
                str2 = "dark";
                break;
        }
        if (str2 != null) {
            hashMap.put("callbuttoncolor", str2);
        }
        if (searchAdRequestParcel.j != null) {
            hashMap.put("channel", searchAdRequestParcel.j);
        }
        if (Color.alpha(searchAdRequestParcel.k) != 0) {
            hashMap.put("dcolor", zzI(searchAdRequestParcel.k));
        }
        if (searchAdRequestParcel.l != null) {
            hashMap.put("font", searchAdRequestParcel.l);
        }
        if (Color.alpha(searchAdRequestParcel.m) != 0) {
            hashMap.put("hcolor", zzI(searchAdRequestParcel.m));
        }
        hashMap.put("headersize", Integer.toString(searchAdRequestParcel.n));
        if (searchAdRequestParcel.o != null) {
            hashMap.put("q", searchAdRequestParcel.o);
        }
    }

    private static void zza(HashMap<String, Object> hashMap, zzgy zzgyVar, zzhb.zza zzaVar) {
        hashMap.put("am", Integer.valueOf(zzgyVar.zzGs));
        hashMap.put("cog", zzx(zzgyVar.zzGt));
        hashMap.put("coh", zzx(zzgyVar.zzGu));
        if (!TextUtils.isEmpty(zzgyVar.zzGv)) {
            hashMap.put("carrier", zzgyVar.zzGv);
        }
        hashMap.put("gl", zzgyVar.zzGw);
        if (zzgyVar.zzGx) {
            hashMap.put("simulator", 1);
        }
        if (zzgyVar.zzGy) {
            hashMap.put("is_sidewinder", 1);
        }
        hashMap.put("ma", zzx(zzgyVar.zzGz));
        hashMap.put("sp", zzx(zzgyVar.zzGA));
        hashMap.put("hl", zzgyVar.zzGB);
        if (!TextUtils.isEmpty(zzgyVar.zzGC)) {
            hashMap.put("mv", zzgyVar.zzGC);
        }
        hashMap.put("muv", Integer.valueOf(zzgyVar.zzGD));
        if (zzgyVar.zzGE != -2) {
            hashMap.put("cnt", Integer.valueOf(zzgyVar.zzGE));
        }
        hashMap.put("gnt", Integer.valueOf(zzgyVar.zzGF));
        hashMap.put("pt", Integer.valueOf(zzgyVar.zzGG));
        hashMap.put("rm", Integer.valueOf(zzgyVar.zzGH));
        hashMap.put("riv", Integer.valueOf(zzgyVar.zzGI));
        Bundle bundle = new Bundle();
        bundle.putString("build", zzgyVar.zzGN);
        Bundle bundle2 = new Bundle();
        bundle2.putBoolean("is_charging", zzgyVar.zzGK);
        bundle2.putDouble("battery_level", zzgyVar.zzGJ);
        bundle.putBundle("battery", bundle2);
        Bundle bundle3 = new Bundle();
        bundle3.putInt("active_network_state", zzgyVar.zzGM);
        bundle3.putBoolean("active_network_metered", zzgyVar.zzGL);
        if (zzaVar != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("predicted_latency_micros", zzaVar.zzGS);
            bundle4.putLong("predicted_down_throughput_bps", zzaVar.zzGT);
            bundle4.putLong("predicted_up_throughput_bps", zzaVar.zzGU);
            bundle3.putBundle("predictions", bundle4);
        }
        bundle.putBundle("network", bundle3);
        hashMap.put("device", bundle);
    }

    private static void zza(HashMap<String, Object> hashMap, String str) {
        if (str != null) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("token", str);
            hashMap.put("pan", hashMap2);
        }
    }

    private static String zzc(NativeAdOptionsParcel nativeAdOptionsParcel) {
        switch (nativeAdOptionsParcel != null ? nativeAdOptionsParcel.c : 0) {
            case 1:
                return "portrait";
            case 2:
                return "landscape";
            default:
                return "any";
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.google.android.gms.appdatasearch.UsageInfo zzd(android.content.Context r6, java.lang.String r7) {
        /*
            r1 = 0
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = new com.google.android.gms.common.api.GoogleApiClient$Builder     // Catch: java.lang.SecurityException -> L73 java.lang.Throwable -> L81
            r0.<init>(r6)     // Catch: java.lang.SecurityException -> L73 java.lang.Throwable -> L81
            com.google.android.gms.common.api.Api<com.google.android.gms.common.api.Api$ApiOptions$NoOptions> r2 = com.google.android.gms.appdatasearch.zza.b     // Catch: java.lang.SecurityException -> L73 java.lang.Throwable -> L81
            com.google.android.gms.common.api.GoogleApiClient$Builder r0 = r0.a(r2)     // Catch: java.lang.SecurityException -> L73 java.lang.Throwable -> L81
            com.google.android.gms.common.api.GoogleApiClient r2 = r0.b()     // Catch: java.lang.SecurityException -> L73 java.lang.Throwable -> L81
            r2.connect()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = new com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            r0.<init>()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            r3 = 1
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = r0.a(r3)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request$zza r0 = r0.a(r7)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.GetRecentContextCall$Request r0 = r0.a()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.zzk r3 = com.google.android.gms.appdatasearch.zza.c     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.common.api.PendingResult r0 = r3.zza(r2, r0)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            r4 = 1
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.SECONDS     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.common.api.Result r0 = r0.await(r4, r3)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.GetRecentContextCall$Response r0 = (com.google.android.gms.appdatasearch.GetRecentContextCall.Response) r0     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r0 == 0) goto L41
            com.google.android.gms.common.api.Status r3 = r0.getStatus()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            boolean r3 = r3.d()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r3 != 0) goto L4c
        L41:
            java.lang.String r0 = "Fail to obtain recent context call"
            com.google.android.gms.ads.internal.util.client.zzb.c(r0)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r2 == 0) goto L4b
            r2.disconnect()
        L4b:
            return r1
        L4c:
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r3 = r0.b     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r3 == 0) goto L58
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r3 = r0.b     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            boolean r3 = r3.isEmpty()     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r3 == 0) goto L63
        L58:
            java.lang.String r0 = "Fail to obtain recent context"
            com.google.android.gms.ads.internal.util.client.zzb.c(r0)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r2 == 0) goto L4b
            r2.disconnect()
            goto L4b
        L63:
            java.util.List<com.google.android.gms.appdatasearch.UsageInfo> r0 = r0.b     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            com.google.android.gms.appdatasearch.UsageInfo r0 = (com.google.android.gms.appdatasearch.UsageInfo) r0     // Catch: java.lang.Throwable -> L89 java.lang.SecurityException -> L8f
            if (r2 == 0) goto L71
            r2.disconnect()
        L71:
            r1 = r0
            goto L4b
        L73:
            r0 = move-exception
            r0 = r1
        L75:
            java.lang.String r2 = "Fail to get recent context"
            com.google.android.gms.ads.internal.util.client.zzb.e(r2)     // Catch: java.lang.Throwable -> L8b
            if (r0 == 0) goto L92
            r0.disconnect()
            r0 = r1
            goto L71
        L81:
            r0 = move-exception
            r2 = r1
        L83:
            if (r2 == 0) goto L88
            r2.disconnect()
        L88:
            throw r0
        L89:
            r0 = move-exception
            goto L83
        L8b:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L83
        L8f:
            r0 = move-exception
            r0 = r2
            goto L75
        L92:
            r0 = r1
            goto L71
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzgu.zzd(android.content.Context, java.lang.String):com.google.android.gms.appdatasearch.UsageInfo");
    }

    private static Integer zzx(boolean z) {
        return Integer.valueOf(z ? 1 : 0);
    }
}
