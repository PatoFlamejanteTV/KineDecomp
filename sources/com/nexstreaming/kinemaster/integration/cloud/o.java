package com.nexstreaming.kinemaster.integration.cloud;

import com.adobe.creativesdk.foundation.auth.AdobeAuthSessionHelper;

/* compiled from: KMCreativeCloud.java */
/* loaded from: classes.dex */
/* synthetic */ class o {

    /* renamed from: a */
    static final /* synthetic */ int[] f20446a = new int[AdobeAuthSessionHelper.AdobeAuthStatus.values().length];

    static {
        try {
            f20446a[AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedIn.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f20446a[AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoginAttemptFailed.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f20446a[AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLoggedOut.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f20446a[AdobeAuthSessionHelper.AdobeAuthStatus.AdobeAuthLogoutAttemptFailed.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
