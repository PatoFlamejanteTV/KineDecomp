package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ka implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21918a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ka(FullScreenInputActivity fullScreenInputActivity) {
        this.f21918a = fullScreenInputActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        FullScreenInputActivity fullScreenInputActivity = this.f21918a;
        fullScreenInputActivity.f21854b.showSoftInput(fullScreenInputActivity.f21853a, 0);
        this.f21918a.f21853a.requestFocus();
    }
}
