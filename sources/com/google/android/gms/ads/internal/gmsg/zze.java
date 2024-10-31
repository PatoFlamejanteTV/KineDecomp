package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzaba;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zze implements zzu<zzbgg> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzbbd.zzeo("No label given for CSI tick.");
                return;
            }
            if (TextUtils.isEmpty(str4)) {
                zzbbd.zzeo("No timestamp given for CSI tick.");
                return;
            }
            try {
                long c2 = zzbv.l().c() + (Long.parseLong(str4) - zzbv.l().a());
                if (TextUtils.isEmpty(str3)) {
                    str3 = "native:view_load";
                }
                zzbggVar2.zzaby().zzb(str2, str3, c2);
                return;
            } catch (NumberFormatException e2) {
                zzbbd.zzc("Malformed timestamp for CSI tick.", e2);
                return;
            }
        }
        if ("experiment".equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzbbd.zzeo("No value given for CSI experiment.");
                return;
            }
            zzaba zzrf = zzbggVar2.zzaby().zzrf();
            if (zzrf == null) {
                zzbbd.zzeo("No ticker for WebView, dropping experiment ID.");
                return;
            } else {
                zzrf.zzg("e", str5);
                return;
            }
        }
        if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzbbd.zzeo("No value given for CSI extra.");
                return;
            }
            if (TextUtils.isEmpty(str6)) {
                zzbbd.zzeo("No name given for CSI extra.");
                return;
            }
            zzaba zzrf2 = zzbggVar2.zzaby().zzrf();
            if (zzrf2 == null) {
                zzbbd.zzeo("No ticker for WebView, dropping extra parameter.");
            } else {
                zzrf2.zzg(str6, str7);
            }
        }
    }
}
