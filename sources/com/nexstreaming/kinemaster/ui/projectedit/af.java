package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3759a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(FullScreenInputActivity fullScreenInputActivity) {
        this.f3759a = fullScreenInputActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3759a.b.showSoftInput(this.f3759a.f3732a, 0);
    }
}
