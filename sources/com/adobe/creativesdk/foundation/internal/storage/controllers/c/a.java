package com.adobe.creativesdk.foundation.internal.storage.controllers.c;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.notification.c;
import java.util.ArrayList;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeInternalNotificationListener.java */
/* loaded from: classes.dex */
public class a implements Observer {

    /* renamed from: a */
    final /* synthetic */ b f5966a;

    public a(b bVar) {
        this.f5966a = bVar;
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Map map;
        Map map2;
        Map map3;
        c cVar = (c) obj;
        AdobeInternalNotificationID adobeInternalNotificationID = (AdobeInternalNotificationID) cVar.a();
        map = this.f5966a.f5968b;
        Observer observer = (Observer) map.get(adobeInternalNotificationID);
        if (observer == null) {
            map2 = this.f5966a.f5967a;
            ArrayList arrayList = (ArrayList) map2.get(adobeInternalNotificationID);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            arrayList.add(cVar);
            map3 = this.f5966a.f5967a;
            map3.put(adobeInternalNotificationID, arrayList);
            return;
        }
        observer.update(observable, obj);
    }
}
