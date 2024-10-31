package c.d.b.m;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import com.crashlytics.android.Crashlytics;

/* compiled from: CheckVersionExtension.kt */
/* loaded from: classes2.dex */
public final class c {
    public static final String a(Context context) {
        kotlin.jvm.internal.h.b(context, "$this$getCurrentVersion");
        return context.getPackageManager().getPackageInfo(context.getPackageName(), 128).versionName;
    }

    public static final String b(Context context) {
        kotlin.jvm.internal.h.b(context, "$this$getLatestVersion");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        kotlin.jvm.internal.h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
        return defaultSharedPreferences.getString("latest_version", null);
    }

    public static final boolean c(Context context) {
        kotlin.jvm.internal.h.b(context, "$this$isFirstUser");
        return b(context) == null;
    }

    public static final void d(Context context) {
        kotlin.jvm.internal.h.b(context, "$this$updateLatestVersion");
        try {
            String a2 = a(context);
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            kotlin.jvm.internal.h.a((Object) defaultSharedPreferences, "PreferenceManager.getDef…ltSharedPreferences(this)");
            defaultSharedPreferences.edit().putString("latest_version", a2).apply();
        } catch (PackageManager.NameNotFoundException e2) {
            Crashlytics.logException(e2);
        }
    }
}
