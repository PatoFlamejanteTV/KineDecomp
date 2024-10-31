package com.google.android.gms.appdatasearch;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class zzh {

    /* renamed from: a, reason: collision with root package name */
    private static final String[] f770a = {"text1", "text2", "icon", "intent_action", "intent_data", "intent_data_id", "intent_extra_data", "suggest_large_icon", "intent_activity"};
    private static final Map<String, Integer> b = new HashMap(f770a.length);

    static {
        for (int i = 0; i < f770a.length; i++) {
            b.put(f770a[i], Integer.valueOf(i));
        }
    }

    public static int a() {
        return f770a.length;
    }

    public static int a(String str) {
        Integer num = b.get(str);
        if (num == null) {
            throw new IllegalArgumentException("[" + str + "] is not a valid global search section name");
        }
        return num.intValue();
    }

    public static String a(int i) {
        if (i < 0 || i >= f770a.length) {
            return null;
        }
        return f770a[i];
    }
}
