package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AppOpsManager;
import android.app.Dialog;
import android.app.NotificationManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.UserManager;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import com.facebook.internal.ServerProtocol;
import com.facebook.internal.Utility;
import com.google.android.gms.R;
import com.google.android.gms.common.a;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzh;
import com.google.android.gms.internal.zzml;
import com.google.android.gms.internal.zzmx;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class GooglePlayServicesUtil {

    /* renamed from: a, reason: collision with root package name */
    @Deprecated
    public static final int f863a = b();
    public static boolean b = false;
    public static boolean c = false;
    private static int e = -1;
    private static final Object f = new Object();
    private static String g = null;
    private static Integer h = null;
    static final AtomicBoolean d = new AtomicBoolean();
    private static final AtomicBoolean i = new AtomicBoolean();

    private GooglePlayServicesUtil() {
    }

    @Deprecated
    public static int a(Context context) {
        int i2 = 9;
        if (com.google.android.gms.common.internal.zzd.f1003a) {
            return 0;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            context.getResources().getString(R.string.common_google_play_services_unknown_issue);
        } catch (Throwable th) {
            Log.e("GooglePlayServicesUtil", "The Google Play services resources were not found. Check your project configuration to ensure that the resources are included.");
        }
        if (!"com.google.android.gms".equals(context.getPackageName())) {
            i(context);
        }
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo("com.google.android.gms", 64);
            zzd a2 = zzd.a();
            if (!zzml.zzcb(packageInfo.versionCode) && !zzml.zzan(context)) {
                try {
                    a.AbstractC0031a a3 = a2.a(packageManager.getPackageInfo("com.android.vending", 8256), a.bb.f896a);
                    if (a3 == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play Store signature invalid.");
                    } else if (a2.a(packageInfo, a3) == null) {
                        Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                    }
                    return i2;
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.w("GooglePlayServicesUtil", "Google Play Store is neither installed nor updating.");
                    return i2;
                }
            }
            if (a2.a(packageInfo, a.bb.f896a) == null) {
                Log.w("GooglePlayServicesUtil", "Google Play services signature invalid.");
                return 9;
            }
            if (zzml.zzca(packageInfo.versionCode) < zzml.zzca(f863a)) {
                Log.w("GooglePlayServicesUtil", "Google Play services out of date.  Requires " + f863a + " but found " + packageInfo.versionCode);
                i2 = 2;
            } else {
                ApplicationInfo applicationInfo = packageInfo.applicationInfo;
                if (applicationInfo == null) {
                    try {
                        applicationInfo = packageManager.getApplicationInfo("com.google.android.gms", 0);
                    } catch (PackageManager.NameNotFoundException e3) {
                        Log.wtf("GooglePlayServicesUtil", "Google Play services missing when getting application info.", e3);
                        i2 = 1;
                    }
                }
                i2 = !applicationInfo.enabled ? 3 : 0;
            }
            return i2;
        } catch (PackageManager.NameNotFoundException e4) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 1;
        }
    }

    @Deprecated
    public static Dialog a(int i2, Activity activity, int i3) {
        return a(i2, activity, i3, (DialogInterface.OnCancelListener) null);
    }

    @Deprecated
    public static Dialog a(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return b(i2, activity, null, i3, onCancelListener);
    }

    @Deprecated
    public static Intent a(int i2) {
        return GoogleApiAvailability.a().a(null, i2, null);
    }

    public static void a(Activity activity, DialogInterface.OnCancelListener onCancelListener, String str, Dialog dialog) {
        boolean z;
        try {
            z = activity instanceof android.support.v4.app.l;
        } catch (NoClassDefFoundError e2) {
            z = false;
        }
        if (z) {
            SupportErrorDialogFragment.a(dialog, onCancelListener).show(((android.support.v4.app.l) activity).getSupportFragmentManager(), str);
        } else {
            if (!zzmx.zzqu()) {
                throw new RuntimeException("This Activity does not support Fragments.");
            }
            ErrorDialogFragment.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
        }
    }

    public static boolean a() {
        return b ? c : "user".equals(Build.TYPE);
    }

    public static boolean a(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog b2 = b(i2, activity, fragment, i3, onCancelListener);
        if (b2 == null) {
            return false;
        }
        a(activity, onCancelListener, "GooglePlayServicesErrorDialog", b2);
        return true;
    }

    public static boolean a(Context context, int i2) {
        return a(context, i2, "com.google.android.gms") && a(context.getPackageManager(), "com.google.android.gms");
    }

    public static boolean a(Context context, int i2, String str) {
        if (zzmx.zzqB()) {
            try {
                ((AppOpsManager) context.getSystemService("appops")).checkPackage(i2, str);
                return true;
            } catch (SecurityException e2) {
                return false;
            }
        }
        String[] packagesForUid = context.getPackageManager().getPackagesForUid(i2);
        if (str == null || packagesForUid == null) {
            return false;
        }
        for (String str2 : packagesForUid) {
            if (str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Context context, String str) {
        if (zzmx.zzqD()) {
            Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().getAppPackageName())) {
                    return true;
                }
            }
        }
        if (h(context)) {
            return false;
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, Utility.DEFAULT_STREAM_BUFFER_SIZE).enabled;
        } catch (PackageManager.NameNotFoundException e2) {
            return false;
        }
    }

    public static boolean a(PackageManager packageManager) {
        boolean z;
        synchronized (f) {
            if (e == -1) {
                try {
                    if (zzd.a().a(packageManager.getPackageInfo("com.google.android.gms", 64), a.b[1]) != null) {
                        e = 1;
                    } else {
                        e = 0;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    e = 0;
                }
            }
            z = e != 0;
        }
        return z;
    }

    @Deprecated
    public static boolean a(PackageManager packageManager, String str) {
        return zzd.a().a(packageManager, str);
    }

    private static int b() {
        return 8115000;
    }

    private static Dialog b(int i2, Activity activity, Fragment fragment, int i3, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        if (zzml.zzan(activity) && i2 == 2) {
            i2 = 42;
        }
        if (zzmx.zzqx()) {
            TypedValue typedValue = new TypedValue();
            activity.getTheme().resolveAttribute(android.R.attr.alertDialogTheme, typedValue, true);
            if ("Theme.Dialog.Alert".equals(activity.getResources().getResourceEntryName(typedValue.resourceId))) {
                builder = new AlertDialog.Builder(activity, 5);
            }
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(activity);
        }
        builder.setMessage(zzg.a(activity, i2, f(activity)));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        Intent a2 = GoogleApiAvailability.a().a(activity, i2, "d");
        zzh zzhVar = fragment == null ? new zzh(activity, a2, i3) : new zzh(fragment, a2, i3);
        String b2 = zzg.b(activity, i2);
        if (b2 != null) {
            builder.setPositiveButton(b2, zzhVar);
        }
        String a3 = zzg.a(activity, i2);
        if (a3 != null) {
            builder.setTitle(a3);
        }
        return builder.create();
    }

    @Deprecated
    public static void b(Context context) throws GooglePlayServicesRepairableException, GooglePlayServicesNotAvailableException {
        int a2 = GoogleApiAvailability.a().a(context);
        if (a2 != 0) {
            Intent a3 = GoogleApiAvailability.a().a(context, a2, "e");
            Log.e("GooglePlayServicesUtil", "GooglePlayServices not available due to error " + a2);
            if (a3 != null) {
                throw new GooglePlayServicesRepairableException(a2, "Google Play Services not available", a3);
            }
            throw new GooglePlayServicesNotAvailableException(a2);
        }
    }

    @Deprecated
    public static boolean b(int i2) {
        switch (i2) {
            case 1:
            case 2:
            case 3:
            case 9:
                return true;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            default:
                return false;
        }
    }

    @Deprecated
    public static boolean b(int i2, Activity activity, int i3) {
        return b(i2, activity, i3, null);
    }

    @Deprecated
    public static boolean b(int i2, Activity activity, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a(i2, activity, null, i3, onCancelListener);
    }

    @Deprecated
    public static boolean b(Context context, int i2) {
        if (i2 == 18) {
            return true;
        }
        if (i2 == 1) {
            return a(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean b(PackageManager packageManager) {
        return a(packageManager) || !a();
    }

    @Deprecated
    public static void c(Context context) {
        if (d.getAndSet(true)) {
            return;
        }
        try {
            ((NotificationManager) context.getSystemService("notification")).cancel(10436);
        } catch (SecurityException e2) {
        }
    }

    public static Resources d(Context context) {
        try {
            return context.getPackageManager().getResourcesForApplication("com.google.android.gms");
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static Context e(Context context) {
        try {
            return context.createPackageContext("com.google.android.gms", 3);
        } catch (PackageManager.NameNotFoundException e2) {
            return null;
        }
    }

    public static String f(Context context) {
        ApplicationInfo applicationInfo;
        String str = context.getApplicationInfo().name;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        String packageName = context.getPackageName();
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e2) {
            applicationInfo = null;
        }
        return applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo).toString() : packageName;
    }

    public static boolean g(Context context) {
        return zzmx.zzqD() && context.getPackageManager().hasSystemFeature("com.google.sidewinder");
    }

    public static boolean h(Context context) {
        Bundle applicationRestrictions;
        return zzmx.zzqA() && (applicationRestrictions = ((UserManager) context.getSystemService("user")).getApplicationRestrictions(context.getPackageName())) != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(applicationRestrictions.getString("restricted_profile"));
    }

    private static void i(Context context) {
        Integer num;
        if (i.get()) {
            return;
        }
        synchronized (f) {
            if (g == null) {
                g = context.getPackageName();
                try {
                    Bundle bundle = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
                    if (bundle != null) {
                        h = Integer.valueOf(bundle.getInt("com.google.android.gms.version"));
                    } else {
                        h = null;
                    }
                } catch (PackageManager.NameNotFoundException e2) {
                    Log.wtf("GooglePlayServicesUtil", "This should never happen.", e2);
                }
            } else if (!g.equals(context.getPackageName())) {
                throw new IllegalArgumentException("isGooglePlayServicesAvailable should only be called with Context from your application's package. A previous call used package '" + g + "' and this call used package '" + context.getPackageName() + "'.");
            }
            num = h;
        }
        if (num == null) {
            throw new IllegalStateException("A required meta-data tag in your app's AndroidManifest.xml does not exist.  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
        if (num.intValue() != f863a) {
            throw new IllegalStateException("The meta-data tag in your app's AndroidManifest.xml does not have the right value.  Expected " + f863a + " but found " + num + ".  You must have the following declaration within the <application> element:     <meta-data android:name=\"com.google.android.gms.version\" android:value=\"@integer/google_play_services_version\" />");
        }
    }
}
