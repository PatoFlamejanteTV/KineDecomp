package com.adobe.creativesdk.foundation.internal.storage.model.util;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.storage.dcx.AdobeDCXException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.network.AdobeNetworkException;
import com.adobe.creativesdk.foundation.storage.AdobeAssetErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobeAssetException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: AdobeStorageErrorUtils.java */
/* loaded from: classes.dex */
public class e {
    public static AdobeAssetException a(AdobeAssetErrorCode adobeAssetErrorCode, URL url, Object obj, int i, Object obj2) {
        if (obj == null) {
            obj = "[no data]";
        }
        HashMap hashMap = new HashMap();
        if (url != null) {
            hashMap.put("AdobeAssetRequestURLString", url);
        }
        hashMap.put(AdobeEntitlementException.AdobeNetworkHTTPStatusKey, Integer.valueOf(i));
        hashMap.put("AdobeAssetResponseData", obj);
        if (obj2 != null) {
            hashMap.put("AdobeAssetResponseHeaders", obj2);
        }
        return new AdobeAssetException(adobeAssetErrorCode, hashMap, null);
    }

    public static void b(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }

    public static AdobeAssetException a(AdobeAssetErrorCode adobeAssetErrorCode, String str) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", str);
            return new AdobeAssetException(adobeAssetErrorCode, hashMap, null);
        }
        return new AdobeAssetException(adobeAssetErrorCode);
    }

    public static AdobeCSDKException a(AdobeCSDKException adobeCSDKException, HashMap<String, Object> hashMap) {
        if (adobeCSDKException.getClass().equals(AdobeNetworkException.class)) {
            return new AdobeNetworkException(((AdobeNetworkException) adobeCSDKException).getErrorCode(), hashMap, null);
        }
        if (adobeCSDKException.getClass().equals(AdobeAssetException.class)) {
            return new AdobeAssetException(((AdobeAssetException) adobeCSDKException).getErrorCode(), hashMap, null);
        }
        if (adobeCSDKException.getClass().equals(AdobeDCXException.class)) {
            return new AdobeDCXException(((AdobeDCXException) adobeCSDKException).getErrorCode(), null, hashMap, null);
        }
        return new AdobeAssetException(AdobeAssetErrorCode.AdobeAssetErrorUnexpectedResponse, hashMap, null);
    }

    public static AdobeDCXException a(AdobeDCXErrorCode adobeDCXErrorCode, String str) {
        return new AdobeDCXException(adobeDCXErrorCode, str, null);
    }

    public static AdobeDCXException a(AdobeDCXErrorCode adobeDCXErrorCode, String str, Exception exc) {
        return new AdobeDCXException(adobeDCXErrorCode, str, exc);
    }

    public static AdobeDCXException a(AdobeDCXErrorCode adobeDCXErrorCode, String str, Exception exc, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AdobeCSDKException.AdobeErrorPathKey, str2);
        return new AdobeDCXException(adobeDCXErrorCode, str, hashMap, exc);
    }

    public static void a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }
}
