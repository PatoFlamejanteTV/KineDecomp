package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class Ya implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f24193a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ NexVideoClipItem f24194b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ya(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.f24194b = nexVideoClipItem;
        this.f24193a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.mediainfo.T t;
        com.nexstreaming.kinemaster.mediainfo.T t2;
        int i;
        boolean z;
        boolean z2;
        t = this.f24194b.j;
        if (t != null) {
            int firstRepresentedTime = this.f24194b.getFirstRepresentedTime();
            ResultTask resultTask = this.f24193a;
            t2 = this.f24194b.j;
            i = this.f24194b.m_rotation;
            z = this.f24194b.m_fliph;
            z2 = this.f24194b.m_flipv;
            resultTask.setResult(t2.b(i, firstRepresentedTime, z, z2));
            this.f24193a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f24193a.signalEvent(Task.Event.FAIL);
    }
}
