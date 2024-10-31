package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import android.view.View;

/* compiled from: MediaEditFragment.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.yb, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C2079yb implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2087zb f22788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2079yb(C2087zb c2087zb) {
        this.f22788a = c2087zb;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        View view = this.f22788a.f22802c.getView();
        if (view != null) {
            view.post(new RunnableC2071xb(this, str));
        }
    }
}
