package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ay extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ ax f3326a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ay(ax axVar) {
        this.f3326a = axVar;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(int i) {
        this.f3326a.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        this.f3326a.c.sendFailure(bVar);
    }
}
