package com.adobe.creativesdk.foundation.internal.auth;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeAuthIdentityManagementService.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.auth.i, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public /* synthetic */ class C0305i {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f4889a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f4890b = new int[AdobeAuthIMSEnvironment.values().length];

    static {
        try {
            f4890b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4890b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4890b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS2.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4890b[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4890b[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        f4889a = new int[AdobeAuthIdentityManagementService.TokenType.values().length];
        try {
            f4889a[AdobeAuthIdentityManagementService.TokenType.DeviceToken.ordinal()] = 1;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4889a[AdobeAuthIdentityManagementService.TokenType.AccessToken.ordinal()] = 2;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4889a[AdobeAuthIdentityManagementService.TokenType.RefreshToken.ordinal()] = 3;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
