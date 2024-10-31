package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class br implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzeg f1458a;
    final /* synthetic */ zzeh b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(zzeh zzehVar, zzeg zzegVar) {
        this.b = zzehVar;
        this.f1458a = zzegVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        int i;
        zzen zzdU;
        zzen zzenVar;
        obj = this.b.zzpd;
        synchronized (obj) {
            i = this.b.zzzp;
            if (i != -2) {
                return;
            }
            zzeh zzehVar = this.b;
            zzdU = this.b.zzdU();
            zzehVar.zzzo = zzdU;
            zzenVar = this.b.zzzo;
            if (zzenVar == null) {
                this.b.zzq(4);
            } else {
                this.f1458a.zza(this.b);
                this.b.zza(this.f1458a);
            }
        }
    }
}
