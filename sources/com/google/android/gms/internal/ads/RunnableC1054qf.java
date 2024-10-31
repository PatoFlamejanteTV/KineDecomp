package com.google.android.gms.internal.ads;

import android.support.v4.app.NotificationCompat;
import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.ads.qf */
/* loaded from: classes2.dex */
public final class RunnableC1054qf implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ String f12456a;

    /* renamed from: b */
    private final /* synthetic */ String f12457b;

    /* renamed from: c */
    private final /* synthetic */ long f12458c;

    /* renamed from: d */
    private final /* synthetic */ long f12459d;

    /* renamed from: e */
    private final /* synthetic */ boolean f12460e;

    /* renamed from: f */
    private final /* synthetic */ int f12461f;

    /* renamed from: g */
    private final /* synthetic */ int f12462g;

    /* renamed from: h */
    private final /* synthetic */ zzbfk f12463h;

    public RunnableC1054qf(zzbfk zzbfkVar, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.f12463h = zzbfkVar;
        this.f12456a = str;
        this.f12457b = str2;
        this.f12458c = j;
        this.f12459d = j2;
        this.f12460e = z;
        this.f12461f = i;
        this.f12462g = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put("src", this.f12456a);
        hashMap.put("cachedSrc", this.f12457b);
        hashMap.put("bufferedDuration", Long.toString(this.f12458c));
        hashMap.put("totalDuration", Long.toString(this.f12459d));
        hashMap.put("cacheReady", this.f12460e ? "1" : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        hashMap.put("playerCount", Integer.toString(this.f12461f));
        hashMap.put("playerPreparedCount", Integer.toString(this.f12462g));
        this.f12463h.zza("onPrecacheEvent", (Map<String, String>) hashMap);
    }
}
