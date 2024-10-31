package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

@zzark
/* loaded from: classes2.dex */
public final class zzaap {
    private Context mContext;
    private String zzbuk;
    private String zzcyt = (String) zzwu.zzpz().zzd(zzaan.zzcpx);
    private Map<String, String> zzcyu = new LinkedHashMap();

    public zzaap(Context context, String str) {
        String packageName;
        this.mContext = null;
        this.zzbuk = null;
        this.mContext = context;
        this.zzbuk = str;
        this.zzcyu.put(com.umeng.commonsdk.proguard.e.ap, "gmob_sdk");
        this.zzcyu.put("v", "3");
        this.zzcyu.put(com.umeng.commonsdk.proguard.e.w, Build.VERSION.RELEASE);
        this.zzcyu.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Build.VERSION.SDK);
        Map<String, String> map = this.zzcyu;
        com.google.android.gms.ads.internal.zzbv.e();
        map.put("device", zzayh.zzzt());
        Map<String, String> map2 = this.zzcyu;
        if (context.getApplicationContext() != null) {
            packageName = context.getApplicationContext().getPackageName();
        } else {
            packageName = context.getPackageName();
        }
        map2.put("app", packageName);
        Map<String, String> map3 = this.zzcyu;
        com.google.android.gms.ads.internal.zzbv.e();
        map3.put("is_lite_sdk", zzayh.zzav(context) ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Future<zzatz> zzt = com.google.android.gms.ads.internal.zzbv.p().zzt(this.mContext);
        try {
            zzt.get();
            this.zzcyu.put("network_coarse", Integer.toString(zzt.get().zzedd));
            this.zzcyu.put("network_fine", Integer.toString(zzt.get().zzede));
        } catch (Exception e2) {
            com.google.android.gms.ads.internal.zzbv.i().zza(e2, "CsiConfiguration.CsiConfiguration");
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final String zzmr() {
        return this.zzbuk;
    }

    public final String zzra() {
        return this.zzcyt;
    }

    public final Map<String, String> zzrb() {
        return this.zzcyu;
    }
}
