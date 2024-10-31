package com.adobe.creativesdk.foundation.internal.collaboration;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: AdobeCollaborationErrUtils.java */
/* loaded from: classes.dex */
public class a {
    public static AdobeCollaborationException a(AdobeCollaborationErrorCode adobeCollaborationErrorCode, String str, String str2) {
        if (str != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("ADOBE_ASSET_DETAILS_STRING_KEY", str);
            return new AdobeCollaborationException(adobeCollaborationErrorCode, hashMap, null);
        }
        return new AdobeCollaborationException(adobeCollaborationErrorCode, null, str2);
    }

    public static AdobeCollaborationException a(AdobeCollaborationErrorCode adobeCollaborationErrorCode, URL url, Object obj, int i, Object obj2) {
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
        return new AdobeCollaborationException(adobeCollaborationErrorCode, hashMap, null);
    }
}
