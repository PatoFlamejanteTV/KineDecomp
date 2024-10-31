package com.google.api.client.repackaged.org.apache.commons.codec.binary;

import java.io.UnsupportedEncodingException;
import org.keyczar.Keyczar;

/* loaded from: classes.dex */
public class StringUtils {
    public static byte[] a(String str) {
        return a(str, Keyczar.DEFAULT_ENCODING);
    }

    public static byte[] a(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return str.getBytes(str2);
        } catch (UnsupportedEncodingException e) {
            throw a(str2, e);
        }
    }

    private static IllegalStateException a(String str, UnsupportedEncodingException unsupportedEncodingException) {
        return new IllegalStateException(str + ": " + unsupportedEncodingException);
    }

    public static String a(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        try {
            return new String(bArr, str);
        } catch (UnsupportedEncodingException e) {
            throw a(str, e);
        }
    }

    public static String a(byte[] bArr) {
        return a(bArr, Keyczar.DEFAULT_ENCODING);
    }
}
