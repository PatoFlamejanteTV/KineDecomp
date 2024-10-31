package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
public class t implements Task.OnTaskEventListener {

    /* renamed from: a */
    final /* synthetic */ String f4438a;
    final /* synthetic */ ResultTask b;
    final /* synthetic */ GoogleDriveMediaDownload c;

    public t(GoogleDriveMediaDownload googleDriveMediaDownload, String str, ResultTask resultTask) {
        this.c = googleDriveMediaDownload;
        this.f4438a = str;
        this.b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Executor executor;
        this.c.s();
        ab.a("GoogleDriveMediaDL", "getThumbnail onSuccess Task Event called!!");
        u uVar = new u(this, new ByteArrayOutputStream());
        executor = GoogleDriveMediaDownload.m;
        uVar.executeOnExecutor(executor, (Void) null);
    }
}
