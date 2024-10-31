package com.google.android.gms.ads.internal.gmsg;

import com.facebook.internal.NativeProtocol;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.Map;

/* loaded from: classes.dex */
final class k implements zzu<zzbgg> {
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            zzbggVar2.zzjf();
        } else if ("resume".equals(str)) {
            zzbggVar2.zzjg();
        }
    }
}
