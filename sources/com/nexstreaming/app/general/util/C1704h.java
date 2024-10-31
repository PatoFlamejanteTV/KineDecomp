package com.nexstreaming.app.general.util;

import android.app.Activity;
import android.net.Uri;
import com.nexstreaming.kinemaster.ui.projectedit.ProjectEditActivity;
import com.nexstreaming.kinemaster.ui.settings.SettingsActivity;
import com.nexstreaming.kinemaster.ui.store.controller.StoreActivity;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: DeeplinkUtil.java */
/* renamed from: com.nexstreaming.app.general.util.h */
/* loaded from: classes2.dex */
public class C1704h {

    /* renamed from: a */
    public static final String[] f19867a = {"kinemaster", "dynamiclink"};

    /* renamed from: b */
    private static final Map<String, Class<? extends Activity>> f19868b = new HashMap();

    static {
        f19868b.put("kmprch", SettingsActivity.class);
        f19868b.put("kmproject", ProjectEditActivity.class);
        f19868b.put("kmasset", StoreActivity.class);
    }

    public static Class<? extends Activity> a(Uri uri) {
        if (!b(uri)) {
            return null;
        }
        Class<? extends Activity> a2 = a(uri.getHost());
        if (a2 != null) {
            return a2;
        }
        Iterator<String> it = uri.getPathSegments().iterator();
        while (it.hasNext()) {
            a2 = a(it.next());
            if (a2 != null) {
                return a2;
            }
        }
        return a2;
    }

    public static boolean b(Uri uri) {
        if (uri != null) {
            for (String str : f19867a) {
                if (str.equals(uri.getScheme())) {
                    return true;
                }
            }
        }
        return false;
    }

    private static Class<? extends Activity> a(String str) {
        return f19868b.get(str);
    }
}
