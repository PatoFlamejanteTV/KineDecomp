package com.nexstreaming.kinemaster.ui.projectedit;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.kinemaster.mediastore.provider.AndroidMediaStoreProvider;
import java.io.File;

/* compiled from: ProjectEditActivity.java */
/* renamed from: com.nexstreaming.kinemaster.ui.projectedit.rf, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
class C1999rf implements MediaScannerConnection.MediaScannerConnectionClient {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C2008sf f22508a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1999rf(C2008sf c2008sf) {
        this.f22508a = c2008sf;
    }

    @Override // android.media.MediaScannerConnection.MediaScannerConnectionClient
    public void onMediaScannerConnected() {
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        com.nexstreaming.kinemaster.mediastore.item.c b2 = this.f22508a.f22527f.W().b(AndroidMediaStoreProvider.a(new File(str)));
        if (b2 != null) {
            C2008sf c2008sf = this.f22508a;
            c2008sf.f22527f.a(c2008sf.f22523b, b2);
        }
    }
}
