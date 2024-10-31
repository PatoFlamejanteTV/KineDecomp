package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Handler;
import com.nexstreaming.app.general.util.SupportLogger;

/* compiled from: ExportManager.java */
/* loaded from: classes.dex */
class w implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ v f4367a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(v vVar) {
        this.f4367a = vVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        f fVar;
        Handler handler;
        fVar = this.f4367a.f4366a.b.t;
        fVar.a("...scan complete", new String[0]);
        SupportLogger.Event.Export_ScanComplete.log(new int[0]);
        handler = this.f4367a.f4366a.b.d;
        handler.post(new x(this));
    }
}
