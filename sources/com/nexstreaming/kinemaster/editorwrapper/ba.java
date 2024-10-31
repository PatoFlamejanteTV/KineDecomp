package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class ba extends NexEditor.p {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ az f3328a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(az azVar) {
        this.f3328a = azVar;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(int i) {
        this.f3328a.c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.p
    public void a(NexEditor.b bVar) {
        this.f3328a.c.sendFailure(bVar);
    }
}
