package com.adobe.creativesdk.foundation.internal.storage.model.util;

/* compiled from: AdobeStorageLastPathComponentUtil.java */
/* loaded from: classes.dex */
public class g {
    public static String a(String str) {
        if (str.equals("/")) {
            return str;
        }
        if (str.endsWith("/")) {
            return a(str.substring(0, str.length() - 1));
        }
        return org.apache.commons.io.c.e(str);
    }

    public static String b(String str) {
        if (str.equals("/")) {
            return str;
        }
        if (str.endsWith("/")) {
            return b(str.substring(0, str.length() - 1));
        }
        return str.replace(a(str), "");
    }

    public static String a(String str, String str2) {
        if (str.startsWith("http") && str.startsWith(str2)) {
            return str;
        }
        if (str.startsWith("/")) {
            str = str.substring(1);
        }
        if (str2.endsWith("/")) {
            str2 = str2.substring(0, str2.lastIndexOf("/"));
        }
        return str2 + "/" + str;
    }
}
