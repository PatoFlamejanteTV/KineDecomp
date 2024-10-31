package com.nexstreaming.kinemaster.ui.projectedit;

/* compiled from: FullScreenInputActivity.java */
/* loaded from: classes2.dex */
class Ja implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ FullScreenInputActivity f21908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ja(FullScreenInputActivity fullScreenInputActivity) {
        this.f21908a = fullScreenInputActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        FullScreenInputActivity fullScreenInputActivity = this.f21908a;
        fullScreenInputActivity.f21854b.showSoftInput(fullScreenInputActivity.f21853a, 0);
        this.f21908a.f21853a.requestFocus();
    }
}
