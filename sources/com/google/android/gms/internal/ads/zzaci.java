package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes2.dex */
public final class zzaci implements com.google.android.gms.ads.internal.gmsg.zzu<Object> {
    private final WeakReference<zzace> zzboc;
    private final String zzbqb;

    public zzaci(zzace zzaceVar, String str) {
        this.zzboc = new WeakReference<>(zzaceVar);
        this.zzbqb = str;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        zzace zzaceVar;
        String str = map.get("ads_id");
        String str2 = map.get("eventName");
        if (TextUtils.isEmpty(str) || !this.zzbqb.equals(str)) {
            return;
        }
        if ("_ai".equals(str2)) {
            zzace zzaceVar2 = this.zzboc.get();
            if (zzaceVar2 != null) {
                zzaceVar2.zzim();
                return;
            }
            return;
        }
        if (!"_ac".equals(str2) || (zzaceVar = this.zzboc.get()) == null) {
            return;
        }
        zzaceVar.zzin();
    }
}
