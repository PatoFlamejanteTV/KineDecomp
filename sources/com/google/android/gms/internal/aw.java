package com.google.android.gms.internal;

import com.facebook.appevents.AppEventsConstants;
import java.util.HashMap;

/* loaded from: classes.dex */
class aw implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1437a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ boolean e;
    final /* synthetic */ zzdv f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(zzdv zzdvVar, String str, String str2, int i, int i2, boolean z) {
        this.f = zzdvVar;
        this.f1437a = str;
        this.b = str2;
        this.c = i;
        this.d = i2;
        this.e = z;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheProgress");
        hashMap.put("src", this.f1437a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("bytesLoaded", Integer.toString(this.c));
        hashMap.put("totalBytes", Integer.toString(this.d));
        hashMap.put("cacheReady", this.e ? AppEventsConstants.EVENT_PARAM_VALUE_YES : AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.f.zzoM.zzb("onPrecacheEvent", hashMap);
    }
}
