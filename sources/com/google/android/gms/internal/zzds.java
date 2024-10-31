package com.google.android.gms.internal;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import java.util.Map;
import java.util.WeakHashMap;
import org.json.JSONObject;

@zzgr
/* loaded from: classes.dex */
public final class zzds implements zzdk {
    private final Map<zziz, Integer> zzxX = new WeakHashMap();

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            return com.google.android.gms.ads.internal.client.zzl.a().a(context, Integer.parseInt(str2));
        } catch (NumberFormatException e) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse " + str + " in a video GMSG: " + str2);
            return i;
        }
    }

    @Override // com.google.android.gms.internal.zzdk
    public void zza(zziz zzizVar, Map<String, String> map) {
        int i;
        com.google.android.gms.ads.internal.overlay.zzk zzgX;
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Action missing from video GMSG.");
            return;
        }
        if (com.google.android.gms.ads.internal.util.client.zzb.a(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzb.a("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if ("background".equals(str)) {
            String str2 = map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                int parseColor = Color.parseColor(str2);
                zziy zzhl = zzizVar.zzhl();
                if (zzhl == null || (zzgX = zzhl.zzgX()) == null) {
                    this.zzxX.put(zzizVar, Integer.valueOf(parseColor));
                } else {
                    zzgX.setBackgroundColor(parseColor);
                }
                return;
            } catch (IllegalArgumentException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Invalid color parameter in video GMSG.");
                return;
            }
        }
        zziy zzhl2 = zzizVar.zzhl();
        if (zzhl2 == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (equals || equals2) {
            Context context = zzizVar.getContext();
            int zza = zza(context, map, "x", 0);
            int zza2 = zza(context, map, "y", 0);
            int zza3 = zza(context, map, "w", -1);
            int zza4 = zza(context, map, "h", -1);
            try {
                i = Integer.parseInt(map.get("player"));
            } catch (NumberFormatException e2) {
                i = 0;
            }
            if (!equals || zzhl2.zzgX() != null) {
                zzhl2.zze(zza, zza2, zza3, zza4);
                return;
            }
            zzhl2.zza(zza, zza2, zza3, zza4, i);
            if (this.zzxX.containsKey(zzizVar)) {
                int intValue = this.zzxX.get(zzizVar).intValue();
                com.google.android.gms.ads.internal.overlay.zzk zzgX2 = zzhl2.zzgX();
                zzgX2.setBackgroundColor(intValue);
                zzgX2.l();
                return;
            }
            return;
        }
        com.google.android.gms.ads.internal.overlay.zzk zzgX3 = zzhl2.zzgX();
        if (zzgX3 == null) {
            com.google.android.gms.ads.internal.overlay.zzk.a(zzizVar);
            return;
        }
        if ("click".equals(str)) {
            Context context2 = zzizVar.getContext();
            int zza5 = zza(context2, map, "x", 0);
            int zza6 = zza(context2, map, "y", 0);
            long uptimeMillis = SystemClock.uptimeMillis();
            MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza5, zza6, 0);
            zzgX3.a(obtain);
            obtain.recycle();
            return;
        }
        if ("currentTime".equals(str)) {
            String str3 = map.get("time");
            if (str3 == null) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzgX3.a((int) (Float.parseFloat(str3) * 1000.0f));
                return;
            } catch (NumberFormatException e3) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse time parameter from currentTime video GMSG: " + str3);
                return;
            }
        }
        if ("hide".equals(str)) {
            zzgX3.setVisibility(4);
            return;
        }
        if ("load".equals(str)) {
            zzgX3.g();
            return;
        }
        if ("mimetype".equals(str)) {
            zzgX3.setMimeType(map.get("mimetype"));
            return;
        }
        if ("muted".equals(str)) {
            if (Boolean.parseBoolean(map.get("muted"))) {
                zzgX3.j();
                return;
            } else {
                zzgX3.k();
                return;
            }
        }
        if ("pause".equals(str)) {
            zzgX3.h();
            return;
        }
        if ("play".equals(str)) {
            zzgX3.i();
            return;
        }
        if ("show".equals(str)) {
            zzgX3.setVisibility(0);
            return;
        }
        if ("src".equals(str)) {
            zzgX3.a(map.get("src"));
            return;
        }
        if (!"volume".equals(str)) {
            if ("watermark".equals(str)) {
                zzgX3.l();
                return;
            } else {
                com.google.android.gms.ads.internal.util.client.zzb.e("Unknown video action: " + str);
                return;
            }
        }
        String str4 = map.get("volume");
        if (str4 == null) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzgX3.a(Float.parseFloat(str4));
        } catch (NumberFormatException e4) {
            com.google.android.gms.ads.internal.util.client.zzb.e("Could not parse volume parameter from volume video GMSG: " + str4);
        }
    }
}
