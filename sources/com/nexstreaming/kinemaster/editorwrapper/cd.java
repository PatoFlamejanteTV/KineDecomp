package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class cd implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ cc f3357a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cd(cc ccVar) {
        this.f3357a = ccVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3357a.c.sendFailure(taskError);
    }
}
