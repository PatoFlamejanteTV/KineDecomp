package com.facebook.appevents;

import com.facebook.appevents.AppEventsLogger;
import com.facebook.internal.Utility;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public final class d implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Map map;
        HashSet hashSet = new HashSet();
        obj = AppEventsLogger.staticLock;
        synchronized (obj) {
            map = AppEventsLogger.stateMap;
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                hashSet.add(((AppEventsLogger.AccessTokenAppIdPair) it.next()).getApplicationId());
            }
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            Utility.queryAppSettings((String) it2.next(), true);
        }
    }
}
