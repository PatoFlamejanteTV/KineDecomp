package com.google.firebase.inappmessaging.internal;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import com.google.firebase.FirebaseApp;
import javax.inject.Inject;

/* compiled from: com.google.firebase:firebase-inappmessaging@@17.0.5 */
/* loaded from: classes2.dex */
public class SharedPreferencesUtils {

    /* renamed from: a */
    private final FirebaseApp f17833a;

    @Inject
    public SharedPreferencesUtils(FirebaseApp firebaseApp) {
        this.f17833a = firebaseApp;
    }

    public boolean a(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.f17833a.b()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        if (sharedPreferences.contains(str)) {
            return sharedPreferences.getBoolean(str, z);
        }
        d(str, z);
        return z;
    }

    public boolean b(String str) {
        return ((Application) this.f17833a.b()).getSharedPreferences("com.google.firebase.inappmessaging", 0).contains(str);
    }

    public boolean c(String str, boolean z) {
        SharedPreferences sharedPreferences = ((Application) this.f17833a.b()).getSharedPreferences("com.google.firebase.inappmessaging", 0);
        return sharedPreferences.contains(str) ? sharedPreferences.getBoolean(str, z) : z;
    }

    public void d(String str, boolean z) {
        SharedPreferences.Editor edit = ((Application) this.f17833a.b()).getSharedPreferences("com.google.firebase.inappmessaging", 0).edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public boolean b(String str, boolean z) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.f17833a.b();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager != null && (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) != null && applicationInfo.metaData != null && applicationInfo.metaData.containsKey(str)) {
                return applicationInfo.metaData.getBoolean(str);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return z;
    }

    public boolean a(String str) {
        ApplicationInfo applicationInfo;
        Application application = (Application) this.f17833a.b();
        try {
            PackageManager packageManager = application.getPackageManager();
            if (packageManager == null || (applicationInfo = packageManager.getApplicationInfo(application.getPackageName(), 128)) == null || applicationInfo.metaData == null) {
                return false;
            }
            return applicationInfo.metaData.containsKey(str);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
