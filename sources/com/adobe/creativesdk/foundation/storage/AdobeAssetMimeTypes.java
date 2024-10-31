package com.adobe.creativesdk.foundation.storage;

import java.util.EnumSet;

/* loaded from: classes.dex */
public enum AdobeAssetMimeTypes {
    MIMETYPE_OCTETSTREAM("application/octet-stream"),
    MIMETYPE_SPARKLER("application/vnd.adobe.sparkler.project+dcx"),
    MIMETYPE_SPARKLER_DCXUCF("application/vnd.adobe.sparkler.project+dcxucf"),
    MIMETYPE_PHOTOSHOP("image/vnd.adobe.photoshop"),
    MIMETYPE_JPEG("image/jpeg"),
    MIMETYPE_JPG("image/jpg"),
    MIMETYPE_ILLUSTRATOR("application/illustrator"),
    MIMETYPE_GIF("image/gif"),
    MIMETYPE_PNG("image/png"),
    MIMETYPE_TIFF("image/tiff"),
    MIMETYPE_BMP("image/bmp"),
    MIMETYPE_PDF("application/pdf"),
    MIMETYPE_DMG("application/x-diskcopy"),
    MIMETYPE_DNG("image/x-adobe-dng"),
    MIMETYPE_RAW("image/x-dcraw"),
    MIMETYPE_IMAGE_RAW("image/raw"),
    MIMETYPE_MP4("video/mp4"),
    MIMETYPE_M4V("video/x-m4v"),
    MIMETYPE_QUICKTIME("video/quicktime");

    private String mimeType;

    AdobeAssetMimeTypes(String str) {
        this.mimeType = str;
    }

    public static EnumSet<AdobeAssetMimeTypes> adobeContent() {
        return EnumSet.of(MIMETYPE_ILLUSTRATOR);
    }

    public static EnumSet<AdobeAssetMimeTypes> basicImagesSet() {
        return EnumSet.of(MIMETYPE_TIFF, MIMETYPE_JPEG, MIMETYPE_GIF, MIMETYPE_PNG, MIMETYPE_BMP);
    }

    public String getMimeType() {
        return this.mimeType;
    }
}
