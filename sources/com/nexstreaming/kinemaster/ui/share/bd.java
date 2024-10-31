package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentActivity.java */
/* loaded from: classes.dex */
public class bd implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4315a;
    final /* synthetic */ bc b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar, File file) {
        this.b = bcVar;
        this.f4315a = file;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.b.b.runOnUiThread(new be(this, str));
    }
}
