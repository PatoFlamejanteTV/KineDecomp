package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
public class vb implements Task.OnFailListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ VideoEditor.a f20369a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public vb(VideoEditor.a aVar) {
        this.f20369a = aVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnFailListener
    public void onFail(Task task, Task.Event event, Task.TaskError taskError) {
        VideoEditor.this.U();
    }
}
