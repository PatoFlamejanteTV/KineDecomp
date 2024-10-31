package c.a.a.a.c.b;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.HashMap;

/* compiled from: AdobeEntitlementErrorUtils.java */
/* loaded from: classes.dex */
public class a {
    public static AdobeEntitlementException a(AdobeEntitlementErrorCode adobeEntitlementErrorCode, Exception exc, String str, String str2) {
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put(AdobeCSDKException.AdobeErrorPathKey, str);
        }
        return new AdobeEntitlementException(adobeEntitlementErrorCode, str2, hashMap, exc);
    }
}
