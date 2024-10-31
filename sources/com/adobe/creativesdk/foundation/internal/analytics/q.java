package com.adobe.creativesdk.foundation.internal.analytics;

import java.util.HashMap;
import java.util.Map;

/* compiled from: AdobeAnalyticsSDKReporter.java */
/* loaded from: classes.dex */
public class q {
    public static synchronized void a(String str, String str2) {
        synchronized (q.class) {
            HashMap hashMap = new HashMap(20);
            hashMap.put("adb.event.eventInfo.eventAction", str);
            a("Auth Step", null, hashMap);
        }
    }

    public static synchronized void b(String str, String str2) {
        synchronized (q.class) {
            HashMap hashMap = new HashMap(20);
            hashMap.put("adb.event.eventInfo.eventAction", str);
            hashMap.put("adb.event.eventInfo.type", str2);
            a("Sharing Action", null, hashMap);
        }
    }

    public static synchronized void a(String str) {
        synchronized (q.class) {
            HashMap hashMap = new HashMap(20);
            hashMap.put("adb.event.eventInfo.eventAction", str);
            a("Asset Browser Action", null, hashMap);
        }
    }

    public static synchronized void a(String str, Map<String, String> map, Map<String, Object> map2) {
        synchronized (q.class) {
            if (map2 == null) {
                map2 = new HashMap<>(20);
            }
            map2.put("adb.event.eventInfo.eventName", str);
            p.a(str, map, map2);
            r.a().a(str, map2);
        }
    }
}
