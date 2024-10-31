package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCollaborationSession.java */
/* loaded from: classes.dex */
public /* synthetic */ class e {

    /* renamed from: a */
    static final /* synthetic */ int[] f4996a = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f4996a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS2.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4996a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4996a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4996a[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4996a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
