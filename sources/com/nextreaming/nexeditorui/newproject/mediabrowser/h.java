package com.nextreaming.nexeditorui.newproject.mediabrowser;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaBrowserFragment.java */
/* loaded from: classes.dex */
public class h implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoView f4730a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ ImageView c;
    final /* synthetic */ MediaBrowserFragment d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(MediaBrowserFragment mediaBrowserFragment, VideoView videoView, ImageView imageView, ImageView imageView2) {
        this.d = mediaBrowserFragment;
        this.f4730a = videoView;
        this.b = imageView;
        this.c = imageView2;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.setOnVideoSizeChangedListener(new i(this));
    }
}
