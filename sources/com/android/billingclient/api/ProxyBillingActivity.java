package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;

/* loaded from: classes.dex */
public class ProxyBillingActivity extends Activity {

    /* renamed from: a */
    private ResultReceiver f7897a;

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 100) {
            int b2 = c.b.a.a.a.b(intent, "ProxyBillingActivity");
            if (i2 != -1 || b2 != 0) {
                c.b.a.a.a.b("ProxyBillingActivity", "Activity finished with resultCode " + i2 + " and billing's responseCode: " + b2);
            }
            this.f7897a.send(b2, intent == null ? null : intent.getExtras());
        } else {
            c.b.a.a.a.b("ProxyBillingActivity", "Got onActivityResult with wrong requestCode: " + i + "; skipping...");
        }
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        PendingIntent pendingIntent;
        super.onCreate(bundle);
        if (bundle == null) {
            c.b.a.a.a.a("ProxyBillingActivity", "Launching Play Store billing flow");
            this.f7897a = (ResultReceiver) getIntent().getParcelableExtra("result_receiver");
            if (getIntent().hasExtra("BUY_INTENT")) {
                pendingIntent = (PendingIntent) getIntent().getParcelableExtra("BUY_INTENT");
            } else {
                pendingIntent = getIntent().hasExtra("SUBS_MANAGEMENT_INTENT") ? (PendingIntent) getIntent().getParcelableExtra("SUBS_MANAGEMENT_INTENT") : null;
            }
            try {
                startIntentSenderForResult(pendingIntent.getIntentSender(), 100, new Intent(), 0, 0, 0);
                return;
            } catch (IntentSender.SendIntentException e2) {
                c.b.a.a.a.b("ProxyBillingActivity", "Got exception while trying to start a purchase flow: " + e2);
                this.f7897a.send(6, null);
                finish();
                return;
            }
        }
        c.b.a.a.a.a("ProxyBillingActivity", "Launching Play Store billing flow from savedInstanceState");
        this.f7897a = (ResultReceiver) bundle.getParcelable("result_receiver");
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable("result_receiver", this.f7897a);
    }
}
