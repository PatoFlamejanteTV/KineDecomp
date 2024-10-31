package com.adobe.creativesdk.foundation.storage;

import org.json.JSONObject;

/* compiled from: AdobeAssetFolder.java */
/* renamed from: com.adobe.creativesdk.foundation.storage.ga */
/* loaded from: classes.dex */
class RunnableC0558ga implements Runnable {

    /* renamed from: a */
    final /* synthetic */ JSONObject f7259a;

    /* renamed from: b */
    final /* synthetic */ RunnableC0562ha f7260b;

    public RunnableC0558ga(RunnableC0562ha runnableC0562ha, JSONObject jSONObject) {
        this.f7260b = runnableC0562ha;
        this.f7259a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f7260b.f7273b.f7287c.b(this.f7259a);
    }
}
