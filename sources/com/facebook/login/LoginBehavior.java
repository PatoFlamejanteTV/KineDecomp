package com.facebook.login;

/* loaded from: classes.dex */
public enum LoginBehavior {
    NATIVE_WITH_FALLBACK(true, true, true, false, true, true),
    NATIVE_ONLY(true, true, false, false, false, true),
    KATANA_ONLY(false, true, false, false, false, false),
    WEB_ONLY(false, false, true, false, true, false),
    WEB_VIEW_ONLY(false, false, true, false, false, false),
    DEVICE_AUTH(false, false, false, true, false, false);

    private final boolean allowsCustomTabAuth;
    private final boolean allowsDeviceAuth;
    private final boolean allowsFacebookLiteAuth;
    private final boolean allowsGetTokenAuth;
    private final boolean allowsKatanaAuth;
    private final boolean allowsWebViewAuth;

    LoginBehavior(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        this.allowsGetTokenAuth = z;
        this.allowsKatanaAuth = z2;
        this.allowsWebViewAuth = z3;
        this.allowsDeviceAuth = z4;
        this.allowsCustomTabAuth = z5;
        this.allowsFacebookLiteAuth = z6;
    }

    public boolean allowsCustomTabAuth() {
        return this.allowsCustomTabAuth;
    }

    public boolean allowsDeviceAuth() {
        return this.allowsDeviceAuth;
    }

    public boolean allowsFacebookLiteAuth() {
        return this.allowsFacebookLiteAuth;
    }

    public boolean allowsGetTokenAuth() {
        return this.allowsGetTokenAuth;
    }

    public boolean allowsKatanaAuth() {
        return this.allowsKatanaAuth;
    }

    public boolean allowsWebViewAuth() {
        return this.allowsWebViewAuth;
    }
}
