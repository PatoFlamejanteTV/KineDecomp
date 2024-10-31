package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.media.MediaPlayer;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.adobe.creativesdk.foundation.internal.utils.logging.Level;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ga, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0408ga implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetVideoActivity f6097a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0408ga(AdobeUXAssetVideoActivity adobeUXAssetVideoActivity) {
        this.f6097a = adobeUXAssetVideoActivity;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        ProgressBar progressBar;
        com.adobe.creativesdk.foundation.internal.utils.logging.c.a(Level.ERROR, "VideoActivity-onError", String.format("error code is %d:%d", Integer.valueOf(i), Integer.valueOf(i2)));
        progressBar = this.f6097a.f5544c;
        progressBar.setVisibility(4);
        Toast.makeText(this.f6097a, "Can't play this video", 0).show();
        this.f6097a.finish();
        return true;
    }
}
