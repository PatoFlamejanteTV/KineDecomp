package com.nexstreaming.kinemaster.camcorder;

import android.widget.VideoView;

/* compiled from: CamcorderPreviewActivity.java */
/* loaded from: classes.dex */
class n implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ m f3278a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(m mVar) {
        this.f3278a = mVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VideoView videoView;
        videoView = this.f3278a.f3277a.f3263a;
        videoView.pause();
    }
}
