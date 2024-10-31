package com.facebook.appevents;

import com.facebook.internal.FetchedAppSettingsManager;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventsLogger.java */
/* loaded from: classes.dex */
public class s implements Runnable {
    @Override // java.lang.Runnable
    public void run() {
        HashSet hashSet = new HashSet();
        Iterator<AccessTokenAppIdPair> it = m.e().iterator();
        while (it.hasNext()) {
            hashSet.add(it.next().getApplicationId());
        }
        Iterator it2 = hashSet.iterator();
        while (it2.hasNext()) {
            FetchedAppSettingsManager.queryAppSettings((String) it2.next(), true);
        }
    }
}
