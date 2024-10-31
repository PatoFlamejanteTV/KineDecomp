package com.nexstreaming.kinemaster.editorwrapper;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class bp implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3342a;
    final /* synthetic */ bo b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bp(bo boVar, File file) {
        this.b = boVar;
        this.f3342a = file;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Handler handler;
        handler = this.b.f3341a.c.B;
        handler.post(new bq(this, uri, str));
    }
}
