package com.adobe.creativesdk.foundation.adobeinternal.cloud;

import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementErrorCode;
import com.adobe.creativesdk.foundation.adobeinternal.entitlement.AdobeEntitlementException;
import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AdobeCloudUtils.java */
/* loaded from: classes.dex */
public class h {
    public static boolean a(JSONObject jSONObject, List<AdobeCloud> list) throws AdobeCSDKException {
        if (jSONObject != null) {
            boolean optBoolean = jSONObject.optBoolean("public_cloud", true);
            if (c.a.a.a.a.a.a.b().d()) {
                if (jSONObject.opt("endpoints") != null) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("endpoints");
                    if (optJSONArray.optJSONArray(0) != null) {
                        optJSONArray = optJSONArray.optJSONArray(0);
                    }
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        AdobeCloud adobeCloud = new AdobeCloud();
                        if (optJSONObject != null && adobeCloud.updateFromDictionary(optJSONObject)) {
                            if ((!adobeCloud.isPrivateCloud() ? optBoolean : true) && !list.contains(adobeCloud)) {
                                list.add(adobeCloud);
                            } else {
                                ArrayList arrayList = new ArrayList(list);
                                for (AdobeCloud adobeCloud2 : list) {
                                    if (!adobeCloud2.isStrictlyEqual(adobeCloud)) {
                                        arrayList.remove(adobeCloud2);
                                        arrayList.add(adobeCloud);
                                    }
                                }
                                list.clear();
                                list.addAll(arrayList);
                            }
                        }
                    }
                } else {
                    if (jSONObject.opt("endpoints") == null) {
                        throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorNoCloudsAvailable, "No clouds are available for this user.");
                    }
                    throw new AdobeEntitlementException(AdobeEntitlementErrorCode.AdobeEntitlementErrorUnexpectedResponse, "Query for clouds returned an unexpected response.");
                }
            } else {
                AdobeCloud adobeCloud3 = new AdobeCloud();
                adobeCloud3.setGUID("00000000-0000-0000-0000-000000000000");
                adobeCloud3.setName("Adobe Creative Cloud");
                adobeCloud3.setAvailable(true);
                adobeCloud3.setPrivateCloud(false);
                if (!list.contains(adobeCloud3)) {
                    list.add(adobeCloud3);
                }
            }
        }
        return true;
    }

    public static boolean a(AdobeCloud adobeCloud) {
        AdobeCloudEndpoint adobeCloudEndpoint;
        Map<AdobeCloudServiceType, AdobeCloudEndpoint> endpoints = adobeCloud.getEndpoints();
        return (endpoints == null || endpoints.size() == 0 || (adobeCloudEndpoint = endpoints.get(AdobeCloudServiceType.AdobeCloudServiceTypeStorage)) == null || adobeCloudEndpoint.getServiceURLs().size() == 0 || adobeCloudEndpoint.getServiceURLs().size() == 0) ? false : true;
    }

    public static boolean a(List<AdobeCloud> list, List<AdobeCloud> list2) {
        int indexOf;
        boolean z = list.size() == list2.size();
        if (z) {
            for (AdobeCloud adobeCloud : list) {
                if (!list2.contains(adobeCloud) || (indexOf = list2.indexOf(adobeCloud)) == -1 || !list2.get(indexOf).isStrictlyEqual(adobeCloud)) {
                    return false;
                }
            }
        }
        return z;
    }
}
