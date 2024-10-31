package com.mixpanel.android.mpmetrics;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: SystemInformation.java */
/* loaded from: classes.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private final Context f3018a;
    private final Boolean b;
    private final Boolean c;
    private final DisplayMetrics d;
    private final String e;
    private final Integer f;

    /* JADX WARN: Removed duplicated region for block: B:12:0x0038  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public ad(android.content.Context r8) {
        /*
            r7 = this;
            r2 = 0
            r7.<init>()
            r7.f3018a = r8
            android.content.Context r0 = r7.f3018a
            android.content.pm.PackageManager r3 = r0.getPackageManager()
            android.content.Context r0 = r7.f3018a     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L74
            java.lang.String r0 = r0.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L74
            r1 = 0
            android.content.pm.PackageInfo r0 = r3.getPackageInfo(r0, r1)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L74
            java.lang.String r1 = r0.versionName     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L74
            int r0 = r0.versionCode     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L9b
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L9b
        L1f:
            r7.e = r1
            r7.f = r0
            java.lang.Class r0 = r3.getClass()
            java.lang.String r1 = "hasSystemFeature"
            r4 = 1
            java.lang.Class[] r4 = new java.lang.Class[r4]     // Catch: java.lang.NoSuchMethodException -> L80
            r5 = 0
            java.lang.Class<java.lang.String> r6 = java.lang.String.class
            r4[r5] = r6     // Catch: java.lang.NoSuchMethodException -> L80
            java.lang.reflect.Method r0 = r0.getMethod(r1, r4)     // Catch: java.lang.NoSuchMethodException -> L80
            r1 = r0
        L36:
            if (r1 == 0) goto L9e
            r0 = 1
            java.lang.Object[] r0 = new java.lang.Object[r0]     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8d
            r4 = 0
            java.lang.String r5 = "android.hardware.nfc"
            r0[r4] = r5     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8d
            java.lang.Object r0 = r1.invoke(r3, r0)     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8d
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch: java.lang.reflect.InvocationTargetException -> L83 java.lang.IllegalAccessException -> L8d
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: java.lang.IllegalAccessException -> L97 java.lang.reflect.InvocationTargetException -> L99
            r5 = 0
            java.lang.String r6 = "android.hardware.telephony"
            r4[r5] = r6     // Catch: java.lang.IllegalAccessException -> L97 java.lang.reflect.InvocationTargetException -> L99
            java.lang.Object r1 = r1.invoke(r3, r4)     // Catch: java.lang.IllegalAccessException -> L97 java.lang.reflect.InvocationTargetException -> L99
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch: java.lang.IllegalAccessException -> L97 java.lang.reflect.InvocationTargetException -> L99
            r2 = r1
        L55:
            r7.b = r0
            r7.c = r2
            android.util.DisplayMetrics r0 = new android.util.DisplayMetrics
            r0.<init>()
            r7.d = r0
            android.content.Context r0 = r7.f3018a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.util.DisplayMetrics r1 = r7.d
            r0.getMetrics(r1)
            return
        L74:
            r0 = move-exception
            r0 = r2
        L76:
            java.lang.String r1 = "MixpanelAPI.SysInfo"
            java.lang.String r4 = "System information constructed with a context that apparently doesn't exist."
            android.util.Log.w(r1, r4)
            r1 = r0
            r0 = r2
            goto L1f
        L80:
            r0 = move-exception
            r1 = r2
            goto L36
        L83:
            r0 = move-exception
            r0 = r2
        L85:
            java.lang.String r1 = "MixpanelAPI.SysInfo"
            java.lang.String r3 = "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it."
            android.util.Log.w(r1, r3)
            goto L55
        L8d:
            r0 = move-exception
            r0 = r2
        L8f:
            java.lang.String r1 = "MixpanelAPI.SysInfo"
            java.lang.String r3 = "System version appeared to support PackageManager.hasSystemFeature, but we were unable to call it."
            android.util.Log.w(r1, r3)
            goto L55
        L97:
            r1 = move-exception
            goto L8f
        L99:
            r1 = move-exception
            goto L85
        L9b:
            r0 = move-exception
            r0 = r1
            goto L76
        L9e:
            r0 = r2
            goto L55
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mixpanel.android.mpmetrics.ad.<init>(android.content.Context):void");
    }

    public String a() {
        return this.e;
    }

    public Integer b() {
        return this.f;
    }

    public boolean c() {
        return this.b.booleanValue();
    }

    public boolean d() {
        return this.c.booleanValue();
    }

    public DisplayMetrics e() {
        return this.d;
    }

    public String f() {
        TelephonyManager telephonyManager = (TelephonyManager) this.f3018a.getSystemService("phone");
        if (telephonyManager == null) {
            return null;
        }
        return telephonyManager.getNetworkOperatorName();
    }

    public Boolean g() {
        if (this.f3018a.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") != 0) {
            return null;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) this.f3018a.getSystemService("connectivity")).getActiveNetworkInfo();
        return Boolean.valueOf(activeNetworkInfo != null && activeNetworkInfo.getType() == 1 && activeNetworkInfo.isConnected());
    }

    public Boolean h() {
        try {
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            if (defaultAdapter == null) {
                return null;
            }
            return Boolean.valueOf(defaultAdapter.isEnabled());
        } catch (SecurityException e) {
            return null;
        }
    }

    public String i() {
        if (Build.VERSION.SDK_INT < 8) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18 && this.f3018a.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le")) {
            return "ble";
        }
        if (!this.f3018a.getPackageManager().hasSystemFeature("android.hardware.bluetooth")) {
            return "none";
        }
        return "classic";
    }
}
