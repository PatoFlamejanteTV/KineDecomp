package com.adobe.creativesdk.foundation.internal.storage.controllers;

import com.adobe.creativesdk.foundation.internal.storage.controllers.commands.AdobeAssetViewBrowserCommandName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: AdobeAssetBrowserCommandMgr.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.a */
/* loaded from: classes.dex */
public class C0358a {

    /* renamed from: a */
    private static C0358a f5904a;

    /* renamed from: b */
    Map<AdobeAssetViewBrowserCommandName, C0030a> f5905b;

    /* compiled from: AdobeAssetBrowserCommandMgr.java */
    /* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.a$a */
    /* loaded from: classes.dex */
    public class C0030a {

        /* renamed from: a */
        private ArrayList<com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l> f5906a = new ArrayList<>();

        public C0030a() {
        }

        public void a(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l lVar) {
            this.f5906a.add(lVar);
        }

        public void b(com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l lVar) {
            this.f5906a.remove(lVar);
        }

        public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
            Iterator<com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l> it = this.f5906a.iterator();
            while (it.hasNext()) {
                it.next().a(adobeAssetViewBrowserCommandName, obj);
            }
        }
    }

    C0358a() {
        this.f5905b = null;
        this.f5905b = new HashMap();
    }

    public static synchronized C0358a a() {
        C0358a c0358a;
        synchronized (C0358a.class) {
            if (f5904a == null) {
                f5904a = new C0358a();
            }
            c0358a = f5904a;
        }
        return c0358a;
    }

    public synchronized void b(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l lVar) {
        C0030a c0030a = this.f5905b.get(adobeAssetViewBrowserCommandName);
        if (c0030a != null) {
            c0030a.b(lVar);
        }
    }

    public synchronized void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, com.adobe.creativesdk.foundation.internal.storage.controllers.commands.l lVar) {
        C0030a c0030a = this.f5905b.get(adobeAssetViewBrowserCommandName);
        if (c0030a == null) {
            c0030a = new C0030a();
            this.f5905b.put(adobeAssetViewBrowserCommandName, c0030a);
        }
        c0030a.a(lVar);
    }

    public void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName) {
        a(adobeAssetViewBrowserCommandName, (Object) null);
    }

    public synchronized void a(AdobeAssetViewBrowserCommandName adobeAssetViewBrowserCommandName, Object obj) {
        C0030a c0030a = this.f5905b.get(adobeAssetViewBrowserCommandName);
        if (c0030a != null) {
            c0030a.a(adobeAssetViewBrowserCommandName, obj);
        }
    }
}
