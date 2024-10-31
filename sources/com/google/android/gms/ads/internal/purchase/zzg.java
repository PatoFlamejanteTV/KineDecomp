package com.google.android.gms.ads.internal.purchase;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.zzfv;
import com.google.android.gms.internal.zzgr;

@zzgr
/* loaded from: classes.dex */
public final class zzg extends zzfv.zza implements ServiceConnection {

    /* renamed from: a, reason: collision with root package name */
    zzb f616a;
    private boolean b;
    private Context c;
    private int d;
    private Intent e;
    private zzf f;
    private String g;

    public zzg(Context context, String str, boolean z, int i, Intent intent, zzf zzfVar) {
        this.b = false;
        this.g = str;
        this.d = i;
        this.e = intent;
        this.b = z;
        this.c = context;
        this.f = zzfVar;
    }

    @Override // com.google.android.gms.internal.zzfv
    public void finishPurchase() {
        int a2 = zzp.o().a(this.e);
        if (this.d == -1 && a2 == 0) {
            this.f616a = new zzb(this.c);
            Intent intent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
            intent.setPackage("com.android.vending");
            com.google.android.gms.common.stats.zzb.a().a(this.c, intent, this, 1);
        }
    }

    @Override // com.google.android.gms.internal.zzfv
    public String getProductId() {
        return this.g;
    }

    @Override // com.google.android.gms.internal.zzfv
    public Intent getPurchaseData() {
        return this.e;
    }

    @Override // com.google.android.gms.internal.zzfv
    public int getResultCode() {
        return this.d;
    }

    @Override // com.google.android.gms.internal.zzfv
    public boolean isVerified() {
        return this.b;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.ads.internal.util.client.zzb.c("In-app billing service connected.");
        this.f616a.a(iBinder);
        String b = zzp.o().b(zzp.o().b(this.e));
        if (b == null) {
            return;
        }
        if (this.f616a.a(this.c.getPackageName(), b) == 0) {
            zzh.a(this.c).a(this.f);
        }
        com.google.android.gms.common.stats.zzb.a().a(this.c, this);
        this.f616a.a();
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.ads.internal.util.client.zzb.c("In-app billing service disconnected.");
        this.f616a.a();
    }
}
