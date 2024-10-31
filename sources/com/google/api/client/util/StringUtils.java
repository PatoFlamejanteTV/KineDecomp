package com.google.api.client.util;

/* loaded from: classes2.dex */
public class StringUtils {

    /* renamed from: a */
    public static final String f14981a = System.getProperty("line.separator");

    private StringUtils() {
    }

    public static byte[] a(String str) {
        return org.apache.commons.codec.binary.StringUtils.getBytesUtf8(str);
    }
}
