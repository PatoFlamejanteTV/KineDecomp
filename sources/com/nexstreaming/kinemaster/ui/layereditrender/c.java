package com.nexstreaming.kinemaster.ui.layereditrender;

import com.nexstreaming.app.general.task.Task;
import com.nexstreaming.kinemaster.editorwrapper.VideoEditor;
import com.nextreaming.nexvideoeditor.NexEditor;

/* compiled from: MarchingAnts.java */
/* loaded from: classes.dex */
class c implements Task.OnTaskEventListener {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f21633a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(d dVar) {
        this.f21633a = dVar;
    }

    @Override // com.nexstreaming.app.general.task.Task.OnTaskEventListener
    public void onTaskEvent(Task task, Task.Event event) {
        VideoEditor videoEditor;
        VideoEditor videoEditor2;
        this.f21633a.f21634a.N = false;
        videoEditor = this.f21633a.f21634a.A;
        if (videoEditor != null) {
            videoEditor2 = this.f21633a.f21634a.A;
            videoEditor2.a(NexEditor.FastPreviewOption.normal, 0, true);
        }
    }
}
