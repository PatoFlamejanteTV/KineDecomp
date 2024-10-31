package com.nexstreaming.sdk2.nexsns;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: GoogleDriveMediaDownload.java */
/* loaded from: classes.dex */
public class o implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f4433a;
    final /* synthetic */ String b;
    final /* synthetic */ ResultTask c;
    final /* synthetic */ String d;
    final /* synthetic */ File e;
    final /* synthetic */ File f;
    final /* synthetic */ GoogleDriveMediaDownload g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(GoogleDriveMediaDownload googleDriveMediaDownload, String str, String str2, ResultTask resultTask, String str3, File file, File file2) {
        this.g = googleDriveMediaDownload;
        this.f4433a = str;
        this.b = str2;
        this.c = resultTask;
        this.d = str3;
        this.e = file;
        this.f = file2;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        Executor executor;
        try {
            this.g.s();
            p pVar = new p(this, new FileOutputStream(this.f4433a));
            executor = GoogleDriveMediaDownload.m;
            pVar.executeOnExecutor(executor, (Void) null);
        } catch (IOException e) {
            this.c.sendFailure(new r(this, e));
        }
    }
}
