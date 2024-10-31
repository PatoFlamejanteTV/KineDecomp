package com.nexstreaming.kinemaster.editorwrapper;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class _a implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f20288a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ab f20289b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public _a(ab abVar, File file) {
        this.f20289b = abVar;
        this.f20288a = file;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        Handler handler;
        handler = this.f20289b.f20294a.f20298c.C;
        handler.post(new Za(this, uri, str));
    }
}
