package com.google.firebase.storage.internal;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import java.io.UnsupportedEncodingException;

/* compiled from: com.google.firebase:firebase-storage@@16.0.5 */
/* loaded from: classes2.dex */
public class SlashUtil {
    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (!str.startsWith("/") && !str.endsWith("/") && !str.contains("//")) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("/", -1)) {
            if (!TextUtils.isEmpty(str2)) {
                if (sb.length() > 0) {
                    sb.append("/");
                    sb.append(str2);
                } else {
                    sb.append(str2);
                }
            }
        }
        return sb.toString();
    }

    public static String b(String str) throws UnsupportedEncodingException {
        return TextUtils.isEmpty(str) ? "" : c(Uri.encode(str));
    }

    public static String c(String str) {
        Preconditions.a(str);
        return str.replace("%2F", "/");
    }

    public static String d(String str) {
        Preconditions.a(str);
        return str.replace("/", "%2F");
    }
}
