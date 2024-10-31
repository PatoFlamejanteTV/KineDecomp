package com.google.android.gms.measurement;

/* loaded from: classes.dex */
class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f2014a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.f2014a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2014a.d.stopSelfResult(this.f2014a.b)) {
            if (this.f2014a.f2013a.d().z()) {
                this.f2014a.c.t().a("Device AppMeasurementService processed last upload request");
            } else {
                this.f2014a.c.t().a("Local AppMeasurementService processed last upload request");
            }
        }
    }
}
