package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.media.MediaPlayer;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ka, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0428ka implements MediaPlayer.OnPreparedListener {

    /* renamed from: a, reason: collision with root package name */
    boolean f6161a = true;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdobeUXAssetVideoActivity f6162b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0428ka(AdobeUXAssetVideoActivity adobeUXAssetVideoActivity) {
        this.f6162b = adobeUXAssetVideoActivity;
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        int i;
        int i2;
        i = this.f6162b.f5545d;
        if (i != 0) {
            i2 = this.f6162b.f5545d;
            mediaPlayer.seekTo(i2);
        }
        mediaPlayer.setOnBufferingUpdateListener(new C0413ha(this));
        mediaPlayer.setOnErrorListener(new C0418ia(this));
        mediaPlayer.setOnInfoListener(new C0423ja(this));
        mediaPlayer.start();
    }
}
