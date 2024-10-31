package com.google.android.gms.ads.purchase;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.client.zzb;
import com.google.android.gms.internal.zzft;
import com.google.android.gms.internal.zzfy;

/* loaded from: classes.dex */
public class InAppPurchaseActivity extends Activity {

    /* renamed from: a, reason: collision with root package name */
    private zzft f676a;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        try {
            if (this.f676a != null) {
                this.f676a.onActivityResult(i, i2, intent);
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onActivityResult to in-app purchase manager:", e);
        }
        super.onActivityResult(i, i2, intent);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f676a = zzfy.zze(this);
        if (this.f676a == null) {
            zzb.e("Could not create in-app purchase manager.");
            finish();
            return;
        }
        try {
            this.f676a.onCreate();
        } catch (RemoteException e) {
            zzb.d("Could not forward onCreate to in-app purchase manager:", e);
            finish();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            if (this.f676a != null) {
                this.f676a.onDestroy();
            }
        } catch (RemoteException e) {
            zzb.d("Could not forward onDestroy to in-app purchase manager:", e);
        }
        super.onDestroy();
    }
}
