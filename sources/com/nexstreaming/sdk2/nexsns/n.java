package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class n implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ File f4432a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ GoogleDriveMediaDownload c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(GoogleDriveMediaDownload googleDriveMediaDownload, File file, ResultTask resultTask) {
        this.c = googleDriveMediaDownload;
        this.f4432a = file;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4432a.delete();
        this.b.sendFailure(taskError);
    }
}
