package com.nexstreaming.kinemaster.editorwrapper;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class by implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bx f3351a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f3351a = bxVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Handler handler;
        handler = this.f3351a.e.B;
        handler.post(new bz(this, uri, str));
    }
}
