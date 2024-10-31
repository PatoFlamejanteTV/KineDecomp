package com.adobe.creativesdk.foundation.adobeinternal.storage.dcx;

/* compiled from: AdobeDCXController.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.ia */
/* loaded from: classes.dex */
/* synthetic */ class C0238ia {

    /* renamed from: a */
    static final /* synthetic */ int[] f4392a;

    /* renamed from: b */
    static final /* synthetic */ int[] f4393b = new int[AdobeDCXSyncPhase.values().length];

    static {
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhasePush.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhaseAccept.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhasePull.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhaseResolve.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhaseDelete.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4393b[AdobeDCXSyncPhase.AdobeDCXSyncPhaseInSync.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        f4392a = new int[AdobeDCXControllerMode.values().length];
        try {
            f4392a[AdobeDCXControllerMode.AdobeDCXControllerSyncing.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4392a[AdobeDCXControllerMode.AdobeDCXControllerPaused.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f4392a[AdobeDCXControllerMode.AdobeDCXControllerStopped.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
    }
}
