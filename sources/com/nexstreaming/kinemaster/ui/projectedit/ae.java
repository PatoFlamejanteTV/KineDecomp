package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes.dex */
class ae implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f3758a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(FullScreenInputActivity fullScreenInputActivity) {
        this.f3758a = fullScreenInputActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3758a.b.showSoftInput(this.f3758a.f3732a, 0);
    }
}
