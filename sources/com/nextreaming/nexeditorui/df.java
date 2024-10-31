package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class df implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4595a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public df(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4595a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f4595a.sendFailure(taskError);
    }
}
