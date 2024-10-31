package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.pf */
/* loaded from: classes2.dex */
final class RunnableC1040pf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12426a;

    /* renamed from: b */
    private final /* synthetic */ String f12427b;

    /* renamed from: c */
    private final /* synthetic */ int f12428c;

    /* renamed from: d */
    private final /* synthetic */ int f12429d;

    /* renamed from: e */
    private final /* synthetic */ boolean f12430e = false;

    /* renamed from: f */
    private final /* synthetic */ zzbfk f12431f;

    public RunnableC1040pf(zzbfk zzbfkVar, String str, String str2, int i, int i2, boolean z) {
        this.f12431f = zzbfkVar;
        this.f12426a = str;
        this.f12427b = str2;
        this.f12428c = i;
        this.f12429d = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.f12426a);
        hashMap.put("cachedSrc", this.f12427b);
        hashMap.put("bytesLoaded", Integer.toString(this.f12428c));
        hashMap.put("totalBytes", Integer.toString(this.f12429d));
        hashMap.put("cacheReady", this.f12430e ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f12431f.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
