package com.bumptech.glide.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
public class e extends BroadcastReceiver {

    /* renamed from: a */
    final /* synthetic */ f f8419a;

    public e(f fVar) {
        this.f8419a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f fVar = this.f8419a;
        boolean z = fVar.f8422c;
        fVar.f8422c = fVar.a(context);
        if (z != this.f8419a.f8422c) {
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f8419a.f8422c);
            }
            f fVar2 = this.f8419a;
            fVar2.f8421b.a(fVar2.f8422c);
        }
    }
}
