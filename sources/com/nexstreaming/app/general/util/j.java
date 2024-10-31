package com.nexstreaming.app.general.util;

import android.content.Context;
import android.text.util.Linkify;
import android.widget.TextView;
import com.umeng.commonsdk.proguard.ap;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: StringUtil.java */
/* loaded from: classes.dex */
public class J {

    /* renamed from: a */
    private static final char[] f19831a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: b */
    private static final char[] f19832b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: c */
    private static final Linkify.TransformFilter f19833c = new I();

    public static String a(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            char[] cArr2 = f19832b;
            cArr[i2] = cArr2[(bArr[i] & 240) >> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & ap.m];
        }
        return new String(cArr);
    }

    public static String b(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = i * 2;
            char[] cArr2 = f19831a;
            cArr[i2] = cArr2[(bArr[i] & 240) >> 4];
            cArr[i2 + 1] = cArr2[bArr[i] & ap.m];
        }
        return new String(cArr);
    }

    public static int a(String str, String str2) {
        if (str == null && str2 == null) {
            return 0;
        }
        if (str == null) {
            return -1;
        }
        if (str2 == null) {
            return 1;
        }
        return str.compareTo(str2);
    }

    private static String b(Context context, Map<String, String> map, String str) {
        String str2;
        Locale locale = context != null ? context.getResources().getConfiguration().locale : null;
        if (map == null) {
            return null;
        }
        if (locale == null) {
            locale = Locale.ENGLISH;
        }
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
        if (str3 != null) {
            return str3;
        }
        String str4 = map.get(lowerCase);
        if (str4 != null) {
            return str4;
        }
        String str5 = map.get("");
        if (str5 != null) {
            return str5;
        }
        String str6 = map.get("en");
        if (str6 != null) {
            return str6;
        }
        String str7 = map.get("en-us");
        return str7 == null ? str : str7;
    }

    public static String a(Context context, Map<String, String> map) {
        return a(context, b(context, map, null));
    }

    public static String a(Context context, Map<String, String> map, String str) {
        return a(context, b(context, map, str));
    }

    private static String a(Context context, String str) {
        int identifier;
        if (str != null && context != null) {
            if (str.startsWith("@string/")) {
                int identifier2 = context.getResources().getIdentifier("string/kedl_" + str.substring(8), "string", context.getPackageName());
                if (identifier2 != 0) {
                    return context.getResources().getString(identifier2);
                }
            } else if (str.startsWith("@") && (identifier = context.getResources().getIdentifier(str.substring(1), "string", context.getPackageName())) != 0) {
                return context.getResources().getString(identifier);
            }
        }
        return str;
    }

    public static String a(Locale locale, String str, float f2) {
        if (str == null) {
            return String.valueOf(f2);
        }
        String[] split = str.split(";");
        if (split.length == 1) {
            return String.format(locale, split[0], Float.valueOf(f2));
        }
        if (split.length == 2) {
            return f2 == 0.0f ? String.format(locale, split[1], Float.valueOf(f2)) : String.format(locale, split[0], Float.valueOf(f2));
        }
        if (split.length >= 3) {
            return f2 == 0.0f ? String.format(locale, split[1], Float.valueOf(f2)) : f2 < 0.0f ? String.format(locale, split[2], Float.valueOf(f2)) : String.format(locale, split[0], Float.valueOf(f2));
        }
        return String.valueOf(f2);
    }

    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return b(messageDigest.digest());
        } catch (NoSuchAlgorithmException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static String a(String[] strArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strArr.length; i++) {
            sb.append(strArr[i]);
            if (i < strArr.length - 1) {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    public static void a(TextView textView, String str, String str2) {
        if (textView.getText().toString().indexOf(str) > -1) {
            Linkify.addLinks(textView, Pattern.compile(str), str2, (Linkify.MatchFilter) null, f19833c);
        }
    }
}
