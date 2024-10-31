package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class bn implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bm f3340a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bn(bm bmVar) {
        this.f3340a = bmVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f3340a.b.sendFailure(taskError);
    }
}
