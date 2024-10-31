package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.facebook.internal.NativeProtocol;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.nexstreaming.kinemaster.ui.settings.FragmentC2201x;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

@zzark
/* loaded from: classes2.dex */
public final class zzbff implements com.google.android.gms.ads.internal.gmsg.zzu<zzbdz> {
    private boolean zzewj;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzwu.zzpv();
            return zzbat.zza(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzbbd.zzeo(sb.toString());
            return i;
        }
    }

    private static void zza(zzbdk zzbdkVar, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        if (str != null) {
            try {
                zzbdkVar.zzcz(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzbbd.zzeo(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbdkVar.zzda(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbdkVar.zzdb(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbdkVar.zzdc(Integer.parseInt(str4));
        }
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbdz zzbdzVar, Map map) {
        int i;
        zzbdz zzbdzVar2 = zzbdzVar;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if (str == null) {
            zzbbd.zzeo("Action missing from video GMSG.");
            return;
        }
        if (zzbbd.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzbbd.zzdn(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                zzbbd.zzeo("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdzVar2.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                zzbbd.zzeo("Invalid color parameter in video GMSG.");
                return;
            }
        }
        if ("decoderProps".equals(str)) {
            String str3 = (String) map.get("mimeTypes");
            if (str3 == null) {
                zzbbd.zzeo("No MIME types specified for decoder properties inspection.");
                zzbdk.zza(zzbdzVar2, "missingMimeTypes");
                return;
            }
            if (Build.VERSION.SDK_INT < 16) {
                zzbbd.zzeo("Video decoder properties available on API versions >= 16.");
                zzbdk.zza(zzbdzVar2, "deficientApiVersion");
                return;
            }
            HashMap hashMap = new HashMap();
            for (String str4 : str3.split(",")) {
                hashMap.put(str4, zzbar.zzeh(str4.trim()));
            }
            zzbdk.zza(zzbdzVar2, hashMap);
            return;
        }
        zzbdq zzabt = zzbdzVar2.zzabt();
        if (zzabt == null) {
            zzbbd.zzeo("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean equals = "new".equals(str);
        boolean equals2 = "position".equals(str);
        if (!equals && !equals2) {
            zzbgw zzabu = zzbdzVar2.zzabu();
            if (zzabu != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzbbd.zzeo("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    } else {
                        try {
                            zzabu.zze(Float.parseFloat(str5));
                        } catch (NumberFormatException unused2) {
                            String valueOf = String.valueOf(str5);
                            zzbbd.zzeo(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        }
                    }
                } else if ("skip".equals(str)) {
                    zzabu.zzaew();
                }
            }
            zzbdk zzabp = zzabt.zzabp();
            if (zzabp == null) {
                zzbdk.zzb(zzbdzVar2);
                return;
            }
            if ("click".equals(str)) {
                Context context = zzbdzVar2.getContext();
                int zza = zza(context, map, FragmentC2201x.f23219a, 0);
                int zza2 = zza(context, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, zza, zza2, 0);
                zzabp.zzf(obtain);
                obtain.recycle();
                return;
            }
            if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzbbd.zzeo("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzabp.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                    return;
                } catch (NumberFormatException unused3) {
                    String valueOf2 = String.valueOf(str6);
                    zzbbd.zzeo(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                    return;
                }
            }
            if (MessengerShareContentUtility.SHARE_BUTTON_HIDE.equals(str)) {
                zzabp.setVisibility(4);
                return;
            }
            if ("load".equals(str)) {
                zzabp.zzff();
                return;
            }
            if ("loadControl".equals(str)) {
                zza(zzabp, (Map<String, String>) map);
                return;
            }
            if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzabp.zzabj();
                    return;
                } else {
                    zzabp.zzabk();
                    return;
                }
            }
            if ("pause".equals(str)) {
                zzabp.pause();
                return;
            }
            if ("play".equals(str)) {
                zzabp.play();
                return;
            }
            if ("show".equals(str)) {
                zzabp.setVisibility(0);
                return;
            }
            if ("src".equals(str)) {
                zzabp.zzer((String) map.get("src"));
                return;
            }
            if ("touchMove".equals(str)) {
                Context context2 = zzbdzVar2.getContext();
                zzabp.zza(zza(context2, map, "dx", 0), zza(context2, map, "dy", 0));
                if (this.zzewj) {
                    return;
                }
                zzbdzVar2.zzvw();
                this.zzewj = true;
                return;
            }
            if ("volume".equals(str)) {
                String str7 = (String) map.get("volume");
                if (str7 == null) {
                    zzbbd.zzeo("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzabp.setVolume(Float.parseFloat(str7));
                    return;
                } catch (NumberFormatException unused4) {
                    String valueOf3 = String.valueOf(str7);
                    zzbbd.zzeo(valueOf3.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf3) : new String("Could not parse volume parameter from volume video GMSG: "));
                    return;
                }
            }
            if ("watermark".equals(str)) {
                zzabp.zzabl();
                return;
            } else {
                String valueOf4 = String.valueOf(str);
                zzbbd.zzeo(valueOf4.length() != 0 ? "Unknown video action: ".concat(valueOf4) : new String("Unknown video action: "));
                return;
            }
        }
        Context context3 = zzbdzVar2.getContext();
        int zza3 = zza(context3, map, FragmentC2201x.f23219a, 0);
        int zza4 = zza(context3, map, "y", 0);
        int zza5 = zza(context3, map, "w", -1);
        int zza6 = zza(context3, map, "h", -1);
        int min = Math.min(zza5, zzbdzVar2.zzacb() - zza3);
        int min2 = Math.min(zza6, zzbdzVar2.zzaca() - zza4);
        try {
            i = Integer.parseInt((String) map.get("player"));
        } catch (NumberFormatException unused5) {
            i = 0;
        }
        boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
        if (equals && zzabt.zzabp() == null) {
            zzabt.zza(zza3, zza4, min, min2, i, parseBoolean, new zzbdy((String) map.get("flags")));
            zzbdk zzabp2 = zzabt.zzabp();
            if (zzabp2 != null) {
                zza(zzabp2, (Map<String, String>) map);
                return;
            }
            return;
        }
        zzabt.zze(zza3, zza4, min, min2);
    }
}
