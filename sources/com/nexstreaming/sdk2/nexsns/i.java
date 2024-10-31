package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.util.concurrent.Executor;

/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
class i implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4427a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ GoogleDriveMediaDownload c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(GoogleDriveMediaDownload googleDriveMediaDownload, String str, ResultTask resultTask) {
        this.c = googleDriveMediaDownload;
        this.f4427a = str;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Executor executor;
        ab.a("GoogleDriveMediaDL", "Begin list : " + this.f4427a);
        this.c.s();
        j jVar = new j(this, "'" + this.f4427a + "' in parents and (mimeType contains 'image/' or mimeType contains 'video/mp4' or mimeType contains 'application/vnd.google-apps.folder')");
        executor = GoogleDriveMediaDownload.m;
        jVar.executeOnExecutor(executor, (Void) null);
    }
}
