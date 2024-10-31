package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class dd implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4593a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4593a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4593a.sendFailure(taskError);
    }
}
