package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ExportAndShareActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.share.w, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C2238w implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ExportAndShareActivity f23394a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C2238w(ExportAndShareActivity exportAndShareActivity) {
        this.f23394a = exportAndShareActivity;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
    }
}
