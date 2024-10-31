package com.bumptech.glide.c;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.c.c;

/* compiled from: DefaultConnectivityMonitor.java */
/* loaded from: classes.dex */
public final class f implements c {

    /* renamed from: a */
    private final Context f8420a;

    /* renamed from: b */
    final c.a f8421b;

    /* renamed from: c */
    boolean f8422c;

    /* renamed from: d */
    private boolean f8423d;

    /* renamed from: e */
    private final BroadcastReceiver f8424e = new e(this);

    public f(Context context, c.a aVar) {
        this.f8420a = context.getApplicationContext();
        this.f8421b = aVar;
    }

    private void a() {
        if (this.f8423d) {
            return;
        }
        this.f8422c = a(this.f8420a);
        try {
            this.f8420a.registerReceiver(this.f8424e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f8423d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        if (this.f8423d) {
            this.f8420a.unregisterReceiver(this.f8424e);
            this.f8423d = false;
        }
    }

    @Override // com.bumptech.glide.c.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.c.j
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.c.j
    public void onStop() {
        b();
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        com.bumptech.glide.g.l.a(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}
