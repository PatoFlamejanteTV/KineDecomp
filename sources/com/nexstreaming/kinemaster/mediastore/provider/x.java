package com.nexstreaming.kinemaster.mediastore.provider;

import android.media.MediaScannerConnection;
import android.net.Uri;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
class x implements MediaScannerConnection.OnScanCompletedListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f21032a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f21033b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(y yVar, File file) {
        this.f21033b = yVar;
        this.f21032a = file;
    }

    @Override // android.media.MediaScannerConnection.OnScanCompletedListener
    public void onScanCompleted(String str, Uri uri) {
        this.f21033b.f21034a.c(false);
        this.f21033b.f21034a.b(this.f21032a.getAbsolutePath());
        this.f21033b.f21035b.signalEvent(Task.Event.COMPLETE);
    }
}
