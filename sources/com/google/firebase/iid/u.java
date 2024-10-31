package com.google.firebase.iid;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.Nullable;

@VisibleForTesting
/* loaded from: classes2.dex */
final class u extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    @Nullable
    private t f17388a;

    public u(t tVar) {
        this.f17388a = tVar;
    }

    public final void a() {
        if (FirebaseInstanceId.h()) {
            Log.d("FirebaseInstanceId", "Connectivity change received registered");
        }
        this.f17388a.b().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        t tVar = this.f17388a;
        if (tVar != null && tVar.c()) {
            if (FirebaseInstanceId.h()) {
                Log.d("FirebaseInstanceId", "Connectivity changed. Starting background sync.");
            }
            FirebaseInstanceId.a(this.f17388a, 0L);
            this.f17388a.b().unregisterReceiver(this);
            this.f17388a = null;
        }
    }
}
