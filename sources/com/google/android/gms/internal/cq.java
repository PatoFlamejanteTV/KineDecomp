package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cq implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzin f1483a;
    final /* synthetic */ String b;
    final /* synthetic */ zzgm c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cq(zzgm zzgmVar, zzin zzinVar, String str) {
        this.c = zzgmVar;
        this.f1483a = zzinVar;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.google.android.gms.ads.internal.zzn zznVar;
        zzin zzinVar = this.f1483a;
        zznVar = this.c.zzDG;
        zzinVar.zzf(zznVar.a().get(this.b));
    }
}
