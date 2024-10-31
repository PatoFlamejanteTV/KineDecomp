package com.adobe.creativesdk.foundation.adobeinternal.storage.library;

import com.adobe.creativesdk.foundation.internal.utils.AdobeCSDKException;
import com.adobe.creativesdk.foundation.storage.AdobeCollaborationType;
import com.adobe.creativesdk.foundation.storage.C0614ub;
import com.adobe.creativesdk.foundation.storage.C0622wb;
import com.adobe.creativesdk.foundation.storage.Gb;
import com.adobe.creativesdk.foundation.storage.Hb;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AdobeLibraryAnalyticsReporter.java */
/* renamed from: com.adobe.creativesdk.foundation.adobeinternal.storage.library.t, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0290t {
    public static void a(AdobeCSDKException adobeCSDKException) {
        if (com.adobe.creativesdk.foundation.internal.analytics.r.a().b().booleanValue()) {
            HashMap hashMap = new HashMap();
            hashMap.put("adb.event.eventInfo.eventAction", adobeCSDKException.getDescription());
            a("General Error", hashMap);
        }
    }

    public static void a(String str, C0614ub c0614ub, C0622wb c0622wb, Hb hb, JSONObject jSONObject, AdobeCSDKException adobeCSDKException) {
        if (com.adobe.creativesdk.foundation.internal.analytics.r.a().b().booleanValue()) {
            if (adobeCSDKException != null) {
                a(adobeCSDKException);
                return;
            }
            if (str == null) {
                return;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("adb.event.eventInfo.eventAction", str);
            hashMap.put("adb.user.profile.attributes.LibraryAction", true);
            hashMap.put("adb.user.profile.attributes.LibraryActionDescription", str);
            if (c0614ub != null) {
                if (c0614ub.k() != null) {
                    hashMap.put("adb.user.profile.attributes.libraryID", c0614ub.k());
                }
                hashMap.put("adb.user.profile.attributes.libraryElementCount", Integer.valueOf(c0614ub.n()));
                if (c0614ub.f() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDBYUSER) {
                    hashMap.put("adb.user.profile.attributes.libraryShared", "outgoing");
                } else if (c0614ub.f() == AdobeCollaborationType.ADOBE_COLLABORATION_TYPE_SHAREDWITHUSER) {
                    hashMap.put("adb.user.profile.attributes.libraryShared", "incoming");
                }
            }
            if (c0622wb != null) {
                if (c0622wb.c() != null) {
                    hashMap.put("adb.user.profile.attributes.elementID", c0622wb.c());
                }
                if (c0622wb.j() != null) {
                    hashMap.put("adb.user.profile.attributes.elementType", ia.c(c0622wb.j()));
                }
            }
            if (hb != null && hb.m() != null) {
                hashMap.put("adb.user.profile.attributes.representationType", hb.m());
            }
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    Object opt = jSONObject.opt(next);
                    if (opt != null) {
                        hashMap.put(String.format("%s.%s", "adb.user.profile.attributes", next), opt);
                    }
                }
            }
            a("Library Action", hashMap);
        }
    }

    static void a(String str, Map<String, Object> map) {
        map.put("adb.user.profile.attributes.pcOffline", !Gb.f().k() || !Gb.f().j() ? "Y" : "N");
        map.put("adb.page.pageInfo.SDKsUtilized", "Project Central");
        com.adobe.creativesdk.foundation.internal.analytics.q.a(str, null, map);
    }
}
