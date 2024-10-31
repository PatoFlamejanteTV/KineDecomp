package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
final class Xf implements com.google.android.gms.ads.internal.gmsg.zzu<zzbgg> {

    /* renamed from: a, reason: collision with root package name */
    private final /* synthetic */ Wf f11957a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xf(Wf wf) {
        this.f11957a = wf;
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
                synchronized (this.f11957a) {
                    i = this.f11957a.v;
                    if (i != parseInt) {
                        this.f11957a.v = parseInt;
                        this.f11957a.requestLayout();
                    }
                }
            } catch (Exception e2) {
                zzbbd.zzc("Exception occurred while getting webview content height", e2);
            }
        }
    }
}
