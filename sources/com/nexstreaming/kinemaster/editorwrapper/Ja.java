package com.nexstreaming.kinemaster.editorwrapper;

import com.nexstreaming.app.general.task.Task;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: VideoEditor.java */
/* loaded from: classes.dex */
class Ja extends NexEditor.q {

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ka f20211c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Ja(Ka ka) {
        this.f20211c = ka;
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(int i, int i2) {
        this.f20211c.f20214c.signalEvent(Task.Event.COMPLETE, Task.Event.SUCCESS);
    }

    @Override // com.nextreaming.nexvideoeditor.NexEditor.q
    public void a(NexEditor.b bVar) {
        this.f20211c.f20214c.sendFailure(bVar);
    }
}
