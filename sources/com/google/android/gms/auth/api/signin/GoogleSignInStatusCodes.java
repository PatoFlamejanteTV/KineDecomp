package com.google.android.gms.auth.api.signin;

import com.google.android.gms.common.api.CommonStatusCodes;

/* loaded from: classes.dex */
public final class GoogleSignInStatusCodes extends CommonStatusCodes {
    private GoogleSignInStatusCodes() {
    }

    public static String a(int i) {
        switch (i) {
            case 12500:
                return "A non-recoverable sign in failure occurred";
            case 12501:
                return "Sign in action cancelled";
            case 12502:
                return "Sign-in in progress";
            default:
                return CommonStatusCodes.a(i);
        }
    }
}
