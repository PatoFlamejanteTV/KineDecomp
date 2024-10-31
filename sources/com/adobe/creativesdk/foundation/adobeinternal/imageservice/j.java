package com.adobe.creativesdk.foundation.adobeinternal.imageservice;

import com.adobe.creativesdk.foundation.adobeinternal.storage.agc.AdobeAGCCreationType;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeImageSession.java */
/* loaded from: classes.dex */
public /* synthetic */ class j {

    /* renamed from: a */
    static final /* synthetic */ int[] f4019a;

    /* renamed from: b */
    static final /* synthetic */ int[] f4020b;

    /* renamed from: c */
    static final /* synthetic */ int[] f4021c;

    /* renamed from: d */
    static final /* synthetic */ int[] f4022d;

    /* renamed from: e */
    static final /* synthetic */ int[] f4023e;

    /* renamed from: f */
    static final /* synthetic */ int[] f4024f;

    /* renamed from: g */
    static final /* synthetic */ int[] f4025g;

    /* renamed from: h */
    static final /* synthetic */ int[] f4026h = new int[AdobeAGCCreationType.values().length];

    static {
        try {
            f4026h[AdobeAGCCreationType.ADOBE_AGC_CREATION_TYPE_AI.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4026h[AdobeAGCCreationType.ADOBE_AGC_CREATION_TYPE_PSD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4026h[AdobeAGCCreationType.ADOBE_AGC_CREATION_TYPE_UNKNOWN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f4025g = new int[AdobeImageFitType.values().length];
        try {
            f4025g[AdobeImageFitType.AdobeImageFit.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageConstrain.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageCrop.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageWrap.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageStretch.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageHFit.ordinal()] = 6;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f4025g[AdobeImageFitType.AdobeImageVFit.ordinal()] = 7;
        } catch (NoSuchFieldError unused10) {
        }
        f4024f = new int[AdobeImageFillType.values().length];
        try {
            f4024f[AdobeImageFillType.AdobeImageRegularFill.ordinal()] = 1;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f4024f[AdobeImageFillType.AdobeImageGBFill.ordinal()] = 2;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f4024f[AdobeImageFillType.AdobeImageGBLFill.ordinal()] = 3;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f4024f[AdobeImageFillType.AdobeImageLBCFill.ordinal()] = 4;
        } catch (NoSuchFieldError unused14) {
        }
        f4023e = new int[AdobeImageCropType.values().length];
        try {
            f4023e[AdobeImageCropType.AdobeImageNoCrop.ordinal()] = 1;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f4023e[AdobeImageCropType.AdobeImageCropToFit.ordinal()] = 2;
        } catch (NoSuchFieldError unused16) {
        }
        try {
            f4023e[AdobeImageCropType.AdobeImageSmartFillCrop.ordinal()] = 3;
        } catch (NoSuchFieldError unused17) {
        }
        f4022d = new int[AdobeImageCalibrateType.values().length];
        try {
            f4022d[AdobeImageCalibrateType.AdobeImageCalibrateAll.ordinal()] = 1;
        } catch (NoSuchFieldError unused18) {
        }
        try {
            f4022d[AdobeImageCalibrateType.AdobeImageCalibrateAllFixCop.ordinal()] = 2;
        } catch (NoSuchFieldError unused19) {
        }
        try {
            f4022d[AdobeImageCalibrateType.AdobeImageCalibrateAllFixK.ordinal()] = 3;
        } catch (NoSuchFieldError unused20) {
        }
        f4021c = new int[AdobeImageAdjustType.values().length];
        try {
            f4021c[AdobeImageAdjustType.AdobeImageFullAdjust.ordinal()] = 1;
        } catch (NoSuchFieldError unused21) {
        }
        try {
            f4021c[AdobeImageAdjustType.AdobeImageEyeLevelAdjust.ordinal()] = 2;
        } catch (NoSuchFieldError unused22) {
        }
        try {
            f4021c[AdobeImageAdjustType.AdobeImageNoPerspectiveAdjust.ordinal()] = 3;
        } catch (NoSuchFieldError unused23) {
        }
        try {
            f4021c[AdobeImageAdjustType.AdobeImageRectificationAdjust.ordinal()] = 4;
        } catch (NoSuchFieldError unused24) {
        }
        try {
            f4021c[AdobeImageAdjustType.AdobeImageAdjustAll.ordinal()] = 5;
        } catch (NoSuchFieldError unused25) {
        }
        f4020b = new int[AdobeImageAutoCropSortType.values().length];
        try {
            f4020b[AdobeImageAutoCropSortType.AdobeImageSortOnAll.ordinal()] = 1;
        } catch (NoSuchFieldError unused26) {
        }
        try {
            f4020b[AdobeImageAutoCropSortType.AdobeImageSortOnComposition.ordinal()] = 2;
        } catch (NoSuchFieldError unused27) {
        }
        try {
            f4020b[AdobeImageAutoCropSortType.AdobeImageSortOnSaliency.ordinal()] = 3;
        } catch (NoSuchFieldError unused28) {
        }
        try {
            f4020b[AdobeImageAutoCropSortType.AdobeImageSortOnCutThrough.ordinal()] = 4;
        } catch (NoSuchFieldError unused29) {
        }
        f4019a = new int[AdobeAuthIMSEnvironment.values().length];
        try {
            f4019a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused30) {
        }
        try {
            f4019a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused31) {
        }
        try {
            f4019a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused32) {
        }
        try {
            f4019a[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 4;
        } catch (NoSuchFieldError unused33) {
        }
    }
}
