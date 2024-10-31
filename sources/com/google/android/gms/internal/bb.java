package com.google.android.gms.internal;

/* loaded from: classes.dex */
class bb implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ba f1442a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(ba baVar) {
        this.f1442a = baVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        obj = this.f1442a.b.b.zzpd;
        synchronized (obj) {
            if (this.f1442a.b.f1440a.getStatus() == -1 || this.f1442a.b.f1440a.getStatus() == 1) {
                return;
            }
            this.f1442a.b.f1440a.reject();
            zzid.runOnUiThread(new bc(this));
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not receive loaded message in a timely manner. Rejecting.");
        }
    }
}
