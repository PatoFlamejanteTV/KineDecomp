package com.adobe.creativesdk.foundation.internal.analytics;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* compiled from: AdobeAnalyticsETSSession.java */
/* loaded from: classes.dex */
/* synthetic */ class m {

    /* renamed from: a */
    static final /* synthetic */ int[] f4738a = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f4738a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4738a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4738a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
    }
}
