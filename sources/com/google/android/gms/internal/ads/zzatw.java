package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzatw {
    private zzaso zzbmy;
    private String zzday;
    private final zzasi zzdnh;
    private List<String> zzdth;
    private String zzdtk;
    private String zzebb;
    private String zzebc;
    private List<String> zzebd;
    private String zzebe;
    private String zzebf;
    private String zzebg;
    private List<String> zzebh;
    private List<String> zzebi;
    private zzawd zzebu;
    private List<String> zzebv;
    private List<String> zzebw;
    private String zzebz;
    private List<String> zzeca;
    private boolean zzecb;
    private String zzecc;
    private zzawo zzecd;
    private boolean zzece;
    private boolean zzecf;
    private boolean zzecg;
    private boolean zzech;
    private long zzebj = -1;
    private boolean zzebk = false;
    private final long zzebl = -1;
    private long zzebm = -1;
    private int mOrientation = -1;
    private boolean zzebn = false;
    private boolean zzebo = false;
    private boolean zzebp = false;
    private boolean zzebq = true;
    private boolean zzebr = true;
    private String zzebs = "";
    private boolean zzebt = false;
    private boolean zzdms = false;
    private boolean zzebx = false;
    private boolean zzeby = false;

    public zzatw(zzasi zzasiVar, String str) {
        this.zzebc = str;
        this.zzdnh = zzasiVar;
    }

    private static String zza(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static long zzb(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return -1L;
        }
        String str2 = list.get(0);
        try {
            return Float.parseFloat(str2) * 1000.0f;
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 36 + String.valueOf(str2).length());
            sb.append("Could not parse float from ");
            sb.append(str);
            sb.append(" header: ");
            sb.append(str2);
            zzbbd.zzeo(sb.toString());
            return -1L;
        }
    }

    private static List<String> zzc(Map<String, List<String>> map, String str) {
        String str2;
        List<String> list = map.get(str);
        if (list == null || list.isEmpty() || (str2 = list.get(0)) == null) {
            return null;
        }
        return Arrays.asList(str2.trim().split("\\s+"));
    }

    private static boolean zzd(Map<String, List<String>> map, String str) {
        List<String> list = map.get(str);
        if (list == null || list.isEmpty()) {
            return false;
        }
        return Boolean.valueOf(list.get(0)).booleanValue();
    }

    public final void zzl(Map<String, List<String>> map) {
        this.zzebb = zza(map, "X-Afma-Ad-Size");
        this.zzecc = zza(map, "X-Afma-Ad-Slot-Size");
        List<String> zzc = zzc(map, "X-Afma-Click-Tracking-Urls");
        if (zzc != null) {
            this.zzebd = zzc;
        }
        this.zzebe = zza(map, "X-Afma-Debug-Signals");
        List<String> list = map.get("X-Afma-Debug-Dialog");
        if (list != null && !list.isEmpty()) {
            this.zzebf = list.get(0);
        }
        List<String> zzc2 = zzc(map, "X-Afma-Tracking-Urls");
        if (zzc2 != null) {
            this.zzebh = zzc2;
        }
        List<String> zzc3 = zzc(map, "X-Afma-Downloaded-Impression-Urls");
        if (zzc3 != null) {
            this.zzebi = zzc3;
        }
        long zzb = zzb(map, "X-Afma-Interstitial-Timeout");
        if (zzb != -1) {
            this.zzebj = zzb;
        }
        this.zzebk |= zzd(map, "X-Afma-Mediation");
        List<String> zzc4 = zzc(map, "X-Afma-Manual-Tracking-Urls");
        if (zzc4 != null) {
            this.zzdth = zzc4;
        }
        long zzb2 = zzb(map, "X-Afma-Refresh-Rate");
        if (zzb2 != -1) {
            this.zzebm = zzb2;
        }
        List<String> list2 = map.get("X-Afma-Orientation");
        if (list2 != null && !list2.isEmpty()) {
            String str = list2.get(0);
            if ("portrait".equalsIgnoreCase(str)) {
                this.mOrientation = com.google.android.gms.ads.internal.zzbv.g().zzzx();
            } else if ("landscape".equalsIgnoreCase(str)) {
                this.mOrientation = com.google.android.gms.ads.internal.zzbv.g().zzzw();
            }
        }
        this.zzebg = zza(map, "X-Afma-ActiveView");
        List<String> list3 = map.get("X-Afma-Use-HTTPS");
        if (list3 != null && !list3.isEmpty()) {
            this.zzebp = Boolean.valueOf(list3.get(0)).booleanValue();
        }
        this.zzebn |= zzd(map, "X-Afma-Custom-Rendering-Allowed");
        this.zzebo = AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_NATIVE.equals(zza(map, "X-Afma-Ad-Format"));
        List<String> list4 = map.get("X-Afma-Content-Url-Opted-Out");
        if (list4 != null && !list4.isEmpty()) {
            this.zzebq = Boolean.valueOf(list4.get(0)).booleanValue();
        }
        List<String> list5 = map.get("X-Afma-Content-Vertical-Opted-Out");
        if (list5 != null && !list5.isEmpty()) {
            this.zzebr = Boolean.valueOf(list5.get(0)).booleanValue();
        }
        List<String> list6 = map.get("X-Afma-Gws-Query-Id");
        if (list6 != null && !list6.isEmpty()) {
            this.zzebs = list6.get(0);
        }
        String zza = zza(map, "X-Afma-Fluid");
        if (zza != null && zza.equals("height")) {
            this.zzebt = true;
        }
        this.zzdms = "native_express".equals(zza(map, "X-Afma-Ad-Format"));
        this.zzebu = zzawd.zzdh(zza(map, "X-Afma-Rewards"));
        if (this.zzebv == null) {
            this.zzebv = zzc(map, "X-Afma-Reward-Video-Start-Urls");
        }
        if (this.zzebw == null) {
            this.zzebw = zzc(map, "X-Afma-Reward-Video-Complete-Urls");
        }
        this.zzebx |= zzd(map, "X-Afma-Use-Displayed-Impression");
        this.zzeby |= zzd(map, "X-Afma-Auto-Collect-Location");
        this.zzebz = zza(map, "Set-Cookie");
        String zza2 = zza(map, "X-Afma-Auto-Protection-Configuration");
        if (zza2 != null && !TextUtils.isEmpty(zza2)) {
            try {
                this.zzbmy = zzaso.zzl(new JSONObject(zza2));
            } catch (JSONException e2) {
                zzbbd.zzc("Error parsing configuration JSON", e2);
                this.zzbmy = new zzaso();
            }
        } else {
            Uri.Builder buildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204").buildUpon();
            buildUpon.appendQueryParameter("id", "gmob-apps-blocked-navigation");
            if (!TextUtils.isEmpty(this.zzebf)) {
                buildUpon.appendQueryParameter("debugDialog", this.zzebf);
            }
            String builder = buildUpon.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(builder).length() + 31);
            sb.append(builder);
            sb.append("&navigationURL={NAVIGATION_URL}");
            this.zzbmy = new zzaso(true, Arrays.asList(sb.toString()));
        }
        List<String> zzc5 = zzc(map, "X-Afma-Remote-Ping-Urls");
        if (zzc5 != null) {
            this.zzeca = zzc5;
        }
        String zza3 = zza(map, "X-Afma-Safe-Browsing");
        if (!TextUtils.isEmpty(zza3)) {
            try {
                this.zzecd = zzawo.zzo(new JSONObject(zza3));
            } catch (JSONException e3) {
                zzbbd.zzc("Error parsing safe browsing header", e3);
            }
        }
        this.zzecb |= zzd(map, "X-Afma-Render-In-Browser");
        String zza4 = zza(map, "X-Afma-Pool");
        if (!TextUtils.isEmpty(zza4)) {
            try {
                this.zzece = new JSONObject(zza4).getBoolean("never_pool");
            } catch (JSONException e4) {
                zzbbd.zzc("Error parsing interstitial pool header", e4);
            }
        }
        this.zzecf = zzd(map, "X-Afma-Custom-Close-Blocked");
        this.zzecg = zzd(map, "X-Afma-Enable-Omid");
        this.zzech = zzd(map, "X-Afma-Disable-Closable-Area");
        this.zzdtk = zza(map, "X-Afma-Omid-Settings");
    }

    public final zzasm zza(long j, zzaty zzatyVar) {
        String str;
        int i;
        zzasi zzasiVar = this.zzdnh;
        String str2 = this.zzebc;
        String str3 = this.zzday;
        List<String> list = this.zzebd;
        List<String> list2 = this.zzebh;
        long j2 = this.zzebj;
        boolean z = this.zzebk;
        List<String> list3 = this.zzdth;
        long j3 = this.zzebm;
        int i2 = this.mOrientation;
        String str4 = this.zzebb;
        String str5 = this.zzebf;
        String str6 = this.zzebg;
        boolean z2 = this.zzebn;
        boolean z3 = this.zzebo;
        boolean z4 = this.zzebp;
        boolean z5 = this.zzebq;
        String str7 = this.zzebs;
        boolean z6 = this.zzebt;
        boolean z7 = this.zzdms;
        zzawd zzawdVar = this.zzebu;
        List<String> list4 = this.zzebv;
        List<String> list5 = this.zzebw;
        boolean z8 = this.zzebx;
        zzaso zzasoVar = this.zzbmy;
        boolean z9 = this.zzeby;
        String str8 = this.zzebz;
        List<String> list6 = this.zzeca;
        boolean z10 = this.zzecb;
        String str9 = this.zzecc;
        zzawo zzawoVar = this.zzecd;
        String str10 = this.zzebe;
        boolean z11 = this.zzebr;
        boolean z12 = this.zzece;
        boolean z13 = this.zzecf;
        if (zzatyVar.zzwu()) {
            str = str4;
            i = 2;
        } else {
            str = str4;
            i = 1;
        }
        return new zzasm(zzasiVar, str2, str3, list, list2, j2, z, -1L, list3, j3, i2, str, j, str5, str6, z2, z3, z4, z5, false, str7, z6, z7, zzawdVar, list4, list5, z8, zzasoVar, z9, str8, list6, z10, str9, zzawoVar, str10, z11, z12, z13, i, this.zzecg, this.zzebi, this.zzech, this.zzdtk, zzatyVar.zzwv(), zzatyVar.zzww());
    }

    public final void zza(String str, Map<String, List<String>> map, String str2) {
        this.zzday = str2;
        zzl(map);
    }
}
