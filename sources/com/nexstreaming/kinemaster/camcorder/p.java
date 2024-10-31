package com.nexstreaming.kinemaster.camcorder;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class p implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ o f3280a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(o oVar) {
        this.f3280a = oVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3280a.f3279a.finish();
    }
}
