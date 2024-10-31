package com.nexstreaming.kinemaster.mediaprep;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MediaPrepManager.java */
/* loaded from: classes.dex */
public class j implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    final /* synthetic */ i f3533a;

    public j(i iVar) {
        this.f3533a = iVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Handler handler;
        handler = this.f3533a.d.j;
        handler.post(new k(this, str));
    }
}
