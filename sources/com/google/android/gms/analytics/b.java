package com.google.android.gms.analytics;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f690a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f690a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f690a.d.stopSelfResult(this.f690a.f689a)) {
            if (this.f690a.b.e().a()) {
                this.f690a.c.b("Device AnalyticsService processed last dispatch request");
            } else {
                this.f690a.c.b("Local AnalyticsService processed last dispatch request");
            }
        }
    }
}
