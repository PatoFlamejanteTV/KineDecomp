package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.mediastore.v2.a;
import java.io.File;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class s implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f3594a;
    final /* synthetic */ r b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar, File file) {
        this.b = rVar;
        this.f3594a = file;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        a.InterfaceC0071a interfaceC0071a;
        this.b.f3593a.a(false);
        this.b.f3593a.b(this.f3594a.getAbsolutePath());
        interfaceC0071a = l.q;
        interfaceC0071a.a(this.b.f3593a);
        this.b.b.signalEvent(Task.Event.COMPLETE);
    }
}
