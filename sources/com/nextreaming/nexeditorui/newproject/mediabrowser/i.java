package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.media.MediaPlayer;

/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
class i implements MediaPlayer.OnVideoSizeChangedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ h f4731a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f4731a = hVar;
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i, int i2) {
        this.f4731a.f4730a.postOnAnimationDelayed(new j(this), 100L);
    }
}
