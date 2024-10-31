package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.kt */
/* loaded from: classes.dex */
public final class d implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f21438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(a aVar) {
        this.f21438a = aVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        x xVar;
        this.f21438a.n = null;
        mediaPlayer2 = this.f21438a.m;
        if (mediaPlayer2 != null) {
            mediaPlayer2.stop();
        }
        mediaPlayer3 = this.f21438a.m;
        if (mediaPlayer3 != null) {
            mediaPlayer3.reset();
        }
        xVar = this.f21438a.o;
        if (xVar != null) {
            xVar.b(-1);
        }
    }
}
