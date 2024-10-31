package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* loaded from: classes.dex */
class e implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f3502a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f3502a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ResultTask resultTask;
        resultTask = this.f3502a.f3501a.p;
        resultTask.signalEvent(Task.Event.FAIL);
    }
}
