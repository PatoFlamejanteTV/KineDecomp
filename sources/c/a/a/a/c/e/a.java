package c.a.a.a.c.e;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.storage.AdobePhotoErrorCode;
import com.adobe.creativesdk.foundation.storage.AdobePhotoException;
import java.net.URL;
import java.util.HashMap;

/* compiled from: AdobePhotoErrUtils.java */
/* loaded from: classes.dex */
public class a {
    public static AdobePhotoException a(AdobePhotoErrorCode adobePhotoErrorCode, URL url, Object obj, int i, Object obj2) {
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
        return new AdobePhotoException(adobePhotoErrorCode, hashMap, null);
    }
}
