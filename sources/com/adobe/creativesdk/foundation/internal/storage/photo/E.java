package com.adobe.creativesdk.foundation.internal.storage.photo;

import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIMSEnvironment;
import com.adobe.creativesdk.foundation.storage.AdobePhotoAssetRendition;
import com.adobe.creativesdk.foundation.storage.AdobePhotoCollection;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobePhotoSession.java */
/* loaded from: classes.dex */
public /* synthetic */ class E {

    /* renamed from: a, reason: collision with root package name */
    static final /* synthetic */ int[] f6651a;

    /* renamed from: b, reason: collision with root package name */
    static final /* synthetic */ int[] f6652b;

    /* renamed from: c, reason: collision with root package name */
    static final /* synthetic */ int[] f6653c = new int[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.values().length];

    static {
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_2048.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_1024.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FAVORITE.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_FULL_SIZE.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_PREVIEW.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL.ordinal()] = 6;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f6653c[AdobePhotoAssetRendition.AdobePhotoAssetRenditionType.ADOBE_PHOTO_ASSET_RENDITION_TYPE_IMAGE_THUMBNAIL_2X.ordinal()] = 7;
        } catch (NoSuchFieldError unused7) {
        }
        f6652b = new int[AdobePhotoCollection.AdobePhotoCollectionFlag.values().length];
        try {
            f6652b[AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_ALL.ordinal()] = 1;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f6652b[AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_PICKED.ordinal()] = 2;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f6652b[AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_UNFLAGGED.ordinal()] = 3;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f6652b[AdobePhotoCollection.AdobePhotoCollectionFlag.ADOBE_PHOTO_COLLECTION_FLAG_REJECTED.ordinal()] = 4;
        } catch (NoSuchFieldError unused11) {
        }
        f6651a = new int[AdobeAuthIMSEnvironment.values().length];
        try {
            f6651a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentProductionUS.ordinal()] = 1;
        } catch (NoSuchFieldError unused12) {
        }
        try {
            f6651a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentStageUS.ordinal()] = 2;
        } catch (NoSuchFieldError unused13) {
        }
        try {
            f6651a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentCloudLabsUS.ordinal()] = 3;
        } catch (NoSuchFieldError unused14) {
        }
        try {
            f6651a[AdobeAuthIMSEnvironment.AdobeAuthIMSEnvironmentTestUS.ordinal()] = 4;
        } catch (NoSuchFieldError unused15) {
        }
        try {
            f6651a[AdobeAuthIMSEnvironment.AdobeAuthIdentityManagementServiceUndefined.ordinal()] = 5;
        } catch (NoSuchFieldError unused16) {
        }
    }
}
