package com.adobe.creativesdk.foundation.storage;

import android.os.Handler;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ia */
/* loaded from: classes.dex */
public class C0566ia implements c.a.a.a.b<String> {

    /* renamed from: a */
    final /* synthetic */ Handler f7285a;

    /* renamed from: b */
    final /* synthetic */ c.a.a.a.c f7286b;

    /* renamed from: c */
    final /* synthetic */ c.a.a.a.b f7287c;

    /* renamed from: d */
    final /* synthetic */ C0578la f7288d;

    public C0566ia(C0578la c0578la, Handler handler, c.a.a.a.c cVar, c.a.a.a.b bVar) {
        this.f7288d = c0578la;
        this.f7285a = handler;
        this.f7286b = cVar;
        this.f7287c = bVar;
    }

    @Override // c.a.a.a.b
    /* renamed from: a */
    public void b(String str) {
        new Thread(new RunnableC0562ha(this, str)).start();
    }
}
