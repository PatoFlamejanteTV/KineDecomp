package com.nexstreaming.kinemaster.ui.share;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.kinemaster.mediastore.item.MediaStoreItemId;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import com.nexstreaming.kinemaster.ui.share.Da;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ShareIntentCheckFragment.java */
/* loaded from: classes2.dex */
public class wa implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Da.d f23395a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Da f23396b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public wa(Da da, Da.d dVar) {
        this.f23396b = da;
        this.f23395a = dVar;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        AndroidMediaStoreProvider z;
        AndroidMediaStoreProvider z2;
        File file = new File(str);
        MediaStoreItemId a2 = AndroidMediaStoreProvider.a(file);
        if (a2 != null) {
            z = this.f23396b.z();
            if (z.a(a2) != null) {
                z2 = this.f23396b.z();
                this.f23395a.a(file, z2.a(a2));
            }
        }
    }
}
