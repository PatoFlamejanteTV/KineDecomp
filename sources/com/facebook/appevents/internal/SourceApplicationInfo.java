package com.facebook.appevents.internal;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.facebook.FacebookSdk;

/* loaded from: classes.dex */
public class SourceApplicationInfo {

    /* renamed from: a */
    private String f9178a;

    /* renamed from: b */
    private boolean f9179b;

    /* loaded from: classes.dex */
    public static class Factory {
        public static SourceApplicationInfo create(Activity activity) {
            String str;
            ComponentName callingActivity = activity.getCallingActivity();
            if (callingActivity != null) {
                str = callingActivity.getPackageName();
                if (str.equals(activity.getPackageName())) {
                    return null;
                }
            } else {
                str = "";
            }
            Intent intent = activity.getIntent();
            boolean z = false;
            if (intent != null && !intent.getBooleanExtra("_fbSourceApplicationHasBeenSet", false)) {
                intent.putExtra("_fbSourceApplicationHasBeenSet", true);
                Bundle a2 = bolts.e.a(intent);
                if (a2 != null) {
                    Bundle bundle = a2.getBundle("referer_app_link");
                    if (bundle != null) {
                        str = bundle.getString("package");
                    }
                    z = true;
                }
            }
            intent.putExtra("_fbSourceApplicationHasBeenSet", true);
            return new SourceApplicationInfo(str, z);
        }
    }

    /* synthetic */ SourceApplicationInfo(String str, boolean z, n nVar) {
        this(str, z);
    }

    public static void a() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.remove("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage");
        edit.remove("com.facebook.appevents.SourceApplicationInfo.openedByApplink");
        edit.apply();
    }

    public static SourceApplicationInfo b() {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext());
        if (defaultSharedPreferences.contains("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage")) {
            return new SourceApplicationInfo(defaultSharedPreferences.getString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", null), defaultSharedPreferences.getBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", false));
        }
        return null;
    }

    public void c() {
        SharedPreferences.Editor edit = PreferenceManager.getDefaultSharedPreferences(FacebookSdk.getApplicationContext()).edit();
        edit.putString("com.facebook.appevents.SourceApplicationInfo.callingApplicationPackage", this.f9178a);
        edit.putBoolean("com.facebook.appevents.SourceApplicationInfo.openedByApplink", this.f9179b);
        edit.apply();
    }

    public String toString() {
        String str = this.f9179b ? "Applink" : "Unclassified";
        if (this.f9178a == null) {
            return str;
        }
        return str + "(" + this.f9178a + ")";
    }

    private SourceApplicationInfo(String str, boolean z) {
        this.f9178a = str;
        this.f9179b = z;
    }
}
