package com.google.android.gms.ads.internal.gmsg;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.appevents.u;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.internal.ads.zzahu;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzawz;
import com.google.android.gms.internal.ads.zzbah;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbdz;
import com.google.android.gms.internal.ads.zzbff;
import com.google.android.gms.internal.ads.zzbfg;
import com.google.android.gms.internal.ads.zzbgg;
import com.google.android.gms.internal.ads.zzbhc;
import com.google.android.gms.internal.ads.zzbhk;
import com.google.android.gms.internal.ads.zzbhl;
import com.google.android.gms.internal.ads.zzbhm;
import com.google.android.gms.internal.ads.zzcu;
import com.google.android.gms.internal.ads.zzcv;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    public static final zzu<zzbgg> f10072a = a.f10047a;

    /* renamed from: b, reason: collision with root package name */
    public static final zzu<zzbgg> f10073b = b.f10048a;

    /* renamed from: c, reason: collision with root package name */
    public static final zzu<zzbgg> f10074c = c.f10049a;

    /* renamed from: d, reason: collision with root package name */
    public static final zzu<zzbgg> f10075d = new f();

    /* renamed from: e, reason: collision with root package name */
    public static final zzu<zzbgg> f10076e = new g();

    /* renamed from: f, reason: collision with root package name */
    public static final zzu<zzbgg> f10077f = d.f10050a;

    /* renamed from: g, reason: collision with root package name */
    public static final zzu<Object> f10078g = new h();

    /* renamed from: h, reason: collision with root package name */
    public static final zzu<zzbgg> f10079h = new i();
    public static final zzu<zzbgg> i = e.f10051a;
    public static final zzu<zzbgg> j = new j();
    public static final zzu<zzbgg> k = new k();
    public static final zzu<zzbdz> l = new zzbff();
    public static final zzu<zzbdz> m = new zzbfg();
    public static final zzu<zzbgg> n = new zze();
    public static final zzae o = new zzae();
    public static final zzu<zzbgg> p = new l();
    public static final zzu<zzbgg> q = new m();
    public static final zzu<zzbgg> r = new n();

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbhk zzbhkVar, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get("td");
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzcu zzado = zzbhkVar.zzado();
            if (zzado != null) {
                zzado.zzab().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzbbd.zzeo("Could not parse touch parameters from gmsg.");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void b(zzbhc zzbhcVar, Map map) {
        PackageManager packageManager = zzbhcVar.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get(ShareConstants.WEB_DIALOG_PARAM_DATA)).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i2);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString(u.f9225a);
                        String optString3 = jSONObject2.optString(com.umeng.commonsdk.proguard.e.aq);
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString("p");
                        String optString6 = jSONObject2.optString("c");
                        jSONObject2.optString("f");
                        jSONObject2.optString("e");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e2) {
                                String valueOf = String.valueOf(optString7);
                                zzbbd.zzb(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e2);
                            }
                        }
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split("/", 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        try {
                            jSONObject.put(optString, packageManager.resolveActivity(intent, 65536) != null);
                        } catch (JSONException e3) {
                            zzbbd.zzb("Error constructing openable urls response.", e3);
                        }
                    } catch (JSONException e4) {
                        zzbbd.zzb("Error parsing the intent data.", e4);
                    }
                }
                ((zzahu) zzbhcVar).zza("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzahu) zzbhcVar).zza("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzahu) zzbhcVar).zza("openableIntents", new JSONObject());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void c(zzbhc zzbhcVar, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzbbd.zzeo("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbhcVar.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzahu) zzbhcVar).zza("openableURLs", hashMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzbhc zzbhcVar, Map map) {
        String str = (String) map.get(u.f9225a);
        if (str == null) {
            zzbbd.zzeo("URL missing from httpTrack GMSG.");
        } else {
            new zzbah(zzbhcVar.getContext(), ((zzbhl) zzbhcVar).zzabz().zzdp, str).zzyz();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final /* synthetic */ void a(zzahu zzahuVar, Map map) {
        String str = (String) map.get(u.f9225a);
        if (str == null) {
            zzbbd.zzeo("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzcu zzado = ((zzbhk) zzahuVar).zzado();
            if (zzado != null && zzado.zzb(parse)) {
                parse = zzado.zza(parse, ((zzbhc) zzahuVar).getContext(), ((zzbhm) zzahuVar).getView(), ((zzbhc) zzahuVar).zzabw());
            }
        } catch (zzcv unused) {
            String valueOf = String.valueOf(str);
            zzbbd.zzeo(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbhc zzbhcVar = (zzbhc) zzahuVar;
        new zzbah(zzbhcVar.getContext(), ((zzbhl) zzahuVar).zzabz().zzdp, zzawz.zzb(parse, zzbhcVar.getContext())).zzyz();
    }
}
