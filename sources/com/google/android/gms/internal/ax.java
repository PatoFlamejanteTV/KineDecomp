package com.google.android.gms.internal;

import java.util.HashMap;

/* loaded from: classes.dex */
class ax implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1438a;
    final /* synthetic */ String b;
    final /* synthetic */ int c;
    final /* synthetic */ zzdv d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(zzdv zzdvVar, String str, String str2, int i) {
        this.d = zzdvVar;
        this.f1438a = str;
        this.b = str2;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        HashMap hashMap = new HashMap();
        hashMap.put("event", "precacheComplete");
        hashMap.put("src", this.f1438a);
        hashMap.put("cachedSrc", this.b);
        hashMap.put("totalBytes", Integer.toString(this.c));
        this.d.zzoM.zzb("onPrecacheEvent", hashMap);
    }
}
