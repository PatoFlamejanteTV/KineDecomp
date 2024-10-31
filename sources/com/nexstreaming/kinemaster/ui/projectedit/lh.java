package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.kinemaster.ui.projectedit.Oh;

/* compiled from: VoiceRecordingController.java */
/* loaded from: classes2.dex */
class Lh implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f21952a;

    /* renamed from: b */
    final /* synthetic */ Mh f21953b;

    public Lh(Mh mh, int i) {
        this.f21953b = mh;
        this.f21952a = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        Oh.b bVar;
        int min = (Math.min(this.f21952a, 255) * io.fabric.sdk.android.services.common.a.DEFAULT_TIMEOUT) / 255;
        bVar = this.f21953b.f21966a.f21994h;
        bVar.a(this.f21953b.f21966a.a(), this.f21953b.f21966a.b(), min);
    }
}
