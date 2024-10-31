package com.google.android.gms.ads.internal.request;

import com.google.android.gms.internal.zzdz;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f630a;
    final /* synthetic */ String b;
    final /* synthetic */ zzm c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(zzm zzmVar, JSONObject jSONObject, String str) {
        this.c = zzmVar;
        this.f630a = jSONObject;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzdz zzdzVar;
        zzdz.zzd zzdVar;
        zzm zzmVar = this.c;
        zzdzVar = zzm.d;
        zzmVar.l = zzdzVar.zzdO();
        zzdVar = this.c.l;
        zzdVar.zza(new f(this), new g(this));
    }
}
