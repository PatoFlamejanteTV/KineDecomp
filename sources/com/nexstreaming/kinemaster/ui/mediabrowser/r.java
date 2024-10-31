package com.nexstreaming.kinemaster.ui.mediabrowser;

import android.media.MediaPlayer;
import android.widget.ImageView;
import android.widget.VideoView;

/* compiled from: MediaBrowserFragment.kt */
/* loaded from: classes.dex */
final class r implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1829g f21702a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(C1829g c1829g) {
        this.f21702a = c1829g;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        VideoView videoView;
        ImageView imageView;
        ImageView imageView2;
        videoView = this.f21702a.p;
        if (videoView != null) {
            videoView.setVisibility(8);
        }
        imageView = this.f21702a.n;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        imageView2 = this.f21702a.o;
        if (imageView2 != null) {
            imageView2.setVisibility(0);
        }
    }
}
