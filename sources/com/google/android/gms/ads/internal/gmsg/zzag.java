package com.google.android.gms.ads.internal.gmsg;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzawd;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzag implements zzu<Object> {

    /* renamed from: a */
    private final zzah f10070a;

    public zzag(zzah zzahVar) {
        this.f10070a = zzahVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("grant".equals(str)) {
            zzawd zzawdVar = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzawdVar = new zzawd(str2, parseInt);
                }
            } catch (NumberFormatException e2) {
                zzbbd.zzc("Unable to parse reward amount.", e2);
            }
            this.f10070a.a(zzawdVar);
            return;
        }
        if ("video_start".equals(str)) {
            this.f10070a.v();
        } else if ("video_complete".equals(str)) {
            this.f10070a.w();
        }
    }
}
