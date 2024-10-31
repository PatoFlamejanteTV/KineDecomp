package com.google.android.gms.internal;

/* loaded from: classes.dex */
class dj implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs f1503a;
    final /* synthetic */ zzhn b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(zzhn zzhnVar, zzhs zzhsVar) {
        this.b = zzhnVar;
        this.f1503a = zzhsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        zzhg zzhgVar;
        zzhgVar = this.b.zzHs;
        zzhgVar.zzb(this.f1503a);
    }
}
