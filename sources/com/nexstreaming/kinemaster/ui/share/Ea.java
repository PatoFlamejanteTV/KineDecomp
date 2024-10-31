package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;

/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class Ea implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a */
    final /* synthetic */ Da.e f23271a;

    public Ea(Da.e eVar) {
        this.f23271a = eVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
        MediaScannerConnection mediaScannerConnection;
        File file;
        MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient;
        mediaScannerConnection = this.f23271a.f23264a;
        file = this.f23271a.f23265b;
        mediaScannerConnection.scanFile(file.getAbsolutePath(), null);
        mediaScannerConnectionClient = this.f23271a.f23266c;
        mediaScannerConnectionClient.onMediaScannerConnected();
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        MediaScannerConnection mediaScannerConnection;
        MediaScannerConnection.MediaScannerConnectionClient mediaScannerConnectionClient;
        mediaScannerConnection = this.f23271a.f23264a;
        mediaScannerConnection.disconnect();
        mediaScannerConnectionClient = this.f23271a.f23266c;
        mediaScannerConnectionClient.onScanCompleted(str, uri);
    }
}
