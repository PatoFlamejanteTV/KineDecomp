package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ha, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0413ha implements MediaPlayer.OnBufferingUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0428ka f6102a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0413ha(C0428ka c0428ka) {
        this.f6102a = c0428ka;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public void onBufferingUpdate(MediaPlayer mediaPlayer, int i) {
        ProgressBar progressBar;
        C0428ka c0428ka = this.f6102a;
        if (c0428ka.f6161a) {
            progressBar = c0428ka.f6162b.f5544c;
            progressBar.setVisibility(4);
            this.f6102a.f6161a = false;
        }
    }
}
