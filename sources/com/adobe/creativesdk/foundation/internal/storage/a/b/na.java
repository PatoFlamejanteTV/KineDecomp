package com.adobe.creativesdk.foundation.internal.storage.a.b;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeStorageSession.java */
/* loaded from: classes.dex */
public /* synthetic */ class na {

    /* renamed from: a */
    static final /* synthetic */ int[] f5452a = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f5452a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5452a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5452a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5452a[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
