package com.nextreaming.nexeditorui;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: NexVideoClipItem.java */
/* loaded from: classes.dex */
public class dh implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ResultTask f4597a;
    final /* synthetic */ NexVideoClipItem b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dh(NexVideoClipItem nexVideoClipItem, ResultTask resultTask) {
        this.b = nexVideoClipItem;
        this.f4597a = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        com.nexstreaming.kinemaster.mediainfo.aq aqVar;
        com.nexstreaming.kinemaster.mediainfo.aq aqVar2;
        int i;
        boolean z;
        boolean z2;
        aqVar = this.b.h;
        if (aqVar != null) {
            int firstRepresentedTime = this.b.getFirstRepresentedTime();
            ResultTask resultTask = this.f4597a;
            aqVar2 = this.b.h;
            i = this.b.m_rotation;
            z = this.b.m_fliph;
            z2 = this.b.m_flipv;
            resultTask.setResult(aqVar2.a(i, firstRepresentedTime, z, z2));
            this.f4597a.signalEvent(Task.Event.RESULT_AVAILABLE, Task.Event.SUCCESS, Task.Event.COMPLETE);
            return;
        }
        this.f4597a.signalEvent(Task.Event.FAIL);
    }
}
