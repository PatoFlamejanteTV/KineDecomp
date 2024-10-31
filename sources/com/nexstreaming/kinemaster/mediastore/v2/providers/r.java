package com.nexstreaming.kinemaster.mediastore.v2.providers;

import android.app.Activity;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
public class r implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.v2.a f3593a;
    final /* synthetic */ Task b;
    final /* synthetic */ l c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(l lVar, com.nexstreaming.kinemaster.mediastore.v2.a aVar, Task task) {
        this.c = lVar;
        this.f3593a = aVar;
        this.b = task;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        Activity activity;
        activity = this.c.j;
        MediaScannerConnection.scanFile(activity, new String[]{file.getAbsolutePath()}, null, new s(this, file));
    }
}
