package com.google.android.gms.cast.internal;

import android.text.TextUtils;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class zzf {

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f854a = Pattern.compile("urn:x-cast:[-A-Za-z0-9_]+(\\.[-A-Za-z0-9_]+)*");

    public static long a(double d) {
        return (long) (1000.0d * d);
    }

    public static String a(Locale locale) {
        StringBuilder sb = new StringBuilder(20);
        sb.append(locale.getLanguage());
        String country = locale.getCountry();
        if (!TextUtils.isEmpty(country)) {
            sb.append('-').append(country);
        }
        String variant = locale.getVariant();
        if (!TextUtils.isEmpty(variant)) {
            sb.append('-').append(variant);
        }
        return sb.toString();
    }

    public static void a(String str) throws IllegalArgumentException {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Namespace cannot be null or empty");
        }
        if (str.length() > 128) {
            throw new IllegalArgumentException("Invalid namespace length");
        }
        if (!str.startsWith("urn:x-cast:")) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\"");
        }
        if (str.length() == "urn:x-cast:".length()) {
            throw new IllegalArgumentException("Namespace must begin with the prefix \"urn:x-cast:\" and have non-empty suffix");
        }
    }

    public static <T> boolean a(T t, T t2) {
        return (t == null && t2 == null) || !(t == null || t2 == null || !t.equals(t2));
    }

    public static String b(String str) {
        return "urn:x-cast:" + str;
    }
}
