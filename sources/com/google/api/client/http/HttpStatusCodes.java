package com.google.api.client.http;

/* loaded from: classes.dex */
public class HttpStatusCodes {
    public static boolean a(int i) {
        return i >= 200 && i < 300;
    }

    public static boolean b(int i) {
        switch (i) {
            case 301:
            case 302:
            case 303:
            case 307:
                return true;
            case 304:
            case 305:
            case 306:
            default:
                return false;
        }
    }
}
