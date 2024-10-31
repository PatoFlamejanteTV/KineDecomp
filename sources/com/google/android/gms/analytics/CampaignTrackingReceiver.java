package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

/* loaded from: classes.dex */
public class CampaignTrackingReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    static Object f682a = new Object();
    static zzqy b;
    static Boolean c;

    public static boolean a(Context context) {
        zzx.a(context);
        if (c != null) {
            return c.booleanValue();
        }
        boolean a2 = zzam.a(context, (Class<? extends BroadcastReceiver>) CampaignTrackingReceiver.class, true);
        c = Boolean.valueOf(a2);
        return a2;
    }

    protected Class<? extends CampaignTrackingService> a() {
        return CampaignTrackingService.class;
    }

    protected void a(String str) {
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        zzf a2 = zzf.a(context);
        zzaf f = a2.f();
        String stringExtra = intent.getStringExtra("referrer");
        String action = intent.getAction();
        f.a("CampaignTrackingReceiver received", action);
        if (!"com.android.vending.INSTALL_REFERRER".equals(action) || TextUtils.isEmpty(stringExtra)) {
            f.e("CampaignTrackingReceiver received unexpected intent without referrer extra");
            return;
        }
        boolean a3 = CampaignTrackingService.a(context);
        if (!a3) {
            f.e("CampaignTrackingService not registered or disabled. Installation tracking not possible. See http://goo.gl/8Rd3yj for instructions.");
        }
        a(stringExtra);
        if (a2.e().a()) {
            f.f("Received unexpected installation campaign on package side");
            return;
        }
        Class<? extends CampaignTrackingService> a4 = a();
        zzx.a(a4);
        Intent intent2 = new Intent(context, a4);
        intent2.putExtra("referrer", stringExtra);
        synchronized (f682a) {
            context.startService(intent2);
            if (a3) {
                try {
                    if (b == null) {
                        b = new zzqy(context, 1, "Analytics campaign WakeLock");
                        b.setReferenceCounted(false);
                    }
                    b.acquire(1000L);
                } catch (SecurityException e) {
                    f.e("CampaignTrackingService service at risk of not starting. For more reliable installation campaign reports, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                }
            }
        }
    }
}
