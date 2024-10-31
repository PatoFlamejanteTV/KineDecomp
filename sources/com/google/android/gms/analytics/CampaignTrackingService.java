package com.google.android.gms.analytics;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzaf;
import com.google.android.gms.analytics.internal.zzam;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.internal.zzqy;

/* loaded from: classes.dex */
public class CampaignTrackingService extends Service {
    private static Boolean b;

    /* renamed from: a, reason: collision with root package name */
    private Handler f683a;

    private void a() {
        try {
            synchronized (CampaignTrackingReceiver.f682a) {
                zzqy zzqyVar = CampaignTrackingReceiver.b;
                if (zzqyVar != null && zzqyVar.isHeld()) {
                    zzqyVar.release();
                }
            }
        } catch (SecurityException e) {
        }
    }

    public static boolean a(Context context) {
        zzx.a(context);
        if (b != null) {
            return b.booleanValue();
        }
        boolean a2 = zzam.a(context, (Class<? extends Service>) CampaignTrackingService.class);
        b = Boolean.valueOf(a2);
        return a2;
    }

    private Handler b() {
        Handler handler = this.f683a;
        if (handler != null) {
            return handler;
        }
        Handler handler2 = new Handler(getMainLooper());
        this.f683a = handler2;
        return handler2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(zzaf zzafVar, Handler handler, int i) {
        handler.post(new e(this, i, zzafVar));
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        zzf.a(this).f().b("CampaignTrackingService is starting up");
    }

    @Override // android.app.Service
    public void onDestroy() {
        zzf.a(this).f().b("CampaignTrackingService is shutting down");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        a();
        zzf a2 = zzf.a(this);
        zzaf f = a2.f();
        String str = null;
        if (a2.e().a()) {
            f.f("Unexpected installation campaign (package side)");
        } else {
            str = intent.getStringExtra("referrer");
        }
        Handler b2 = b();
        if (TextUtils.isEmpty(str)) {
            if (!a2.e().a()) {
                f.e("No campaign found on com.android.vending.INSTALL_REFERRER \"referrer\" extra");
            }
            a2.h().a(new c(this, f, b2, i2));
        } else {
            int e = a2.e().e();
            if (str.length() > e) {
                f.c("Campaign data exceed the maximum supported size and will be clipped. size, limit", Integer.valueOf(str.length()), Integer.valueOf(e));
                str = str.substring(0, e);
            }
            f.a("CampaignTrackingService called. startId, campaign", Integer.valueOf(i2), str);
            a2.i().a(str, (Runnable) new d(this, f, b2, i2));
        }
        return 2;
    }
}
