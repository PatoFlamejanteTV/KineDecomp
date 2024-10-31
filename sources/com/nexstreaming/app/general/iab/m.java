package com.nexstreaming.app.general.iab;

import com.nexstreaming.app.general.task.ResultTask;
import com.nexstreaming.app.general.task.Task;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: IABManager.kt */
/* loaded from: classes2.dex */
public final class m implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ IABManager f19480a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ResultTask f19481b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(IABManager iABManager, ResultTask resultTask) {
        this.f19480a = iABManager;
        this.f19481b = resultTask;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public final void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f19481b.setTaskError(taskError);
        this.f19481b.signalEvent(Task.Event.FAIL);
        this.f19480a.j = false;
    }
}
