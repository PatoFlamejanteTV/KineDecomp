package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class s implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4437a;
    final /* synthetic */ GoogleDriveMediaDownload b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(GoogleDriveMediaDownload googleDriveMediaDownload, ResultTask resultTask) {
        this.b = googleDriveMediaDownload;
        this.f4437a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4437a.sendFailure(taskError);
    }
}
