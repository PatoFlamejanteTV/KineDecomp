package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeCloud.java */
/* loaded from: classes.dex */
public /* synthetic */ class a {

    /* renamed from: a */
    static final /* synthetic */ int[] f3939a;

    /* renamed from: b */
    static final /* synthetic */ int[] f3940b = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f3940b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3940b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3940b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3940b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3940b[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f3939a = new int[AdobeCloudServiceType.values().length];
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeImage.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeMarket.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypePhoto.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeStorage.ordinal()] = 4;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeEntitlement.ordinal()] = 5;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeNotification.ordinal()] = 6;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeClipBoard.ordinal()] = 7;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f3939a[AdobeCloudServiceType.AdobeCloudServiceTypeUnknown.ordinal()] = 8;
        } catch (NoSuchFieldError unused13) {
        }
    }
}
