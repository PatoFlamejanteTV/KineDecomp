package com.bumptech.glide.c;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import com.bumptech.glide.c.c;

/* compiled from: DefaultConnectivityMonitorFactory.java */
/* loaded from: classes.dex */
public class g implements d {
    @Override // com.bumptech.glide.c.d
    public c a(Context context, c.a aVar) {
        boolean z = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        return z ? new f(context, aVar) : new k();
    }
}
