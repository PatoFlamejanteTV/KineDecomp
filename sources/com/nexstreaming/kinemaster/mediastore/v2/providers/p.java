package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.Task;
import java.io.File;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class p implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ Task f3591a;
    final /* synthetic */ File b;
    final /* synthetic */ l c;

    public p(l lVar, Task task, File file) {
        this.c = lVar;
        this.f3591a = task;
        this.b = file;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3591a.sendFailure(Task.makeTaskError(taskError.getMessage(), taskError.getException()));
        this.b.delete();
    }
}
