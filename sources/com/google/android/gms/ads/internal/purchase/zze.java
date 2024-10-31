package com.google.android.gms.ads.internal.purchase;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfr;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public class zze extends zzft.zza implements ServiceConnection {

    /* renamed from: a */
    zzh f614a;
    private final Activity b;
    private Context c;
    private zzfr d;
    private zzb e;
    private zzf f;
    private zzj g;
    private zzk h;
    private String i = null;

    public zze(Activity activity) {
        this.b = activity;
        this.f614a = zzh.a(this.b.getApplicationContext());
    }

    protected void a(String str, boolean z, int i, Intent intent) {
        if (this.g != null) {
            this.g.zza(str, z, i, intent, this.f);
        }
    }

    @Override // com.google.android.gms.internal.zzft
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 1001) {
            boolean z = false;
            try {
                int a2 = zzp.o().a(intent);
                if (i2 == -1) {
                    zzp.o();
                    if (a2 == 0) {
                        if (this.h.a(this.i, i2, intent)) {
                            z = true;
                        }
                        this.d.recordPlayBillingResolution(a2);
                        this.b.finish();
                        a(this.d.getProductId(), z, i2, intent);
                    }
                }
                this.f614a.a(this.f);
                this.d.recordPlayBillingResolution(a2);
                this.b.finish();
                a(this.d.getProductId(), z, i2, intent);
            } catch (RemoteException e) {
                com.google.android.gms.ads.internal.util.client.zzb.e("Fail to process purchase result.");
                this.b.finish();
            } finally {
                this.i = null;
            }
        }
    }

    @Override // com.google.android.gms.internal.zzft
    public void onCreate() {
        GInAppPurchaseManagerInfoParcel a2 = GInAppPurchaseManagerInfoParcel.a(this.b.getIntent());
        this.g = a2.e;
        this.h = a2.b;
        this.d = a2.c;
        this.e = new zzb(this.b.getApplicationContext());
        this.c = a2.d;
        if (this.b.getResources().getConfiguration().orientation == 2) {
            this.b.setRequestedOrientation(zzp.g().zzgG());
        } else {
            this.b.setRequestedOrientation(zzp.g().zzgH());
        }
        Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        intent.setPackage("com.android.vending");
        this.b.bindService(intent, this, 1);
    }

    @Override // com.google.android.gms.internal.zzft
    public void onDestroy() {
        this.b.unbindService(this);
        this.e.a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.e.a(iBinder);
        try {
            this.i = this.h.a();
            Bundle a2 = this.e.a(this.b.getPackageName(), this.d.getProductId(), this.i);
            PendingIntent pendingIntent = (PendingIntent) a2.getParcelable("BUY_INTENT");
            if (pendingIntent == null) {
                int a3 = zzp.o().a(a2);
                this.d.recordPlayBillingResolution(a3);
                a(this.d.getProductId(), false, a3, null);
                this.b.finish();
            } else {
                this.f = new zzf(this.d.getProductId(), this.i);
                this.f614a.b(this.f);
                Integer num = 0;
                Integer num2 = 0;
                Integer num3 = 0;
                this.b.startIntentSenderForResult(pendingIntent.getIntentSender(), 1001, new Intent(), num.intValue(), num2.intValue(), num3.intValue());
            }
        } catch (IntentSender.SendIntentException | RemoteException e) {
            com.google.android.gms.ads.internal.util.client.zzb.d("Error when connecting in-app billing service", e);
            this.b.finish();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.ads.internal.util.client.zzb.c("In-app billing service disconnected.");
        this.e.a();
    }
}
