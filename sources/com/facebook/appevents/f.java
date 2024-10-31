package com.facebook.appevents;

import android.content.Context;
import com.facebook.FacebookSdk;
import com.facebook.internal.AttributionIdentifiers;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AppEventCollection.java */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<AccessTokenAppIdPair, y> f9173a = new HashMap<>();

    public synchronized void a(PersistedEvents persistedEvents) {
        if (persistedEvents == null) {
            return;
        }
        for (AccessTokenAppIdPair accessTokenAppIdPair : persistedEvents.keySet()) {
            y b2 = b(accessTokenAppIdPair);
            Iterator<AppEvent> it = persistedEvents.get(accessTokenAppIdPair).iterator();
            while (it.hasNext()) {
                b2.a(it.next());
            }
        }
    }

    public synchronized Set<AccessTokenAppIdPair> b() {
        return this.f9173a.keySet();
    }

    private synchronized y b(AccessTokenAppIdPair accessTokenAppIdPair) {
        y yVar;
        yVar = this.f9173a.get(accessTokenAppIdPair);
        if (yVar == null) {
            Context applicationContext = FacebookSdk.getApplicationContext();
            yVar = new y(AttributionIdentifiers.getAttributionIdentifiers(applicationContext), AppEventsLogger.getAnonymousAppDeviceGUID(applicationContext));
        }
        this.f9173a.put(accessTokenAppIdPair, yVar);
        return yVar;
    }

    public synchronized void a(AccessTokenAppIdPair accessTokenAppIdPair, AppEvent appEvent) {
        b(accessTokenAppIdPair).a(appEvent);
    }

    public synchronized y a(AccessTokenAppIdPair accessTokenAppIdPair) {
        return this.f9173a.get(accessTokenAppIdPair);
    }

    public synchronized int a() {
        int i;
        i = 0;
        Iterator<y> it = this.f9173a.values().iterator();
        while (it.hasNext()) {
            i += it.next().a();
        }
        return i;
    }
}
