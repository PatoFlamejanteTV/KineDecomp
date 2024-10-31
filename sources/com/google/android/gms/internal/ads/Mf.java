package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
final class Mf implements com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Lf f11685a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Mf(Lf lf) {
        this.f11685a = lf;
    }

    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        int i;
        if (map != null) {
            String str = (String) map.get("height");
            if (TextUtils.isEmpty(str)) {
                return;
            }
            try {
                int parseInt = Integer.parseInt(str);
                synchronized (this.f11685a) {
                    i = this.f11685a.C;
                    if (i != parseInt) {
                        this.f11685a.C = parseInt;
                        this.f11685a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbbd.zzc("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
