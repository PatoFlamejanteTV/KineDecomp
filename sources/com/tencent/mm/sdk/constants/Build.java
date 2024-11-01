package com.tencent.mm.sdk.constants;

/* loaded from: classes.dex */
public final class Build {
    public static final int EMOJI_SUPPORTED_SDK_INT = 553844737;
    public static final int MIN_SDK_INT = 553713665;
    public static final int MUSIC_DATA_URL_SUPPORTED_SDK_INT = 553910273;
    public static final int OPENID_SUPPORTED_SDK_INT = 570425345;
    public static final int PAY_SUPPORTED_SDK_INT = 570425345;
    public static final int SDK_INT = 570425345;
    public static final String SDK_VERSION_NAME = "android 2.0.1 rev 1";
    public static final int TIMELINE_SUPPORTED_SDK_INT = 553779201;

    private Build() {
        throw new RuntimeException(getClass().getSimpleName() + " should not be instantiated");
    }

    public static int getMajorVersion() {
        return 2;
    }

    public static int getMinorVersion() {
        return 0;
    }
}
