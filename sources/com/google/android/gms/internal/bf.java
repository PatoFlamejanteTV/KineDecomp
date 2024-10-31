package com.google.android.gms.internal;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bf implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbb f1446a;
    final /* synthetic */ az b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(az azVar, zzbb zzbbVar) {
        this.b = azVar;
        this.f1446a = zzbbVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        obj = this.b.b.zzpd;
        synchronized (obj) {
            if (this.b.f1440a.getStatus() == -1 || this.b.f1440a.getStatus() == 1) {
                return;
            }
            this.b.f1440a.reject();
            zzid.runOnUiThread(new bg(this));
            com.google.android.gms.ads.internal.util.client.zzb.d("Could not receive loaded message in a timely manner. Rejecting.");
        }
    }
}
