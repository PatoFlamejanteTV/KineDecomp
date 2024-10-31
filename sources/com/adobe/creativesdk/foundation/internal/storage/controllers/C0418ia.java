package com.adobe.creativesdk.foundation.internal.storage.controllers;

import android.media.MediaPlayer;

/* compiled from: AdobeUXAssetVideoActivity.java */
/* renamed from: com.adobe.creativesdk.foundation.internal.storage.controllers.ia, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C0418ia implements MediaPlayer.OnErrorListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C0428ka f6143a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0418ia(C0428ka c0428ka) {
        this.f6143a = c0428ka;
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public boolean onError(MediaPlayer mediaPlayer, int i, int i2) {
        this.f6143a.f6162b.f5545d = mediaPlayer.getCurrentPosition();
        return true;
    }
}
