package com.adobe.creativesdk.foundation.storage;

/* compiled from: AdobeAssetFileExtensions.java */
/* loaded from: classes.dex */
public class V {
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("image/bmp")) {
            return "bmp";
        }
        if (lowerCase.equals("application/x-diskcopy")) {
            return "dmg";
        }
        if (lowerCase.equals("image/x-adobe-dng")) {
            return "dng";
        }
        if (lowerCase.equals("image/gif")) {
            return "gif";
        }
        if (lowerCase.equals("application/vnd.adobe.indesign-idml-package")) {
            return "idml";
        }
        if (lowerCase.equals("application/vnd.adobe.indesign-idms")) {
            return "idms";
        }
        if (lowerCase.equals("application/illustrator")) {
            return "ai";
        }
        if (lowerCase.equals("application/x-indesign")) {
            return "indd";
        }
        if (lowerCase.equals("image/jpeg")) {
            return "jpg";
        }
        if (lowerCase.equals("video/mp4")) {
            return "mp4";
        }
        if (lowerCase.equals("application/pdf")) {
            return "pdf";
        }
        if (lowerCase.equals("image/vnd.adobe.photoshop")) {
            return "psd";
        }
        if (lowerCase.equals("image/png")) {
            return "png";
        }
        if (lowerCase.equals("application/postscript")) {
            return "eps";
        }
        if (lowerCase.equals("video/quicktime")) {
            return "mov";
        }
        if (lowerCase.equals("image/vnd.adobe.shape+svg")) {
            return "shape";
        }
        if (lowerCase.equals("image/x-adobe-photoshop-brush")) {
            return "abr";
        }
        if (lowerCase.equals("image/svg+xml")) {
            return "svg";
        }
        if (lowerCase.equals("image/tiff")) {
            return "tiff";
        }
        if (lowerCase.equals("application/zip")) {
            return "zip";
        }
        if (lowerCase.equals("application/vnd.adobe.sparkler.project+dcxucf")) {
            return "xd";
        }
        return null;
    }

    public static String b(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.equals("ai")) {
            return "application/illustrator";
        }
        if (lowerCase.equals("ait")) {
            return "application/pdf";
        }
        if (lowerCase.equals("bmp")) {
            return "image/bmp";
        }
        if (lowerCase.equals("dmg")) {
            return "application/x-diskcopy";
        }
        if (lowerCase.equals("dng")) {
            return "image/x-adobe-dng";
        }
        if (lowerCase.equals("eps")) {
            return "application/postscript";
        }
        if (lowerCase.equals("gif")) {
            return "image/gif";
        }
        if (lowerCase.equals("idml")) {
            return "application/vnd.adobe.indesign-idml-package";
        }
        if (lowerCase.equals("idms")) {
            return "application/vnd.adobe.indesign-idms";
        }
        if (lowerCase.equals("indd")) {
            return "application/x-indesign";
        }
        if (lowerCase.equals("indt")) {
            return "application/octet-stream";
        }
        if (lowerCase.equals("mov")) {
            return "video/quicktime";
        }
        if (lowerCase.equals("mp4")) {
            return "video/mp4";
        }
        if (lowerCase.equals("jpg")) {
            return "image/jpeg";
        }
        if (lowerCase.equals("pdf")) {
            return "application/pdf";
        }
        if (lowerCase.equals("psb") || lowerCase.equals("psd")) {
            return "image/vnd.adobe.photoshop";
        }
        if (lowerCase.equals("png")) {
            return "image/png";
        }
        if (lowerCase.equals("shape")) {
            return "image/vnd.adobe.shape+svg";
        }
        if (lowerCase.equals("svg")) {
            return "image/svg+xml";
        }
        if (lowerCase.equals("tiff")) {
            return "image/tiff";
        }
        if (lowerCase.equals("zip")) {
            return "application/zip";
        }
        if (lowerCase.equals("xd")) {
            return "application/vnd.adobe.sparkler.project+dcxucf";
        }
        if (lowerCase.equals("abr")) {
            return "image/x-adobe-photoshop-brush";
        }
        return null;
    }
}
