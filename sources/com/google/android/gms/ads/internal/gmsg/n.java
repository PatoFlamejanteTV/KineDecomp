package com.google.android.gms.ads.internal.gmsg;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzbv;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzbgg;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
final class n implements zzu<zzbgg> {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.ads.internal.gmsg.zzu
    public final /* synthetic */ void zza(zzbgg zzbggVar, Map map) {
        zzbgg zzbggVar2 = zzbggVar;
        WindowManager windowManager = (WindowManager) zzbggVar2.getContext().getSystemService("window");
        zzbv.e();
        DisplayMetrics zza = zzayh.zza(windowManager);
        int i = zza.widthPixels;
        int i2 = zza.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzbggVar2).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i2));
        zzbggVar2.zza("locationReady", hashMap);
        zzbbd.zzeo("GET LOCATION COMPILED");
    }
}
