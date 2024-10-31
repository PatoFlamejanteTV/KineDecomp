package com.nexstreaming.kinemaster.camcorder;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class r implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ q f3282a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.f3282a = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3282a.f3281a.finish();
    }
}
