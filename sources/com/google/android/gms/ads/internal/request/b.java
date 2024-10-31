package com.google.android.gms.ads.internal.request;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzb f627a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(zzb zzbVar) {
        this.f627a = zzbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        obj = this.f627a.f;
        synchronized (obj) {
            if (this.f627a.f634a == null) {
                return;
            }
            this.f627a.onStop();
            this.f627a.a(2, "Timed out waiting for ad response.");
        }
    }
}
