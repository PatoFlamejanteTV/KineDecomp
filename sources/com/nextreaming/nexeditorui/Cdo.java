package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* renamed from: com.nextreaming.nexeditorui.do, reason: invalid class name */
/* loaded from: classes.dex */
class Cdo implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4604a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Cdo(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4604a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4604a.sendFailure(taskError);
    }
}
