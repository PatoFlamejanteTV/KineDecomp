package com.adobe.creativesdk.foundation.internal.analytics;

import android.content.res.Resources;
import com.adobe.creativesdk.foundation.internal.auth.AdobeAuthIdentityManagementService;
import com.adobe.creativesdk.foundation.internal.utils.w;
import com.facebook.internal.NativeProtocol;
import java.util.Map;

/* compiled from: AdobeAnalyticsGlobalData.java */
/* loaded from: classes.dex */
public class p {
    public static void a(String str, Map<String, String> map, Map<String, Object> map2) {
        String e2 = AdobeAuthIdentityManagementService.K().e();
        String h2 = AdobeAuthIdentityManagementService.K().h();
        map2.put("adb.user.profile.profileId", e2);
        map2.put("adb.page.pageInfo.productcategory", "mobile");
        map2.put("adb.user.profile.attributes.clientId", h2);
        map2.put("adb.page.pageInfo.productversion", w.e());
        map2.put("adb.page.pageInfo.language", Resources.getSystem().getConfiguration().locale.getDisplayLanguage());
        map2.put("adb.event.eventInfo.eventName", str);
        map2.put("adb.event.eventInfo.eventeventcategory", "");
        map2.put("adb.mobile.event.name", "");
        if (map != null) {
            if (map.containsKey("area")) {
                map2.put("adb.mobile.event.area", map.get("area"));
            }
            if (map.containsKey("type")) {
                map2.put("adb.mobile.event.type", map.get("type"));
            }
            if (map.containsKey(NativeProtocol.WEB_DIALOG_ACTION)) {
                map2.put("adb.mobile.event.action", map.get(NativeProtocol.WEB_DIALOG_ACTION));
            }
            if (map.containsKey("assetName")) {
                map2.put("adb.event.eventInfo.eventassetname", map.get("assetName"));
            }
            if (map.containsKey("assetID")) {
                map2.put("adb.event.eventInfo.eventassetid", map.get("assetID"));
            }
        }
        a(map2);
    }

    public static void a(Map<String, Object> map) {
        String str;
        com.adobe.creativesdk.foundation.auth.k a2 = com.adobe.creativesdk.foundation.auth.k.a();
        String e2 = AdobeAuthIdentityManagementService.K().e();
        String h2 = AdobeAuthIdentityManagementService.K().h();
        map.put("adb.user.profile.profileId", e2);
        map.put("adb.user.profile.attributes.clientId", h2);
        if (map.get("adb.page.pageInfo.SDKsUtilized") == null) {
            map.put("adb.page.pageInfo.SDKsUtilized", "Creative SDK Android");
        } else {
            map.put("adb.page.pageInfo.SDKsUtilized", map.get("adb.page.pageInfo.SDKsUtilized") + "|Creative SDK Android");
        }
        Boolean valueOf = Boolean.valueOf(a2.c());
        Boolean valueOf2 = Boolean.valueOf(com.adobe.creativesdk.foundation.adobeinternal.net.a.b().b());
        if (valueOf.booleanValue()) {
            str = valueOf2.booleanValue() ? "Logged In : Online" : "Logged In : Offline";
        } else {
            str = valueOf2.booleanValue() ? "Logged Out : Online" : "Logged Out : Offline";
        }
        map.put("adb.user.profile.attributes.authStatus", str);
    }
}
