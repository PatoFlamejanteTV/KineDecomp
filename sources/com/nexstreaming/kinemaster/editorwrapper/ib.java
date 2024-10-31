package com.nexstreaming.kinemaster.editorwrapper;

import com.crashlytics.android.Crashlytics;
import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexeditorui.EditorGlobal;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ib implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ lb f20325a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ib(lb lbVar) {
        this.f20325a = lbVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        if (EditorGlobal.p) {
            Crashlytics.log("[VideoEditor] loadProject -> syncEditorToTimeline -> onFailure: " + taskError);
        }
        this.f20325a.k.sendFailure(taskError);
    }
}
