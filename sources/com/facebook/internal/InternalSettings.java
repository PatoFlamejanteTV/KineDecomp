package com.facebook.internal;

/* loaded from: classes.dex */
public class InternalSettings {
    private static volatile String mCustomUserAgent;

    public static void setCustomUserAgent(String str) {
        mCustomUserAgent = str;
    }

    public static String getCustomUserAgent() {
        return mCustomUserAgent;
    }
}
