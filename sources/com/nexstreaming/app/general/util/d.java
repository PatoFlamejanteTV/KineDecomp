package com.nexstreaming.app.general.util;

import android.app.Activity;
import android.net.Uri;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DeeplinkUtil.java */
/* loaded from: classes.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static final Map<String, Class<? extends Activity>> f3226a = new HashMap();

    static {
        f3226a.put("setting", SettingsActivity.class);
    }

    public static Class<? extends Activity> a(Uri uri) {
        if (uri == null || !uri.getScheme().equals("kine") || uri.getHost() == null) {
            return null;
        }
        return f3226a.get(uri.getHost());
    }

    public static String a(String str, String... strArr) {
        String str2 = "kine://" + str;
        for (String str3 : strArr) {
            str2 = str2 + "/" + str3;
        }
        return str2;
    }
}
