package com.adobe.creativesdk.foundation.adobeinternal.entitlement;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeEntitlementSession.java */
/* loaded from: classes.dex */
public /* synthetic */ class g {

    /* renamed from: a */
    static final /* synthetic */ int[] f3985a = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f3985a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3985a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3985a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3985a[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
