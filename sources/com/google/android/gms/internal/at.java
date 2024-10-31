package com.google.android.gms.internal;

import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class at implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Map f1434a;
    final /* synthetic */ zziz b;
    final /* synthetic */ zzdl c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(zzdl zzdlVar, Map map, zziz zzizVar) {
        this.c = zzdlVar;
        this.f1434a = map;
        this.b = zzizVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.google.android.gms.ads.internal.util.client.zzb.a("Received Http request.");
        JSONObject zzX = this.c.zzX((String) this.f1434a.get("http_request"));
        if (zzX == null) {
            com.google.android.gms.ads.internal.util.client.zzb.b("Response should not be null.");
        } else {
            zzid.zzIE.post(new au(this, zzX));
        }
    }
}
