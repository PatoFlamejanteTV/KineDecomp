package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class k implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f4733a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ ImageView c;
    final /* synthetic */ MediaBrowserFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(MediaBrowserFragment mediaBrowserFragment, VideoView videoView, ImageView imageView, ImageView imageView2) {
        this.d = mediaBrowserFragment;
        this.f4733a = videoView;
        this.b = imageView;
        this.c = imageView2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        this.f4733a.stopPlayback();
        this.b.setVisibility(0);
        this.f4733a.setVisibility(8);
        this.c.setVisibility(0);
    }
}
