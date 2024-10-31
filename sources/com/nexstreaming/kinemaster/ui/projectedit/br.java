package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;

/* compiled from: MediaEditFragment.java */
/* loaded from: classes.dex */
class br implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bq f3799a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bq bqVar) {
        this.f3799a = bqVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        View view = this.f3799a.c.getView();
        if (view != null) {
            view.post(new bs(this, str));
        }
    }
}
