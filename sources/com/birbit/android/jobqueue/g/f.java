package com.birbit.android.jobqueue.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.PowerManager;
import com.birbit.android.jobqueue.g.a;

/* compiled from: NetworkUtilImpl.java */
/* loaded from: classes.dex */
public class f implements b, a {

    /* renamed from: a */
    private a.InterfaceC0042a f8157a;

    public f(Context context) {
        Context applicationContext = context.getApplicationContext();
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            if (i >= 23) {
                d(applicationContext);
            }
            e(applicationContext);
            return;
        }
        applicationContext.registerReceiver(new c(this), a());
    }

    @TargetApi(23)
    private static boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 23) {
            return false;
        }
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        return powerManager.isDeviceIdleMode() && !powerManager.isIgnoringBatteryOptimizations(context.getPackageName());
    }

    @TargetApi(23)
    private void d(Context context) {
        context.registerReceiver(new e(this), new IntentFilter("android.os.action.DEVICE_IDLE_MODE_CHANGED"));
    }

    @TargetApi(23)
    private void e(Context context) {
        ((ConnectivityManager) context.getSystemService("connectivity")).registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).addCapability(13).build(), new d(this, context));
    }

    @Override // com.birbit.android.jobqueue.g.b
    public int a(Context context) {
        NetworkInfo activeNetworkInfo;
        if (c(context) || (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) == null) {
            return 0;
        }
        return (activeNetworkInfo.getType() == 1 || activeNetworkInfo.getType() == 9) ? 2 : 1;
    }

    public void b(Context context) {
        a.InterfaceC0042a interfaceC0042a = this.f8157a;
        if (interfaceC0042a == null) {
            return;
        }
        interfaceC0042a.a(a(context));
    }

    @TargetApi(23)
    private static IntentFilter a() {
        IntentFilter intentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        if (Build.VERSION.SDK_INT >= 23) {
            intentFilter.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
        }
        return intentFilter;
    }

    @Override // com.birbit.android.jobqueue.g.a
    public void a(a.InterfaceC0042a interfaceC0042a) {
        this.f8157a = interfaceC0042a;
    }
}
