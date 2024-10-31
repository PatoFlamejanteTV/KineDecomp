package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzap;
import com.google.android.gms.internal.gtm.zzbq;
import com.google.android.gms.internal.gtm.zzci;
import com.google.android.gms.internal.gtm.zzcz;

@VisibleForTesting
/* loaded from: classes.dex */
public class CampaignTrackingReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private static Boolean f10321a;

    public static boolean a(Context context) {
        Preconditions.a(context);
        Boolean bool = f10321a;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean zza = zzcz.zza(context, "com.google.android.gms.analytics.CampaignTrackingReceiver", true);
        f10321a = Boolean.valueOf(zza);
        return zza;
    }

    protected void a(Context context, String str) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzap zzc = zzap.zzc(context);
        zzci zzco = zzc.zzco();
        if (intent == null) {
            zzco.zzt("CampaignTrackingReceiver received null intent");
            return;
        }
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        zzco.zza("CampaignTrackingReceiver received", action);
        if ("com.android.vending.INSTALL_REFERRER".equals(action) && !TextUtils.isEmpty(stringExtra)) {
            a(context, stringExtra);
            int zzeo = zzbq.zzeo();
            if (stringExtra.length() > zzeo) {
                zzco.zzc("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(stringExtra.length()), Integer.valueOf(zzeo));
                stringExtra = stringExtra.substring(0, zzeo);
            }
            zzc.zzcs().zza(stringExtra, (Runnable) new a(this, goAsync()));
            return;
        }
        zzco.zzt("CampaignTrackingReceiver received unexpected intent without referrer extra");
    }
}
