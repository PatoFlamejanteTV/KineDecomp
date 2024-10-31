package com.squareup.okhttp;

import java.io.UnsupportedEncodingException;
import okio.ByteString;

/* compiled from: Credentials.java */
/* loaded from: classes3.dex */
public final class r {
    public static String a(String str, String str2) {
        try {
            return "Basic " + ByteString.of((str + ":" + str2).getBytes("ISO-8859-1")).base64();
        } catch (UnsupportedEncodingException unused) {
            throw new AssertionError();
        }
    }
}
