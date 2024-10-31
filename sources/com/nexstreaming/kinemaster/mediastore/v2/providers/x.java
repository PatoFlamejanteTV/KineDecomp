package com.nexstreaming.kinemaster.mediastore.v2.providers;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: GoogleDriveMediaStoreProvider.java */
/* loaded from: classes.dex */
class x implements Task.OnFailListener {

    /* renamed from: a */
    final /* synthetic */ ResultTask f3597a;
    final /* synthetic */ l b;

    public x(l lVar, ResultTask resultTask) {
        this.b = lVar;
        this.f3597a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3597a.sendFailure(taskError);
    }
}
