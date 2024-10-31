package com.nexstreaming.kinemaster.ui.projectedit;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: ProjectEditActivity.java */
/* loaded from: classes2.dex */
public class Of implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ _f f21986a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Of(_f _fVar) {
        this.f21986a = _fVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        this.f21986a.f22205b.Ia();
        videoEditor = this.f21986a.f22205b.M;
        videoEditor.K().onComplete(new Nf(this));
    }
}
