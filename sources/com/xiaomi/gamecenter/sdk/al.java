package com.xiaomi.gamecenter.sdk;

import android.app.Activity;
import android.content.SharedPreferences;

/* loaded from: classes3.dex */
public class al {
    public static void a(Activity activity, String str, boolean z) {
        try {
            SharedPreferences.Editor edit = activity.getSharedPreferences("gclicense.xml", 0).edit();
            edit.putBoolean(str, z);
            edit.commit();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static boolean a(Activity activity, String str) {
        try {
            return activity.getSharedPreferences("gclicense.xml", 0).getBoolean(str, false);
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
