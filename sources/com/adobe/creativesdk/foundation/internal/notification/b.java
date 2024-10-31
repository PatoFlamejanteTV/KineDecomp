package com.adobe.creativesdk.foundation.internal.notification;

import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

/* compiled from: AdobeLocalNotificationCenter.java */
/* loaded from: classes.dex */
public class b {

    /* renamed from: a */
    private static b f5191a;

    /* renamed from: b */
    Map<d, a> f5192b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AdobeLocalNotificationCenter.java */
    /* loaded from: classes.dex */
    public static class a extends Observable {
        private a() {
        }

        public void a() {
            setChanged();
        }

        /* synthetic */ a(com.adobe.creativesdk.foundation.internal.notification.a aVar) {
            this();
        }
    }

    public b() {
        this.f5192b = null;
        this.f5192b = new HashMap();
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (f5191a == null) {
                f5191a = new b();
            }
            bVar = f5191a;
        }
        return bVar;
    }

    public synchronized void b(d dVar, Observer observer) {
        a aVar = this.f5192b.get(dVar);
        if (aVar != null) {
            aVar.deleteObserver(observer);
        }
    }

    public synchronized void a(d dVar, Observer observer) {
        a aVar = this.f5192b.get(dVar);
        if (aVar == null) {
            aVar = new a();
            this.f5192b.put(dVar, aVar);
        }
        aVar.addObserver(observer);
    }

    public synchronized void a(c cVar) {
        a aVar = this.f5192b.get(cVar.a());
        if (aVar != null) {
            aVar.a();
            aVar.notifyObservers(cVar);
        }
    }
}
