package com.nexstreaming.kinemaster.mediainfo;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: MediaInfo.java */
/* renamed from: com.nexstreaming.kinemaster.mediainfo.d, reason: case insensitive filesystem */
/* loaded from: classes.dex */
class C1786d implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ C1789g f20738a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C1786d(C1789g c1789g) {
        this.f20738a = c1789g;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        ResultTask resultTask;
        resultTask = this.f20738a.f20741a.G;
        resultTask.signalEvent(Task.Event.FAIL);
    }
}
