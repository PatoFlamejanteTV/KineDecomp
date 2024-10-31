package com.nexstreaming.kinemaster.ui.audiobrowser;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AudioBrowserFragment.java */
/* loaded from: classes.dex */
public class h implements MediaPlayer.OnCompletionListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ a f3673a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(a aVar) {
        this.f3673a = aVar;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        MediaPlayer mediaPlayer3;
        q qVar;
        q qVar2;
        this.f3673a.k = null;
        mediaPlayer2 = this.f3673a.j;
        mediaPlayer2.stop();
        mediaPlayer3 = this.f3673a.j;
        mediaPlayer3.reset();
        qVar = this.f3673a.l;
        if (qVar != null) {
            qVar2 = this.f3673a.l;
            qVar2.a(-1);
        }
    }
}
