package com.adobe.creativesdk.foundation.internal.storage.controllers.upload;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.Map;

/* compiled from: AdobeUploadHistoryManager.java */
/* loaded from: classes.dex */
public class q {

    /* renamed from: a */
    private static String f6457a = "Adobe_CC_Upload_History_Shared_Preference";

    /* renamed from: b */
    private static Context f6458b;

    public static void a() {
        f6458b.getSharedPreferences(f6457a, 0).edit().clear().commit();
    }

    public static Map<String, ?> b() {
        Context context = f6458b;
        if (context == null) {
            return null;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences(f6457a, 0);
        Map<String, ?> all = sharedPreferences.getAll();
        sharedPreferences.edit().clear().commit();
        return all;
    }
}
