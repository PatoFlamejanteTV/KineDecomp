package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Xa implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ bb f20281a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Xa(bb bbVar) {
        this.f20281a = bbVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        this.f20281a.f20297b.sendFailure(taskError);
    }
}
