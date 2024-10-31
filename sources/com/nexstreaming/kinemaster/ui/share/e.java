package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import com.nexstreaming.app.general.util.SupportLogger;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportManager.java */
/* loaded from: classes2.dex */
public class E implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ U f23270a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public E(U u) {
        this.f23270a = u;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        InterfaceC2240y interfaceC2240y;
        Handler handler;
        interfaceC2240y = this.f23270a.t;
        interfaceC2240y.a("...scan complete", new String[0]);
        SupportLogger.Event.Export_ScanComplete.log(new int[0]);
        handler = this.f23270a.f23304d;
        handler.post(new D(this));
    }
}
