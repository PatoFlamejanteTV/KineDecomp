package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* compiled from: OptionPanelDefaultFragment.java */
/* loaded from: classes.dex */
class fk implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor f3901a;
    final /* synthetic */ ez b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public fk(ez ezVar, VideoEditor videoEditor) {
        this.b = ezVar;
        this.f3901a = videoEditor;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        View view = this.b.getView();
        if (view != null) {
            view.post(new fl(this, str));
        }
    }
}
