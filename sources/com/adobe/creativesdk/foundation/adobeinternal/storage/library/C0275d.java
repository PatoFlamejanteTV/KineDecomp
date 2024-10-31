package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.storage.AdobeAssetPackagePages;

/* compiled from: AdobeAssetProductFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.d */
/* loaded from: classes.dex */
/* synthetic */ class C0275d {

    /* renamed from: a */
    static final /* synthetic */ int[] f4598a;

    /* renamed from: b */
    static final /* synthetic */ int[] f4599b = new int[AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.values().length];

    static {
        try {
            f4599b[AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.AdobeAssetPackageSharedProjectTypeSinglePage.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f4599b[AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.AdobeAssetPackageSharedProjectTypeMultiPage.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f4599b[AdobeAssetPackagePages.AdobeAssetPackageSharedProjectType.AdobeAssetPackageSharedProjectTypeMaxDemo.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        f4598a = new int[AdobeAssetProduct.values().length];
        try {
            f4598a[AdobeAssetProduct.AdobeAssetProductComposition.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f4598a[AdobeAssetProduct.AdobeAssetProductDraw.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f4598a[AdobeAssetProduct.AdobeAssetProductPSMix.ordinal()] = 3;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f4598a[AdobeAssetProduct.AdobeAssetProductPSFix.ordinal()] = 4;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f4598a[AdobeAssetProduct.AdobeAssetProductSketch.ordinal()] = 5;
        } catch (NoSuchFieldError unused8) {
        }
    }
}
