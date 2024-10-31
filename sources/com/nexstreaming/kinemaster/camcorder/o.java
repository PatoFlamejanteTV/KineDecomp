package com.nexstreaming.kinemaster.camcorder;

import android.widget.VideoView;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ p f20004a;

    public o(p pVar) {
        this.f20004a = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoView videoView;
        videoView = this.f20004a.f20005a.f19977a;
        videoView.pause();
    }
}
