package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.SharedPreferences;

/* loaded from: classes.dex */
public class al {
    public static void a(Activity activity, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = activity.getSharedPreferences("gclicense.xml", 0).edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean a(Activity activity, String str) {
        try {
            return activity.getSharedPreferences("gclicense.xml", 0).getBoolean(str, false);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
