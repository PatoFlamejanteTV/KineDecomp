package com.nexstreaming.kinemaster.camcorder;

import android.media.MediaRecorder;
import android.widget.LinearLayout;

/* compiled from: CamcorderActivity.java */
/* loaded from: classes.dex */
class h implements Runnable {

    /* renamed from: a */
    final /* synthetic */ CamcorderActivity f19996a;

    public h(CamcorderActivity camcorderActivity) {
        this.f19996a = camcorderActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.nexstreaming.app.kinemasterfree.a.g gVar;
        Runnable runnable;
        boolean z;
        boolean z2;
        MediaRecorder mediaRecorder;
        com.nexstreaming.app.kinemasterfree.a.g gVar2;
        com.nexstreaming.app.kinemasterfree.a.g gVar3;
        com.nexstreaming.app.kinemasterfree.a.g gVar4;
        Runnable runnable2;
        gVar = this.f19996a.K;
        LinearLayout linearLayout = gVar.G;
        runnable = this.f19996a.V;
        linearLayout.removeCallbacks(runnable);
        z = this.f19996a.f19975g;
        if (z) {
            z2 = this.f19996a.L;
            if (z2) {
                mediaRecorder = this.f19996a.f19974f;
                long maxAmplitude = mediaRecorder.getMaxAmplitude();
                gVar2 = this.f19996a.K;
                int i = (int) ((maxAmplitude * 100) / 32767);
                gVar2.a(i);
                gVar3 = this.f19996a.K;
                gVar3.b(i);
                gVar4 = this.f19996a.K;
                LinearLayout linearLayout2 = gVar4.G;
                runnable2 = this.f19996a.V;
                linearLayout2.postOnAnimationDelayed(runnable2, 15L);
            }
        }
    }
}
