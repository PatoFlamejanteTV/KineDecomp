package com.adobe.creativesdk.foundation.internal.storage.controllers.c;

import com.adobe.creativesdk.foundation.internal.notification.AdobeInternalNotificationID;
import com.adobe.creativesdk.foundation.internal.notification.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observer;

/* compiled from: AdobeInternalNotificationListener.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: c */
    private Observer f5969c = new a(this);

    /* renamed from: a */
    private Map<AdobeInternalNotificationID, ArrayList<c>> f5967a = new HashMap();

    /* renamed from: b */
    private Map<AdobeInternalNotificationID, Observer> f5968b = new HashMap();

    public void c(AdobeInternalNotificationID adobeInternalNotificationID) {
        this.f5968b.remove(adobeInternalNotificationID);
    }

    public void a(AdobeInternalNotificationID adobeInternalNotificationID, Observer observer) {
        this.f5968b.put(adobeInternalNotificationID, observer);
        com.adobe.creativesdk.foundation.internal.notification.b.a().a(adobeInternalNotificationID, this.f5969c);
    }

    public List<c> b(AdobeInternalNotificationID adobeInternalNotificationID) {
        return this.f5967a.get(adobeInternalNotificationID);
    }

    public void a(AdobeInternalNotificationID adobeInternalNotificationID) {
        Map<AdobeInternalNotificationID, ArrayList<c>> map = this.f5967a;
        if (map != null) {
            map.remove(adobeInternalNotificationID);
        }
    }
}
