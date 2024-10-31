package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.rf */
/* loaded from: classes2.dex */
public final class RunnableC1067rf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12489a;

    /* renamed from: b */
    private final /* synthetic */ String f12490b;

    /* renamed from: c */
    private final /* synthetic */ int f12491c;

    /* renamed from: d */
    private final /* synthetic */ zzbfk f12492d;

    public RunnableC1067rf(zzbfk zzbfkVar, String str, String str2, int i) {
        this.f12492d = zzbfkVar;
        this.f12489a = str;
        this.f12490b = str2;
        this.f12491c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.f12489a);
        hashMap.put("cachedSrc", this.f12490b);
        hashMap.put("totalBytes", Integer.toString(this.f12491c));
        this.f12492d.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
