package com.google.android.gms.internal;

import org.json.JSONObject;

/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f1659a;
    final /* synthetic */ JSONObject b;
    final /* synthetic */ zzbd c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(zzbd zzbdVar, String str, JSONObject jSONObject) {
        this.c = zzbdVar;
        this.f1659a = str;
        this.b = jSONObject;
    }

    @Override // java.lang.Runnable
    public void run() {
        zziz zzizVar;
        zzizVar = this.c.zzoM;
        zzizVar.zza(this.f1659a, this.b);
    }
}
