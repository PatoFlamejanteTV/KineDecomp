package com.google.android.gms.internal;

import org.json.JSONObject;

/* loaded from: classes.dex */
class au implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f1435a;
    final /* synthetic */ at b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public au(at atVar, JSONObject jSONObject) {
        this.b = atVar;
        this.f1435a = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b.zzb("fetchHttpRequestCompleted", this.f1435a);
        com.google.android.gms.ads.internal.util.client.zzb.a("Dispatched http response.");
    }
}
