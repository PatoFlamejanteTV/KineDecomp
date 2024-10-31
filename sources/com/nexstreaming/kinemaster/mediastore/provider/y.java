package com.nexstreaming.kinemaster.mediastore.provider;

import android.content.Context;
import android.media.MediaScannerConnection;
import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveProvider.java */
/* loaded from: classes.dex */
public class y implements ResultTask.OnResultAvailableListener<File> {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.nexstreaming.kinemaster.mediastore.item.b f21034a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Task f21035b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ GoogleDriveProvider f21036c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(GoogleDriveProvider googleDriveProvider, com.nexstreaming.kinemaster.mediastore.item.b bVar, Task task) {
        this.f21036c = googleDriveProvider;
        this.f21034a = bVar;
        this.f21035b = task;
    }

    @Override // com.nexstreaming.app.general.task.ResultTask.OnResultAvailableListener
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onResultAvailable(ResultTask<File> resultTask, Task.Event event, File file) {
        Context context;
        context = this.f21036c.f20965a;
        MediaScannerConnection.scanFile(context, new String[]{file.getAbsolutePath()}, null, new x(this, file));
    }
}
