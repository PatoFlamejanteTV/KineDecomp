package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.concurrent.Executor;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class l implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4430a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ GoogleDriveMediaDownload c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(GoogleDriveMediaDownload googleDriveMediaDownload, String str, ResultTask resultTask) {
        this.c = googleDriveMediaDownload;
        this.f4430a = str;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Executor executor;
        this.c.s();
        m mVar = new m(this);
        executor = GoogleDriveMediaDownload.m;
        mVar.executeOnExecutor(executor, (Void) null);
    }
}
