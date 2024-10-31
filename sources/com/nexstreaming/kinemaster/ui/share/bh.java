package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.kinemaster.ui.share.ShareIntentActivity;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class bh implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ShareIntentActivity.d f4319a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(ShareIntentActivity.d dVar) {
        this.f4319a = dVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient;
        mediaScannerConnection = this.f4319a.b;
        file = this.f4319a.c;
        mediaScannerConnection.scanFile(file.getAbsolutePath(), null);
        mediaScannerConnectionClient = this.f4319a.d;
        mediaScannerConnectionClient.onMediaScannerConnected();
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        MediaScannerConnection mediaScannerConnection;
        MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient;
        mediaScannerConnection = this.f4319a.b;
        mediaScannerConnection.disconnect();
        mediaScannerConnectionClient = this.f4319a.d;
        mediaScannerConnectionClient.onScanCompleted(str, uri);
    }
}
