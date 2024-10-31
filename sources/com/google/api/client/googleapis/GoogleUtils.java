package com.google.api.client.googleapis;

/* loaded from: classes.dex */
public final class GoogleUtils {

    /* renamed from: a, reason: collision with root package name */
    public static final Integer f2424a = 1;
    public static final Integer b = 20;
    public static final Integer c = 0;
    public static final String d;

    static {
        String valueOf = String.valueOf(String.valueOf(f2424a));
        String valueOf2 = String.valueOf(String.valueOf(b));
        String valueOf3 = String.valueOf(String.valueOf(c));
        d = new StringBuilder(valueOf.length() + 2 + valueOf2.length() + valueOf3.length()).append(valueOf).append(".").append(valueOf2).append(".").append(valueOf3).toString().toString();
    }

    private GoogleUtils() {
    }
}
