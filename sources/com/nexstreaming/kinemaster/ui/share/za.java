package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class za implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f23402a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Aa f23403b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public za(Aa aa, File file) {
        this.f23403b = aa;
        this.f23402a = file;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        if (this.f23403b.f23245b.getActivity() != null) {
            this.f23403b.f23245b.getActivity().runOnUiThread(new ya(this, str));
        }
    }
}
