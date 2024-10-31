package c.a.a.a.a.b.a.b.b;

import android.content.SharedPreferences;

/* compiled from: ACLibraryManagerPrefs.java */
/* loaded from: classes.dex */
public class c {
    private static String a(String str) {
        return a(str, null);
    }

    private static SharedPreferences b() {
        return c.a.a.a.c.a.a.b().a().getSharedPreferences("aclibmgr_prefs", 0);
    }

    private static String a(String str, String str2) {
        return b().getString(str, str2);
    }

    public static String a() {
        return a("aclibmgr_lastusersel_libid");
    }
}
