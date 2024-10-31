package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Ha extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ia f20206c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ha(Ia ia) {
        this.f20206c = ia;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        this.f20206c.f20209c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        this.f20206c.f20209c.sendFailure(bVar);
    }
}
