package com.nexstreaming.kinemaster.kmpackage;

import android.content.Context;
import java.util.Locale;
import java.util.Map;

/* compiled from: KMTLocalization.java */
/* loaded from: classes.dex */
class ah {
    /* JADX INFO: Access modifiers changed from: protected */
    public static String a(Context context, Map<String, String> map) {
        return context == null ? "####" : a(context, a(context.getResources().getConfiguration().locale, map, null));
    }

    private static String a(Locale locale, Map<String, String> map, String str) {
        String str2;
        String lowerCase = locale.getLanguage().toLowerCase(Locale.ENGLISH);
        String lowerCase2 = locale.getCountry().toLowerCase(Locale.ENGLISH);
        String lowerCase3 = locale.getVariant().toLowerCase(Locale.ENGLISH);
        if (lowerCase3.isEmpty() && lowerCase2.isEmpty()) {
            str2 = lowerCase;
        } else if (lowerCase3.isEmpty()) {
            str2 = lowerCase + "-" + lowerCase2;
        } else if (lowerCase2.isEmpty()) {
            str2 = lowerCase + "-" + lowerCase3;
        } else {
            str2 = lowerCase + "-" + lowerCase2 + "-" + lowerCase3;
        }
        String str3 = map.get(str2);
        if (str3 == null) {
            String str4 = map.get(lowerCase);
            if (str4 == null) {
                String str5 = map.get("");
                if (str5 == null) {
                    String str6 = map.get("en");
                    if (str6 == null) {
                        String str7 = map.get("en-us");
                        return str7 == null ? str : str7;
                    }
                    return str6;
                }
                return str5;
            }
            return str4;
        }
        return str3;
    }

    private static String a(Context context, String str) {
        int identifier;
        if (str != null && context != null) {
            if (str.startsWith("@string/")) {
                int identifier2 = context.getResources().getIdentifier("string/kedl_" + str.substring(8), "string", context.getPackageName());
                if (identifier2 != 0) {
                    return context.getResources().getString(identifier2);
                }
                return str;
            }
            if (str.startsWith("@") && (identifier = context.getResources().getIdentifier(str.substring(1), "string", context.getPackageName())) != 0) {
                return context.getResources().getString(identifier);
            }
            return str;
        }
        return str;
    }
}
