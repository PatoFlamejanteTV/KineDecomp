package com.nextreaming.nexeditorui.newproject.b;

import android.media.MediaPlayer;
import android.view.TextureView;
import android.view.View;

/* compiled from: ThemeBrowserAdapter.java */
/* loaded from: classes.dex */
class d implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ View f4665a;
    final /* synthetic */ TextureView b;
    final /* synthetic */ View c;
    final /* synthetic */ c d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar, View view, TextureView textureView, View view2) {
        this.d = cVar;
        this.f4665a = view;
        this.b = textureView;
        this.c = view2;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        MediaPlayer mediaPlayer2;
        Runnable runnable;
        Runnable runnable2;
        this.d.b.i = false;
        this.f4665a.setVisibility(8);
        this.b.setVisibility(0);
        this.c.setVisibility(8);
        mediaPlayer2 = this.d.b.f;
        mediaPlayer2.start();
        runnable = this.d.b.j;
        if (runnable != null) {
            runnable2 = this.d.b.j;
            runnable2.run();
            this.d.b.j = null;
        }
    }
}
