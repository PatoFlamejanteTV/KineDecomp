package com.google.api.client.util;

/* loaded from: classes2.dex */
public class Base64 {
    private Base64() {
    }

    public static byte[] a(byte[] bArr) {
        return org.apache.commons.codec.binary.Base64.encodeBase64(bArr);
    }

    public static String b(byte[] bArr) {
        return org.apache.commons.codec.binary.Base64.encodeBase64String(bArr);
    }

    public static String c(byte[] bArr) {
        return org.apache.commons.codec.binary.Base64.encodeBase64URLSafeString(bArr);
    }

    public static byte[] a(String str) {
        return org.apache.commons.codec.binary.Base64.decodeBase64(str);
    }
}
