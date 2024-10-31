package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.sf */
/* loaded from: classes2.dex */
public final class RunnableC1081sf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12518a;

    /* renamed from: b */
    private final /* synthetic */ String f12519b;

    /* renamed from: c */
    private final /* synthetic */ long f12520c;

    /* renamed from: d */
    private final /* synthetic */ zzbfk f12521d;

    public RunnableC1081sf(zzbfk zzbfkVar, String str, String str2, long j) {
        this.f12521d = zzbfkVar;
        this.f12518a = str;
        this.f12519b = str2;
        this.f12520c = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put("src", this.f12518a);
        hashMap.put("cachedSrc", this.f12519b);
        hashMap.put("totalDuration", Long.toString(this.f12520c));
        this.f12521d.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
