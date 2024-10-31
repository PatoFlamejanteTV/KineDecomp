package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.Task;

/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
class eb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24246a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eb(NexVideoClipItem nexVideoClipItem) {
        this.f24246a = nexVideoClipItem;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f24246a.n = false;
        this.f24246a.o = true;
    }
}
