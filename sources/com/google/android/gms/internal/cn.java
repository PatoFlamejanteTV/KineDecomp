package com.google.android.gms.internal;

/* loaded from: classes.dex */
class cn implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzhs f1480a;
    final /* synthetic */ zzgf b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(zzgf zzgfVar, zzhs zzhsVar) {
        this.b = zzgfVar;
        this.f1480a = zzhsVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this.b.zzpd) {
            this.b.zzi(this.f1480a);
        }
    }
}
