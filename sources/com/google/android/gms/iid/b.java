package com.google.android.gms.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* loaded from: classes.dex */
class b extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ InstanceIDListenerService f1427a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InstanceIDListenerService instanceIDListenerService) {
        this.f1427a = instanceIDListenerService;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (Log.isLoggable("InstanceID", 3)) {
            intent.getStringExtra("registration_id");
            Log.d("InstanceID", "Received GSF callback using dynamic receiver: " + intent.getExtras());
        }
        this.f1427a.a(intent);
        this.f1427a.a();
    }
}
