package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.media.MediaPlayer;
import android.widget.ProgressBar;

/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ja, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0423ja implements MediaPlayer.OnInfoListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0428ka f6151a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0423ja(C0428ka c0428ka) {
        this.f6151a = c0428ka;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public boolean onInfo(MediaPlayer mediaPlayer, int i, int i2) {
        ProgressBar progressBar;
        ProgressBar progressBar2;
        if (i == 701) {
            progressBar2 = this.f6151a.f6162b.f5544c;
            progressBar2.setVisibility(0);
        }
        if (i == 702 || i == 3) {
            progressBar = this.f6151a.f6162b.f5544c;
            progressBar.setVisibility(4);
        }
        return false;
    }
}
