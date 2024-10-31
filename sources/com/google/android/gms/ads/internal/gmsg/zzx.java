package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzark;
import com.google.android.gms.internal.ads.zzbbd;
import java.util.Map;

@zzark
/* loaded from: classes.dex */
public final class zzx implements zzu<Object> {

    /* renamed from: a */
    private final zzy f10080a;

    public zzx(zzy zzyVar) {
        this.f10080a = zzyVar;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final void zza(Object obj, Map<String, String> map) {
        boolean equals = "1".equals(map.get("transparentBackground"));
        boolean equals2 = "1".equals(map.get("blur"));
        float f2 = 0.0f;
        try {
            if (map.get("blurRadius") != null) {
                f2 = Float.parseFloat(map.get("blurRadius"));
            }
        } catch (NumberFormatException e2) {
            zzbbd.zzb("Fail to parse float", e2);
        }
        this.f10080a.a(equals);
        this.f10080a.a(equals2, f2);
    }
}
