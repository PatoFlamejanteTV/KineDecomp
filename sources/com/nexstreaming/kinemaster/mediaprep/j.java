package com.nexstreaming.kinemaster.mediaprep;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;

/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
class j implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ k f20800a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(k kVar) {
        this.f20800a = kVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Handler handler;
        handler = this.f20800a.f20804d.j;
        handler.post(new i(this, str));
    }
}
