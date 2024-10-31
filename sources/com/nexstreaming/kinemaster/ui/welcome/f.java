package com.nexstreaming.kinemaster.ui.welcome;

import android.media.MediaPlayer;
import android.widget.VideoView;
import kotlin.jvm.internal.h;

/* compiled from: WelcomeViewPager.kt */
/* loaded from: classes2.dex */
final class f implements MediaPlayer.OnPreparedListener {

    /* renamed from: a */
    final /* synthetic */ VideoView f23705a;

    public f(VideoView videoView) {
        this.f23705a = videoView;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        h.a((Object) mediaPlayer, "it");
        mediaPlayer.setLooping(true);
        mediaPlayer.setScreenOnWhilePlaying(false);
        this.f23705a.start();
    }
}
