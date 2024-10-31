package com.flurry.sdk;

import java.io.Closeable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public final class bb {

    /* renamed from: a, reason: collision with root package name */
    private static final String f475a = bb.class.getSimpleName();

    public static String a(String str) {
        return a(str, 255);
    }

    public static String a(String str, int i) {
        if (str == null) {
            return "";
        }
        return str.length() > i ? str.substring(0, i) : str;
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Throwable th) {
            }
        }
    }

    public static byte[] b(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
            messageDigest.update(str.getBytes(), 0, str.length());
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e) {
            as.a(6, f475a, "Unsupported SHA1: " + e.getMessage());
            return null;
        }
    }
}
