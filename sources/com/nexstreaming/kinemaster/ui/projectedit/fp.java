package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fp implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3906a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fp(ez ezVar, VideoEditor videoEditor) {
        this.b = ezVar;
        this.f3906a = videoEditor;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        View view = this.b.getView();
        if (view != null) {
            view.post(new fq(this, str));
        }
    }
}
