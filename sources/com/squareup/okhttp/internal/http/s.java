package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.E;
import com.squareup.okhttp.HttpUrl;
import java.net.Proxy;

/* compiled from: RequestLine.java */
/* loaded from: classes3.dex */
public final class s {
    public static String a(E e2, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(e2.f());
        sb.append(' ');
        if (b(e2, type)) {
            sb.append(e2.d());
        } else {
            sb.append(a(e2.d()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    private static boolean b(E e2, Proxy.Type type) {
        return !e2.e() && type == Proxy.Type.HTTP;
    }

    public static String a(HttpUrl httpUrl) {
        String c2 = httpUrl.c();
        String e2 = httpUrl.e();
        if (e2 == null) {
            return c2;
        }
        return c2 + '?' + e2;
    }
}
