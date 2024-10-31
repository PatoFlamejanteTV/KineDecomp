package com.google.android.gms.ads.internal.gmsg;

import com.google.android.gms.internal.ads.zzbbd;
import org.json.JSONObject;

/* loaded from: classes.dex */
final class p implements Runnable {

    /* renamed from: a */
    private final /* synthetic */ JSONObject f10055a;

    /* renamed from: b */
    private final /* synthetic */ o f10056b;

    public p(o oVar, JSONObject jSONObject) {
        this.f10056b = oVar;
        this.f10055a = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f10056b.f10053b.zza("fetchHttpRequestCompleted", this.f10055a);
        zzbbd.zzdn("Dispatched http response.");
    }
}
