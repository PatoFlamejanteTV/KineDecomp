package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class h implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4426a;
    final /* synthetic */ GoogleDriveMediaDownload b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(GoogleDriveMediaDownload googleDriveMediaDownload, ResultTask resultTask) {
        this.b = googleDriveMediaDownload;
        this.f4426a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4426a.sendFailure(taskError);
    }
}
