package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.util.Log;
import com.mixpanel.android.surveys.SurveyActivity;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ConfigurationChecker.java */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public static String f3028a = "MixpanelAPI.ConfigurationChecker";

    public static boolean a(Context context) {
        if (context.getPackageManager().checkPermission("android.permission.INTERNET", context.getPackageName()) == 0) {
            return true;
        }
        Log.w(f3028a, "Package does not have permission android.permission.INTERNET - Mixpanel will not work at all!");
        Log.i(f3028a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
        return false;
    }

    public static boolean b(Context context) {
        boolean z;
        boolean z2;
        if (Build.VERSION.SDK_INT < 8) {
            Log.i(f3028a, "Mixpanel push notifications not supported in SDK " + Build.VERSION.SDK_INT);
            return false;
        }
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String str = packageName + ".permission.C2D_MESSAGE";
        try {
            packageManager.getPermissionInfo(str, 4096);
            if (packageManager.checkPermission("com.google.android.c2dm.permission.RECEIVE", packageName) != 0) {
                Log.w(f3028a, "Package does not have permission com.google.android.c2dm.permission.RECEIVE");
                Log.i(f3028a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"com.google.android.c2dm.permission.RECEIVE\" />");
                return false;
            }
            if (packageManager.checkPermission("android.permission.INTERNET", packageName) != 0) {
                Log.w(f3028a, "Package does not have permission android.permission.INTERNET");
                Log.i(f3028a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.INTERNET\" />");
                return false;
            }
            if (packageManager.checkPermission("android.permission.WAKE_LOCK", packageName) != 0) {
                Log.w(f3028a, "Package does not have permission android.permission.WAKE_LOCK");
                Log.i(f3028a, "You can fix this by adding the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.WAKE_LOCK\" />");
                return false;
            }
            if (packageManager.checkPermission("android.permission.GET_ACCOUNTS", packageName) != 0) {
                Log.i(f3028a, "Package does not have permission android.permission.GET_ACCOUNTS");
                Log.i(f3028a, "Android versions below 4.1 require GET_ACCOUNTS to receive Mixpanel push notifications.\nDevices with later OS versions will still be able to receive messages, but if you'd like to support older devices, you'll need to add the following to your AndroidManifest.xml file:\n<uses-permission android:name=\"android.permission.GET_ACCOUNTS\" />");
                if (Build.VERSION.SDK_INT < 16) {
                    return false;
                }
            }
            try {
                ActivityInfo[] activityInfoArr = packageManager.getPackageInfo(packageName, 2).receivers;
                if (activityInfoArr == null || activityInfoArr.length == 0) {
                    Log.w(f3028a, "No receiver for package " + packageName);
                    Log.i(f3028a, "You can fix this with the following into your <application> tag:\n" + a(packageName));
                    return false;
                }
                HashSet hashSet = new HashSet();
                for (ActivityInfo activityInfo : activityInfoArr) {
                    if ("com.google.android.c2dm.permission.SEND".equals(activityInfo.permission)) {
                        hashSet.add(activityInfo.name);
                    }
                }
                if (hashSet.isEmpty()) {
                    Log.w(f3028a, "No receiver allowed to receive com.google.android.c2dm.permission.SEND");
                    Log.i(f3028a, "You can fix by pasting the following into the <application> tag in your AndroidManifest.xml:\n" + a(packageName));
                    return false;
                }
                if (!a(context, hashSet, "com.google.android.c2dm.intent.RECEIVE")) {
                    return false;
                }
                try {
                    Class.forName("com.google.android.gms.common.GooglePlayServicesUtil");
                    z = true;
                } catch (ClassNotFoundException e) {
                    Log.w(f3028a, "Google Play Services aren't included in your build- push notifications won't work on Lollipop/API 21 or greater");
                    Log.i(f3028a, "You can fix this by adding com.google.android.gms:play-services as a dependency of your gradle or maven project");
                    z = false;
                }
                if (a(context, hashSet, "com.google.android.c2dm.intent.REGISTRATION")) {
                    z2 = true;
                } else {
                    Log.i(f3028a, "(You can still receive push notifications on Lollipop/API 21 or greater with this configuration)");
                    z2 = false;
                }
                return z || z2;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.w(f3028a, "Could not get receivers for package " + packageName);
                return false;
            }
        } catch (PackageManager.NameNotFoundException e3) {
            Log.w(f3028a, "Application does not define permission " + str);
            Log.i(f3028a, "You will need to add the following lines to your application manifest:\n<permission android:name=\"" + packageName + ".permission.C2D_MESSAGE\" android:protectionLevel=\"signature\" />\n<uses-permission android:name=\"" + packageName + ".permission.C2D_MESSAGE\" />");
            return false;
        }
    }

    public static boolean c(Context context) {
        if (Build.VERSION.SDK_INT < 16) {
            return false;
        }
        Intent intent = new Intent(context, (Class<?>) SurveyActivity.class);
        intent.addFlags(268435456);
        intent.addFlags(131072);
        if (context.getPackageManager().queryIntentActivities(intent, 0).size() == 0) {
            Log.w(f3028a, SurveyActivity.class.getName() + " is not registered as an activity in your application, so surveys can't be shown.");
            Log.i(f3028a, "Please add the child tag <activity android:name=\"com.mixpanel.android.surveys.SurveyActivity\" /> to your <application> tag.");
            return false;
        }
        return true;
    }

    private static String a(String str) {
        return "<receiver android:name=\"com.mixpanel.android.mpmetrics.GCMReceiver\"\n          android:permission=\"com.google.android.c2dm.permission.SEND\" >\n    <intent-filter>\n       <action android:name=\"com.google.android.c2dm.intent.RECEIVE\" />\n       <action android:name=\"com.google.android.c2dm.intent.REGISTRATION\" />\n       <category android:name=\"" + str + "\" />\n    </intent-filter>\n</receiver>";
    }

    private static boolean a(Context context, Set<String> set, String str) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        Intent intent = new Intent(str);
        intent.setPackage(packageName);
        List<ResolveInfo> queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 32);
        if (queryBroadcastReceivers.isEmpty()) {
            Log.w(f3028a, "No receivers for action " + str);
            Log.i(f3028a, "You can fix by pasting the following into the <application> tag in your AndroidManifest.xml:\n" + a(packageName));
            return false;
        }
        Iterator<ResolveInfo> it = queryBroadcastReceivers.iterator();
        while (it.hasNext()) {
            String str2 = it.next().activityInfo.name;
            if (!set.contains(str2)) {
                Log.w(f3028a, "Receiver " + str2 + " is not set with permission com.google.android.c2dm.permission.SEND");
                Log.i(f3028a, "Please add the attribute 'android:permission=\"com.google.android.c2dm.permission.SEND\"' to your <receiver> tag");
                return false;
            }
        }
        return true;
    }
}
