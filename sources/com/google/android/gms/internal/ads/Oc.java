package com.google.android.gms.internal.ads;

import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public final class Oc implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ JSONObject f11728a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f11729b;

    /* renamed from: c, reason: collision with root package name */
    private final /* synthetic */ zzatd f11730c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Oc(zzatd zzatdVar, JSONObject jSONObject, String str) {
        this.f11730c = zzatdVar;
        this.f11728a = jSONObject;
        this.f11729b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        zzait zzaitVar;
        zzaji zzajiVar;
        zzatd zzatdVar = this.f11730c;
        zzaitVar = zzatd.zzdzt;
        zzatdVar.zzdzx = zzaitVar.zzb((zzcu) null);
        zzajiVar = this.f11730c.zzdzx;
        zzajiVar.zza(new Pc(this), new Qc(this));
    }
}
